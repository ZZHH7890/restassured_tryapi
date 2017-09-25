package apitestcases;

import org.testng.annotations.Test;

import common.Config;
import common.RestAssuredMethods;
import testdatapro.ApiTestDataPro;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class ZzkgApiCases {
	// 测试添加收货地址接口
	@Test(enabled = true, dataProvider = "address", dataProviderClass = ApiTestDataPro.class, groups = { "P2" })
	public void addAddress(String jsonString, String expectValue) throws IOException {
		RestAssuredMethods.postMethod(Config.API_LOGIN);
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
