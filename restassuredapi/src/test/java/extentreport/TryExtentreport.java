package extentreport;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.Assert;

public class TryExtentreport extends BaseExample{
	 @Test
	    public void passTest() {
	        test = extent.startTest("passTest");
	        test.log(LogStatus.PASS, "Pass");
	        
	        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	    }
	    
	    @Test
	    public void intentionalFailure() throws Exception {
	        test = extent.startTest("intentionalFailure");
	        throw new Exception("intentional failure");        
	    }

}
