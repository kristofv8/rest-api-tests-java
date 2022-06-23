import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestInvalidPeselErrorCodes extends BaseTest {

    @DataProvider
    public Object[][] invalidPeselWithErrors() {
        return new Object[][]{
                {"123", "[INVL]", "[Invalid length. Pesel should have exactly 11 digits.]"},
                {"test", "[NBRQ]", "[Invalid characters. Pesel should be a number.]"},
                {"00013117741", "[INVC]", "[Check sum is invalid. Check last digit.]"},
                {"92013260210", "[INVD]", "[Invalid day.]"},
                {"92003193987", "[INVC, INVY, INVM, INVD]", "[Check sum is invalid. Check last digit., Invalid year., Invalid month., Invalid day.]"},
                {"72132369405", "[INVY, INVM]", "[Invalid year., Invalid month.]"}


        };
    }

    @Test(dataProvider = "invalidPeselWithErrors")
    public void testInvalidPesel(String endpointPesel, String expectedErrorCode, String expectedErrorText) {
        invalidPesel(endpointPesel, expectedErrorCode, expectedErrorText);


    }


}