package testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import clientLib.ClientSetup;
import utils.Utilities;

public class GETservicetest extends BaseClass {
	String uri;
	ClientSetup oClient;

	@BeforeMethod
	public void setup() {
		initialize();
		uri = oProp.getProperty("Url") + oProp.getProperty("serviceUrl");

	}

	@Test
	public void testGETapi() throws ClientProtocolException, IOException {
		CloseableHttpResponse clientResponse = oClient.getClientResponseWithoutHeader(uri);

		int statusCode = clientResponse.getStatusLine().getStatusCode();
		System.out.println("Status code retreived :" + statusCode);

		// validating status Code
		Assert.assertEquals(statusCode, repsonseCode_200, "Not a Success Code 200");

		JSONObject oJson = new JSONObject(EntityUtils.toString(clientResponse.getEntity(), "UTF-8"));
		System.out.println("JSON format of the response :" + oJson);
		
		//validating a particular object from JSON payLoad Data
		String test=Utilities.JSONparser(oJson, "/per_page");
		Assert.assertEquals(Integer.parseInt(test), 3);
		
		String JSONarray=Utilities.JSONparser(oJson, "/data[0]/first_name");
		Assert.assertEquals(JSONarray, "Eve");

		Header[] allHeaders = clientResponse.getAllHeaders();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		for (Header h : allHeaders) {
			headerMap.put(h.getName(), h.getValue());
		}

		
		System.out.println("All the headers received in the response: " + headerMap);

	}
	
	//Validating on adding Headers to Closeable client req
	
	@Test
	public void testGETwithHeaderAddition() throws JSONException, ParseException, IOException {
			//Adding Headers
		HashMap<String, String> testheader=new HashMap<String, String>();
		testheader.put("Content-type", "application/json");
		CloseableHttpResponse clientResponse=oClient.getClientResponseWithHeader(uri,testheader);
		//Validating the status
		Assert.assertEquals(clientResponse.getStatusLine().getStatusCode(), repsonseCode_200);
	
		
		JSONObject oJson=new JSONObject(EntityUtils.toString(clientResponse.getEntity(), "UTF-8"));
		Assert.assertEquals(Integer.parseInt(Utilities.JSONparser(oJson, "/total")), 12);
		Assert.assertEquals(Utilities.JSONparser(oJson, "/data[2]/last_name"), "Ramos");
		
		
		
	}
}
