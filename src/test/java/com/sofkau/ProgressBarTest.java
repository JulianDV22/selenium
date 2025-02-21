package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ProgressBarTest extends Setup {

    @Test
    public void testStopProgressBar(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navigateToProgressBarPage(wait);

        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("startButton")));
        startButton.click();

        WebElement stopButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("stopButton")));

        WebElement progressBar = wait.until(ExpectedConditions.elementToBeClickable(By.id("progressBar")));

        while (true){
            String valueProgressBar = progressBar.getAttribute("aria-valuenow");
            if(Objects.equals(valueProgressBar, "75")){
                stopButton.click();
                break;
            }
        }


    }

    public void navigateToProgressBarPage(WebDriverWait wait){
        WebElement progressBarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/progressbar']")));
        progressBarLink.click();
    }
}
