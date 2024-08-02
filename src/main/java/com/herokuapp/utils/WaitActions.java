package com.herokuapp.utils;

import static com.herokuapp.enums.Timeout.LOW_TIME;
import static com.herokuapp.enums.Timeout.MINOR_TIME;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.herokuapp.enums.Timeout;
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
   * @param timeout time out to wait the element
   */
  public static void waitUntilElementIsVisible(WebElement webElement, Timeout timeout) {
    Device.getDriverWait()
        .withTimeout(ofSeconds(timeout.getTime()))
        .pollingEvery(ofSeconds(LOW_TIME.getTime()))
        .ignoring(NoSuchElementException.class)
        .ignoring(TimeoutException.class)
        .until(visibilityOf(webElement));
  }

  /**
   * Wait until element will be clickable.
   *
   * @param webElement to wait the element in the page
   * @return webElement
   */
  public static WebElement waitUntilElementToBeClickable(WebElement webElement) {
    Device.getDriverWait()
        .withTimeout(ofSeconds(MINOR_TIME.getTime()))
        .pollingEvery(ofSeconds(LOW_TIME.getTime()))
        .ignoring(NoSuchElementException.class)
        .ignoring(TimeoutException.class)
        .until(elementToBeClickable(webElement));
    return webElement;
  }
}
