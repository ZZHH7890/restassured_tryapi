package testdatapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import common.Config;
import common.ReadExcel;

public class ApiTestDataPro {
	@DataProvider(name = "address")
	public static Object[][] addAddressData() throws IOException {
		return ReadExcel.getTestDataMap(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.DATA_ADDRESS_SHEET);
	}

}
