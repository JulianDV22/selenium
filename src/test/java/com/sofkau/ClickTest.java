package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClickTest extends Setup {

    @Test
    public void testClickButtonByEmulatingMouse(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(16));
        navigateToClickPage(wait);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='badButton']")));
        button.click();

        String buttonIdAfterClick = button.getAttribute("class");

        assertEquals("btn btn-success", buttonIdAfterClick);
    }

    @Test
    public void testClickButtonByJavaScript(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(16));
        navigateToClickPage(wait);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='badButton']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);

        String buttonIdAfterClick = button.getAttribute("class");

        assertNotEquals("btn btn-success", buttonIdAfterClick);
    }

    public void navigateToClickPage(WebDriverWait wait){
        WebElement clickLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/click']")));
        clickLink.click();
    }
}
