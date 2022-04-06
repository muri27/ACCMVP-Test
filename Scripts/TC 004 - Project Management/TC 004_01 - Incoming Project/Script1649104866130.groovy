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

WebUI.callTestCase(findTestCase('TC 001 - Login'), [('Email') : GlobalVariable.Email, ('Password') : GlobalVariable.Password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Incoming Project/section_Project Management'))

WebUI.click(findTestObject('Incoming Project/a_Incoming Project'))

WebUI.setText(findTestObject('Object Repository/Incoming Project/input_search'), ProjectName)

WebUI.click(findTestObject('Object Repository/Incoming Project/button_search'))

WebUI.click(findTestObject('Incoming Project/button_clear'))

WebUI.click(findTestObject('Object Repository/Incoming Project/button_detail'))

WebUI.scrollToElement(findTestObject('Incoming Project/button_back'), 0)

WebUI.click(findTestObject('Object Repository/Incoming Project/button_back'))

WebUI.click(findTestObject('Object Repository/Incoming Project/button_download'))

if (Status == 'registered') {
    WebUI.click(findTestObject('Object Repository/Incoming Project/button_registered'))

    if (WebUI.verifyElementVisible(findTestObject('Object Repository/Incoming Project/success_Update Status Success'), FailureHandling.OPTIONAL)) {
        print('Success')
    }
} else if (Status == 'rejected') {
    WebUI.click(findTestObject('Object Repository/Incoming Project/button_rejected'))

    if (WebUI.verifyElementVisible(findTestObject('Object Repository/Incoming Project/success_Update Status Success'), FailureHandling.OPTIONAL)) {
        print('Success')
    }
}

