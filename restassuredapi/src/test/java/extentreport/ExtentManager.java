package extentreport;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author 张大爷
 * @time 2017年11月10日 下午6:00:57
 * @mail 767580776@qq.com
 * @automation
 */
public class ExtentManager {
	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter(String filePath) {
		if (extent == null) {
			extent = new ExtentReports(filePath, true);

			extent.addSystemInfo("Host Name", "Anshoo").addSystemInfo("Environment", "QA");
		}

		return extent;
	}
}
