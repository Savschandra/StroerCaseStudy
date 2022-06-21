package com.testproject.pages;

import com.testproject.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StroerElements extends BasePage<StroerElements> {
    /*
    This page contains the locators of webelements
     */
    /******************** Login Page ***********************/
    @FindBy(xpath = "")
    public WebElement userName_Fld;

    @FindBy(xpath = "")
    public WebElement Password_Fld;

    @FindBy(xpath = "")
    public WebElement Login_Bttn;

    @FindBy(xpath = "")
    public WebElement cancel_Bttn;

    @FindBy(xpath = "")
    public WebElement success_Txt;

    @FindBy(xpath = "")
    public WebElement err_Txt;

    /******************** Product Page ***********************/
    @FindBy(xpath = "")
    public WebElement produc_img;

    @FindBy(xpath = "")
    public WebElement produc_Prc;

    @FindBy(xpath = "")
    public WebElement produc_Name;

    @FindBy(xpath = "")
    public WebElement produc_Desc;

    @FindBy(xpath = "")
    public WebElement addCart_bttn;


    /******************** Checkout Page ***********************/


    @FindBy(xpath = "")
    public WebElement userName;

    @FindBy(xpath = "")
    public WebElement cart;

    @FindBy(xpath = "")
    public WebElement proIncart;

    @FindBy(xpath = "")
    public WebElement chck_bttn;

    @FindBy(xpath = "")
    public WebElement checkout_Txt;

    @FindBy(xpath = "")
    public WebElement sntEml_Txt;

    /******************** Assuming if Order Table is an UI component ***********************/

    @FindBy(xpath = "")
    public WebElement order_Tbl;

    @FindBy(xpath = "")
    public WebElement custData_Tbl;

    @FindBy(xpath = "")
    public WebElement ordData_Tbl;

    @FindBy(xpath = "")
    public WebElement odrLine_tbl;


}
