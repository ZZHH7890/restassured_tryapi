package restassuredapi;

import org.testng.annotations.Test;

import common.Config;
import common.HandlerExcel;
import common.RestAssuredMethods;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class NewTest {
	@Test
	public void test() throws IOException {
		System.out.println(Config.getToken());
//		Response response = RestAssuredMethods.httpRequest(Config.API_CLEAR_CART);
//		Response response = RestAssuredMethods.httpRequest(Config.API_BUY, "{\"dealId\":991824,\"odLabelId\":\"-1\",\"limitFlag\":false,\"selected\":false,\"specId\":924116,\"dealCount\":1}");
//		response.getBody().prettyPrint();
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
