package hofls.com.github.rest.patch.common;

public interface IPatchService <T extends Identifiable, K extends IPatch> {

    void toEntity(Object entity, Object patch);

    T newEntity();

}
