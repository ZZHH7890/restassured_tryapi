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
	public static Response postMethod(Map<String, String> configMap, Map<String, String> apiMap) throws IOException {
		Response response = null;
		configMap = ReadExcel.getConfigMap(Config.EXCEL_PATH, Config.EXCEL_NAME, Config.EXCEL_API_SHEET, Config.TEST_ENV);
		if ("application/json".contentEquals(apiMap.get("contentType"))) {
			response = given().contentType("application/json")
					.body(apiMap.get("postData"))
					.post(configMap.get("host") + apiMap.get("api"));
		}
		return response;
	}

}
