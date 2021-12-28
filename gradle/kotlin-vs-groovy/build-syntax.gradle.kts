plugins {
    id("org.springframework.boot") version("2.4.5")
    java
}

version = "1.0.2"
group = "org.gradle.samples"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("org.sample.myapp.Main")
}

val swaggerVersion = "2.9.2"
val lombokVersion = "1.18.20"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.4.5"))

    implementation("io.springfox:springfox-swagger2:${swaggerVersion}")
    implementation("io.springfox:springfox-swagger-ui:${swaggerVersion}")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.sample:number-utils:1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(mapOf("group" to "org.junit.vintage", "module" to "junit-vintage-engine"))
    }
}

tasks.test {
    useJUnitPlatform()
}

// gradle performRelease -PisCI=true
tasks.register("performRelease") {
    doLast {
        if (project.hasProperty("isCI")) {
            println("Performing release actions")
        } else {
            throw RuntimeException("Cannot perform release outside of CI")
        }
    }
}
