package com.herokuapp.utils;

import static com.herokuapp.utils.WaitActions.waitUntilElementToBeClickable;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

/** Utility class to model device actions. */
@UtilityClass
public class DeviceActions {

  @Step("Click on '{element}'")
  public static void click(WebElement webElement, String element) {
    waitUntilElementToBeClickable(webElement).click();
  }

  @Step("Send keys {keys}")
  public static void sendKeys(WebElement webElement, String keys) {
    webElement.sendKeys(keys);
  }

  @Step("Clear '{element}'")
  public static WebElement clear(WebElement webElement, String element) {
    webElement.clear();
    return webElement;
  }
}
