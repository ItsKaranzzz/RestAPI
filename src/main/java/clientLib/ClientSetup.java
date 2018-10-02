package clientLib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import utils.Utilities;

public class ClientSetup {

	// GET operation without passing Header details

	public static CloseableHttpResponse getClientResponseWithoutHeader(String uri)
			throws ClientProtocolException, IOException {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getUri = new HttpGet(uri);
		CloseableHttpResponse clientResponse = client.execute(getUri);

		return clientResponse;
	}

	// GET operation with Header details in the Request

	public static CloseableHttpResponse getClientResponseWithHeader(String uri, HashMap<String, String> headers)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getAll = new HttpGet(uri);
		for (Entry<String, String> i : headers.entrySet()) {
			getAll.addHeader(i.getKey(), i.getValue());
		}

		CloseableHttpResponse clientresponse = httpClient.execute(getAll);

		return clientresponse;

	}

	// POST operations on webservices

	public static CloseableHttpResponse postClientResponse(String uri, String JSONpayload,
			HashMap<String, String> headers) throws ClientProtocolException, IOException {

		CloseableHttpClient client = HttpClients.createDefault();
		// Created URI for the Request
		HttpPost postToURI = new HttpPost(uri);
		// Created headers required for the Request
		for (Entry<String, String> i : headers.entrySet()) {
			postToURI.addHeader(i.getKey(), i.getValue());
		}

		// For the JSON Payload now
		postToURI.setEntity(new StringEntity(JSONpayload));
		CloseableHttpResponse postResponse = client.execute(postToURI);
		return postResponse;

	}
}
