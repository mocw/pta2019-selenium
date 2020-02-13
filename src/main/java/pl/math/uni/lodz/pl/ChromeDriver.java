package pl.math.uni.lodz.pl;

import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class ChromeDriver{
    private static WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
    private ChromeDriver() {}

    public static void navigate(String url){
        driver.navigate().to(url);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void await(){
        try{

            sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void tearDown(){
        driver.close();
    }

    public static void quit(){
        driver.quit();
    }

}
