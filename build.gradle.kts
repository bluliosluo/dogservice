plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
	id("org.flywaydb.flyway") version "9.14.1"
}

group = "org.chloe"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")


	/// aws
	implementation(platform("software.amazon.awssdk:bom:2.25.57"))

	// s3
	implementation("software.amazon.awssdk:s3")

	// sqs
	implementation("software.amazon.awssdk:sqs")

	// immutables
	// implementation("org.immutables:value:2.10.1")
	annotationProcessor("org.immutables:value:2.10.1")
	compileOnly("org.immutables:value:2.10.1")

	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

flyway {
	url = "jdbc:postgresql://localhost:5432/demo_db"
	user = "postgres"
	password = "postgres"
}
