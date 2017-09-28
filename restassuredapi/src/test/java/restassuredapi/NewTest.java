package restassuredapi;

import org.testng.annotations.Test;

import common.Config;
import common.HandlerExcel;
import common.RestAssuredMethods;
import groovy.time.BaseDuration.From;
import groovyjarjarantlr.collections.List;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class NewTest {
	@Test
	public void test() throws IOException {
		// System.out.println(Config.getToken());
		// Response response = RestAssuredMethods.httpRequest(Config.API_CLEAR_CART);
		// Response response = RestAssuredMethods.httpRequest(Config.API_BUY,
		// "{\"dealId\":991824,\"odLabelId\":\"-1\",\"limitFlag\":false,\"selected\":false,\"specId\":924116,\"dealCount\":1}");
		// response.getBody().prettyPrint();
		// Response response = RestAssuredMethods.httpRequest(Config.API_GET_ADDRESS);
		// JsonPath jsonPath = new JsonPath(response.asString());
		// ArrayList<Integer> addressId = jsonPath.get("id");
		// Iterator<Integer> iterator = addressId.iterator();
		// while (iterator.hasNext()) {
		// String string = String.valueOf(iterator.next());
		// RestAssuredMethods.httpRequest(Config.API_DELETE_ADDRESS, string);
		// }
//		Config.clearAddress();
//		 Config.clearCart();
		RestAssuredMethods.httpRequest(6, "17224");
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
