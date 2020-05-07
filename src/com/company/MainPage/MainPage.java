package com.company.MainPage;

import com.company.DriverManagers.DriverManager;
import com.company.DriverManagers.DriverManagerFactory;
import com.company.DriverManagers.DriverType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    DriverManager driverManager;
    WebDriver driver;

    @org.junit.Test
    public void navigateToQueueAppTest() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get("https://qr-queue-0.firebaseapp.com/");
        Assert.assertEquals("QR Queue", driver.getTitle());
    }

    @org.junit.Test
    public void navigateToFooterButtonsTest() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get("https://qr-queue-0.firebaseapp.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement aboutUsBtn = driver.findElement(By.cssSelector(".footer-menu__item:nth-of-type(2)"));
        System.out.println(aboutUsBtn);
        aboutUsBtn.click();
        System.out.println("\"О нас\" button Done with Click");
        js.executeScript("window.history.go(-1)");

        WebElement contactsBtn = driver.findElement(By.cssSelector(".footer-menu__item:last-of-type"));
        contactsBtn.click();
        System.out.println("\"Конакты\" button Done with Click");
        js.executeScript("window.history.go(-1)");

        driver.close();
    }

    @org.junit.Test
    public void navigateToScanBtnTest() throws InterruptedException {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get("https://qr-queue-0.firebaseapp.com/");

        WebElement aboutUsBtn = driver.findElement(By.cssSelector(".body_button"));
        aboutUsBtn.click();
        WebElement takeScanBtn = driver.findElement(By.cssSelector(".button"));

        takeScanBtn.click();
        takeScanBtn.sendKeys("E:/IAAU/backendFP/qr-code2.png");


        System.out.println("Photo has been successfully uploaded");
    }

}