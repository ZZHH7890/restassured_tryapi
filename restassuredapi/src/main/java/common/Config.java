package common;

import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import io.restassured.path.json.JsonPath;
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
	// 获取地址列表接口信息在表格第7行
	public static final int API_GET_ADDRESS = 7;
	// 删除地址列表接口信息在表格第6行
	public static final int API_DELETE_ADDRESS = 6;
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
	// 日志存放的路径
	public static final String LOG_FILE_PATH = "C:\\Users\\Administrator\\eclipse-workspace\\restassured_tryapi\\restassuredapi\\log\\logfile.log";

	// 生成用户token
	public static String getToken() {
		try {
			Map<String, String> configMap = HandlerExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
					Config.EXCEL_CONFIG_SHEET, Config.TEST_ENV);
			Response response = RestAssuredMethods.httpRequest(API_LOGIN, configMap.get("loginData"));
			return response.path("token");
		} catch (Exception e) {
			String failString = "获取用户token执行失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 用户token写入excel
	public static void initToken() {
		try {
			HandlerExcel.setTokenToCell(EXCEL_PATH, EXCEL_NAME, EXCEL_API_SHEET, getToken());
			String succString = "用户token写入excel成功！";
			Log.info(succString);
		} catch (Exception e) {
			String failString = "用户token写入excel失败！";
			Log.info(failString);
		}
	}

	// 初始化收货地址
	public static String initAddress() {
		try {
			Map<String, String> configMap = HandlerExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
					Config.EXCEL_CONFIG_SHEET, Config.TEST_ENV);
			Response response = RestAssuredMethods.httpRequest(API_ADD_ADDRESS, configMap.get("initAddress"));
			String succString = "初始化收货地址成功！！";
			Log.info(succString + response.asString());
			return succString;
		} catch (Exception e) {
			String failString = "获取用户token执行失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 清空用户token
	public static void clearToken() {
		try {
			HandlerExcel.setTokenToCell(EXCEL_PATH, EXCEL_NAME, EXCEL_API_SHEET, "");
			String succString = "清空用户token成功！";
			Log.info(succString);
		} catch (Exception e) {
			String failString = "清空用户token失败！";
			Log.info(failString);
		}
	}

	// 清空购物车
	public static void clearCart() {
		try {
			RestAssuredMethods.httpRequest(Config.API_CLEAR_CART);
			Log.info("清空购物车成功：");
		} catch (Exception e) {
			String failString = "清空购物车失败！";
			Log.info(failString);
		}
	}

	// 清空用户地址
	public static void clearAddress() {
		try {
			Response response = RestAssuredMethods.httpRequest(Config.API_GET_ADDRESS);
			JsonPath jsonPath = new JsonPath(response.asString());
			ArrayList<Integer> addressIds = jsonPath.get("id");
			if (addressIds.size() != 0) {
				Iterator<Integer> iterator = addressIds.iterator();
				while (iterator.hasNext()) {
					String string = String.valueOf(iterator.next());
					RestAssuredMethods.httpRequest(Config.API_DELETE_ADDRESS, string);
				}
				Log.info("清空用户地址成功");
			} else {
				Log.info("用户没有地址，不需要清空地址操作!");
			}

		} catch (Exception e) {
			String failString = "清空购物车失败！";
			Log.info(failString);
		}
	}

	// 清空日志
	public static void initLog() {
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
