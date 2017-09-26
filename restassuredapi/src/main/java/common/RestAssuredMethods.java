package common;
/**
*@author 张大爷
*@time 2017年9月24日 下午10:12:53
*Just a joke
*/

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.restassured.response.Response;

public class RestAssuredMethods {
	
	public static Response httpRequest(String postData, int apiRow) {
		
	}
	

	public static Response postMethod(String postData, int apiRow) throws IOException {
		Log.startTestCase("开始调用postMethod");
		Response response = null;
		Map<String, String> configMap = HandlerExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
				Config.EXCEL_CONFIG_SHEET, Config.TEST_ENV);
		Map<String, String> apiMap = HandlerExcel.getApiMap(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.EXCEL_API_SHEET,
				apiRow);
		if ("application/json".contentEquals(apiMap.get("contentType"))) {
			response = given().contentType("application/json").header("token", apiMap.get("token"))
					.header("region", configMap.get("region")).body(postData)
					.post(configMap.get("host") + apiMap.get("api"));
		}
		if (response != null) {
			Log.info("测试接口返回：" + response.asString());
		} else {
			Log.info("接口" + apiMap.get("api") + "请求失败");
		}
		Log.endTestCase("结束调用postMethod");
		return response;
	}

	public static Response deleteMethod(int apiRow) throws IOException {
		Log.startTestCase("开始调用deleteMethod");
		Response response = null;
		Map<String, String> configMap = HandlerExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
				Config.EXCEL_CONFIG_SHEET, Config.TEST_ENV);
		Map<String, String> apiMap = HandlerExcel.getApiMap(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.EXCEL_API_SHEET,
				apiRow);
		response = given().contentType("application/json").header("token", apiMap.get("token"))
				.header("region", configMap.get("region")).delete(configMap.get("host") + apiMap.get("api"));
		if (response != null) {
			Log.info("测试接口返回：" + response.asString());
		} else {
			Log.info("接口" + apiMap.get("api") + "请求失败");
		}
		Log.endTestCase("结束调用deleteMethod");
		return response;
	}

}
