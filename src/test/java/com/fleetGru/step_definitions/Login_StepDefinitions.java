package com.fleetGru.step_definitions;

import com.fleetGru.pages.BasePage;
import com.fleetGru.pages.HomePage;
import com.fleetGru.pages.LoginPage;
import com.fleetGru.utilities.BrowserUtils;
import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Login_StepDefinitions {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fleetGruUrl"));
    }


    @When("User logs in with below credentials")
    public void userLogsInWithBelowCredentials(Map<String, String> credentials) {

        loginPage.login(credentials.get("username"), credentials.get("password"));

        //basePage.waitUntilLoaderScreenDisappear();

    }

    @Then("User is on the {string} page")
    public void userIsOnThePage(String homepage) {

        //Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals(homepage, homePage.homepageSubTitle.getText());
        homePage.logout();


    }

    @Then("User sees {string}")
    public void userSees(String message) {

        System.out.println(loginPage.errorMessage.getText());
        Assert.assertEquals(message, loginPage.errorMessage.getText());

    }


    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.userNameInput.sendKeys(username);
    }


    @And("User press login button")
    public void userPressLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("User sees {string} under username input box")
    public void userSeesAlert(String alertMessage) {
        BrowserUtils.sleep(1);
        String actualAlertMessage = loginPage.passwordInput.getAttribute("validationMessage");
        System.out.println(actualAlertMessage);
        Assert.assertEquals(alertMessage, actualAlertMessage);

    }

    @When("User enters password {string}")
    public void userEntersPassword(String password){
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("User sees {string} under password input box")
    public void userSeesUnderPasswordInputBox(String alertMessage) {
        BrowserUtils.sleep(1);
        String actualAlertMessage = loginPage.userNameInput.getAttribute("validationMessage");
        System.out.println(actualAlertMessage);
        Assert.assertEquals(alertMessage, actualAlertMessage);
    }

    @When("User clicks Forgot your password? link")
    public void userClicksForgotYourPasswordLink() {
        loginPage.forgotPasswordLink.click();
    }

    @Then("User is on the Forgot Password page")
    public void userIsOnTheForgotPasswordPage() {
        String forgotPasswordPageTitle = Driver.getDriver().findElement(By.xpath("//h2[@class='title']")).getText();
        System.out.println(forgotPasswordPageTitle);
        String expectedTitle = "Forgot Password";
        Assert.assertEquals(expectedTitle, forgotPasswordPageTitle);
    }

    @When("User sees Remember Me link")
    public void userSeesRememberMeLink() {
        Assert.assertTrue(loginPage.rememberMeTitle.isDisplayed());
    }

    @Then("User sees Remember Me link clickable")
    public void userSeesRememberMeLinkClickable() {
        Assert.assertTrue(loginPage.rememberMeCheckBox.isEnabled());
    }

    @Then("User sees bullet signs")
    public void userSeesBulletSigns() {
        Assert.assertTrue(loginPage.passwordInput.getAttribute("type").equals("password"));
    }

    @And("User press Enter key")
    public void userPressEnterKey() {
        loginPage.passwordInput.sendKeys(Keys.ENTER);
    }


    @Then("User sees {string} on the profile")
    public void userSeesOnTheProfile(String username) {
        basePage.waitUntilLoaderScreenDisappear();
        System.out.println(username);
        System.out.println(homePage.userMenu.getText());
        Assert.assertEquals(username, homePage.userMenu.getText());
    }
}

