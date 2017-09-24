package restassuredapi;

import java.util.HashMap;
import java.util.Map;

/**
*@author 张大爷
*@time 2017年9月23日 下午10:23:13
*Just a joke
*/

public class TrytMap {

	public static void main(String[] args) {
		Map <String, String> map = new HashMap<String, String>();
		map.put("region", "121");
		map.put("host", "http://release.thy360.com");
		String hoString = map.get("host");
		System.out.println(hoString);
		String reString = map.get("region");
		System.out.println(reString);
	}

}
