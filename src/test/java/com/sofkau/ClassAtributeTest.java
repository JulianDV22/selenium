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

public class ClassAtributeTest {

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

        if (driver.getTitle().contains("privacidad") || driver.getTitle().contains("No es privada")) {
            try {
                driver.findElement(By.id("details-button")).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link")));
                proceedButton.click();
            } catch (NoSuchElementException e) {
                System.out.println("No se encontró la advertencia de seguridad, continuando...");
            }
        }
    }

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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
