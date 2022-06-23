import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

public class BaseTest {
    public BaseTest() {
        RestAssured.baseURI = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=";
    }


    public static String getErrorCodeString(Response errorResponse) {
        return errorResponse.jsonPath().getString("errors.errorCode");
    }

    public static String getErrorMessageString(Response errorResponse) {
        return errorResponse.jsonPath().getString("errors.errorMessage");
    }

    public static boolean getIsValidValue(Response valueResponse) {
        return valueResponse.jsonPath().get("isValid");
    }

    public static String getDateOfBirthString(Response dateOfBirthResponse) {
        return dateOfBirthResponse.jsonPath().getString("dateOfBirth");
    }

    public static String getGender(Response genderResponse) {
        return genderResponse.jsonPath().getString("gender");
    }

    public static boolean iterateElementAreEquals(List<Object> category) {
        for (Object element : category) {
            if (!element.equals(category.get(0)))
                return false;
        }
        return true;
    }

    public static void addApiKey(RequestSpecification httpRequest) {
        httpRequest.header("X-Api-Key", "hk3ZufhIwWHtJtxdEklnw6jwk0vxF187nwYYfUeq");
    }

    public static Response openPage(RequestSpecification httpRequest) {
        return httpRequest.get("https://quizapi.io/api/v1/questions");
    }

    public static void testValidPesel(String endpointPesel, String expectedDateOfBirth, String expectedGender) {
        Response response = get(baseURI + endpointPesel);
        String dateOfBirth = getDateOfBirthString(response);
        String gender = getGender(response);
        boolean isValid = getIsValidValue(response);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(isValid);
        Assert.assertEquals(dateOfBirth, expectedDateOfBirth);
        Assert.assertEquals(gender, expectedGender);
    }

    public static void invalidPesel(String endpointPesel, String expectedErrorCode, String expectedErrorText) {
        Response response = get(baseURI + endpointPesel);
        String errorCode = getErrorCodeString(response);
        String errorMessage = getErrorMessageString(response);
        boolean isValid = getIsValidValue(response);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertFalse(isValid);
        Assert.assertEquals(errorCode, expectedErrorCode);
        Assert.assertEquals(errorMessage, expectedErrorText);
    }
}
