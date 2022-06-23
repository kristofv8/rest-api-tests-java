import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestValidPeselBoundaryValuesAndLeapYear extends BaseTest {
    @DataProvider
    public Object[][] validPeselWithAnswers() {
        return new Object[][]{
                {"00213125712", "2000-01-31T00:00:00", "Male"},
                {"00213189400", "2000-01-31T00:00:00", "Female"},
                {"00222892513", "2000-02-28T00:00:00", "Male"},
                {"00222898403", "2000-02-28T00:00:00", "Female"},
                {"00222932314", "2000-02-29T00:00:00", "Male"},
                {"00222948801", "2000-02-29T00:00:00", "Female"},
                {"01213165612", "2001-01-31T00:00:00", "Male"},
                {"01213179305", "2001-01-31T00:00:00", "Female"},
                {"01222846618", "2001-02-28T00:00:00", "Male"},
                {"01222829202", "2001-02-28T00:00:00", "Female"},


        };
    }

    @Test(dataProvider = "validPeselWithAnswers")
    public void testValidPeselBoundaryValuesLeapYear(String endpointPesel, String expectedDateOfBirth, String expectedGender) {
        testValidPesel(endpointPesel, expectedDateOfBirth, expectedGender);

    }

}
