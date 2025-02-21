package com.sofkau;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HiddenLayersTest extends Setup {

    @Test
    public void testHiddenLayers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToHiddenLayersPage(wait);

        WebElement firstHiddenLayerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("greenButton")));
        firstHiddenLayerButton.click();
        String firstHiddenLayerText = firstHiddenLayerButton.getAttribute("class");
        WebElement secondHiddenLayerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("blueButton")));
        String secondHiddenLayerText = secondHiddenLayerButton.getAttribute("class");

        assertNotEquals(secondHiddenLayerText, firstHiddenLayerText);


    }

    private void navigateToHiddenLayersPage(WebDriverWait wait) {
        WebElement hiddenLayersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/hiddenlayers']")));
        hiddenLayersLink.click();
    }
}
