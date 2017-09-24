package restassuredapi;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class PostDemo {
	@Test
	public void postJson() {
		String apiUrl = "http://release.thy360.com/v2/regist/code";
		Response response = given().contentType("application/json")
				.body("{\"phone\": \"13714672776\",\"code\":\"1234\",\"introducerCode\":\"\"}")
				.post(apiUrl);
		System.out.println(response.asString());
		response.getBody().prettyPrint();
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

}
