package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class NonbreakingSpaceTest extends Setup {

     @Test
     public void testNonbreakingSpace(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         navigateToNonbreakingSpacePage(wait);

         WebElement myButtonButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
         String correctTextPath = myButtonButton.getText();

         WebElement myButtonByPath = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[translate(text(), ' ', ' ')]")));
         String correctText = myButtonByPath.getText();

         assertEquals(correctTextPath, correctText);
    }

     public void navigateToNonbreakingSpacePage(WebDriverWait wait){
         WebElement nonbreakingSpaceLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/nbsp']")));
         nonbreakingSpaceLink.click();
     }
}
