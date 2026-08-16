plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // Parser JSON para o TaxaCdiMapper
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")

    // Testes de Unidade
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}