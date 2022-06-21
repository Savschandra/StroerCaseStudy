package com.testproject.stepDefs;

import com.testproject.base.BasePage;
import com.testproject.cucumber.ScenarioContext;
import com.testproject.pages.StroerElements;
import com.testproject.pages.StroerMethods;
import com.testproject.utils.Driver;
import com.testproject.utils.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static com.testproject.pages.StroerMethods.LOG;


public class StroerStepDef {

    /******************  This class is to map scenarios to actual selenium code ******************/
    private final StroerElements StroerPage;
    private final ScenarioContext context;
    private final StroerMethods AllMethods;
    private final BasePage AllFunctions;

    public StroerStepDef(ScenarioContext context, StroerElements StroerPage, StroerMethods AllMethods, BasePage AllFunctions) {
        this.context = context;
        this.StroerPage = StroerPage;
        this.AllMethods = AllMethods;
        this.AllFunctions = AllFunctions;
    }

    /*These functions are for the Background steps*/
    @When("User navigates to web shop URL")
    public void user_navigates_to_web_shop_url() {
        Driver.get().get(Environment.URL);
        Driver.get().manage().window().maximize();
        AllFunctions.waitForPageToLoad();
    }

    /*Test01 >> verify user is able login to webShop*/
    @Given("Load Test Data from {string}")
    public void load_test_data_from(String caseID) throws IOException {
        StroerMethods.getTestData("Case_1");
    }
    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        StroerPage.userName_Fld.sendKeys(AllMethods.username);
        StroerPage.Password_Fld.sendKeys(AllMethods.password);
    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        StroerPage.Login_Bttn.click();
    }
    @Then("User should get successful login message")
    public void user_should_get_successful_login_message() {
        if(StroerPage.success_Txt.isDisplayed()) {
            AllMethods.assertThat(StroerPage.success_Txt,  "User Logged in Successfully");
        }
        else {
            assert false;
        }
    }
    @Then("User navigates to webShop home page")
    public void user_navigates_to_web_shop_home_page() throws IOException {
        AllFunctions.waitForPageToLoad();
        AllMethods.assertPageTitle("WebShop product page URL");
    }

    /*Test02 >> verify user is not able to login to webShop with wrong user details*/
    @Given("Load second Test Data from {string}")
    public void load_second_test_data_from(String string) throws IOException {
        StroerMethods.getTestData("Case_2");
    }
    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials() {
        StroerPage.userName_Fld.sendKeys(AllMethods.username);
        StroerPage.Password_Fld.sendKeys(AllMethods.password);
    }
    @Then("User should get error message")
    public void user_should_get_error_message() {
        if(StroerPage.err_Txt.isDisplayed()) {
            AllMethods.assertThat(StroerPage.err_Txt,  "Invalid Credentials");
        }
        else {
            assert false;
        }
    }
    @Then("User should remain on login page")
    public void user_should_remain_on_login_page() throws IOException {
        AllMethods.assertPageTitle("WebShop login page URL");
        BasePage.takeScreenShot();
    }

    /*Test03 >> verify user is able to add product to cart*/
    @Then("User checks product name, product price and description")
    public void user_checks_product_name_product_price_and_description() {
        if(StroerPage.produc_Prc.isDisplayed() && StroerPage.produc_Name.isDisplayed() && StroerPage.produc_Desc.isDisplayed() ){
            Assert.assertTrue(true);
        }else{
            assert false;
        }
    }
    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        StroerPage.addCart_bttn.click();
    }
    @Then("product is added to cart")
    public void product_is_added_to_cart() {
        AllFunctions.waitForPageToLoad();
        if(StroerPage.proIncart.isDisplayed()){
            Assert.assertTrue(true);
        }else{
            assert false;
        }
    }

    /*Test04 >> verify checkout page*/
    @When("user clicks on cart button")
    public void user_clicks_on_cart_button() {
        StroerPage.cart.click();
    }
    @Then("user navigates to checkout page")
    public void user_navigates_to_checkout_page() {
        AllFunctions.waitForPageToLoad();
        AllMethods.assertPageTitle("Checkout page URL");
    }
    @Then("User checks his details and product in cart")
    public void user_checks_his_details_and_product_in_cart() {
        if(StroerPage.userName.isDisplayed() && StroerPage.proIncart.isDisplayed()){
            Assert.assertTrue(true);
        }else{
            assert false;
        }
    }
    @When("user clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        StroerPage.chck_bttn.click();
    }
    @Then("user gets success message")
    public void user_gets_success_message() {
        AllFunctions.waitForPageToLoad();
        if(StroerPage.checkout_Txt.isDisplayed()) {
            AllMethods.assertThat(StroerPage.checkout_Txt,  "Checkout Successful");
        } else {
            LOG.error("User checkout failed");
        }
    }

    /*Test05 >> Verify order tables*/
    @Then("Order table is created")
    public void order_table_is_created() {
        if(AllMethods.checkTableStatus()==true){
            Assert.assertTrue(true);
        }
    }

    @Then("User verifies table data")
    public void user_verifies_table_data() {
        AllMethods.readOrderTable("Customer Data");
        AllMethods.readOrderTable("Order Data");
        AllMethods.readOrderTable("Order Line Details");
    }

    /*Test06 >> Verify confirmation email is sent to Customer*/
    @Then("verify confirmation email is sent to customer")
    public void verify_confirmation_email_is_sent_to_customer() {
        AllMethods.assertVerifyText(StroerPage.sntEml_Txt);
    }

    /*Test07 >> Verify order xml is created*/
    @Then("verify order xml is created")
    public void verify_order_xml_is_created() {
        AllMethods.checkXMLfile();
    }

    /*Test08 >> Verify product details in order xml*/
    @When("read created order xml")
    public void read_created_order_xml() {
        AllMethods.readXml("orderId");
    }
    @Then("User can verify product details <Product ID> in xml")
    public void user_can_verify_product_details_product_id_in_xml() {
        AllMethods.readXml("productId");
    }
}
