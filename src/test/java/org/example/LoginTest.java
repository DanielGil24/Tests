package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static ProfilePage profilePage;



    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);



        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void loginTest() {

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        }

    @AfterClass
    public static void tearDown() {

        profilePage.clickWrtBtn();

        boolean isEnbled = driver.findElement(By.xpath("//*[@id='new-plus']/div[2]/div/div[3]/div/div/div/div/div[1]/a")).isEnabled();
        if (isEnbled){
            System.out.println("btn is enabled");
        } else {
            System.out.println("btn is not enabled");
        }

         }
}


