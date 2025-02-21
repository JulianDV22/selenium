package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicIdTest extends Setup {

    @Test
    public void testClickDynamicID() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        navigateToDynamicIDPage(wait);

        assertTrue(driver.getCurrentUrl().contains("/dynamicid"),
                "No se redirigió correctamente a la página Dynamic ID");

        String beforeRefreshButtonId = getButtonId(wait);

        driver.navigate().refresh();

        String afterRefreshButtonId = getButtonId(wait);

        assertNotEquals(beforeRefreshButtonId, afterRefreshButtonId,
                "El ID del botón no cambió después de la recarga");

        System.out.println("Prueba completada: El ID del botón cambió correctamente.");
    }

    private void navigateToDynamicIDPage(WebDriverWait wait) {
        WebElement dynamicIDLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/dynamicid']")));
        dynamicIDLink.click();
    }

    private String getButtonId(WebDriverWait wait) {
        WebElement dynamicButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'btn-primary')]")
        ));
        return dynamicButton.getAttribute("id");
    }
}