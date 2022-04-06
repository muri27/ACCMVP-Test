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

WebUI.click(findTestObject('Master Management/section_Master Management'))

if (Role == 'FE') {
    WebUI.click(findTestObject('Master Management/a_Master Front End'))
} else if (Role == 'BE') {
    WebUI.click(findTestObject('Master Management/a_Master Back End'))
} else if (Role == 'DA') {
    WebUI.click(findTestObject('Master Management/a_Master Data Automation'))
} else if (Role == 'QC') {
    WebUI.click(findTestObject('Master Management/a_Master Quality Control'))
} else if (Role == 'PSA') {
    WebUI.click(findTestObject('Master Management/a_Master PSA'))
}

WebUI.click(findTestObject('Master Management/input_Add_Item'))

WebUI.setText(findTestObject('Master Management/input_Name_Resource'), ResourceName)

WebUI.click(findTestObject('Master Management/button_save'))

if (WebUI.verifyElementVisible(findTestObject('Master Management/success_Data berhasil di input'), FailureHandling.OPTIONAL)) {
    print('Add Item Success')
} else if (WebUI.verifyElementVisible(findTestObject('Master Management/error_null_input'), FailureHandling.OPTIONAL)) {
    print('Add Item Gagal')

    WebUI.click(findTestObject('Master Management/button_cancel'))
}

