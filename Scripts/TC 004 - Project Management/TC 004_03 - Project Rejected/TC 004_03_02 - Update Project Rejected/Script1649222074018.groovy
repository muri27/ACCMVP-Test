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

WebUI.click(findTestObject('Page_Project Rejected/button_update'))

WebUI.setText(findTestObject('Page_Detail Project/input_Requester Name'), Name)

WebUI.setText(findTestObject('Page_Detail Project/input_Phone'), Phone)

WebUI.setText(findTestObject('Page_Detail Project/input_Email'), Email)

WebUI.selectOptionByValue(findTestObject('Page_Detail Project/select_Select Project Section'), Section, true)

WebUI.selectOptionByValue(findTestObject('Page_Detail Project/select_Select Project Size'), Size, true)

WebUI.setText(findTestObject('Page_Detail Project/input_Project Name'), ProjectName)

WebUI.setText(findTestObject('Page_Detail Project/textarea_Project desc'), ProjectDesc)

if (WebUI.verifyElementNotChecked(findTestObject('Page_Detail Project/input_checkbox'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Detail Project/input_checkbox'))
}

WebUI.setText(findTestObject('Page_Detail Project/input_Quantity'), ProjectDesc)

WebUI.selectOptionByValue(findTestObject('Page_Detail Project/select_Select Project'), Type, true)

WebUI.setText(findTestObject('Page_Detail Project/input_Request ID Project'), RequestId)

WebUI.setText(findTestObject('Page_Detail Project/input_Link Board Project'), LinkBoard)

WebUI.setText(findTestObject('Page_Detail Project/textarea_List email'), ListEmail)

WebUI.click(findTestObject('Page_Detail Project/button_save'))

if (WebUI.verifyElementVisible(findTestObject('error_Pilih Resource yang diperlukan'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Detail Project/button_back'))
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/error_new_page_Invalid Email Address'), FailureHandling.OPTIONAL)) {
    print('Invalid Email')
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/success_Order Project Updated'), FailureHandling.OPTIONAL)) {
    print('Success')
}

