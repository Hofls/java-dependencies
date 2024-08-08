package com.github.hofls.javatests.archunit;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.junit.jupiter.api.Test;
import com.tngtech.archunit.core.domain.JavaAccess;

import java.time.OffsetDateTime;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
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

        classes().should(haveLessLinesThan(20))
            .because("We have decided to limit size of classes")
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

    private ArchCondition<JavaClass> haveLessLinesThan(int number) {
        return new ArchCondition<>("have less than " + number + " lines") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                int lastLineNumber = javaClass.getCodeUnits().stream()
                        .flatMap(c -> c.getAccessesFromSelf().stream())
                        .map(JavaAccess::getLineNumber)
                        .mapToInt(n -> n)
                        .max().orElse(0);
                boolean satisfied = lastLineNumber < number;
                events.add(new SimpleConditionEvent(javaClass, satisfied, javaClass.getName() + " has more than " + lastLineNumber + " lines"));
            }
        };
    }


}
