package pl.math.uni.lodz.pl.pageObject;

public class Page {
    private Page(){}
    private static String webPage = "http://www.seleniumeasy.com/test/";
    public static String getPage(){
        return webPage;
    }
}
