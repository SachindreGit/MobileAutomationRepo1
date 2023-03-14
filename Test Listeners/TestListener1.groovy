import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class TestListener1 {
	
	TestSuiteContext suiteContext;
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		
		//To set the test name at LambdaTest.
		RunConfiguration.setDriverPreferencesProperty("Remote", "name", testCaseContext.getTestCaseId());
		if (suiteContext != null){
			RunConfiguration.setDriverPreferencesProperty("Remote","build", suiteContext.getTestSuiteId());
		}
		println testCaseContext.getTestCaseId();
		println RunConfiguration.getDriverPreferencesProperties();
		
		println 'I am inside beforeTestCase'
	}
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		//To set the status of test at LambdaTest.
		String result="failed";
		if(testCaseContext.getTestCaseStatus().equalsIgnoreCase("PASSED")){
			result="passed"
		}
		println 'TestCaseStatus: ' + result
		
		//try{
		//	WebUI.executeJavaScript("lambda-status="+result,null)
		//}catch (Exception e)
		//{
		//	println e.toString()
		//}
		//finally {
		//	WebUI.closeBrowser()
		//}
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		
		println 'I am inside afterTestCase'
	}
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		suiteContext=testSuiteContext
		//To Set the build Name at LambdaTest.
		RunConfiguration.setDriverPreferencesProperty("Remote","build", suiteContext.getTestSuiteId());
		println testSuiteContext.getTestSuiteId()
		
		println 'I am inside beforeTestSuite'
	}
	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
		println 'I am inside afterTestSuite'
	}
}