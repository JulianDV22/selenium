package com.sofkau;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class VisibilityTest extends Setup {

    @Test
    public void testRemovedButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToVisibilityPage(wait);
        hideButtons(wait);

        Boolean removedButtonAfterHide = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("removedButton")));
        assertTrue(removedButtonAfterHide, "El elemento deberia haber sido eliminado");
    }

    @Test
    public void testZeroWidth(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        navigateToVisibilityPage(wait);
        hideButtons(wait);

        WebElement zeroWidthButton = driver.findElement(By.id("zeroWidthButton"));
        Dimension dimension = zeroWidthButton.getSize();

        boolean isInvisible = dimension.getHeight() == 0 || dimension.getWidth() == 0;

        assertTrue(isInvisible, "El elemento deberia de tener un size 0x0");
    }

    private void navigateToVisibilityPage(WebDriverWait wait) {
        WebElement visibilityLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href = '/visibility']")));
        visibilityLink.click();
    }

    private void hideButtons(WebDriverWait wait){
        WebElement hideButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("hideButton")));
        hideButton.click();
    }

}
