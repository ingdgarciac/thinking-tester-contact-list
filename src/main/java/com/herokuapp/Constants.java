package com.herokuapp;

import static java.lang.Integer.parseInt;

import com.herokuapp.utils.LocalProperties;
import lombok.experimental.UtilityClass;

/** Class for handle constants in Properties. */
@UtilityClass
public class Constants {

  public static final String PATH_TO_PROJECT_PROPERTIES = "project.properties";

  public static final String TEST_BROWSER = LocalProperties.getProperty("project.browser");

  public static final String PROJECT_URL = LocalProperties.getProperty("project.url");

  public static final int TIMEOUT = parseInt(LocalProperties.getProperty("project.timeout"));

  public static final String PATH_REPORT_DIRECTORY = "./allure-results";
}
