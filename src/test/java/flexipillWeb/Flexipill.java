package flexipillWeb;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class Flexipill {
 
	//private String baseURL = "https://flexipill-ui-new-staging.vercel.app/";
	//private String Token = "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";
	
	 String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjk4NSwiYXV0aF90eXBlIjoiZXh0ZXJuYWxfYXV0aCIsImlhdCI6MTcxNzUzMTU0MCwiZXhwIjoxNzE3NTMyMTQwfQ.81GSbxkAxWLMVHsAzRRKUI4VPMpIafXEcy739npSmWI";
	
	@Test(enabled = false)
	public void loginTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("phone_number", "1111111111");
		obj.put("otp_code", "1111");
		given().body(obj.toJSONString()).header("Content-Type", "application/JSON").contentType(ContentType.JSON)
		.when().post("https://backendstaging.platinumrx.in/auth/login").then().log().all();
	}
	
	@Test(enabled = false)
	public void addToCart() {
		
		JSONObject obj = new JSONObject();
		obj.put("increaseQuantityBy", "2");
		obj.put("drugCode", 1110806);
		
		given().header("Authorization", "Bearer " + jwtToken).header("Content-Type", "application/JSON").contentType(ContentType.JSON)
		.body(obj.toJSONString()).when().post("https://backendstaging.platinumrx.in/cart/addItem").then().log().all();
	}
	
	@Test(enabled = true)
	public void createOrder() {
		
		JSONObject obj = new JSONObject();
		obj.put("paymentType", "COD");
		obj.put("orderType", "SEARCH");
		obj.put("patientName", "test");
		obj.put("patientAddress", "test-block test-city test-state 577201");
		obj.put("patientMobileNumber", "9876543219");
		obj.put("patientAge", "23");
		obj.put("patientGender", "male");
		obj.put("pincode", 577201);
		obj.put("city", "test-city");
		obj.put("state", "test-state");
		
		given().header("Authorization", "Bearer " + jwtToken).contentType(ContentType.JSON)
		.body(obj.toJSONString()).when().post("https://backendstaging.platinumrx.in/orders/initiateOrder").then().log().all();
		
	}
	
}
