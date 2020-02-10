package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class P10 {

    private WebElement selectBtn;
    private WebElement option;
    private WebElement resultText;

    public P10(){
        selectBtn = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/select"));
        option = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/select/option[4]"));
        resultText = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/p[2]"));
    }

    public void selectBtnClick(){
        selectBtn.click();
    }

    public void optionClick(){
        option.click();
    }

    public String getResultText(){
        return resultText.getText();
    }
}
