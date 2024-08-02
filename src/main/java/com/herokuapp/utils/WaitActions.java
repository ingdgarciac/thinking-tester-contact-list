package com.herokuapp.utils;

import static com.herokuapp.enums.Timeout.LOW_TIME;
import static com.herokuapp.enums.Timeout.MEDIUM_TIME;
import static com.herokuapp.enums.Timeout.MINOR_TIME;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.herokuapp.enums.Timeout;
import com.herokuapp.ui.driver.Device;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Alert;
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
  public static boolean waitUntilElementIsVisible(WebElement webElement, Timeout timeout) {
    try {
      Device.getDriverWait()
          .withTimeout(ofSeconds(timeout.getTime()))
          .pollingEvery(ofSeconds(LOW_TIME.getTime()))
          .until(visibilityOf(webElement));
      return true;
    } catch (NoSuchElementException | TimeoutException e) {
      return false;
    }
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

  /**
   * Wait until alert is visible.
   *
   * @return Alert instance
   */
  public static Alert waitUntilAlertIsVisible() {
    return Device.getDriverWait()
        .withTimeout(ofSeconds(MEDIUM_TIME.getTime()))
        .pollingEvery(ofSeconds(LOW_TIME.getTime()))
        .ignoring(NoSuchElementException.class)
        .ignoring(TimeoutException.class)
        .until(alertIsPresent());
  }
}
