package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

public class P5 {
    private WebElement btnStartDownload = ChromeDriver.getDriver()
            .findElement(By.xpath("//button[@id='cricle-btn']"));
    private WebElement downloadProgress = ChromeDriver.getDriver()
            .findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]"));

    public void BtnStartDownloadClick() {
        this.btnStartDownload.click();
    }

    public boolean isDownloaded(){
        while(true){
            if(downloadProgress.getText().toString().equals("100%")){
                return true;
            }
        }
    }

}
