# MirrorServiceApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**reflectUsingGET**](MirrorServiceApi.md#reflectUsingGET) | **GET** /mirror/{id} | Reflects value back


<a name="reflectUsingGET"></a>
# **reflectUsingGET**
> String reflectUsingGET(id)

Reflects value back

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MirrorServiceApi;


MirrorServiceApi apiInstance = new MirrorServiceApi();
String id = "id_example"; // String | id
try {
    String result = apiInstance.reflectUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MirrorServiceApi#reflectUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

