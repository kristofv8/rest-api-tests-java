import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestValidPeselFromDifferentCenturies extends BaseTest {
    @DataProvider
    public Object[][] validPeselWithAnswers() {
        return new Object[][]{
                {"00810131613", "1800-01-01T00:00:00", "Male"},
                {"00810178803", "1800-01-01T00:00:00", "Female"},
                {"99810195312", "1899-01-01T00:00:00", "Male"},
                {"99810136308", "1899-01-01T00:00:00", "Female"},
                {"00010191112", "1900-01-01T00:00:00", "Male"},
                {"00010197507", "1900-01-01T00:00:00", "Female"},
                {"99010168619", "1999-01-01T00:00:00", "Male"},
                {"99010150304", "1999-01-01T00:00:00", "Female"},
                {"00210173114", "2000-01-01T00:00:00", "Male"},
                {"00210118203", "2000-01-01T00:00:00", "Female"},
                {"99210167317", "2099-01-01T00:00:00", "Male"},
                {"99210126208", "2099-01-01T00:00:00", "Female"},
                {"00410180011", "2100-01-01T00:00:00", "Male"},
                {"00410103904", "2100-01-01T00:00:00", "Female"},
                {"99410121117", "2199-01-01T00:00:00", "Male"},
                {"99410166602", "2199-01-01T00:00:00", "Female"},
                {"00610163519", "2200-01-01T00:00:00", "Male"},
                {"00610191707", "2200-01-01T00:00:00", "Female"},
                {"99610101117", "2299-01-01T00:00:00", "Male"},
                {"99610118209", "2299-01-01T00:00:00", "Female"},


        };
    }

    @Test(dataProvider = "validPeselWithAnswers")
    public void testValidPeselDifferentCenturies(String endpointPesel, String expectedDateOfBirth, String expectedGender) {
        testValidPesel(endpointPesel, expectedDateOfBirth, expectedGender);

    }


}