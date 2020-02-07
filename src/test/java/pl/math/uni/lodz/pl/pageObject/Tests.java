package pl.math.uni.lodz.pl.pageObject;
import org.junit.*;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

import static junit.framework.TestCase.*;


public class Tests {
    @BeforeClass
    public static void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    }

    @AfterClass
    public static void afterTests(){
        //ChromeDriver.quit();
    }

    @Test
    public void T1() {
        ChromeDriver.navigate(Page.getPage() + "basic-first-form-demo.html");
        P1 page = new P1();
        page.setInputTextElement("testMessage");
        page.clickSubmitButton();
        assertEquals("testMessage",page.getResultText());
    }

    @Test
    public void T2() {
        ChromeDriver.navigate(Page.getPage() + "basic-first-form-demo.html");
        P2 page = new P2();
        page.setInputAField("1");
        page.setInputBField("2");
        ChromeDriver.await();
        page.clickSubmitButton();
        ChromeDriver.await();
        assertEquals("3",page.getResultText());
    }

    @Test
    public void T3(){
        ChromeDriver.navigate(Page.getPage() + "basic-checkbox-demo.html");
        P3 page = new P3();
        page.setRbElement();
        assertEquals(page.getResultText(),"Success - Check box is checked");
        page.checkUncheckAllButtonClick();
        assertEquals(page.getCheckAllButtonText(),"Uncheck All");
        for ( WebElement el : page.getChkBoxes() ) {
            if ( !el.isSelected() ) {
                assertFalse(true);
            }
        }
        ChromeDriver.await();
        page.checkUncheckAllButtonClick();
        assertEquals(page.getCheckAllButtonText(),"Check All");
        for ( WebElement el : page.getChkBoxes() ) {
            if ( el.isSelected() ) {
                assertFalse(true);
            }
        }
    }

    @Test
    public void T4(){
        ChromeDriver.navigate(Page.getPage() + "bootstrap-date-picker-demo.html");
        P4 page = new P4();
        page.inputDate(page.getNow());
        assertEquals(page.getInputValue(),page.getNow());
        ChromeDriver.await();
        page.inputDate(page.addDaysToToday(7));
        ChromeDriver.await();
        assertEquals(page.getInputValue(),page.addDaysToToday(7));
        ChromeDriver.await();
        page.btnTodayClick();
        assertEquals(page.getInputValue(),page.getNow());
    }

    @Test
    public void T5() throws InterruptedException {
        ChromeDriver.navigate(Page.getPage() + "bootstrap-download-progress-demo.html");
        P5 page = new P5();
        page.BtnStartDownloadClick();
        assertTrue(page.isDownloaded());
    }

    @Test
    public void T6(){
        ChromeDriver.navigate(Page.getPage() + "bootstrap-modal-demo.html");
        P6 page = new P6();
        page.singleModalButtonClick();
        ChromeDriver.await();
        try{
            page.singleModalCloseButtonClick();
        }
        catch(ElementNotInteractableException e){
            assertFalse(true);
        }
        ChromeDriver.await();

        page.multipleModalButtonClick();
        ChromeDriver.await();
        try{
            page.multipleInnerModalButtonClick();
        }
        catch(ElementNotInteractableException e){
            assertFalse(true);
        }

        ChromeDriver.await();
        try{
            page.multipleInnerModalCloseButtonClick();
        }
        catch(ElementNotInteractableException e){
            assertFalse(true);
        }

        ChromeDriver.await();
        try{
            page.multipleModalButtonCloseClick();
        }
        catch(ElementNotInteractableException e){
            assertFalse(true);
        }

    }

}
