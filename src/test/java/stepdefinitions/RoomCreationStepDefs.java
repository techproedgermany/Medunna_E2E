package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.RoomPage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

public class RoomCreationStepDefs {

    LoginPage loginPage = new LoginPage();
    RoomPage roomPage = new RoomPage();

    public static int roomNumber;
    public static String roomId;

    @When("admin clicks Items&Titles button")
    public void adminClicksItemsTitlesButton() {
        loginPage.itemsdAndTitles.click();
    }

    @And("clicks on Room option")
    public void clicksOnRoomOption() {
        loginPage.roomOption.click();
    }

    @And("clicks on Create A New Room button")
    public void clicksOnCreateANewRoomButton() {
        roomPage.createANewRoom.click();
    }

    @And("enters roomNumber into Room Number field")
    public void entersRoomNumberIntoRoomNumberField() {
       roomNumber = Faker.instance().number().numberBetween(10000, 100000);
       roomPage.roomNumberInput.sendKeys(roomNumber+"");
    }

    @And("chooses {string} from the dropdown")
    public void choosesFromTheDropdown(String arg0) {
        Select select = new Select(roomPage.roomTypeDropDown);
        select.selectByIndex(1);
    }

    @And("clicks Status box")
    public void clicksStatusBox() {
        roomPage.statusCheckbox.click();
    }

    @And("enters {string} into Price field")
    public void entersIntoPriceField(String price) {
        roomPage.priceInput.sendKeys(price);
    }

    @And("enters {string} into Description field")
    public void entersIntoDescriptionField(String description) {
        roomPage.descriptionInput.sendKeys(description);
    }

    @And("clicks on Save button")
    public void clicksOnSaveButton() {
        roomPage.saveSubmitButton.click();
    }

    @Then("verify the new room is created")
    public void verifyTheNewRoomIsCreated() {
        WaitUtils.waitForVisibility(roomPage.alertMessage,5);
        BrowserUtils.verifyElementDisplayed(roomPage.alertMessage);
        roomId = roomPage.alertMessage.getText().replaceAll("[^0-9]","");
    }
}
