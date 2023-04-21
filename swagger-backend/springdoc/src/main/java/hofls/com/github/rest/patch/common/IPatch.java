package hofls.com.github.rest.patch.common;

public interface IPatch {

    String getId();

    void setId(String id);

    PatchOperation getOperation();

}
