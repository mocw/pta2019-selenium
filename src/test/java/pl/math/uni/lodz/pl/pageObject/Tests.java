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
    public void singleInputFormTest() {
        ChromeDriver.navigate(Page.getPage() + "basic-first-form-demo.html");
        SingleInputForm page = new SingleInputForm();
        page.setInputTextElement("testMessage");
        page.clickSubmitButton();
        assertEquals("testMessage",page.getResultText());
    }

    @Test
    public void multiInputFormTest() {
        ChromeDriver.navigate(Page.getPage() + "basic-first-form-demo.html");
        MultiInputForm page = new MultiInputForm();
        page.setInputAField("1");
        page.setInputBField("2");
        ChromeDriver.await();
        page.clickSubmitButton();
        ChromeDriver.await();
        assertEquals("3",page.getResultText());
    }

    @Test
    public void checkboxTest(){
        ChromeDriver.navigate(Page.getPage() + "basic-checkbox-demo.html");
        Checkbox page = new Checkbox();
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
    public void bootstrapDatePickerTest(){
        ChromeDriver.navigate(Page.getPage() + "bootstrap-date-picker-demo.html");
        BootstrapDatePicker page = new BootstrapDatePicker();
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
    public void downloadProgressTest() throws InterruptedException {
        ChromeDriver.navigate(Page.getPage() + "bootstrap-download-progress-demo.html");
        DownloadProgress page = new DownloadProgress();
        page.BtnStartDownloadClick();
        assertTrue(page.isDownloaded());
    }

    @Test
    public void bootstrapModalTest(){
        ChromeDriver.navigate(Page.getPage() + "bootstrap-modal-demo.html");
        BootstrapModal page = new BootstrapModal();
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

    @Test
    public void bootstrapAlertTest(){
        ChromeDriver.navigate(Page.getPage() + "bootstrap-alert-messages-demo.html");
        BootstrapAlert page = new BootstrapAlert();
        page.autoCloseSuccessMsgButtonClick();
        ChromeDriver.await();
        assertTrue(page.isSuccessMsgHidden());
    }

    @Test
    public void searchFilterTest(){
        ChromeDriver.navigate(Page.getPage() + "table-search-filter-demo.html");
        SearchFilter page = new SearchFilter();
        page.setIdInputValue("1");
        assertEquals("1",page.getIdCellValue());
        page.setTaskInputValue("jQuery library");
        assertEquals("jQuery library",page.getTaskCellValue());
        page.setAssigneeInputValue("Mike");
        assertEquals("Mike Trout",page.getAssigneeCellValue());
        page.setStatusInputValue("in progress");
        assertEquals("in progress",page.getStatusCellValue());
        page.filterButtonClick();
        page.setFilterIdInputValue("2");
        assertEquals("2",page.getIdFilterCell());
        page.setFilterUsernameInputValue("mar");
        assertEquals("markino",page.getUsernameFilterCell());
        page.setFilterFirstNameInputValue("Daniel");
        assertEquals("Daniel",page.getFirstNameFilterCell());
        page.setFilterLastNameInputValue("Dima");
        assertEquals("Dimarison",page.getFilterLastNameCell());
    }

    @Test
    public void ajaxFormSubmitTest(){
        ChromeDriver.navigate(Page.getPage() + "ajax-form-submit-demo.html");
        AjaxFormSubmit page = new AjaxFormSubmit();
        page.setInputName("Test User");
        page.setInputComment("Test comment");
        page.setSubmitButtonClick();
        assertTrue(page.isResultTextSuccessfull());
    }

    @Test
    public void selectDropDownTest(){
        ChromeDriver.navigate(Page.getPage() + "basic-select-dropdown-demo.html");
        SelectDropDown page = new SelectDropDown();
        page.selectBtnClick();
        page.optionClick();
        assertEquals("Day selected :- Tuesday", page.getResultText());
    }

}
