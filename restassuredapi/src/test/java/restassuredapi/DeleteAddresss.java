package restassuredapi;

import org.testng.annotations.Test;

import common.Config;
import common.Log;
import common.RestAssuredMethods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterClass;

public class DeleteAddresss {
	@Test
  public void f() {
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


	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

}
