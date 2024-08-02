package com.herokuapp.utils;

import lombok.experimental.UtilityClass;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/** Class for handle assertions. */
@UtilityClass
public final class Assertion {

  private static final SoftAssert softAssert;
  private static final ThreadLocal<SoftAssert> threadLocalSoftAssert =
      ThreadLocal.withInitial(SoftAssert::new);

  static {
    softAssert = getSoftAssert();
  }

  private static synchronized SoftAssert getSoftAssert() {
    return threadLocalSoftAssert.get();
  }

  /** Method for call a hard assertion. */
  public static <T> void hardAssert(String description, T actual, T expected) {
    String step = String.format(description, expected.toString());

    try {
      Assert.assertEquals(actual, expected, step);
    } catch (AssertionError var6) {
      throw new AssertionError(var6.getMessage());
    }
  }

  /** Method for call a soft assertion. */
  public static synchronized <T> void softAssert(String description, T actual, T expected) {
    String step = String.format(description, expected.toString());

    try {
      Assert.assertEquals(actual, expected, step);
    } catch (AssertionError var7) {
      softAssert.fail(var7.getMessage());
    }
  }
}
