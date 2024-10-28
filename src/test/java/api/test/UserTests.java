package api.test;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.Map;

public class UserTests {

    Faker faker = new Faker();
    User user;

    @BeforeClass
    public void setup() {

//        faker = new Faker();
//        user = new User();
//
//        user.setId(faker.idNumber().hashCode());
//        user.setUsername(faker.name().username());
//        user.setFirstName(faker.name().firstName());
//        user.setLastName(faker.name().lastName());
//        user.setEmail(faker.internet().emailAddress());
//        user.setPassword(faker.internet().password(5, 10));
//        user.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1, dataProvider = "userData")
    public void testPostUser(User user) {
        Response r = UserEndPoints.createUser(user);
        Assert.assertEquals(r.statusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUserByUsername() {

        Response r = UserEndPoints.readUser(this.user.getUsername());
        Assert.assertEquals(r.statusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUserByUsername() {
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());

        Response r = UserEndPoints.updateUser(this.user.getUsername());
        Assert.assertEquals(r.statusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        Response r = UserEndPoints.deleteUser(this.user.getUsername());
        Assert.assertEquals(r.statusCode(), 200);
    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        faker = new Faker();


        return new Object[][]{
                {new User(faker.idNumber().hashCode(), faker.name().username(),
                        faker.name().firstName(), faker.name().lastName(),
                        faker.internet().emailAddress(), faker.internet().password(5, 10),
                        "92212122")}
//                {new User(faker.idNumber().hashCode(), faker.name().username(),
//                        faker.name().firstName(), faker.name().lastName(),
//                        faker.internet().emailAddress(), faker.internet().password(5, 10),
//                        "92212122")},
                       };

    }
}
