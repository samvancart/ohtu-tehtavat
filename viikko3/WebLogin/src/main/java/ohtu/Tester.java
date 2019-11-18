package ohtu;

import java.io.File;
import java.util.Random;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

//        WebElement element = driver.findElement(By.linkText("login"));
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto" + r.nextInt(100000));

//        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
        element.sendKeys("salainen2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salainen2");
        //väärä salasana
//        element.sendKeys("akke");
//        element = driver.findElement(By.name("login"));
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(1);
        element.click();
        sleep(2);
        element=driver.findElement(By.linkText("logout"));
        element.click();

        sleep(3);

        driver.quit();

    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
