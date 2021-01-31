package com.github.hofls.javatests.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.github.hofls.javatests.archunit");

        noClasses()
            .that()
                .resideInAnyPackage("com.github.hofls.javatests.archunit.service..")
            .or()
                .resideInAnyPackage("com.github.hofls.javatests.archunit.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.github.hofls.javatests.archunit.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);


    }
}
