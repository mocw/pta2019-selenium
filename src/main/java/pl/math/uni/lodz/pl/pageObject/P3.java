package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

import java.util.List;

public class P3 {
    private WebElement rbElement;
    private WebElement resultText;
    private List<WebElement> chkBoxes;
    private WebElement checkUncheckAllButton;

    public P3(){
        this.rbElement = ChromeDriver.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']"));
        this.resultText = ChromeDriver.getDriver().findElement(By.xpath("//div[@id='txtAge']"));
        this.chkBoxes = ChromeDriver.getDriver().findElements(By.xpath("//input[@class='cb1-element']"));
        this.checkUncheckAllButton = ChromeDriver.getDriver().findElement(By.xpath("//input[@id='check1']"));
    }

    public WebElement getRbElement() {
        return rbElement;
    }

    public List<WebElement> getChkBoxes() {
        return chkBoxes;
    }

    public void setAllCheckBoxes(){
        rbElement.click();
        for ( WebElement el : chkBoxes ) {
            if ( !el.isSelected() ) {
                el.click();
            }
        }
    }

    public String getCheckAllButtonText(){
        return checkUncheckAllButton.getAttribute("value");
    }

    public void setRbElement() {
        this.rbElement.click();
    }

    public String getResultText() {
        return resultText.getText();
    }

    public void checkUncheckAllButtonClick(){
        checkUncheckAllButton.click();
    }
}

