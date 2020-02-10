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
    private String tdValue;
    private String tdXpath;

    public P8(){
        inputSearchBox = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/input"));
        tdXpath = "//*[@id=\"task-table\"]/tbody/tr/td";
    }

    private void updateTdValue(String value){
        tdValue = value;
        tdXpath = "//*[@id=\"task-table\"]/tbody/tr/td[contains(text(), '" + tdValue +"')]";
        idCell = taskCell = assigneeCell = statusCell = ChromeDriver.getDriver()
                .findElement(By.xpath(tdXpath));
    }

    public void setIdInputValue(String id){
        tdValue = id;
        updateTdValue(id);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(id);
    }

    public void setTaskInputValue(String task){
        tdValue = task;
        updateTdValue(task);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(task);
    }

    public void setAssigneeInputValue(String assignee){
        tdValue = assignee;
        updateTdValue(assignee);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(assignee);
    }

    public void setStatusInputValue(String status){
        tdValue = status;
        updateTdValue(status);
        inputSearchBox.clear();
        inputSearchBox.sendKeys(status);
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

}
