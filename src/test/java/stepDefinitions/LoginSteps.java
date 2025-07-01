package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.Assert.*;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user should see {string}")
    public void the_user_should_be_logged_in_successfully(String outcome) {

        switch (outcome) {
            case "login successful message":
                String successfulLoginText = driver.findElement(By.cssSelector(".has-text-align-center strong")).getText();
                assertEquals(successfulLoginText, "Congratulations student. You successfully logged in!");
                break;
            case "username incorrect error": {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
                String errorMessage = driver.findElement(By.id("error")).getText();
                assertEquals(errorMessage, "Your username is invalid!");
                break;
            }
            case "password incorrect error": {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
                String errorMessage = driver.findElement(By.id("error")).getText();
                assertEquals(errorMessage, "Your password is invalid!");
                break;
            }
        }
    }
}
