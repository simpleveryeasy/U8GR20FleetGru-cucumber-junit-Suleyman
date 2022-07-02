package com.fleetGru.pages;

import com.fleetGru.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMeTitle;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;




    public void login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }



}
