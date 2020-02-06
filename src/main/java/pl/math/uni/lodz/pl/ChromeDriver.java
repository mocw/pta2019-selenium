package pl.math.uni.lodz.pl;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriver{
    private static WebDriver driver;
    private static ChromeDriver chromeDriver;
    private ChromeDriver() {}
    public static ChromeDriver getInstance(){
        if(chromeDriver==null){
            driver = new org.openqa.selenium.chrome.ChromeDriver();
            chromeDriver=new ChromeDriver();
        }
        return chromeDriver;
    }
    public static void navigate(String url){
        driver.navigate().to(url);
    }

    public static WebDriver getDriver(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // try{
        //    Thread.sleep(2000);
        // }
        // catch(Exception e){
        //     System.out.println(e.getMessage());
        // }
        return driver;
    }

    public static void tearDown(){
        driver.close();
    }

    public static void quit(){
        driver.quit();
    }



}
