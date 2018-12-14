import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.everythingwineandmore.ca/')

if (!(WebUI.waitForElementVisible(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/a_Jeffrey Ibsen'), 
    5, FailureHandling.CONTINUE_ON_FAILURE))) {
    WebUI.click(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/a_Log In'))

    WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/input_Username or Email_userna'), 
        'jefflibsen@gmail.com')

    WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/input_Password_password'), 
        'wineman1')

    WebUI.click(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/button_Log In'))
}
	
	WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/input_Wine search_searchText'), 
    'Monte Antico ')

WebUI.sendKeys(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More/input_Wine search_searchText'), 
    Keys.chord(Keys.ENTER))

not_run: WebUI.click(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Win/span_Add To Cart'))

not_run: WebUI.click(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Win/span_View Cart'))

not_run: WebUI.click(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/span_Proceed To Checkout'))

WebUI.waitForElementVisible(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/h1_Billing Information'), 
    300)

WebUI.selectOptionByValue(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/select_New Shipping AddressPic'), 
    'ShippingAddress', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/select_MonthJanFebMarAprMayJun'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/select_Day12345678910111213141'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/select_Year1900190119021903190'), 
    '1964', true)

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__ShipFirstName'), 
    'test')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__ShipLastName'), 
    'test')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__ShipAddress'), 
    'test')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__ShipCity'), 'test')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__ShipZipCode'), 
    'T2b 3J3')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__ShipMainPhone'), 
    '342-433-2394')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/textarea_Gift Message_giftMess'), 
    'test')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__nameOnCard'), 
    '1111222233334444')

WebUI.selectOptionByValue(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/select_--JanuaryFebruaryMarchA'), 
    '03', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/select_--201820192020202120222'), 
    '2020', true)

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__nameOnCard'), 
    '')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__CardNumber'), 
    '1111222233334444')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__nameOnCard'), 
    'SDsfs sf')

WebUI.setText(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/input__CVV2'), '132')

WebUI.click(findTestObject('Object Repository/ShipStatus_Page/Page_Everything Wine And More - Car/span_Continue  Review'))

