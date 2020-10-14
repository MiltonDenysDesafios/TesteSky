package test;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features/ValidarModal.feature",
glue = "",
tags = "@ValidarModal")
public class ValidarModalTest {

}
