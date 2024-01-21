package com.bestbuy.bestbuy;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

public class BestbuyStoreSteps {

    @Step
    public ValidatableResponse creatingStore(String name, String type, String address, String address2, String city, String state, String zip, Double lat, Double lng, String hours, HashMap<String, Object> services){

        StorePojo storePojo = new StorePojo();

        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        storePojo.setServices(services);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(storePojo)
                .post(EndPoints.POST)
                .then().log().all();
    }
}
