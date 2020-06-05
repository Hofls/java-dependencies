# SameNameBApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserUsingGET1**](SameNameBApi.md#getUserUsingGET1) | **GET** /same-name-userB | getUser


<a name="getUserUsingGET1"></a>
# **getUserUsingGET1**
> User getUserUsingGET1()

getUser

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SameNameBApi;


SameNameBApi apiInstance = new SameNameBApi();
try {
    User result = apiInstance.getUserUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SameNameBApi#getUserUsingGET1");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

