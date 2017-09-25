package restassuredapi;

import org.testng.annotations.Test;

import common.Config;
import common.RestAssuredMethods;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class NewTest {
	@Test
	public void test() throws IOException {
		System.out.println(Config.getToken());
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
