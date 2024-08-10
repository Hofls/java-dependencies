package com.github.hofls.javatests.archunit;

import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

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

        classes()
            .that().haveSimpleNameNotEndingWith("MapperImpl") // Exclude automatically generated mappers
            .should(haveLessLinesThan(20))
            .because("Huge class = huge complexity, better break it into two smaller classes")
            .check(classes);

        ArchRuleDefinition.methods().should(haveLessParametersThan(10))
            .because("Huge parameters count = huge complexity, better break it into two smaller methods")
            .check(classes);

        banAnnotation(classes, Deprecated.class, "We have decided to use @Outdated annotation instead");

        noClasses()
            .that()
                .resideInAnyPackage("com.github.hofls.javatests.archunit.service..")
            .or()
                .resideInAnyPackage("com.github.hofls.javatests.archunit.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.github.hofls.javatests.archunit.web..")
        .because("Services and repositories should not depend on web layer")
        .check(classes);

        // Not possible with archunit:
        // Max method length - 100 lines
        // Ban interfaces with only 1 implementation
        // No packages with 25+ classes

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
                events.add(new SimpleConditionEvent(javaClass, satisfied, javaClass.getName() + " has " + lastLineNumber + "+ lines"));
            }
        };
    }

    private ArchCondition<JavaMethod> haveLessParametersThan(int number) {
        return new ArchCondition<>("have less than " + number + " parameters") {
            @Override
            public void check(JavaMethod method, ConditionEvents events) {
                int numberOfParameters = method.getRawParameterTypes().size();
                if (numberOfParameters >= number) {
                    events.add(SimpleConditionEvent.violated(method,
                            String.format("Method " + method.getFullName() + " has " + number + "+ parameters")));
                }
            }
        };
    }

    private void banAnnotation(JavaClasses classes, Class annotation, String explanation) {
        noClasses()
                .should().beAnnotatedWith(annotation)
                .because(explanation)
                .check(classes);
        noFields()
                .should().beAnnotatedWith(annotation)
                .because(explanation)
                .check(classes);
        noMethods()
                .should().beAnnotatedWith(annotation)
                .because(explanation)
                .check(classes);
        ArchRuleDefinition.methods().should(notHaveParametersWithAnnotation(annotation))
                .because(explanation)
                .check(classes);
    }

    private ArchCondition<JavaMethod> notHaveParametersWithAnnotation(Class annotation) {
        return new ArchCondition<>("be not annotated with " + annotation.getName()) {
            @Override
            public void check(JavaMethod method, ConditionEvents events) {
                for (var parameter : method.getParameters()) {
                    if (parameter.isAnnotatedWith(annotation)) {
                        events.add(SimpleConditionEvent.violated(method,
                                String.format("Method " + method.getFullName() + " has parameter with banned annotation - " + annotation.getName())));
                    }
                }
            }
        };
    }


}
