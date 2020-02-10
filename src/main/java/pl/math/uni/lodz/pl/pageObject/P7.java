package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class P7 {
    private WebElement autoCloseSuccessMsgButton;
    private WebElement normalSuccessMsgButton;
    private WebElement autoCloseSuccessMsgContent;
    public P7(){
        autoCloseSuccessMsgButton = ChromeDriver.getDriver()
                .findElement(By.xpath("//*[@id=\"autoclosable-btn-success\"]"));
        normalSuccessMsgButton = ChromeDriver.getDriver()
                .findElement(By.xpath("//*[@id=\"normal-btn-success\"]"));
        autoCloseSuccessMsgContent = ChromeDriver.getDriver()
                .findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]"));
    }

    public void autoCloseSuccessMsgButtonClick(){
        autoCloseSuccessMsgButton.click();
    }

    public boolean isSuccessMsgHidden(){
        while(true){
           String style = autoCloseSuccessMsgButton.getAttribute("style");
            if(style.contains("none")){
                return true;
            }
        }
    }

}
