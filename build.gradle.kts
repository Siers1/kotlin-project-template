plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.spring") version "2.1.21"
    kotlin("kapt") version "2.1.21"
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.siersi"
version = "0.0.1-SNAPSHOT"
description = "backendkotlin"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.mybatis-flex:mybatis-flex-spring-boot3-starter:1.11.1")
    implementation("com.zaxxer:HikariCP")
    kapt("com.mybatis-flex:mybatis-flex-processor:1.5.6")
    implementation("com.auth0:java-jwt:4.4.0")
    implementation("cn.hutool:hutool-all:5.8.40")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
