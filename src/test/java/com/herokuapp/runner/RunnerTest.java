package com.herokuapp.runner;

import com.herokuapp.listener.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com/herokuapp/hooks", "com/herokuapp/ui/stepsdefinitions"},
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
@Listeners(TestListener.class)
public class RunnerTest extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
