package com.bestbuy.CRUDtest;

import com.bestbuy.bestbuy.BestbuyStoreSteps;
import com.bestbuy.constants.EndPoints;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class StoreCRUDTest extends TestBase {

    static String name = "StoreWatford";//for POST request

    static String type = "Games";//for POST request

    static String address = "1 High Street";
    static String address2 = "Watford";
    static String city = "Hertforshire";
    static String state = "England";
    static String zip = "WD1 1AA";
    static Double lat = 50.00;

    static Double lng = 50.00;
    static String hours = "Mon: 9 - 9";
    static HashMap<String, Object> services = new HashMap<String, Object>();

    static int Id;

    @Steps
    BestbuyStoreSteps steps;

    @Test
    public void createStores() {

        ValidatableResponse response = steps.creatingStore(name, type, address, address2, city, state, zip, lat, lng, hours, services);
        response.statusCode(201);

      Id = response.extract().path("id");
        System.out.println("Store ID created" + Id);

}
    @Test
    public void getStoreById(){

                given()
                .pathParam("storeID", Id)
                        .when()
                        .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                        .then().log().all()
                        .statusCode(200);

    }

    @Test
    public void updateId(){
        name = name + "updated";
        ValidatableResponse response = steps.creatingStore(name, type, address, address2, city, state, zip, lat, lng, hours, services);
        response.statusCode(201);
    }

}
