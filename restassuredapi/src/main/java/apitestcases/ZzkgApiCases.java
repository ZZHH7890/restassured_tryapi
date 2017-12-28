package apitestcases;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import common.Config;
import common.Log;
import common.RestAssuredMethods;
import io.restassured.response.Response;
import testdatapro.ApiTestDataPro;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ZzkgApiCases {

	// 测试添加商品到购物车接口
	@Test(enabled = false, dataProvider = "buyProcess", dataProviderClass = ApiTestDataPro.class,groups = { "P2" })
	public void addGoodsToCart(String postData, String expectValue) throws IOException {
		Log.startTestCase("addGoodsToCart用例测试开始！");
		Response response = RestAssuredMethods.httpRequest(Config.API_BUY, postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addGoodsToCart测试结束！");
	}

	// 测试新增地址接口
	@Test(enabled = true, dataProvider = "address", dataProviderClass = ApiTestDataPro.class,groups = { "P1" })
	public void addAddress(String postData, String expectValue) throws IOException {
		Log.startTestCase("addAddress用例测试开始！");
		Response response = RestAssuredMethods.httpRequest(Config.API_ADD_ADDRESS, postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addAddress测试结束！");
	}
	

	// 用例前提条件设置
	@BeforeMethod(groups = { "init.env" })
	public void beforeMethod() {
		try {
			Config.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("用例前提条件设置未完成！");
		}
	}

	// 用例后置条件设置
	@AfterMethod(groups = { "clear.env" })
	public void afterMethod() {
		try {
			Config.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("用例后置条件设置未完成！");
		}
	}

	// 初始化环境
	@BeforeClass(groups = { "init.env" })
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("测试开始！");
		try {
			Config.initLog();
			Config.initToken();
			Config.initAddress();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("初始化环境未完成！");
		}
	}

	// 清理环境
	@AfterClass(groups = { "clear.env" })
	public void afterClass() {
		Log.endTestCase("测试结束！");
		try {
			Config.clearCart();
			Config.clearAddress();
			Config.clearToken();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("清理环境未完成！");
		}
	}

}
