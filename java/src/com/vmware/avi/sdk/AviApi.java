package com.vmware.avi.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class creates a session with controller and facilitates CRUD operations.
 * 
 * @author: Chaitanya Deshpande
 *
 */
public class AviApi {

	/**
	 * Sets the logger for get all logs.
	 */
	static final Logger LOGGER = Logger.getLogger(AviApi.class.getName());

	/**
	 * Constructor for AviApi Class.
	 * 
	 * @param aviCredentials an AviCredentials Object containing controller's
	 *                       details to create session.
	 */
	public AviApi(AviCredentials aviCredentials) {
		this.aviCredentials = aviCredentials;
		this.sessionKey = aviCredentials.getController() + ":" + aviCredentials.getUsername() + ":"
				+ aviCredentials.getPort();
		this.restTemplate = AviRestUtils.getRestTemplate(aviCredentials);
	}

	/**
	 * The Session pool containing session objects in runtime to avoid duplicates.
	 */
	private static HashMap<String, AviApi> sessionPool = new HashMap<String, AviApi>();

	/**
	 * AviCredentials object for this session.
	 */
	private AviCredentials aviCredentials;
	/**
	 * The session key of this session.
	 */
	private String sessionKey;

	private RestTemplate restTemplate;



	/**
	 * This static factory method to create session if not present in the pool if
	 * presents in the session pool returns existing session.
	 * 
	 * @param aviCredentials Containing the credentials of the controller.
	 * @return A session representing the session for the controller.
	 * @throws IOException if get any exception to set session.
	 */
	public static AviApi getSession(AviCredentials aviCredentials) throws IOException {
		String sessionKey = aviCredentials.getController() + ":" + aviCredentials.getUsername() + ":"
				+ aviCredentials.getPort();
		synchronized (AviApi.class) {
			if (sessionPool.containsKey(sessionKey)) {
				return sessionPool.get(sessionKey);
			} else {
				AviApi session = new AviApi(aviCredentials);
				if (!aviCredentials.getLazyAuthentication()) {
					AviRestUtils.authenticateSession(aviCredentials);
				}
				sessionPool.put(session.sessionKey, session);
				return session;
			}
		}
	}

	/**
	 * This method calls the GET REST API.
	 * 
	 * @param path   A String containing the objectType to be get from controller.
	 * @param params A Map which can contain URL params if any.
	 * 
	 * @return A JSONObeject representing response of the GET REST call.
	 * @throws Exception
	 */
	public JSONObject get(String path, Map<String, String> params) throws Exception {
		return this.get(path, params, null);
	}

	public <T> T getForObject(Class<T> objClass, String objectUUid) throws Exception {
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = path + "/" + objectUUid;

		T aviObj = (T) this.restTemplate.getForObject(getUrl, objClass);
		return aviObj;
	}

	public <T> T getForObject(Class<T> objClass, Map<String, String> params) throws Exception {
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = buildApiParams(path.split("apiresponse")[0], params);

		T aviObj = (T) this.restTemplate.getForObject(getUrl, objClass, params);
		return aviObj;
	}

	public <T> T getForObjectList(Class<T> objClass, Map<String, String> params) throws Exception {

		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = buildApiParams(path.split("apiresponse")[0], params);

		T aviObj = null;
		if (params != null) {
			aviObj = (T) this.restTemplate.getForObject(getUrl, objClass, params);
		}
		else {
			aviObj = (T) this.restTemplate.getForObject(getUrl, objClass);
		}
		return aviObj;
	}

	public String buildApiParams(String path, Map<String, String> params) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restTemplate.getUriTemplateHandler().expand("/").toString().concat(path));
		if (null != params) {
			for(String key: params.keySet()) {
				uriBuilder.queryParam(key, params.get(key));
			}
		}
		return uriBuilder.toUriString();
	}

	/**
	 * This method calls the GET REST API.
	 * 
	 * @param path   A String containing the objectType to be get from controller.
	 * @param params A Map which can contain URL params if any.
	 * @userHeaders A map which can contains extra headers/overwrite common headers
	 *              for the request
	 * 
	 * @return A JSONObeject representing response of the GET REST call.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject get(String path, Map<String, String> params, HashMap<String, String> userHeaders)
			throws Exception {
		CloseableHttpClient httpClient = null;
		try {
			String getUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + path;
			URIBuilder uriBuilder = new URIBuilder(getUrl);

			if (null != params && !params.isEmpty()) {
				List<NameValuePair> urlParameters = new ArrayList<>();
				for (String key : params.keySet()) {
					urlParameters.add(new BasicNameValuePair(key, params.get(key)));
				}
				uriBuilder.addParameters(urlParameters);
			}

			httpClient = AviRestUtils.buildHttpClient(this.aviCredentials);
			HttpGet request = new HttpGet(uriBuilder.build());
			AviRestUtils.buildHeaders(request, userHeaders, this.aviCredentials);
			HttpResponse response = httpClient.execute(request);

			Object[] args = new Object[] { path, params };
			Class[] mParams = new Class[] { String.class, Map.class };
			Method m = AviApi.class.getMethod("get", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		} catch (IOException | URISyntaxException | NoSuchMethodException | SecurityException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in GET : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} finally {
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * This method calls the PUT REST API.
	 * 
	 * @param path A String containing object type which want to PUT on the
	 *             controller.
	 * @param body A JSONObject containing object details.
	 * 
	 * @return A JSONObject representing response of the PUT REST call.
	 * 
	 * @throws AviApiException if there any error in executing PUT request
	 */
	public JSONObject put(String path, JSONObject body) throws AviApiException {
		return this.put(path, body, null);
	}

	public <T> ResponseEntity<T> put(Class<T> objClass, T aviObj, String objectUUid) throws JSONException, AviApiException, IOException {
		String path = aviObj.getClass().getSimpleName().toLowerCase();
		String getUrl = path + "/" + objectUUid;

        HttpEntity<T> requestEntity = new HttpEntity<T>(aviObj);
		ResponseEntity<T> response = restTemplate.exchange(getUrl, HttpMethod.PUT, requestEntity, objClass);
		return response;
	}

	public <T> ResponseEntity<T> post(Class<T> objClass, T aviObj) throws JSONException, AviApiException, IOException {
		String path = aviObj.getClass().getSimpleName().toLowerCase();
		String getUrl = path;
		ResponseEntity<T> responseEntity = (ResponseEntity<T>)this.restTemplate.postForEntity(getUrl, aviObj, objClass);
		return responseEntity;
	}

	public <T> ResponseEntity<T> delete(Class<T> objClass, String objUUid) throws JSONException, AviApiException, IOException {
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = path + "/" + objUUid;

        ResponseEntity<T> responseEntity = restTemplate.exchange(getUrl, HttpMethod.DELETE, null, objClass);
        return responseEntity;
	}

	/**
	 * This method calls the PUT REST API.
	 * 
	 * @param path A String containing object type which want to PUT on the
	 *             controller.
	 * @param body A JSONObject containing object details.
	 * @userHeaders A map which can contains extra headers/overwrite common headers
	 *              for the request
	 * 
	 * @return A JSONObject representing response of the PUT REST call.
	 * 
	 * @throws AviApiException if there any error in executing PUT request
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject put(String path, JSONObject body, HashMap<String, String> userHeaders) throws AviApiException {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = AviRestUtils.buildHttpClient(this.aviCredentials);
			String putUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + path + "/" + body.get("uuid");
			HttpPut request = new HttpPut(putUrl);
			StringEntity input = new StringEntity(body.toString());
			request.setEntity(input);
			AviRestUtils.buildHeaders(request, userHeaders, this.aviCredentials);
			HttpResponse response = httpClient.execute(request);

			Object[] args = new Object[] { path, body };
			Class[] mParams = new Class[] { String.class, JSONObject.class };
			Method m = AviApi.class.getMethod("put", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in PUT : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} finally {
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * This method calls the POST REST API
	 * 
	 * @param path A String containing object type which want to create on the
	 *             controller.
	 * @param body A JSONObject containing the object body.
	 * 
	 * @return A JSONObject representing the created response of the POST REST call.
	 * 
	 * @throws AviApiException if there any error in executing POST request.
	 */
	public JSONObject post(String path, JSONObject body) throws AviApiException {
		return this.post(path, body, null);
	}

	public Object post(Object aviObj) throws JSONException, AviApiException, IOException {
		String path = aviObj.getClass().getSimpleName().toLowerCase();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		JSONObject objPut = new JSONObject(objectMapper.writeValueAsString(aviObj));
		JSONObject responseVal = this.post(path, objPut);
		Object resObj = null;
		if (null != responseVal) {
			resObj = objectMapper.readValue(responseVal.toString(), aviObj.getClass());
		}
		return resObj;
	}

	/**
	 * This method calls the POST REST API
	 * 
	 * @param path A String containing object type which want to create on the
	 *             controller.
	 * @param body A JSONObject containing the object body.
	 * @userHeaders A map which can contains extra headers/overwrite common headers
	 *              for the request
	 * 
	 * @return A JSONObject representing the created response of the POST REST call.
	 * 
	 * @throws AviApiException if there any error in executing POST request.
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject post(String path, JSONObject body, HashMap<String, String> userHeaders) throws AviApiException {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = AviRestUtils.buildHttpClient(this.aviCredentials);
			String postUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + path;
			HttpPost request = new HttpPost(postUrl);
			StringEntity input = new StringEntity(body.toString());
			request.setEntity(input);
			AviRestUtils.buildHeaders(request, userHeaders, this.aviCredentials);
			HttpResponse response = httpClient.execute(request);

			Object[] args = new Object[] { path, body };
			Class[] mParams = new Class[] { String.class, JSONObject.class };
			Method m = AviApi.class.getMethod("post", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in POST : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} finally {
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * This method calls the DELETE REST API.
	 * 
	 * @param path A String containing object type which want to delete from the
	 *             controller.
	 * @param uuid A String containing id of the object which want to DELETE.
	 * 
	 * @return A JSONObject representing response of the DELETE REST call.
	 * 
	 * @throws AviApiException if any error executing DELETE request.
	 */
	public JSONObject delete(String path, String uuid) throws AviApiException {
		return this.delete(path, uuid, null);
	}

	/**
	 * This method calls the DELETE REST API.
	 * 
	 * @param path A String containing object type which want to delete from the
	 *             controller.
	 * @param uuid A String containing id of the object which want to DELETE.
	 * @userHeaders A map which can contains extra headers/overwrite common headers
	 *              for the request
	 * 
	 * @return A JSONObject representing response of the DELETE REST call.
	 * 
	 * @throws AviApiException if any error executing DELETE request.
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject delete(String path, String uuid, HashMap<String, String> userHeaders) throws AviApiException {
		CloseableHttpClient httpClient = null;
		try {
			String deleteUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + path + "/" + uuid;
			httpClient = AviRestUtils.buildHttpClient(this.aviCredentials);
			HttpDelete request = new HttpDelete(deleteUrl);
			AviRestUtils.buildHeaders(request, userHeaders, this.aviCredentials);
			HttpResponse response = httpClient.execute(request);
			Object[] args = new Object[] { path, uuid };
			Class[] mParams = new Class[] { String.class, String.class };
			Method m = AviApi.class.getMethod("delete", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in DELETE : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} finally {
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * 
	 * This method upload the file into the controller.
	 * 
	 * @param uri           is the api which upload a file
	 * @param filePath      is file which we want to upload
	 * @param fileUploadUri is uri where we have to upload file
	 * @throws Exception
	 */
	public void fileUpload(String uri, String filePath, String fileUploadUri) throws Exception {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = AviRestUtils.buildHttpClient(this.aviCredentials);
			String postUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + uri;
			HttpPost request = new HttpPost(postUrl);
			AviRestUtils.buildHeaders(request, null, this.aviCredentials);
			request.removeHeaders("Content-Type");
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addTextBody("uri", fileUploadUri, ContentType.TEXT_PLAIN);

			// This attaches the file to the POST:
			File f = new File(filePath);
			builder.addBinaryBody("file", new FileInputStream(f), ContentType.APPLICATION_OCTET_STREAM, f.getName());
			HttpEntity multipart = (HttpEntity) builder.build();
			request.setEntity((org.apache.http.HttpEntity) multipart);
			CloseableHttpResponse response = httpClient.execute(request);
			int responseCode = response.getStatusLine().getStatusCode();
			if (responseCode > 299) {
				StringBuffer errMessage = new StringBuffer();
				errMessage.append("Failed : HTTP error code : ");
				errMessage.append(responseCode);
				if (null != response.getEntity()) {
					errMessage.append(" Error Message :");
					errMessage.append(EntityUtils.toString(response.getEntity()));
				}
				throw new AviApiException(errMessage.toString());
			}

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in postFileUpload : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} finally {
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/***
	 * 
	 * This method download the file from the controller.
	 * 
	 * @param path          is the the path from which file gets download.
	 * @param localFilePath is a path where file needs to be download.
	 * @param params        A map which can contains the additional values.
	 * @return String name of the downloaded file.
	 * @throws AviApiException
	 * @throws IOException
	 */
	public String fileDownload(String path, String localFilePath, Map<String, String> params)
			throws AviApiException, IOException {
		CloseableHttpClient httpClient = null;
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		String filePath = null;
		try {
			HttpResponse response = null;
			httpClient = AviRestUtils.buildHttpClient(this.aviCredentials);
			LOGGER.info("Inside download file :: Path is :" + path);
			String getUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + path;
			LOGGER.info("postUrl : " + getUrl);
			URIBuilder uriBuilder = new URIBuilder(getUrl);

			if (null != params && !params.isEmpty()) {
				List<NameValuePair> urlParameters = new ArrayList<>();
				for (String key : params.keySet()) {
					urlParameters.add(new BasicNameValuePair(key, params.get(key)));
				}
				uriBuilder.addParameters(urlParameters);
			}

			HttpGet request = new HttpGet(uriBuilder.build());
			AviRestUtils.buildHeaders(request, null, this.aviCredentials);
			request.removeHeaders("Content-Type");
			response = httpClient.execute(request);
			if (null != response.getEntity()) {
				inputStream = response.getEntity().getContent();
				File file = new File(localFilePath);
				fileOutputStream = new FileOutputStream(file);
				int inByte;
				while ((inByte = inputStream.read()) != -1) {
					fileOutputStream.write(inByte);
				}
				filePath = file.getAbsolutePath();
			}
			LOGGER.info("Path of downloaded file :" + filePath);
			return filePath;
		} catch (IOException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in POST : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in POST : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} finally {

			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
			if (null != inputStream) {
				inputStream.close();
			}
			if (null != fileOutputStream) {
				fileOutputStream.close();
			}
		}

	}

	/**
	 * This method gets the response and convert it into JSONObject.
	 * 
	 * @param response A HttpResponse from the REST call.
	 * @param m        The method type.
	 * @param args     Object which have headers and post body into it.
	 * 
	 * @return A JSONObject representing converted response of the REST call.
	 * 
	 * @throws AviApiException if any issue when set the REST call and if there is
	 *                         any issue when convert HttpResponse to JSONObject.
	 */
	private JSONObject parseResponse(HttpResponse response, Method m, Object[] args) throws AviApiException {
		try {
			int responseCode = response.getStatusLine().getStatusCode();
			if (responseCode > 299) {
				StringBuffer errMessage = new StringBuffer();
				errMessage.append("Failed : HTTP error code : ");
				errMessage.append(responseCode);
				if (null != response.getEntity()) {
					errMessage.append(" Error Message :");
					errMessage.append(EntityUtils.toString(response.getEntity()));
				}
				throw new AviApiException(errMessage.toString());
			}
			if (null != response.getEntity()) {
				String output = EntityUtils.toString(response.getEntity());
				JSONObject result = new JSONObject(output);
				return result;
			} else {
				if (m.getName().equals("delete")) {
					JSONObject result = new JSONObject();
					result.put("Message", "Object deleted successfully");
					return result;
				} else {
					return null;
				}
			}
		} catch (IllegalArgumentException | IOException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in parsing response : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		}
	}
}
