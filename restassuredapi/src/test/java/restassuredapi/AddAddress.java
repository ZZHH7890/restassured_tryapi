package restassuredapi;

import org.testng.annotations.Test;

import common.Config;
import common.Log;
import common.RestAssuredMethods;
import io.restassured.response.Response;
import testdatapro.ApiTestDataPro;

import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class AddAddress {
	@Test(enabled = true, dataProvider = "address", dataProviderClass = ApiTestDataPro.class)
	public void addAddress(String postData, String expectValue) throws IOException {
		Log.startTestCase("addAddress用例测试开始！");
		Response response = RestAssuredMethods.httpRequest(Config.API_ADD_ADDRESS, postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addAddress测试结束！");
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("测试开始！");
		try {
			Config.initToken();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("初始化环境未完成！");
		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

}
