package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextInputTest extends Setup {

    @Test
    public void testChangeNameButton(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(16));
        navigateToTextInputPage(wait);

        WebElement textInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='newButtonName']")));
        textInput.sendKeys("Cambio de Boton");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='updatingButton']")));
        button.click();
        String newButtonName = button.getText();

        assertEquals("Cambio de Boton", newButtonName);

    }

    public void navigateToTextInputPage(WebDriverWait wait){
        WebElement textInputLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/textinput']")));
        textInputLink.click();
    }
}
