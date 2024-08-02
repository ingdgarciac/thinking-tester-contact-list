package com.herokuapp.utils;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.herokuapp.ui.driver.Device;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/** Utility class to model the wait actions. */
@UtilityClass
public class WaitActions {

  /**
   * Wait until element will be visible.
   *
   * @param webElement to wait the element in the page
   * @param timeInSeconds time out to wait the element
   */
  public static void waitUntilElementIsVisible(WebElement webElement, int timeInSeconds) {
    Device.getDriverWait()
        .withTimeout(ofSeconds(timeInSeconds))
        .pollingEvery(ofSeconds(1))
        .ignoring(NoSuchElementException.class)
        .ignoring(TimeoutException.class)
        .until(visibilityOf(webElement));
  }
}
