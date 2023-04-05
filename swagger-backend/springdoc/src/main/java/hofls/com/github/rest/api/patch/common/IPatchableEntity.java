package hofls.com.github.rest.api.patch.common;

public interface IPatchableEntity {

    void toEntity(Object entity, Object patch);

    Identifiable newEntity();

}
