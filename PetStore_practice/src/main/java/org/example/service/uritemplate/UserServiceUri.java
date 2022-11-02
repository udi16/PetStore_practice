package org.example.service.uritemplate;

public class UserServiceUri {
    public static final UriTemplate USER = new UriTemplate("user");
    public static final UriTemplate USER_BY_USERNAME = new UriTemplate("user/string");
    public static final UriTemplate USER_DELETE = new UriTemplate("user/%s");


}
