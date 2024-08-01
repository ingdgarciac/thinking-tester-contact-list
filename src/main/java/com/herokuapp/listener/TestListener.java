package com.herokuapp.listener;

import static com.herokuapp.Constants.PATH_REPORT_DIRECTORY;

import java.io.File;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;

/** Class to model listeners. */
@Slf4j
public class TestListener implements IExecutionListener {

  @Override
  public void onExecutionStart() {
    log.info("Cleaning Allure Report");
    IExecutionListener.super.onExecutionStart();
    File reportDir = new File(PATH_REPORT_DIRECTORY);
    FileUtils.deleteQuietly(reportDir);
  }
}
