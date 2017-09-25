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
	@Test(enabled = true, dataProvider = "buyProcess", dataProviderClass = ApiTestDataPro.class)
	public void addGoodsToCart(String postData, String expectValue) throws IOException {
		Log.startTestCase("addGoodsToCart用例测试开始！");
		Response response = RestAssuredMethods.postMethod(postData, Config.API_BUY);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addGoodsToCart测试结束！");
	}

	//用例前提条件设置
	@BeforeMethod
	public void beforeMethod() {
		try {
			Config.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("用例前提条件设置未完成！");
		}
	}
	//用例后置条件设置
	@AfterMethod
	public void afterMethod() {
		try {
			Config.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("用例后置条件设置未完成！");
		}
	}
	//初始化环境
	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("测试开始！");
		try {
			Config.clearLog();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("初始化环境未完成！");
		}
	}
	//清理环境
	@AfterClass
	public void afterClass() {
		Log.endTestCase("测试结束！");
		try {
			Config.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("清理环境未完成！");
		}
	}

}
