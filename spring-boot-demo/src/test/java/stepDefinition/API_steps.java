package stepDefinition;

import com.example.frank.service.GameUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.core.dto.UserMaxGamesPlayed;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.APICommonActions;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class API_steps extends APICommonActions {


    @Given("^I set json body for auth token$")
    public void iSetJsonBodyForAuthToken() throws Throwable {
        request = given()
                .contentType(ContentType.JSON);
    }

    @When("^I do a get call to \"([^\"]*)\"$")
    public void iDoAGetCallTo(String endPoint) throws Throwable {
        response = request.when().get(site + endPoint);
        response.then().log().all();
    }

    @Then("^the status code is (\\d+)$")
    public void theStatusCodeIs(int statusCode) throws Throwable {
        json = response.then().log().ifError().statusCode(statusCode);
        jsonString = json.extract().asString();


    }

    @And("^I check contain type is \"([^\"]*)\"$")
    public void iCheckContainTypeIs(String contentType) throws Throwable {
        response.then().contentType(contentType);
    }

    @And("^I check jsonSchema for \"([^\"]*)\"$")
    public void iCheckJsonSchemaFor(String jsonFile) throws Throwable {
        json.body(matchesJsonSchemaInClasspath(jsonFile));
    }

    @And("^response includes the following$")
    public void responseIncludesTheFollowing(Map<String, String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                JsonPath jsonpath = new JsonPath(jsonString);
                int keyValue = ((jsonpath.getInt(field.getKey())));
                int value = Integer.parseInt(field.getValue());
                Assert.assertTrue("Actual value: " + keyValue + "\n is not matching with : " + value, keyValue <= value);
            } else {
                JsonPath jsonpath = new JsonPath(jsonString);
                String keyValue = jsonpath.getString(field.getKey());
                String value = field.getValue();
                Assert.assertEquals("Actual value: " + keyValue + "\n is not matching with : " + value, keyValue, (value));
            }
        }
    }



}
