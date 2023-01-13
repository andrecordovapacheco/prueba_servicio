package auto.prueba.apis.step;

import java.util.TreeMap;

import auto.prueba.apis.response.*;
import auto.prueba.apis.util.ServiciosUtil;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HomeStep {
	protected String url;
	protected RequestSpecification restAssuredRequest;
	protected Response response;
	protected TreeMap<String, String> queryParameters =new TreeMap<String, String> ();
	protected ServiciosUtil util=new ServiciosUtil();
	protected TokenResponse token;
	protected BookingAllResponse bookingAll;
	private static HomeStep obj = null;

	private HomeStep() {
	}

	public static HomeStep getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new HomeStep();
		}
	}
	
}
