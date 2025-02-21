package com.sofkau;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassAtributeTest extends Setup {

    @Test
    public void testClickClassAttributeButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement classAttributeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/classattr']")));
        classAttributeLink.click();

        assertTrue(driver.getCurrentUrl().contains("/classattr"),
                "No se redirigió correctamente a la página Class Attribute");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-primary')]")));
        button.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept(); // Aceptar la alerta

        System.out.println("Alerta aceptada correctamente");
    }


}
