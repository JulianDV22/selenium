package com.sofkau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicTableTest extends Setup {

    @Test
    public void testFindCPUChromePercentage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToDynamicTablePage(wait);

        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='table' and @aria-label='Tasks']")));

        WebElement cpuValueElement = table.findElement(By.xpath("//div[@role='rowgroup']/div[@role='row'][span[@role='cell' and text()='Chrome']]//span[@role='cell'][contains(text(), '%')]"));
        String cpuValue = cpuValueElement.getText();
        System.out.println(cpuValue);

        WebElement labelValue = wait.until(ExpectedConditions.elementToBeClickable(By.className("bg-warning")));
        String valueToCompare = "Chrome CPU: " + cpuValue ;

        Assertions.assertEquals(valueToCompare, labelValue.getText());
    }

    public void navigateToDynamicTablePage(WebDriverWait wait){
        WebElement dynamicTableLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/dynamictable']")));
        dynamicTableLink.click();
    }
}
