package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import clientLib.ClientSetup;

import entities.Users;
import utils.Utilities;

public class POSTservicetest extends BaseClass {

	String Uri;

	@BeforeMethod
	public void setUp() {

		initialize();
		Uri = (oProp.getProperty("Url") + oProp.getProperty("postUrl"));

	}

	@Test
	public void testPostServices()
			throws JsonGenerationException, JsonMappingException, ClientProtocolException, IOException {

		Users expected=new Users("Karan", "Chaudhary");
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-type", "application/json");
		CloseableHttpResponse response = ClientSetup.postClientResponse(Uri, Utilities.marshelling(expected), headers);
		// Status Code validation
		Assert.assertEquals(response.getStatusLine().getStatusCode(), repsonseCode_201);
		// fetching the response
		String responsePayload = EntityUtils.toString(response.getEntity(), "UTF-8");
		// Converting to JSONObject if required
		JSONObject respPayload = new JSONObject(responsePayload);
		System.out.println(respPayload);
		
		Users actual = Utilities.unmarshelling(expected,responsePayload);

		Assert.assertTrue(actual.getFirst_name().equals(expected.getFirst_name()));
		Assert.assertEquals(actual.getLast_name(),expected.getLast_name());

	}

}
