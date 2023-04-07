package hofls.com.github.rest.patch.common;

public interface IPatchService {

    void toEntity(Object entity, Object patch);

    Identifiable newEntity();

}
