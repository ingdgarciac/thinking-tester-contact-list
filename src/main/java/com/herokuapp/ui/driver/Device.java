package com.herokuapp.ui.driver;

import static com.herokuapp.Constants.TEST_BROWSER;
import static com.herokuapp.Constants.TIMEOUT;
import static java.time.Duration.ofSeconds;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Utility class to instantiate the driver. */
@UtilityClass
public class Device {

  @Getter private static final WebDriver driver;
  @Getter private static final WebDriverWait driverWait;

  static {
    switch (TEST_BROWSER) {
      case "Chrome":
        driver = new ChromeDriver();
        break;
      case "Edge":
        driver = new EdgeDriver();
        break;
      case "Firefox":
        driver = new FirefoxDriver();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + TEST_BROWSER);
    }
    driverWait = new WebDriverWait(driver, ofSeconds(TIMEOUT));
  }
}
