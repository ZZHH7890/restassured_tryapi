package common;

/**
 * @author 张大爷
 * @time 2017年9月23日 上午12:14:50 Just a joke
 */

public class Config {

	// 测试环境：预发布环境为2，21环境为3
	public static final int TEST_ENV = 2;
	// excel登录接口信息在表格第2行
	public static final int API_LOGIN = 2;
	// excel增加地址接口信息在表格第5行
	public static final int API_ADD_ADDRESS = 5;
	// excel表格路径
	public static final String EXCEL_PATH = "C:\\Users\\Administrator\\eclipse-workspace\\restassured_tryapi\\restassuredapi\\ExcelForData";
	// excel表格名字
	public static final String EXCEL_NAME = "testData.xlsx";
	// excel表格config信息所在sheet
	public static final String EXCEL_CONFIG_SHEET = "config";
	// excel表格接口信息所在sheet
	public static final String EXCEL_API_SHEET = "api";
	// excel表格地址接口测试数据所在sheet
	public static final String DATA_ADDRESS_SHEET = "address";

}
