package com.github.hofls.javatests.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void archUnit_MainClasses() {
        JavaClasses classes = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.github.hofls.javatests.archunit");

        noClasses().should().callMethod(OffsetDateTime.class, "now")
            .because("We have decided to use LocalDateTime.now() instead")
            .check(classes);

        noClasses().should().callConstructor(IllegalArgumentException.class, String.class)
            .because("We have decided to use RuntimeException instead")
            .check(classes);

        noClasses()
            .that()
                .resideInAnyPackage("com.github.hofls.javatests.archunit.service..")
            .or()
                .resideInAnyPackage("com.github.hofls.javatests.archunit.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.github.hofls.javatests.archunit.web..")
        .because("Services and repositories should not depend on web layer")
        .check(classes);

    }

}
