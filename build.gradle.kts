plugins {
    id("org.springframework.boot") version "3.3.0"
    java
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.0")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.0")
}

tasks.register<Jar>("fatJar") {
    archiveClassifier.set("")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes("Main-Class" to "com.example.camisasapi.CamisasApiApplication")
    }

    from(sourceSets.main.get().output)
    from({ configurations.runtimeClasspath.get().filter { it.name.endsWith(".jar") }.map { zipTree(it) } })
}

tasks.named("bootJar") {
    enabled = false
}

tasks.named("jar") {
    enabled = false
}

tasks.named("build") {
    dependsOn(tasks.named("fatJar"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}
