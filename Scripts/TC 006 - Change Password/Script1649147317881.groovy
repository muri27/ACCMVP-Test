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

WebUI.click(findTestObject('Object Repository/Change Password/div_Rifkii'))

WebUI.click(findTestObject('Object Repository/Change Password/a_Change Password'))

WebUI.setText(findTestObject('Object Repository/Change Password/input_Old Password'), GlobalVariable.Password)

WebUI.click(findTestObject('Object Repository/Change Password/icon_eye_Old Password'))

WebUI.setText(findTestObject('Object Repository/Change Password/input_New Password'), NewPassword)

WebUI.click(findTestObject('Object Repository/Change Password/icon_eye_New Password'))

WebUI.setText(findTestObject('Object Repository/Change Password/input_Confirm New Password'), Confirm)

WebUI.click(findTestObject('Object Repository/Change Password/icon_eye_Confirm New Password'))

WebUI.click(findTestObject('Object Repository/Change Password/button_change'))

if (WebUI.verifyElementVisible(findTestObject('Change Password/success_Password berhasil diubah'), FailureHandling.OPTIONAL)) {
    print('Success')
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/Change Password/error_Old Password is invalid'), 
    FailureHandling.OPTIONAL)) {
    print('Old Password Invalid')

    WebUI.click(findTestObject('Object Repository/Change Password/button_cancel'))
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/Change Password/error_Something went wrong, please try again later'), 
    FailureHandling.OPTIONAL)) {
    print('Please Fill Form !')

    WebUI.click(findTestObject('Object Repository/Change Password/button_cancel'))
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/Change Password/error_Password confirmation does not match'), 
    FailureHandling.OPTIONAL)) {
    print('New Password did not match')

    WebUI.click(findTestObject('Object Repository/Change Password/button_cancel'))
}

