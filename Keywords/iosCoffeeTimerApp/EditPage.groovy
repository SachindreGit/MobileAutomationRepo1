package iosCoffeeTimerApp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class EditPage {

	// Executed for each call of keyword
	public EditPage() {
		//println "EditPage - Init"

		def isSuccessElementPresent = Mobile.waitForElementPresent(findTestObject('iOS-CoffeeTimer-App/EditPage/XCUIElementTypeButton - Done'), 0)
		if(!isSuccessElementPresent) {
			println "EditPage - Mobile.waitForElementPresent - FALSE";
			throw new StepFailedException();
		}
		//println "EditPage - Mobile.waitForElementPresent - Done";
	}

	@Keyword(keywordObject="EditPage")
	def printConsole() {
		println 'EditPage - printConsole'
	}
}
