package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class MultiInputForm {
    private WebElement inputAField;

    private WebElement inputBField;

    private WebElement getTotalSubmitButton;

    private WebElement resultText;

    public MultiInputForm() {
        this.inputAField = ChromeDriver.getDriver().findElement(By.xpath("//input[@id='sum1']"));
        this.inputBField = ChromeDriver.getDriver().findElement(By.xpath("//input[@id='sum2']"));
        this.getTotalSubmitButton = ChromeDriver.getDriver().findElement(By.xpath("//form[@id='gettotal']/button"));
        this.resultText = ChromeDriver.getDriver().findElement(By.xpath("//span[@id='displayvalue']"));
    }

    public WebElement getInputAField() {
        return inputAField;
    }

    public void setInputAField(String text) {
        this.inputAField.clear();
        this.inputAField.sendKeys(text);
    }

    public WebElement getInputBField() {
        return inputBField;
    }

    public void setInputBField(String text) {
        this.inputBField.clear();
        this.inputBField.sendKeys(text);
    }

    public WebElement getTotalSubmitButton() {
        return getTotalSubmitButton;
    }

    public void clickSubmitButton() {
        getTotalSubmitButton.click();
    }

    public String getResultText() {
        return resultText.getText();
    }
}
