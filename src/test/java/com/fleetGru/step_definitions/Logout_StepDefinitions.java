package com.fleetGru.step_definitions;

import com.fleetGru.pages.BasePage;
import com.fleetGru.pages.HomePage;
import com.fleetGru.pages.LoginPage;
import com.fleetGru.utilities.BrowserUtils;
import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Logout_StepDefinitions {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @When("User logs out homepage")
    public void user_logs_out_homepage() {
        basePage.waitUntilLoaderScreenDisappear();

        homePage.logout();
    }
    @Then("User returns login page")
    public void user_returns_login_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
    }

    @And("User clicks go back button")
    public void userClicksGoBackButton() {
        Driver.getDriver().navigate().back();
        BrowserUtils.sleep(3);
    }

    @And("User close the tab")
    public void userCloseTheTab() {
        basePage.waitUntilLoaderScreenDisappear();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open();");
        BrowserUtils.sleep(5);

        ArrayList<String> switchTabs= new ArrayList<String>(Driver.getDriver().getWindowHandles());
        //Driver.getDriver().switchTo().window(switchTabs.get(0));
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(switchTabs.get(1));
        BrowserUtils.sleep(5);
    }

    @And("User opens application on a new tab")
    public void userOpensApplicationOnANewTab() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fleetGruUrl"));
        BrowserUtils.sleep(3);
    }
}
