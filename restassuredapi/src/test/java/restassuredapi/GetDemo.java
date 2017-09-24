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
		Response response = given().headers("region", "813395", "token", "f31279fd-bc89-43c6-ad79-367fa41f88da")
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
