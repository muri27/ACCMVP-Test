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

WebUI.click(findTestObject('Object Repository/Page_Homepage/a_User Management'))

WebUI.click(findTestObject('Page_User Management/icon_update'))

WebUI.setText(findTestObject('Object Repository/Page_Detail User Management/input_nama'), Name)

WebUI.setText(findTestObject('Object Repository/Page_Detail User Management/input_NPK'), NPK)

WebUI.setText(findTestObject('Object Repository/Page_Detail User Management/input_Email'), Email)

WebUI.setText(findTestObject('Page_Detail User Management/input_Phone'), Phone)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Detail User Management/Select Role'), Role, true)

WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_save'))

if (WebUI.verifyElementVisible(findTestObject('Page_User Management/success_Data berhasil diupdate'), FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('Page_User Management/input_Search'), Name)

    WebUI.click(findTestObject('Page_User Management/button_search'))

    if (WebUI.verifyElementVisible(findTestObject('Page_User Management/section_No items to show'), FailureHandling.OPTIONAL)) {
        print('User Not Found')

        WebUI.click(findTestObject('Page_User Management/button_clear'))

        WebUI.callTestCase(findTestCase('TC 002 - User Management/TC 002_03 - Delete Users'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Page_User Management/toggle_active'))

        if (WebUI.verifyElementVisible(findTestObject('Page_User Management/success_Restore User Success'), FailureHandling.OPTIONAL)) {
            print('Restore User Success')
        }
    } else {
        print('User Found')

        WebUI.click(findTestObject('Page_User Management/button_clear'))

        WebUI.callTestCase(findTestCase('TC 002 - User Management/TC 002_03 - Delete Users'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Page_User Management/toggle_active'))

        if (WebUI.verifyElementVisible(findTestObject('Page_User Management/success_Restore User Success'), FailureHandling.OPTIONAL)) {
            print('Restore User Success')
        }
    }
}

if (WebUI.verifyElementVisible(findTestObject('Page_Detail User Management/error_Please fix the existing errors before saving'), 
    FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_cancel'))
}

if (WebUI.verifyElementVisible(findTestObject('Page_Detail User Management/error_Email already been taken'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_cancel'))
}

if (WebUI.verifyElementVisible(findTestObject('Page_Detail User Management/error_NPK already been taken'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Page_Detail User Management/button_cancel'))
}

