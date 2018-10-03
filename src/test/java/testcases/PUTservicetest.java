package testcases;

import java.io.IOException;

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
import entities.UsersJob;
import utils.Utilities;

public class PUTservicetest extends BaseClass {

	String uri;

	@BeforeMethod
	public void starup() {
		initialize();

		uri = oProp.getProperty("Url") + oProp.getProperty("putUrl");
	}

	@Test
	public void testPutServices() throws JsonGenerationException, JsonMappingException, IOException {
		UsersJob u = new UsersJob("Karan", "Automation Engineer");
		String payload = Utilities.marshelling(u);
		System.out.println(payload);
		CloseableHttpResponse putResp = ClientSetup.putClientResponse(uri, payload);

		Assert.assertEquals(putResp.getStatusLine().getStatusCode(), repsonseCode_200);
		JSONObject objJSON = new JSONObject(EntityUtils.toString(putResp.getEntity(), "UTF-8"));
		System.out.println(objJSON);

	}

}
