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
	// http请求
	public static Response httpRequest(int apiRow, String... postData) throws IOException {
		Log.startTestCase("开始调用httpRequest");
		Map<String, String> configMap = HandlerExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
				Config.EXCEL_CONFIG_SHEET, Config.TEST_ENV);
		Map<String, String> apiMap = HandlerExcel.getApiMap(Config.EXCEL_PATH, Config.EXCEL_NAME,
				Config.EXCEL_API_SHEET, apiRow);
		Response response = null;
		switch (apiMap.get("requestMethod")) {
		case "post":
			response = given().contentType(apiMap.get("contentType")).header("token", apiMap.get("token"))
					.header("region", configMap.get("region")).body(postData[0])
					.post(configMap.get("host") + apiMap.get("api"));
			break;
		case "put":
			response = given().contentType(apiMap.get("contentType")).header("token", apiMap.get("token"))
					.header("region", configMap.get("region")).body(postData[0])
					.put(configMap.get("host") + apiMap.get("api"));
			break;
		case "get":
			response = given().contentType(apiMap.get("contentType")).header("token", apiMap.get("token"))
					.header("region", configMap.get("region")).get(configMap.get("host") + apiMap.get("api"));
			break;
		case "delete":
			if (postData.length > 0) {
				Log.info("http delete method with parameter");
				response = given().contentType("application/json").header("token", apiMap.get("token"))
						.header("region", configMap.get("region"))
						.delete(configMap.get("host") + apiMap.get("api") + postData[0]);
			} else {
				Log.info("http delete method with no parameter");
				response = given().contentType("application/json").header("token", apiMap.get("token"))
						.header("region", configMap.get("region")).delete(configMap.get("host") + apiMap.get("api"));
			}
			break;
		default:
			Log.info("请求方法无法识别, 请求失败");
			break;
		}

		if (response != null) {
			Log.info("测试接口返回：" + response.asString());
		} else {
			Log.info("接口" + apiMap.get("api") + "请求失败");
		}
		Log.endTestCase("结束调用httpRequest");
		return response;
	}

}
