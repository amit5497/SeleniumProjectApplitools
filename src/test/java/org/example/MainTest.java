package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;

public class MainTest {
    public WebDriver driver;

    @BeforeTest
    public void preTest(){
         driver = new ChromeDriver();
         driver.manage().window().maximize();
    }

    @Test
    public void launchSite(){
        driver.get("https://demo.applitools.com/app.html");
        List<WebElement> listAmounts= driver.findElements(By.xpath("//table[@class='table table-padded']/tbody//tr/td[5]"));
        double positiveSum = 0, negativeSum = 0;

        for(WebElement element : listAmounts){
            String text = element.getText();
            System.out.println(text);
            String[] arr = text.split(" ");
            if(arr[0].equalsIgnoreCase("+")){
                String a  =arr[1].replaceAll("[,]","");
                positiveSum += Double.parseDouble(a);

            }else {
                String a  =arr[1].replaceAll("[,]","");
                negativeSum += Double.parseDouble(a);

            }
        }
        System.out.println("Sum of two number :"+positiveSum +" = "+negativeSum);
        double sum = positiveSum-negativeSum;
        System.out.println(sum);

    }
    @AfterTest
    public void postCondition() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
