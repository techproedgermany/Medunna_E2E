package stepdefinitions.api;

import baseurl.Medunna_BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.RoomPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.ui.RoomCreationStepDefs.roomId;
import static stepdefinitions.ui.RoomCreationStepDefs.roomNumber;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class GetRequestStepDefs extends Medunna_BaseUrl {

    RoomPojo expectedData;
    Response response;
    Response response1;

    @Given("Admin sends GET request for all rooms")
    public void adminSendsGETRequestForAllRooms() {

        //https://medunna.com/api/rooms?sort=CreatedDate,desc
        //Set the URL
        spec.pathParam("p1","rooms").queryParam("sort","CreatedDate,desc");
        //send request and get response
        response = given(spec).get("{p1}");
        response.prettyPrint();

    }

    @Then("verify the room is created")
    public void verifyTheRoomIsCreated() {
        //Do assertion
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("findAll{it.roomNumber == " + roomNumber + "}.id").get(0));
    }


    // TC03_RoomById_ApiValidation.feature
    @Given("Admin sends GET request for a room by its id")
    public void adminSendsGETRequestForARoomByItsId() {
        //https://medunna.com/api/rooms/id
        //Set the Url
        spec.pathParams("p1","rooms","p2",roomId);

        //Set the expected Data
        expectedData = new RoomPojo(roomNumber,"DELUXE",true,1400,"SeaView");
        System.out.println("expectedData = " + expectedData);

        //Send request and get response
        response1 = given(spec).when().get("{p1}/{p2}");
        response1.prettyPrint();

    }

    @Then("verify response body of created room")
    public void verifyResponseBodyOfCreatedRoom() {
        //Do assertion
        response1.then().statusCode(200);
        //Deserialization = Best Practice ==> Object Mapper + Pojo
        RoomPojo actualData = convertJsonToJava(response1.asString(), RoomPojo.class);
        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        assertEquals(expectedData.isStatus(),actualData.isStatus());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getDescription(),actualData.getDescription());

    }
}
