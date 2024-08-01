package com.herokuapp.utils;

import static com.herokuapp.Constants.PATH_TO_PROJECT_PROPERTIES;

import java.io.IOException;
import java.util.Properties;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/** Class to load the local properties. */
@Slf4j
@UtilityClass
public class LocalProperties {

  private static final Properties properties = new Properties();

  static {
    try {
      properties.load(
          LocalProperties.class.getClassLoader().getResourceAsStream(PATH_TO_PROJECT_PROPERTIES));
    } catch (IOException e) {
      log.info("Error getting properties file {}", e.getMessage());
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
