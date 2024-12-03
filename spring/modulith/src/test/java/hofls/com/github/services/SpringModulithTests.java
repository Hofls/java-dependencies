package hofls.com.github.services;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class SpringModulithTests {

    ApplicationModules modules = ApplicationModules.of(SpringModulith.class);

    @Test
    void shouldBeCompliant() {
        modules.verify();
    }

    @Test
    void generatePlantUml() {
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}
