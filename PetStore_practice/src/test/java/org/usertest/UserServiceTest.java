package org.usertest;

import org.example.entities.User;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class UserServiceTest {
    private String expectedusername;
    @Test
    public void createUserTest(){
        User userexpected = createUser();
        expectedusername= userexpected.getUsername();
        Map<String, Object> response = UserServiceSteps.createUser(userexpected);
        Assert.assertEquals(response.get("code"), 200, "Expected user doesn't have correct username");
    }

    @Test(dependsOnMethods = {"createUserTest"})
    public void getUserbyUsername(){
        expectedusername="string";
        User user = UserServiceSteps.getUserByUsername(expectedusername);
        Assert.assertEquals(user.getUsername(), expectedusername, "Expected user doesn't have correct username");
    }
    @Test
   public void deleteUserTest()
   {User createdUser = UserServiceSteps.createUser(createUser());

       UserServiceSteps.deleteUserByUsername(createdUser.getUsername());
    List<User> users = UserServiceSteps.getAllUsers();
        Assert.assertFalse(users.contains(createdUser), "Expected users list doesn't contain deleted element");
    }
    private User createUser() {
        Random random = new Random();
        return new User()
                .setUsername("test" + random.nextInt())
                .setEmail("testEmail" + random.nextInt() + "@gmail.com")
                .setUserStatus(random.nextInt())
                .setPassword("test" + random.nextInt())
                .setLastName("test")
                .setFirstName("test")
                .setPhone("test")
                .setId(2L);
    }
}
