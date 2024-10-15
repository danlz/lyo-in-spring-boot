package com.danlz.spring.boot.lyo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LyoInSpringBootApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Test
	void serviceProviderCatalog() {
		given()
				.accept("application/json")
		.when()
				.get("/oslc/catalog/singleton")
		.then()
				.log().all(true)
				.statusCode(200)
				.body("\"dcterms:title\"", equalTo("Service Provider Catalog"))
				.body("\"oslc:serviceProvider\"[0].\"dcterms:title\"", equalTo("Requirements Service Provider"))
				.body("\"oslc:serviceProvider\"[0].\"oslc:details\"[0].\"rdf:resource\"", endsWith("/oslc/serviceProviders/1"));

	}

	@Test
	void serviceProviderService() {
		given()
				.accept("application/json")
		.when()
				.get("/oslc/serviceProviders/1")
		.then()
				.log().all(true)
				.statusCode(200)
				.body("\"dcterms:title\"", equalTo("Requirements Service Provider"))
				.body("\"oslc:service\"[0].\"oslc:domain\".\"rdf:resource\"", equalTo("http://open-services.net/ns/rm#"))
				.body("\"oslc:service\"[0].\"oslc:queryCapability\"[0].\"oslc:label\"", equalTo("QueryCapability1"));

	}

	@Test
	void queryRequirement() {
		given()
				.accept("application/json")
		.when()
				.get("/oslc/requirements/query")
		.then()
				.log().all(true)
				.statusCode(200)
				.body("[0].about", endsWith("/oslc/requirements/1"))
				.body("[0].title", equalTo("Requirement 1"))
				.body("[1].about", endsWith("/oslc/requirements/2"))
				.body("[1].title", equalTo("Requirement 2"));
	}

}
