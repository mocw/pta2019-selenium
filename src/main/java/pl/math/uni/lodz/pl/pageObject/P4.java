package pl.math.uni.lodz.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.math.uni.lodz.pl.ChromeDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P4 {
    private WebElement inputDate;
    private WebElement btnToday;
    private WebElement btnClear;
    private String today;
    private DateTimeFormatter dtf;
    private LocalDateTime now;

    public P4(){
        inputDate = ChromeDriver.getInstance().getDriver().findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        now = LocalDateTime.now();
        today = dtf.format(now);
    }

    public String getNow() {
        return today;
    }

    public void inputDate(String date){
        inputDate.clear();
        DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return;
        }
        inputDate.sendKeys(date);
    }

    public String getInputDate(){
        return inputDate.getText();
    }

    public String addDaysToToday(long days){
        now = now.plusDays(days);
        String newDate = dtf.format(now);
        return newDate;
    }
}
