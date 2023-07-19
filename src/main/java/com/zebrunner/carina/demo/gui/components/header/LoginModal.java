package com.zebrunner.carina.demo.gui.components.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginModal {
    protected WebDriver driver;

    public LoginModal(WebDriver driver) {
        this.driver = driver;
    }


}
