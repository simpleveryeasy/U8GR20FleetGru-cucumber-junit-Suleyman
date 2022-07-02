package com.fleetGru.pages;

import com.fleetGru.utilities.Driver;
import com.fleetGru.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement homepageSubTitle;

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement nameDropdown;

    @FindBy(xpath = "//a[@href=\"/user/logout\"]")
    public WebElement logoutButton;


    public void logout(){
        BrowserUtils.waitForClickablility(nameDropdown, 5);
        nameDropdown.click();
        BrowserUtils.waitForClickablility(logoutButton, 5);
        logoutButton.click();

    }





}
