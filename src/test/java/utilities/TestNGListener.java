package utilities;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseClass;

public class TestNGListener extends BaseClass implements ITestListener  {

	ExtentReports ext = ExtentManager.createExtentReports();

	@Override
	public synchronized void onStart(ITestContext context) {
		ext.createTest(context.getName())
				.info("suite execution starts");

	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		ext.createTest(context.getName())
				.info("suite execution ends");
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		ext.createTest(result.getName())
				.info(result.getName()+"test starts");
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		CommonUtility.getScreenShot(driver, passedTCSSPath+result.getName()+".png");
		ext.createTest(result.getName())
				.addScreenCaptureFromPath(passedTCSSPath)
				.info(result.getName()+"test success !!");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		CommonUtility.getScreenShot(driver, failedTCSSPath+result.getName()+".png");
		ext.createTest(result.getName())
				.addScreenCaptureFromPath(failedTCSSPath)
				.fail(result.getName()+"test failed !!");
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		ext.createTest(result.getName())
				.skip(result.getName()+"test success !!");
	}
}
