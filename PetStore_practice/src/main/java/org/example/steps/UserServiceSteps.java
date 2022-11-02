package org.example.steps;

import org.example.entities.User;
import org.example.service.UserService;

import java.util.List;
import java.util.Map;

import static org.example.service.uritemplate.UserServiceUri.*;
import static org.example.service.uritemplate.UserServiceUri.USER;

public class UserServiceSteps {
    private static final UserService USER_SERVICE = UserService.getInstance();
    public static Map<String, Object> createUser(User user){
        return USER_SERVICE.postRequest(USER, user).jsonPath().getMap("");
    }
    public static  User getUserByUsername(String username){
        return  USER_SERVICE.getRequestQuery(USER_BY_USERNAME, username).as(User.class);
    }
    public static void deleteUserByUsername(String username){
        USER_SERVICE.deleteRequestQuery(USER_DELETE, username);
    }
    public static List<User> getAllUsers() {
        return USER_SERVICE.getRequest(USER).jsonPath().getList("", User.class);
    }

}
