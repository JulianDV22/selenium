package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollbarsTest extends Setup {

    @Test
    public void testScrollAndClickButton(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(16));
        navigateToScrollbarsPage(wait);

        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='hidingButton']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", button);

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        System.out.println("Botón clickeado exitosamente");
    }

    public void navigateToScrollbarsPage(WebDriverWait wait){
        WebElement scrollbarsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/scrollbars']")));
        scrollbarsLink.click();
    }
}
