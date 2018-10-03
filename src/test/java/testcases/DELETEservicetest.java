package testcases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import clientLib.ClientSetup;

public class DELETEservicetest extends BaseClass{
	String uri;
	@BeforeMethod
	public void startUp() {
		initialize();
		uri=oProp.getProperty("Url")+oProp.getProperty("deleteUrl");
	}

	
	@Test
	public void deleteTest() throws ClientProtocolException, IOException {
		
		CloseableHttpResponse deleteResponse=ClientSetup.deleteServiceTest(uri);
		
		Assert.assertEquals(deleteResponse.getStatusLine().getStatusCode(), repsonseCode_204);
	
	}
}
