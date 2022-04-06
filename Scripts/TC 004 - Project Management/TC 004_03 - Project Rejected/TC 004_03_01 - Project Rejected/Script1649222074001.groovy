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

WebUI.callTestCase(findTestCase('TC 001 - Login'), [('Email') : GlobalVariable.Email, ('Password') : GlobalVariable.Password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Incoming Project/section_Project Management'))

WebUI.click(findTestObject('Object Repository/a_Project Rejected'))

WebUI.click(findTestObject('Object Repository/Page_Project Rejected/button_download'))

WebUI.setText(findTestObject('Page_Project Rejected/search_text'), ProjectName)

WebUI.click(findTestObject('Page_Project Rejected/button_search'))

WebUI.click(findTestObject('Page_Project Rejected/button_clear'))

if (Role == 'SuperAdmin') {
    WebUI.click(findTestObject('Page_Project Rejected/button_template'))

    WebUI.click(findTestObject('Page_Template Email/button_copy'))

    WebUI.click(findTestObject('Object Repository/Page_Template Email/button_close'))

    WebUI.callTestCase(findTestCase('TC 004 - Project Management/TC 004_03 - Project Rejected/TC 004_03_02 - Update Project Rejected'), 
        [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('TC 004 - Project Management/TC 004_03 - Project Rejected/TC 004_03_03 - Delete Project Rejected'), 
        [:], FailureHandling.STOP_ON_FAILURE)
} else if (Role == 'Admin') {
    WebUI.click(findTestObject('Page_Project Rejected/button_template_admin'))

    WebUI.click(findTestObject('Page_Template Email/button_copy'))

    WebUI.click(findTestObject('Object Repository/Page_Template Email/button_close'))
}

