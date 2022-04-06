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

WebUI.openBrowser('https://acc-dev.outsystemsenterprise.com/ACCMVPFormulirOrder')

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Requester Name'), Name)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Phone'), Phone)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Email'), Email)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Formulir Order Techno/select_Select Project Section'), 
    Section, true)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Project Name'), ProjectName)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/textarea_Project Description'), ProjectDesc)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Formulir Order Techno/select_Select Project Size'), Size, 
    true)

WebUI.click(findTestObject('Object Repository/Page_Formulir Order Techno/input_checkbox'))

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Quantity'), Quantity)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_File Timeline'), LinkTimeline)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Formulir Order Techno/select_Select Project Type'), Type, 
    true)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Request ID Project'), RequestId)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/input_Link Board Project'), LinkBoard)

WebUI.setText(findTestObject('Object Repository/Page_Formulir Order Techno/textarea_List email'), ListEmail)

WebUI.click(findTestObject('Object Repository/Page_Formulir Order Techno/button_submit'))

if (WebUI.verifyElementVisible(findTestObject('Page_Formulir Order Techno/success_Order Project Created'), FailureHandling.OPTIONAL)) {
    print('Project Created !')
} else if (WebUI.verifyElementVisible(findTestObject('Page_Formulir Order Techno/error_Invalid Email Address'), FailureHandling.OPTIONAL)) {
    print('Domain must @acc.co.id')
} else if (WebUI.verifyElementVisible(findTestObject('Page_Formulir Order Techno/error_Pilih Resource yang diperlukan'), 
    FailureHandling.OPTIONAL)) {
    print('Resource must fill !')
} else if (WebUI.verifyElementVisible(findTestObject('Page_Formulir Order Techno/error_Update Project Failed'), FailureHandling.OPTIONAL)) {
    print('Fix Error')
}

