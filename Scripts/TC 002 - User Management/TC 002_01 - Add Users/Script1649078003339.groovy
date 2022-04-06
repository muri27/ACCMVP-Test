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

WebUI.click(findTestObject('Object Repository/Page_Homepage/a_User Management'))

WebUI.click(findTestObject('Object Repository/Page_User Management/button_add_user'))

WebUI.setText(findTestObject('Object Repository/Page_Detail User Management/input_nama'), Name)

WebUI.setText(findTestObject('Object Repository/Page_Detail User Management/input_NPK'), NPK)

WebUI.setText(findTestObject('Object Repository/Page_Detail User Management/input_Email'), Email)

WebUI.setText(findTestObject('Page_Detail User Management/input_Phone'), Phone)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Detail User Management/Select Role'), Role, true)

WebUI.scrollToElement(findTestObject('Page_Detail User Management/button_save'), 0)

WebUI.click(findTestObject('Page_Detail User Management/eye_icon_password_add_user'))

WebUI.setText(findTestObject('Page_Detail User Management/input_Password'), Password)

WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_save'))

if (WebUI.verifyElementVisible(findTestObject('Page_User Management/succes_Data berhasil diinput'), FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('Page_User Management/a_next_pagination'), 0)

    while (WebUI.verifyTextNotPresent(NPK, false) == true) {
        if (WebUI.verifyTextPresent(NPK, false, FailureHandling.OPTIONAL)) {
                
			print("success Add User")
            
            break
        } else {
            WebUI.click(findTestObject('Page_User Management/a_next'))
        }
    }
}

if (WebUI.verifyElementVisible(findTestObject('Page_Detail User Management/error_Please fix the existing errors before saving'), 
    FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Detail User Management/close_error_Please fix the existing errors before sav_5b3f25'))

    WebUI.scrollToElement(findTestObject('Page_Detail User Management/button_save'), 0)

    WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_cancel'))
}

if (WebUI.verifyElementVisible(findTestObject('Page_Detail User Management/error_Email already been taken'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Detail User Management/close_error_Email already been taken'))

    WebUI.scrollToElement(findTestObject('Page_Detail User Management/button_save'), 0)

    WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_cancel'))
}

if (WebUI.verifyElementVisible(findTestObject('Page_Detail User Management/error_NPK already been taken'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Detail User Management/close_error_NPK already been taken'))

    WebUI.scrollToElement(findTestObject('Page_Detail User Management/button_save'), 0)

    WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_cancel'))
}

