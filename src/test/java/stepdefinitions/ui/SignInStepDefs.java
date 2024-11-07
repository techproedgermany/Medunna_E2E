package stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;


public class SignInStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("admin goes to {string} homepage")
    public void adminGoesToHomepage(String url) {
        Driver.getDriver().get(url);
    }

    @And("clicks on userIcon")
    public void clicksOnUserIcon() {
        homePage.userIcon.click();
    }

    @And("clicks on signIn option")
    public void clicksOnSignInOption() {
        homePage.signInOption.click();
    }

    @And("enters username in the Username field")
    public void entersUsernameInTheUsernameField() {
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }

    @And("enters password in the Password field")
    public void entersPasswordInThePasswordField() {
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }

    @And("clicks on signIn button")
    public void clicksOnSignInButton() {
        loginPage.signInSubmitButton.click();
    }


}
