package common;

import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.util.Map;
import io.restassured.response.Response;

/**
 * @author 张大爷
 * @time 2017年9月23日 上午12:14:50 Just a joke
 */

public class Config {

	// 测试环境：预发布环境为2，21环境为3
	public static final int TEST_ENV = 2;
	// 登录接口信息在表格第2行
	public static final int API_LOGIN = 2;
	// 清空购物车接口信息在表格第3行
	public static final int API_CLEAR_CART = 3;
	// 增加地址接口信息在表格第5行
	public static final int API_ADD_ADDRESS = 5;
	// 添加商品到购物车接口信息在表格第12行
	public static final int API_BUY = 12;
	// excel表格路径
	public static final String EXCEL_PATH = "C:\\Users\\Administrator\\eclipse-workspace\\restassured_tryapi\\restassuredapi\\ExcelForData";
	// excel表格名字
	public static final String EXCEL_NAME = "testData.xlsx";

	// excel表格config信息所在sheet
	public static final String EXCEL_TEST_SHEET = "test";
	// excel表格config信息所在sheet
	public static final String EXCEL_CONFIG_SHEET = "config";
	// excel表格接口信息所在sheet
	public static final String EXCEL_API_SHEET = "api";
	// excel表格地址接口测试数据所在sheet
	public static final String DATA_LOGIN_SHEET = "login";
	// excel表格地址接口测试数据所在sheet
	public static final String DATA_ADDRESS_SHEET = "address";
	// excel表格添加商品到购物车接口测试数据所在sheet
	public static final String DATA_BUY_SHEET = "buyprocess";

	public static final String LOG_FILE_PATH = "C:\\Users\\Administrator\\eclipse-workspace\\restassured_tryapi\\restassuredapi\\log\\logfile.log";

	public static String getToken() {
		try {
			Map<String, String> configMap = HandlerExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
					Config.EXCEL_CONFIG_SHEET, Config.TEST_ENV);
			Map<String, String> apiMap = HandlerExcel.getApiMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
					Config.EXCEL_API_SHEET, Config.API_LOGIN);
			Response response = given().contentType("application/json").body(configMap.get("loginData"))
					.post(configMap.get("host") + apiMap.get("api"));
			return response.path("token");
		} catch (Exception e) {
			String failString = "获取用户token执行失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 清空购物车
	public static void clearCart() {
		try {
			RestAssuredMethods.deleteMethod(API_CLEAR_CART);
		} catch (Exception e) {
			String failString = "清空购物车失败！";
			Log.info(failString);
		}
	}

	// 清空日志
	public static void clearLog() {
		try {
			FileWriter fw = new FileWriter(LOG_FILE_PATH, false);
			fw.write("");
			fw.flush();
			fw.close();
			String successString = "清空日志成功！";
			Log.info(successString);
		} catch (Exception e) {
			String failString = "清空日志失败！";
			Log.info(failString);
		}
	}

}
