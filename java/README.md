# Avi SDK

Avi SDK is a java API which creates a session with controller and perform CRUD operations.

## Prerequisites
jdk 1.8

Maven
## Installation



Download the jar from https://github.com/avinetworks/sdk/blob/java_sdk/java/target/avisdk-18.2.7-SNAPSHOT.jar

add the jar into the classpath of your project.

for documentation please refer https://github.com/avinetworks/sdk/blob/java_sdk/java/target/avisdk-18.2.7-SNAPSHOT-javadoc.jar.

## Usage Examples

AviApi is a pilot class of the API.

- **Create Avi API Session :**
```
AviCredentials creds= new AviCredentials("198.51.100.12", "admin", "something");
creds.setTenant("admin");
creds.setVersion("18.2.8");
AviApi apiInstance = AviApi.getSession(creds);
```

- **Creating health monitor :**
```
JSONObject hmData = new JSONObject();
hmData.put("type","HEALTH_MONITOR_PING");
hmData.put("name","test_hm1");
hmData.put("send_interval","20");
apiInstance.post("healthmonitor", hmData);
```

- **Fetching health monitor info :**
```
Map<String, String> val = new HashMap<String, String>();
val.put("name", "test_hm1");
JSONObject healthmonitor = apiInstance.get("healthmonitor", val);
```

- **Deleting health monitor :**
```
Map<String, String> val = new HashMap<String, String>();
val.put("name", "test_hm1");
JSONObject healthmonitor = serv.get("healthmonitor", val);
JSONArray resp = (JSONArray) healthmonitor.get("results");
JSONObject result = (JSONObject) resp.get(0);
String uuid = (String) result.get("uuid");
apiInstance.delete("healthmonitor",uuid);
```
- **Uploading file :**
```
apiInstance.fileUpload("fileservice/hsmpackages?hsmtype=safenet", "/mnt/files/hsmpackages/safenet.tar","controller://hsmpackages");
```

- **Downloading file :**
```
Map<String, String> param = new HashMap<String, String>();
param.put("full_system", "true");
param.put("passphrase", "abc1234");
apiInstance.fileDownload("/configuration/export", "filepath", param);
```



