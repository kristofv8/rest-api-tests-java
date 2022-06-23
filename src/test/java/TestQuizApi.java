import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TestQuizApi extends BaseTest {
    @DataProvider
    public Object[][] differentCategoriesAndDifficulty() {
        return new Object[][]{
                {"Linux", "Easy"},
                {"Linux", "Medium"},
                {"Linux", "Hard"},
                {"DevOps", "Easy"},
                {"DevOps", "Medium"},
                {"DevOps", "Hard"},
                {"Docker", "Easy"},
                {"Docker", "Medium"},
                {"Docker", "Hard"},


        };

    }

    @Test(dataProvider = "differentCategoriesAndDifficulty")
    public void testResponseAnswersAreAsExpected(String Category, String Difficulty) {
        RequestSpecification httpRequest = RestAssured.given();
        addApiKey(httpRequest);
        httpRequest.queryParam("category", Category);
        httpRequest.queryParam("difficulty", Difficulty);
        Response response = openPage(httpRequest);

        org.testng.Assert.assertEquals(response.statusCode(), 200);

        List<Object> category = response.jsonPath().getList("category");
        boolean allCategoriesAreTheSame = iterateElementAreEquals(category);
        Assert.assertTrue(allCategoriesAreTheSame);

        List<Object> difficulty = response.jsonPath().getList("difficulty");
        boolean difficultyIsTheSame = iterateElementAreEquals(difficulty);
        Assert.assertTrue(difficultyIsTheSame);


    }

    @DataProvider
    public Object[][] differentQuantityOfQuestions() {
        return new Object[][]{
                {1},
                {5},
                {10},
                {15},
                {19},
                {20},

        };

    }

    @Test(dataProvider = "differentQuantityOfQuestions")
    public void testQuantityQuestionsIsAsExpected(int Quantity) {
        RequestSpecification httpRequest = RestAssured.given();
        addApiKey(httpRequest);
        httpRequest.queryParam("limit", Quantity);

        Response response = openPage(httpRequest);

        org.testng.Assert.assertEquals(response.statusCode(), 200);

        List<Object> quantityOfAnswers = response.jsonPath().getList("id");
        int idNumbers = quantityOfAnswers.size();
        Assert.assertEquals(idNumbers, Quantity);
    }
}