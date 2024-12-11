package tester;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SignUp {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  
  @BeforeClass
  public void setup() {
	  RestAssured.baseURI = "https://qa.api.welup.savein.money";
  }  
  
  @Test(priority=1)
  public void sendSignupOtpTest() {
      // Get bearerToken from the Singleton class
      String bearerToken = SharedData.getInstance().getBearerToken();

      // API call using RestAssured
      Response response = RestAssured
              .given()
              .contentType(ContentType.JSON)
              .accept("*/*")
              .header("Authorization", "Bearer " + bearerToken)
              .body("{ \"name\": \"Ayush\", \"email\": \"tayush7379@gmail.com\", \"mobile\": \"7379406027\" }")
              .when()
              .post("/api/auth/send-signup-otp")
              .then()
              .statusCode(200) // Adjust the status code based on your requirement
              .extract()
              .response();

      // Print response
      System.out.println("Response: " + response.asString());
  }
  
  @Test(priority=2)
  public void verifySignupOtpTest() {
      // Get bearerToken, email, and OTP from the Singleton class
      String bearerToken = SharedData.getInstance().getBearerToken();
      SharedData.getInstance().setEmail("tayush7379@gmail.com");
      String email = SharedData.getInstance().getEmail();
      SharedData.getInstance().setOtp("263077");
      String otp = SharedData.getInstance().getOtp();
      System.out.println(otp);

      // API call using RestAssured
      Response response = RestAssured
              .given()
              .contentType(ContentType.JSON)
              .accept("*/*")
              .header("Authorization", "Bearer " + bearerToken)
              .body("{ \"email\": \"" + email + "\", \"otp\": \"" + otp + "\" }")
              .when()
              .post("/api/auth/verify-signup-otp")
              .then()
              .statusCode(200) // Adjust the status code based on your requirement
              .extract()
              .response();

      // Print response
      System.out.println("Response: " + response.asString());
      String token = response.jsonPath().getString("token"); // Adjust the path as per the actual response structure
      SharedData.getInstance().setBearerToken(token);
  }
  



  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  static class TestData {
      @DataProvider(name = "signupData")
      public Object[][] provideSignupData() {
          return new Object[][] {
              { "Ayush", "tayush7379@gmail.com", "7379406027" }
          };
      }
  }

}
