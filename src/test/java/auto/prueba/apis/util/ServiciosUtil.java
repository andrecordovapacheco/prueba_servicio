package auto.prueba.apis.util;

import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;


public class ServiciosUtil {

	public static String urlRequest;
	public static String uri;
	public static String host;
	public static String accessKey;
	public static String secretKey;
	public static String method;
	public String portUrl = "";
	public String portHost = "";
	public String portPath = "";

	private int status;


	public int getStatus() {
		return status;
	}

	public void setStatus(int statusLine) {
		this.status = statusLine;
	}


	public void urlServicio() {
		//urlRequest = portUrl+ portHost+portPath;
		uri = portUrl+ portHost+portPath;
		host = portHost;

	}
	public Response conexion(String url,String metodo,String body,TreeMap<String, String> parametros,String token) {
		
		Response restAssuredResponse=null;
		
		RequestSpecification restAssuredRequest = SerenityRest.given().contentType("application/json").accept("application/json");
		
		if(token!=null) {
			restAssuredRequest = SerenityRest.given().header("Cookie", "token=" + token).header("Authorization","Basic").header("Content-Type","application/json; charset=UTF-8").contentType("application/json").accept("application/json");
		}
		
		restAssuredRequest.given().log().all();
		//restAssuredRequest.and();
		
		if(body!=null) {
			restAssuredRequest.body(body);
		}
		
		if(parametros!=null) {
			restAssuredRequest.queryParameters(parametros);
		}
		

		switch (metodo) {
		case "PATCH":
			restAssuredResponse = restAssuredRequest.when().patch(url);
			break;
		case "POST":
			restAssuredResponse = restAssuredRequest.when().post(url);
			break;
		case "GET":
			restAssuredResponse = restAssuredRequest.when().get(url);
			break;
		case "PUT":
			restAssuredResponse = restAssuredRequest.when().put(url);
			break;
		case "DELETE":
			restAssuredResponse = restAssuredRequest.when().delete(url);
			break;
		default:
			break;
		} 


		return restAssuredResponse;
	}
	/*
	public Response conexion(AWSSignature signature, RequestSpecification restAssuredRequest) {

		signature.setHeader("host", host);
		signature.setHeader("Content-type", "application/json");
		signature.setHeader("charset", "UTF-8");

		signature.setHeader("Content-Length", "3744");



		signature.setAccessKey(accessKey);
		signature.setSecretKey(secretKey);
		signature.setMethod(method);
		signature.setCanonicalUri(uri);
		System.out.println("URL REQUEST "   +urlRequest );
		Map<String, String> header = signature.getAWSSignature();

		for(Map.Entry<String, String> entrySet : header.entrySet()) {
			String key = entrySet.getKey();
			String value = entrySet.getValue();
			System.out.println("KEY :" + key + " VALUE :" + value);
			restAssuredRequest.header(key, value);
		}


		if(!signature.isPayloadEmpty()) {
			restAssuredRequest.body(signature.getPayload());
		}

		if(!signature.isQueryParametersEmpty()) { 
			restAssuredRequest.queryParameters(signature.getQueryParameters());
		}

		Response restAssuredResponse;
		if(method.equals("GET")) {
			restAssuredResponse = restAssuredRequest.when().get(urlRequest);
		}else {
			restAssuredResponse = restAssuredRequest.when().post(urlRequest);
					}

		return restAssuredResponse;
	}*/
}
