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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.io.IOException as IOException
import org.openqa.selenium.NoSuchWindowException as NoSuchWindowException
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.Select as Select

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

WebDriverWait wait = new WebDriverWait(driver, 300, 5000)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://ss3.shipstation.com/')

WebUI.setText(findTestObject('ShipStatus_Page/LoginPage/input_EmailUsername_username'), 'Katalon')

WebUI.setText(findTestObject('ShipStatus_Page/LoginPage/input_Password_password'), 'My100%script')

WebUI.click(findTestObject('ShipStatus_Page/LoginPage/button_Login_btn'))

WebUI.waitForElementVisible(findTestObject('ShipStatus_Page/Page_Dashboard/a_orderLink'), 60)

WebUI.click(findTestObject('ShipStatus_Page/Page_Dashboard/a_orderLink'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('ShipStatus_Page/Page_Orders/awaiting shipment'), 30)

WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/select_Tag'))

WebUI.waitForElementVisible(findTestObject('ShipStatus_Page/Page_Orders/filter_Katalon tag'), 10)

WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/filter_Katalon tag'))

int k = 0

while (true) {
    WebUI.waitForElementVisible(findTestObject('ShipStatus_Page/Page_Orders/text_Order ID'), 120)

    String pastOrder = WebUI.getText(findTestObject('ShipStatus_Page/Page_Orders/text_Order ID')).split(' ')[1]

    addressBlock = WebUI.getText(findTestObject('ShipStatus_Page/Page_Orders/text_Customer address'))

    String firstName = ''

    String lastName = ''

    String address = ''

    String city = ''

    String state = ''

    String postalCode = ''

    String phone = ''

    String company = ''

    String floor = ''

    String[] cust = WebUI.getText(findTestObject('address1')).split('\n')

    String[] block = WebUI.getText(findTestObject('add2')).split('\n')

    if (cust.length == 2) {
        firstName = (cust[0].split(' ')[0])

        lastName = (cust[0].split(' ')[1])

        address = (cust[1])
    } else if (cust.length == 3) {
        firstName = (cust[0].split(' ')[0])

        lastName = (cust[0].split(' ')[1])

        company = (cust[1])

        address = (cust[2])
    } else if (cust.length == 4) {
        firstName = (cust[0].split(' ')[0])

        lastName = (cust[0].split(' ')[1])

        company = (cust[1])

        address = (cust[2])

        floor = (cust[3])
    }
    
    String[] country = block[(cust.length + 1)].split(',')

    city = (country[0])

    String[] StatePostCont = country[1].split(' ')

    state = (StatePostCont[1])

    for (int i = 2; i < (StatePostCont.length - 1); i++) {
        postalCode += ((StatePostCont[i]) + ' ')
    }
    
    if (((block.length - 2) - cust.length) > 1) {
        phone = (block[(block.length - 2)])
    }
    
    if (phone == '') {
        phone = '(614) 954-2736'
    }
    
    String productName = ''

    String ConfirmID = ''

    'Get appropriate product name'
    if (driver.findElements(By.xpath('//div[@class=\'tab-pane section-details clearfix active\']//input[@class=\'form-control item-description input-sm\']')).size() > 
    0) {
        //if (WebUI.verifyElementVisible(findTestObject('ShipStatus_Page/Page_Orders/input_Product description'), FailureHandling.CONTINUE_ON_FAILURE)) {
        productName = WebUI.getAttribute(findTestObject('ShipStatus_Page/Page_Orders/input_Product description'), 'value')
    } else {
        productName = WebUI.getText(findTestObject('productName2'))
    }
    
    giftMessage = WebUI.getText(findTestObject('ShipStatus_Page/Page_Orders/text_gift message'))

    if (giftMessage.equals('None')) {
        giftMessage = WebUI.getText(findTestObject('ShipStatus_Page/Page_Orders/text_another gift'))
    }
    
    js.executeScript('window.open();')

    try {
        siteName = driver.findElement(By.xpath(('//*[text()=\'' + pastOrder) + '\']/../../../td[@data-column=\'WarehouseID\']//a')).getText()

        siteUrl = ''

        switch (siteName) {
            case 'wine.com':
                siteUrl = 'https://click.linksynergy.com/fs-bin/click?id=FzJ6p9pgbic&offerid=209195.10003402&type=3&subid=0'

                break
            case 'Everythngwine.ca BC':
                siteUrl = 'https://www.everythingwine.ca/'

                break
        }
        
        WebUI.switchToWindowIndex(1)

        'WINE.COM'
        if (siteUrl.equals('https://click.linksynergy.com/fs-bin/click?id=FzJ6p9pgbic&offerid=209195.10003402&type=3&subid=0')) {
            WebUI.navigateToUrl(siteUrl)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/button_Account'))

            'Verifing is user loged in'
            if (!(WebUI.verifyElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/text_Welcome'), 
                FailureHandling.CONTINUE_ON_FAILURE))) {
                WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Email_email'), 
                    10)

                WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Email_email'), 'jefflibsen@gmail.com')

                WebUI.setEncryptedText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Password_password'), 
                    'm3qJssA67VtARSrQgNc0Ww==')

                WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/button_Sign In'))

                WebUI.waitForElementNotPresent(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/button_Sign In'), 
                    10)
            }
            
            WebUI.selectOptionByValue(findTestObject('Wine_Page/select_State'), state, false)

            WebUI.delay(5)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_search items'), productName)

            WebUI.delay(3)

            WebUI.sendKeys(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_search items'), Keys.chord(
                    Keys.ENTER))

            'The 1st stop'
            WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/a_Check Out'), 120, 
                FailureHandling.OPTIONAL)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/a_Check Out'))

            if (WebUI.verifyElementVisible(findTestObject('Wine_Page/header_change address'), FailureHandling.CONTINUE_ON_FAILURE)) {
                WebUI.click(findTestObject('Wine_Page/header_change address'))
            }
            
            WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/a_Add a new address'), 
                10)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/a_Add a new address'))

            WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/span_Ship to home or work_form'), 
                10)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/span_Ship to home or work_form'))

            WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_First Name_firstName'), 
                10)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_First Name_firstName'), firstName)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Last Name_lastName'), lastName)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_company'), company)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Street Address_address1'), 
                address)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_City_city'), city)

            WebUI.selectOptionByValue(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/select_AKALARAZCACOCTDCDEFLGAH'), 
                state, true)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Zip_zip'), postalCode)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/input_Phone  (mobile preferred'), 
                phone)

            WebUI.delay(5)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/span_See gift options_formWrap'))

            String isGift = WebUI.getAttribute(findTestObject('Wine_Page/checkbox_Gift'), 'class')

            if (isGift.contains('hidden')) {
                WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/span_See gift options_formWrap'))

                WebUI.delay(2)
            }
            
            WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/textarea_See gift options_gift'), 
                10)

            WebUI.setText(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/textarea_See gift options_gift'), 
                giftMessage)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/span_s_formWrap_radioSpan gift'))

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/a_Continue'))

            WebUI.waitForElementVisible(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/button_Verify address'), 
                30)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/button_Verify address'), FailureHandling.STOP_ON_FAILURE)

            WebUI.waitForElementVisible(findTestObject('Wine_Page/spinner'), 10)

            WebUI.waitForElementNotVisible(findTestObject('Wine_Page/spinner'), 20)

            WebUI.click(findTestObject('Wine_Page/Page_Wine.com - Wine Wine Gifts and/button_Continue'))

            not_run: if ((21 - Integer.parseInt(shipDate)) < 0) {
                not_run: js.executeScript('arguments[0].setAttribute(\'style\', \'background: yellow; border: 2px solid red;\');', 
                    driver.findElement(By.cssSelector('.deliveryHeader_date')))
            }
            
            not_run: WebUI.waitForElementPresent(findTestObject('Wine_Page/button_Place order'), 300)

            'The 2nd stop. If you need to increase the time, set new value into Input field in seconds'
            not_run: WebUI.waitForElementPresent(findTestObject('Wine_Page/text_orderID'), 360)

            not_run: WebUI.delay(3)

            not_run: ConfirmID = WebUI.getText(findTestObject('Wine_Page/text_orderID'), FailureHandling.STOP_ON_FAILURE //if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__loginusername'), FailureHandling.CONTINUE_ON_FAILURE)) {
                )
        } else if (siteUrl.equals('https://www.everythingwine.ca/')) {
            'everythingwine CA'
            WebUI.navigateToUrl(siteUrl)

            'Aftet first visit popup will show and it will be closed'
            if (k == 0) {
                WebUI.waitForElementVisible(findTestObject('Page_Buy Wine Online  BCs largest w/close Modal'), 15)

                WebUI.click(findTestObject('Page_Buy Wine Online  BCs largest w/close Modal'))

                k = (k + 1)
            }
            
            '"PRODUCT NAME"'
            WebUI.setText(findTestObject('Object Repository/Page_Buy Wine Online  BCs largest w/input_Search_q'), productName)

            WebUI.sendKeys(findTestObject('Page_Buy Wine Online  BCs largest w/input_Search_q'), Keys.chord(Keys.ENTER))

            not_run: WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Search results for Stags Leap/button_Buy'), 
                10)

            not_run: WebUI.click(findTestObject('Object Repository/Page_Search results for Stags Leap/button_Buy'))

            'If first buy'
            not_run: if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_242081 Stags Leap Wine Cellars/label_Delivery'), 
                FailureHandling.CONTINUE_ON_FAILURE)) {
                not_run: WebUI.click(findTestObject('Object Repository/Page_242081 Stags Leap Wine Cellars/label_Delivery'))

                not_run: WebUI.click(findTestObject('Object Repository/Page_242081 Stags Leap Wine Cellars/button_Accept'))

                not_run: WebUI.waitForElementPresent(findTestObject('Object Repository/Page_242081 Stags Leap Wine Cellars/button_Buy'), 
                    10)

                not_run: WebUI.click(findTestObject('Object Repository/Page_242081 Stags Leap Wine Cellars/button_Buy'))
            }
            
            'wait fot 2 min until continue'
            WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Shopping Cart  Everything Wine/button_Proceed to Checkout'), 
                300)

            'wait fot 2 min until continue'
            WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Shopping Cart  Everything Wine/button_Proceed to Checkout'), 
                300)

            WebUI.delay(3)

            'First login\r\n'
            if (WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__loginusername'), 
                5, FailureHandling.CONTINUE_ON_FAILURE)) {
                WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__loginusername'), 'jefflibsen@gmail.com')

                WebUI.setEncryptedText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__loginpassword'), 
                    'hu5wyreiopZhAJ8iC7MqUA==')

                WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Log In'))
            }
            
            if (WebUI.getAttribute(findTestObject('evthWine_First block'), 'id').contains('billing')) {
                WebUI.click(findTestObject('evthWine_shipAnother'))

                WebUI.click(findTestObject('evthWine_nextBilling'))

                WebUI.delay(5)
            }
            
            WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout  Everything Wine/select_Lee Almeroth 326 W 13 A'), 
                10, FailureHandling.STOP_ON_FAILURE)

            WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Checkout  Everything Wine/select_Lee Almeroth 326 W 13 A'), 
                'New Address', false)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__billingfirstname'), firstName)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__billinglastname'), lastName)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__billingstreet'), address)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__billingcity'), city)

            WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Checkout  Everything Wine/select_Afghanistanland Islands'), 
                'CA', true)

            WebUI.delay(1)

            WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Checkout  Everything Wine/select_- Choose -'), 
                '67', true)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__billingpostcode'), postalCode)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/input__billingtelephone'), phone)

            WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Continue'))

            WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout  Everything Wine/textarea_Gift Message AndOr Sp'), 
                10)

            WebUI.delay(5)

            WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/input_Choose Another Store To'))

            List<WebElement> list = driver.findElements(By.xpath('//li[@class=\'gift-item\']//select'))

            for (def el : list) {
                Select select = new Select(el)

                select.selectByValue('1')
            }
            
            not_run: WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Checkout  Everything Wine/select_Do not gift wrapWrap th'), 
                '1', true)

            WebUI.setText(findTestObject('Object Repository/Page_Checkout  Everything Wine/textarea_Gift Message AndOr Sp'), 
                giftMessage)

            WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Continue_1'))

            WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout  Everything Wine/span_Loading next step...'), 
                10)

            WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/span_Loading next step...'))

            WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Continue_2'), 
                10)

            WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Continue_2'))

            WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Continue_3'), 
                10)

            WebUI.scrollToPosition(0, 300)

            WebUI.delay(2)

            WebUI.click(findTestObject('Object Repository/Page_Checkout  Everything Wine/button_Continue_3'))

            WebUI.waitForElementVisible(findTestObject('evthWine_PlaceOrder button'), 120)

            WebUI.click(findTestObject('evthWine_agreement'))

            not_run: WebUI.waitForElementVisible(findTestObject('evthWine_OrderID'), 300)

            not_run: ConfirmID = WebUI.getText(findTestObject('evthWine_OrderID'))
        } else {
        }
        
        js.executeScript('window.close();')

        WebUI.switchToWindowTitle('Orders :: ShipStation')

        not_run: WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/CustomeField2'))

        not_run: WebUI.delay(5)

        not_run: WebUI.setText(findTestObject('Wine_Page/textarea_customer2'), ConfirmID, FailureHandling.STOP_ON_FAILURE)

        not_run: WebUI.delay(1)

        not_run: WebUI.sendKeys(findTestObject('Wine_Page/textarea_customer2'), Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER))

        not_run: WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/select_Tags'))

        not_run: WebUI.waitForElementVisible(findTestObject('ShipStatus_Page/Page_Orders/tag_Tracking'), 10)

        not_run: WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/tag_Tracking'))

        not_run: if (!(WebUI.getText(findTestObject('Wine_Page/is_tracking_check_box')).contains('selected'))) {
            WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/tag_Tracking'))
        }
        
        not_run: WebUI.delay(1)

        not_run: WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/tag_KATALON'))

        not_run: if (WebUI.getText(findTestObject('Wine_Page/is_tracking_check_box')).contains('selected')) {
            WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/tag_KATALON'))
        }
        
        WebUI.click(findTestObject('ShipStatus_Page/Page_Orders/button_close'))

        WebUI.waitForElementVisible(findTestObject('ShipStatus_Page/Page_Orders/awaiting shipment'), 30 // }
            )
    }
    catch (Exception e) {
        WebUI.delay(45)

        WebUI.switchToWindowIndex(0)

        if (driver.findElement(By.xpath(('//div[@class=\'order-num\' and text() !=\'' + pastOrder) + '\']')).isDisplayed()) {
            continue
        }
    } 
}

