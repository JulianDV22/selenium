package com.sofkau;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicIdTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.uitestingplayground.com/home");

        // Manejar manualmente la advertencia de seguridad si aparece
        if (driver.getTitle().contains("privacidad") || driver.getTitle().contains("No es privada")) {
            try {
                // Hacer clic en "Avanzado"
                driver.findElement(By.id("details-button")).click();

                // Hacer clic en "Continuar al sitio"
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link")));
                proceedButton.click();
            } catch (NoSuchElementException e) {
                System.out.println("No se encontró la advertencia de seguridad, continuando...");
            }
        }
    }

    @Test
    public void testClickDynamicID() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dynamicIDLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/dynamicid']")));
        dynamicIDLink.click();

        assertTrue(driver.getCurrentUrl().contains("/dynamicid"),
                "No se redirigió correctamente a la página Dynamic ID");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
