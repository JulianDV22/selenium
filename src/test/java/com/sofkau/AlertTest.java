package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest extends Setup {

    @Test
    public void testAlertButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToAlertPage(wait);

        WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
        alertButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Test
    public void testConfirmButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToAlertPage(wait);

        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmButton")));
        confirmButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    @Test
    public void testPromptButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToAlertPage(wait);

        WebElement promptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("promptButton")));
        promptButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }


    private void navigateToAlertPage(WebDriverWait wait) {
        WebElement alertLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/alerts']")));
        alertLink.click();
    }
}
