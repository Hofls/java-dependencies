/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.6/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

application {
    // Define the main class for the application.
    mainClassName = "tasks.demo.App"
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
}

// --------------------------------------------------------------------------------------------------

// gradlew task-in-kotlin -PisCI=true
tasks.register("task-in-kotlin") {
    doLast {
        if (project.hasProperty("isCI")) {
            val message = "Hello world"
            repeat(4) {
                println("Release message - ${message}")
            }
        } else {
            throw RuntimeException("Cannot perform release outside of CI")
        }
    }
}

// gradlew depends-demo --console=plain
tasks.register("depends-demo") {
    // Notice that gradle runs "clean" first, then "test" (ignored order)
    dependsOn("test")
    dependsOn("clean")
    doLast {
        println("Done!")
    }
}

// Adds behaviour to existing task
// gradlew clean
tasks.named("clean") {
    doFirst {
        println("Cleaning start..")
    }
    doLast {
        println("Cleaning done!")
    }
}

