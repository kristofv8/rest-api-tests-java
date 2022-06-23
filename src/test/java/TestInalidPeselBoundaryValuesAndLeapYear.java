import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestInalidPeselBoundaryValuesAndLeapYear extends BaseTest {

    @DataProvider
    public Object[][] invalidPeselWithErrors() {
        return new Object[][]{
                {"00213290213", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"00213298204", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"00223092510", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"00223055009", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"01213235613", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"01213270702", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"01222950318", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"01222928904", "[INVC, INVD]", "[Check sum is invalid. Check last digit., Invalid day.]"},
                {"00213290210", "[INVD]", "[Invalid day.]"},
                {"00213298201", "[INVD]", "[Invalid day.]"},
                {"00223092516", "[INVD]", "[Invalid day.]"},
                {"00223055005", "[INVD]", "[Invalid day.]"},
                {"01213235610", "[INVD]", "[Invalid day.]"},
                {"01213270709", "[INVD]", "[Invalid day.]"},
                {"01222950315", "[INVD]", "[Invalid day.]"},
                {"01222928901", "[INVD]", "[Invalid day.]"},


        };
    }

    @Test(dataProvider = "invalidPeselWithErrors")
    public void testInvalidPeselBoundaryValuesAndLeapYear(String endpointPesel, String expectedErrorCode, String expectedErrorText) {
        invalidPesel(endpointPesel, expectedErrorCode, expectedErrorText);


    }

}
