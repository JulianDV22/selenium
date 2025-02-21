package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AjaxDataTest extends Setup {

    @Test
    public void testAjaxData() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(16));

        navigateToAjaxDataPage(wait);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ajaxButton']")));
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Data loaded with AJAX get request.']")));

        assertTrue(driver.findElement(By.xpath("//p[text() = 'Data loaded with AJAX get request.']")).isDisplayed());

    }

    private void navigateToAjaxDataPage(WebDriverWait wait) {
        WebElement ajaxDataLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/ajax']")));
        ajaxDataLink.click();
    }
}
