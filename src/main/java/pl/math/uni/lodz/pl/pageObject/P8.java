package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class P8 {

    private WebElement inputSearchBox;
    private WebElement idCell;
    private WebElement taskCell;
    private WebElement assigneeCell;
    private WebElement statusCell;
    private WebElement filterButton;
    private WebElement filterIdInput;
    private WebElement filterUsernameInput;
    private WebElement filterFirstNameInput;
    private WebElement filterLastNameInput;
    private WebElement idFilterCell;
    private WebElement usernameFilterCell;
    private WebElement firstNameFilterCell;
    private WebElement lastNameFilterCell;
    private String tdValue;
    private String tdXpath;

    public P8(){
        inputSearchBox = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/input"));
        tdXpath = "//*[@id=\"task-table\"]/tbody/tr/td";
        filterButton = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/button"));
        filterIdInput = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[1]/input"));
        filterUsernameInput = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[2]/input"));
        filterFirstNameInput = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[3]/input"));
        filterLastNameInput = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[4]/input"));
    }

    private void updateTdValue(String value){
        tdValue = value;
        tdXpath = "//*[@id=\"task-table\"]/tbody/tr/td[contains(text(), '" + tdValue +"')]";
        idCell = taskCell = assigneeCell = statusCell = ChromeDriver.getDriver()
                .findElement(By.xpath(tdXpath));
    }

    private void updateFilterTdValue(String value){
        tdValue = value;
        tdXpath = "/html/body/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[contains(text(), '" + tdValue +"')]";
        idFilterCell = usernameFilterCell = firstNameFilterCell = lastNameFilterCell =  ChromeDriver.getDriver()
                .findElement(By.xpath(tdXpath));
    }

    public void setIdInputValue(String id){
        updateTdValue(id);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(id);
    }

    public void setTaskInputValue(String task){
        updateTdValue(task);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(task);
    }

    public void setAssigneeInputValue(String assignee){
        updateTdValue(assignee);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(assignee);
    }

    public void setStatusInputValue(String status){
        updateTdValue(status);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(status);
    }

    public void filterButtonClick(){
        filterButton.click();
    }

    public String getIdCellValue(){
        return idCell.getText();
    }

    public String getTaskCellValue(){
        return taskCell.getText();
    }

    public String getAssigneeCellValue(){
        return assigneeCell.getText();
    }

    public String getStatusCellValue(){
        return statusCell.getText();
    }

    public void setFilterIdInputValue(String id){
        updateFilterTdValue(id);
        filterIdInput.sendKeys(id);
    }

    public void setFilterUsernameInputValue(String username){
        updateFilterTdValue(username);
        filterUsernameInput.sendKeys(username);
    }

    public void setFilterFirstNameInputValue(String firstName){
        updateFilterTdValue(firstName);
        filterFirstNameInput.sendKeys(firstName);
    }

    public void setFilterLastNameInputValue(String lastName){
        updateFilterTdValue(lastName);
        filterLastNameInput.sendKeys(lastName);
    }

    public String getIdFilterCell(){
        return idFilterCell.getText();
    }

    public String getUsernameFilterCell() {
        return usernameFilterCell.getText();
    }

    public String getFirstNameFilterCell() {
        return firstNameFilterCell.getText();
    }

    public String getFilterLastNameCell() {
        return lastNameFilterCell.getText();
    }
}
