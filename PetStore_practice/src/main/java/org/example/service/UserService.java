package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class UserService extends CommonService {
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    public Response getRequestQuery(UriTemplate uri, String username) {
        return super.getRequestQuery(uri.getUri(uri));
    }
    public Response getRequest(UriTemplate uri) {
        return super.getRequest(uri.getUri());
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public void deleteRequestQuery(UriTemplate uri, String username) {
        super.deleteRequestQuery(uri.getUri(), username);
    }
}
