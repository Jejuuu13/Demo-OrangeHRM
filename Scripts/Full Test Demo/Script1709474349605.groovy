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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData input = findTestData('Data Files/Excel Data')

// Buka Browser Edge & Fullscreen Window :
WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
WebUI.maximizeWindow()

// Direct link ke Opensource Web (Orangehrm) :
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Jika Web belum load up dengan sempurna : 
if (WebUI.verifyElementPresent(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/input_Username_username'), 5) == false) {
	WebUI.refresh()
}
	else {
		for (int baris = 1; baris <= 3; baris++) {
			
			// Username & Password : Input
			WebUI.setText(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/input_Username_username'), input.getValue('Username', baris))
			WebUI.delay(2)
			
			WebUI.setText(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/input_Password_password'), input.getValue('Password', baris))
			WebUI.delay(2)
			
			// Encrypted Password : 
//			WebUI.setEncryptedText(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')
//			WebUI.delay(2)
			
			// Login to Homepage :
			WebUI.click(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/button_Login'))
			WebUI.delay(5)
			
			// Logout :
			WebUI.click(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/i_Dashboard_oxd-icon bi-caret-down-fill oxd_d2fd49'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/New Folder (1)/Page_OrangeHRM/a_Logout'))
			
		}

		
	}




