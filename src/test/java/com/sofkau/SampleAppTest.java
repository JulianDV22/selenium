package com.sofkau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SampleAppTest extends Setup {

    @Test
    public void testLogInInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToSampleAppPage(wait);

        String userName = "mauricio123";

        setUserName(userName);
        setPassWord();

        WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
        logInButton.click();

        WebElement welcomeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginstatus")));
        String welcomeLabelMessage = welcomeLabel.getText();

        assertEquals("Welcome, " + userName + "!", welcomeLabelMessage);
    }

    private static void setPassWord() {
        WebElement passWordInput = driver.findElement(By.name("Password"));
        passWordInput.sendKeys("pwd");
    }

    private static void setUserName(String userName) {
        WebElement userNameInput = driver.findElement(By.name("UserName"));
        userNameInput.sendKeys(userName);
    }

    private void navigateToSampleAppPage(WebDriverWait wait) {
        WebElement sampleAppLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/sampleapp']")));
        sampleAppLink.click();
    }
    
    
}
