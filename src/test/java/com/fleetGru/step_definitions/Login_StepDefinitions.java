package com.fleetGru.step_definitions;

import com.fleetGru.pages.BasePage;
import com.fleetGru.pages.HomePage;
import com.fleetGru.pages.LoginPage;
import com.fleetGru.utilities.BrowserUtils;
import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

        basePage.waitUntilLoaderScreenDisappear();

    }

    @Then("User is on the {string} page")
    public void userIsOnThePage(String homepage) {

        //Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals(homepage, homePage.homepageSubTitle.getText());
        homePage.logout();


    }
}
