# MirrorServiceApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**reflectUsingGET**](MirrorServiceApi.md#reflectUsingGET) | **GET** /mirror/{value} | Reflects value back


<a name="reflectUsingGET"></a>
# **reflectUsingGET**
> String reflectUsingGET(value)

Reflects value back

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MirrorServiceApi;


MirrorServiceApi apiInstance = new MirrorServiceApi();
String value = "value_example"; // String | value
try {
    String result = apiInstance.reflectUsingGET(value);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MirrorServiceApi#reflectUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **value** | **String**| value |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

