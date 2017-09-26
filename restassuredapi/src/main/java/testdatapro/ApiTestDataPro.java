package testdatapro;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import common.Config;
import common.HandlerExcel;

public class ApiTestDataPro {
	
	@DataProvider(name = "address")
	public static Object[][] addAddressData() throws IOException {
		return HandlerExcel.getTestDataMap(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.DATA_ADDRESS_SHEET);
	}

	@DataProvider(name = "buyProcess")
	public static Object[][] buyProcessData() throws IOException {
		return HandlerExcel.getTestDataMap(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.DATA_BUY_SHEET);
	}
}
