import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://acc-dev.outsystemsenterprise.com/ACCMVPCMS/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Login/npk_email'), Email)

WebUI.setText(findTestObject('Page_Login/password'), Password)

WebUI.click(findTestObject('Page_Login/eye_icon'))

WebUI.click(findTestObject('Page_Login/button-login'))

if (WebUI.verifyElementVisible(findTestObject('Page_Homepage/div_Welcome to ACC MVP CMS'), FailureHandling.OPTIONAL)) {
    print('Login Success!')
}

if (WebUI.verifyElementVisible(findTestObject('Page_Login/error_Something went wrong, please try again later'), FailureHandling.OPTIONAL)) {
    print('Fill Neccessary Field')
} else if (WebUI.verifyElementVisible(findTestObject('Page_Login/error_Invalid Credential'), FailureHandling.OPTIONAL)) {
    print('Check Credentials!')
}

