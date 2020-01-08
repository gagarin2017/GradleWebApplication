package org.gradle.demo;

// import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.*;
// import org.junit.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class HelloServletFunctionalTest {
    private WebDriver driver;

  //   @Test
  // public void testGoogleSearch() throws InterruptedException {
  //   // Optional. If not specified, WebDriver searches the PATH for chromedriver.
  //   System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver_win32\\chromedriver.exe");

  //   WebDriver driver = new ChromeDriver();
  //   driver.get("http://www.google.com/");
  //   Thread.sleep(5000);  // Let the user actually see something!
  //   WebElement searchBox = driver.findElement(By.name("q"));
  //   searchBox.sendKeys("ChromeDriver");
  //   searchBox.submit();
  //   Thread.sleep(5000);  // Let the user actually see something!
  //   driver.quit();
  // }

    // @BeforeClass
    // public static void setupClass() {
    //     ChromeDriverManager.getInstance().setup(); 
    // }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();               
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();                         
    }

    @Test
    public void sayHello() throws Exception {      
        driver.get("http://localhost:8080/GradleWebApplication/");

        Thread.sleep(5000);

        driver.findElement(By.id("say-hello-text-input")).sendKeys("Dolly");
        driver.findElement(By.id("say-hello-button")).click();

        assertEquals("Hello Page", driver.getTitle());
        assertEquals("Hello, Dolly!", driver.findElement(By.tagName("h2")).getText());
    }
}