package restassuredapi;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import static io.restassured.RestAssured.*;

public class GetDemo {
	@Test
	public void test() {
		String apiUrl = "http://release.thy360.com/v2/address";
		Response response = given().headers("region", "813395", "token", "98d6258a-3e23-4256-8cd6-a7a6375ee01c")
				.get(apiUrl);
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
