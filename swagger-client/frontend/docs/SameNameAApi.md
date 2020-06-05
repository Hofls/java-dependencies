# SameNameAApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserUsingGET**](SameNameAApi.md#getUserUsingGET) | **GET** /same-name-userA | getUser


<a name="getUserUsingGET"></a>
# **getUserUsingGET**
> MainUser getUserUsingGET()

getUser

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SameNameAApi;


SameNameAApi apiInstance = new SameNameAApi();
try {
    MainUser result = apiInstance.getUserUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SameNameAApi#getUserUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MainUser**](MainUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

