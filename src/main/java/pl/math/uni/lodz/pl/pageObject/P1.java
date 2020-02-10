package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class P1{

    private WebElement inputTextElement;

    private WebElement submitButton;

    private WebElement resultText;

    public P1(){
        inputTextElement = ChromeDriver.getDriver().findElement(By.xpath("//input[@id='user-message']"));
        submitButton = ChromeDriver.getDriver().findElement(By.xpath("//form[@id='get-input']/button"));
        resultText = ChromeDriver.getDriver().findElement(By.xpath("//div[@id='user-message']/span"));
    }

    public WebElement getInputTextElement() {
        return inputTextElement;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public String getResultText() {
        return resultText.getText();
    }

    public void setInputTextElement(String text) {
        this.inputTextElement.clear();
        this.inputTextElement.sendKeys(text);
    }

    public void clickSubmitButton() {
        this.submitButton.click();
    }
}

