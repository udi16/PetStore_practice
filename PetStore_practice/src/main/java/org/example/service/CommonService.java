package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.example.log.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class CommonService {
    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    private final Function<String, String> prepareUri = uri -> String.format("%s%s", BASE_URI, uri);

    protected RequestSpecification requestSpecification;

    public CommonService() {
        requestSpecification = RestAssured.given();
        setCommonParams();
    }

    protected void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type","application/json");
        requestSpecification.headers(headers);
    }
    protected Response postRequest(String uri, Object body) {
        Log.info("sending the post request to the uri"+ prepareUri.apply(uri));
        Response response = requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(prepareUri.apply(uri));
        Log.info("response is "+ response.asPrettyString());
        return response;
    }
    protected Response getRequestQuery(String uri) {
        Log.info("sending the post request to the uri"+ prepareUri.apply(uri));
        Response response = requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
        Log.info("response is "+ response.asPrettyString());
        return response;
    }
    protected void deleteRequestQuery(String uri, String username) {
        Log.info("sending the post request to the uri"+ prepareUri.apply(uri));
        Response response = requestSpecification.queryParam("username", username).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().delete(prepareUri.apply(uri));
        Log.info("response is "+ response.asPrettyString());

    }
    protected Response getRequest(String uri) {
        Log.info("sending the post request to the uri"+ prepareUri.apply(uri));
        Response response = requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
        Log.info("response is "+ response.asPrettyString());
        return response;
    }

}