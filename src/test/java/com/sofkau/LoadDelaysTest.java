package com.sofkau;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadDelaysTest extends Setup {

    @Test
    public void loadDalaysTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        navigateToLoadDelayPage(wait);

        assertTrue(driver.getCurrentUrl().contains("/loaddelay"),
                "No se redirigió correctamente a la página Load Delays");


    }

    private void navigateToLoadDelayPage(WebDriverWait wait) {
        WebElement loadDelayLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/loaddelay']")));
        loadDelayLink.click();
    }
}
