package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class BootstrapModal {
    private WebElement singleModalButton;
    private WebElement singleModalCloseButton;
    private WebElement multipleModalButton;
    private WebElement multipleModalCloseButton;
    private WebElement multipleInnerModalButton;
    private WebElement multipleInnerModalCloseButton;


    public BootstrapModal(){
        singleModalButton = ChromeDriver.getDriver()
                .findElement(By.xpath("//a[contains(@href,'#myModal0')]"));
        singleModalCloseButton = ChromeDriver.getDriver()
                .findElement(By.xpath("//a[contains(@data-dismiss,'modal')]"));
        multipleModalButton = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        multipleInnerModalButton = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div[3]/a"));
        multipleInnerModalCloseButton = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[6]/a[1]"));
        multipleModalCloseButton = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div[4]/a[1]"));
    }

    public void singleModalButtonClick() {
        this.singleModalButton.click();
    }

    public void singleModalCloseButtonClick() throws ElementNotInteractableException {
        this.singleModalCloseButton.click();
    }

    public void multipleModalButtonClick(){
        this.multipleModalButton.click();
    }

    public void multipleInnerModalButtonClick() throws ElementNotInteractableException {
        this.multipleInnerModalButton.click();
    }

    public void multipleModalButtonCloseClick(){
        this.multipleModalCloseButton.click();
    }

    public void multipleInnerModalCloseButtonClick(){
        this.multipleInnerModalCloseButton.click();
    }
}
