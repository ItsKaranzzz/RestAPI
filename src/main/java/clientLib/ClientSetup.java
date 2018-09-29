package clientLib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ClientSetup {

	public static CloseableHttpResponse getClientResponseWithoutHeader(String uri)
			throws ClientProtocolException, IOException {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getUri = new HttpGet(uri);
		CloseableHttpResponse clientResponse = client.execute(getUri);

		return clientResponse;
	}

	public static CloseableHttpResponse getClientResponseWithHeader(String uri, HashMap<String, String> headers)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getAll = new HttpGet();
		for (Entry<String, String> i : headers.entrySet()) {
			getAll.addHeader(i.getKey(), i.getValue());
		}

		CloseableHttpResponse clientresponse = httpClient.execute(getAll);

		return clientresponse;

	}
}
