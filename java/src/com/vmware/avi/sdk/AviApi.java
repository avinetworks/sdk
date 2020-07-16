package com.vmware.avi.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmware.avi.sdk.model.AviApiResponse;

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
	 * The Map which will fetch classes from model.
	 */
	public static Map<String, String> modelMap = new HashMap<String, String>();

	/**
	 * AviCredentials object for this session.
	 */
	private AviCredentials aviCredentials;
	/**
	 * The session key of this session.
	 */
	private String sessionKey;

	private RestTemplate restTemplate;

	static {
		fetchClassNames("com.vmware.avi.sdk.model");
	}

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
		LOGGER.info("__INIT__ Inside executing getForObject..");
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = path + "/" + objectUUid;

		T aviObj = (T) this.restTemplate.getForObject(getUrl, objClass);
		LOGGER.info("__DONE__Executing getForObject is completed..");
		return aviObj;
	}

	public <T> T getForObject(Class<T> objClass, Map<String, String> params) throws Exception {
		LOGGER.info("__INIT__ Inside executing getForObject..");
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = buildApiParams(path.split("apiresponse")[0], params);

		T aviObj = (T) this.restTemplate.getForObject(getUrl, objClass, params);
		LOGGER.info("__DONE__Executing getForObject is completed..");
		return aviObj;
	}

	public <T> T getForObjectList(Class<T> objClass, Map<String, String> params) throws Exception {
		LOGGER.info("__INIT__ Inside executing getForObjectList..");
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = buildApiParams(path.split("apiresponse")[0], params);

		T aviObj = null;
		if (params != null) {
			aviObj = (T) this.restTemplate.getForObject(getUrl, objClass, params);
		} else {
			aviObj = (T) this.restTemplate.getForObject(getUrl, objClass);
		}
		LOGGER.info("__DONE__Executing getForObjectList is completed..");
		return aviObj;
	}

	public String buildApiParams(String path, Map<String, String> params) {
		LOGGER.info("__INIT__ Inside buildApiParams..");
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl(restTemplate.getUriTemplateHandler().expand("/").toString().concat(path));
		if (null != params) {
			for (String key : params.keySet()) {
				uriBuilder.queryParam(key, params.get(key));
			}
		}
		LOGGER.info("__DONE__ buildApiParams");
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
	public <T> JSONObject get(String path, Map<String, String> params, HashMap<String, String> userHeaders)
			throws AviApiException {
		try {
			LOGGER.info("__INIT__ Inside executing GET..");
			String getUrl = path;
			if (params != null) {
				getUrl = buildApiParams(path, params);
			}
			JSONObject jsonObject = null;
			if (path.contains("/")) {
				Object response = restTemplate.getForObject(getUrl, Object.class);
				ObjectMapper mapper = new ObjectMapper();
				String jsonStr = mapper.writeValueAsString(response);
				jsonObject = new JSONObject(jsonStr);
			} else {
				AviApiResponse result = restTemplate.getForObject(getUrl, AviApiResponse.class);
				jsonObject = new JSONObject(result);
			}
			LOGGER.info("__DONE__Executing GET is completed..");
			return jsonObject;
		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in GET : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
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

	public <T> ResponseEntity<T> put(Class<T> objClass, T aviObj, String objectUUid)
			throws JSONException, AviApiException, IOException {
		LOGGER.info("__INIT__ Inside executing PUT..");
		String path = aviObj.getClass().getSimpleName().toLowerCase();
		String getUrl = path + "/" + objectUUid;

		HttpEntity<T> requestEntity = new HttpEntity<T>(aviObj);
		ResponseEntity<T> response = restTemplate.exchange(getUrl, HttpMethod.PUT, requestEntity, objClass);
		LOGGER.info("__DONE__Executing PUT is completed..");
		return response;
	}

	public <T> ResponseEntity<T> post(Class<T> objClass, T aviObj) throws JSONException, AviApiException, IOException {
		LOGGER.info("__INIT__ Inside executing POST..");
		String path = aviObj.getClass().getSimpleName().toLowerCase();
		String getUrl = path;
		ResponseEntity<T> responseEntity = (ResponseEntity<T>) this.restTemplate.postForEntity(getUrl, aviObj,
				objClass);
		LOGGER.info("__DONE__Executing POST is completed..");
		return responseEntity;
	}

	public <T> ResponseEntity<T> delete(Class<T> objClass, String objUUid)
			throws JSONException, AviApiException, IOException {
		LOGGER.info("__INIT__ Inside executing DELETE..");
		String path = objClass.getSimpleName().toLowerCase();
		String getUrl = path + "/" + objUUid;

		ResponseEntity<T> responseEntity = restTemplate.exchange(getUrl, HttpMethod.DELETE, null, objClass);
		LOGGER.info("__DONE__Executing DELETE is completed..");
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> JSONObject put(String path, JSONObject body, HashMap<String, String> userHeaders)
			throws AviApiException {
		try {
			LOGGER.info("__INIT__ Inside executing PUT..");
			ObjectMapper mapper = new ObjectMapper();
			Class restResource = getAviRestResourceObject(path.toLowerCase());
			Object input = mapper.readValue(body.toString(), restResource);

			String objectUuid = body.get("uuid").toString();
			String putUrl = path.toLowerCase().concat("/" + objectUuid);
			HttpEntity<Object> requestEntity;
			if (userHeaders != null) {
				HttpHeaders headers = setHeaders(userHeaders);
				requestEntity = new HttpEntity<Object>(input, headers);
			} else {
				requestEntity = new HttpEntity<Object>(input);
			}
			ResponseEntity<T> response = (ResponseEntity<T>) restTemplate.exchange(putUrl, HttpMethod.PUT,
					requestEntity, restResource);

			JSONObject jsonObject = new JSONObject(response.getBody());
			LOGGER.info("__DONE__Executing PUT is completed..");
			return jsonObject;

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			throw new AviApiException(e);
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
		LOGGER.info("__INIT__ Inside executing POST..");
		String path = aviObj.getClass().getSimpleName().toLowerCase();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		JSONObject objPut = new JSONObject(objectMapper.writeValueAsString(aviObj));
		JSONObject responseVal = this.post(path, objPut);
		Object resObj = null;
		if (null != responseVal) {
			resObj = objectMapper.readValue(responseVal.toString(), aviObj.getClass());
		}
		LOGGER.info("__DONE__Executing POST is completed..");
		return resObj;
	}

	/**
	 * This method calls the POST REST API
	 * 
	 * @param path A String containing object type which want to create on thebody
	 *             controller.
	 * @param body A JSONObject containing the object body.
	 * @userHeaders A map which can contains extra headers/overwrite common headers
	 *              for the request
	 * 
	 * @return A JSONObject representing the created response of the POST REST call.
	 * 
	 * @throws AviApiException if there any error in executing POST request.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> JSONObject post(String path, JSONObject body, HashMap<String, String> userHeaders)
			throws AviApiException {
		try {
			LOGGER.info("__INIT__ Inside executing POST..");
			ObjectMapper mapper = new ObjectMapper();
			Class restResource = getAviRestResourceObject(path.toLowerCase());
			Object input = mapper.readValue(body.toString(), restResource);

			HttpEntity<Object> requestEntity;
			if (userHeaders != null) {
				HttpHeaders headers = setHeaders(userHeaders);
				requestEntity = new HttpEntity<Object>(input, headers);
			} else {
				requestEntity = new HttpEntity<Object>(input);
			}
			ResponseEntity<T> response = (ResponseEntity<T>) restTemplate.exchange(path, HttpMethod.POST,
					requestEntity, restResource);

			JSONObject jsonObject = new JSONObject(response.getBody());
			LOGGER.info("__DONE__Executing POST is completed..");
			return jsonObject;

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			throw new AviApiException(e);
		}

	}

	/**
	 * This method sets specific HTTP request headers.
	 * 
	 * @param request A HttpRequestBase containing required headers.
	 * @return
	 */
	private HttpHeaders setHeaders(HashMap<String, String> userHeaders) {
		LOGGER.info("__INIT__ Inside set header..");
		HttpHeaders headers = new HttpHeaders();
		if ((null != userHeaders) && (!userHeaders.isEmpty())) {
			for (String key : userHeaders.keySet()) {
				headers.set(key, userHeaders.get(key));
			}
		}
		LOGGER.info("__DONE__ setHeader");
		return headers;
	}

	/***
	 * This method returns AviRestResource
	 * 
	 * @param objectType name of the object.
	 * @return AviRestResource
	 */
	@SuppressWarnings("rawtypes")
	private Class getAviRestResourceObject(String objectType) {
		LOGGER.info("__INIT__ Inside getAviRestResourceObject");
		String className = null;
		if (modelMap.containsKey(objectType.toUpperCase())) {
			className = modelMap.get(objectType.toUpperCase());
		}
		try {
			Class obj = (Class) Class.forName("com.vmware.avi.sdk.model." + className);
			return obj;
		} catch (ClassNotFoundException e) {
			LOGGER.info("Exception : " + e.getMessage());
		}
		LOGGER.info("__DONE__ getAviRestResourceObject");
		return null;
	}

	/**
	 * This method will add Class names from the package into the modelMap.
	 * 
	 * @param packageName fully qualified package name
	 * @throws ClassNotFoundException
	 */
	private static void fetchClassNames(String packageName) {
		LOGGER.info("__INIT__ Inside fetchClassNames and generate map");
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder().setScanners(new SubTypesScanner(false),
				new ResourcesScanner());
		configurationBuilder.setUrls(ClasspathHelper.forPackage(packageName))
				.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageName)));
		Reflections reflection = new Reflections(configurationBuilder);
		Set<Class<?>> classes = reflection.getSubTypesOf(Object.class);
		for (Class c : classes) {
			modelMap.put(c.getSimpleName().toUpperCase(), c.getSimpleName());
		}
		LOGGER.info("__DONE__ fetchClassNames map generated");
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
	public JSONObject delete(String path, String uuid, HashMap<String, String> userHeaders) throws AviApiException {
		LOGGER.info("__INIT__ Inside executing DELETE..");
		String deleteUrl = AviRestUtils.getControllerURL(this.aviCredentials) + "/api/" + path + "/" + uuid;
		if (userHeaders == null) {
			this.restTemplate.delete(deleteUrl);
		} else {
			this.restTemplate.delete(deleteUrl, userHeaders);
		}
		LOGGER.info("__DONE__Executing DELETE is completed..");
		return new JSONObject();
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
			LOGGER.info("Inside upload file :: Path is :" + uri);
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
			LOGGER.info("__DONE__ File upload completed.");
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOGGER.severe("Exception in postFileUpload : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		} 
		finally {
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

}
