package restassuredapi;

import org.testng.annotations.Test;

import common.Config;
import common.HandlerExcel;
import common.RestAssuredMethods;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class NewTest {
	@Test
	public void test() throws IOException {
		HandlerExcel.test(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.EXCEL_TEST_SHEET, "UUUU");
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
