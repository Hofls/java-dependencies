package hofls.com.github.generics.nested;

public class ApiResponse<T> {

    private T data;
    private String error;

    public ApiResponse(T data) {
        this.data = data;
    }
}
