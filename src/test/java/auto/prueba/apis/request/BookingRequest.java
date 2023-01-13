package auto.prueba.apis.request;

import org.json.JSONObject;

public class BookingRequest {

	public String crearJsonBooking(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {

		JSONObject request = new JSONObject();
		request.put("firstname", nombre);
		request.put("lastname", apellido);
		request.put("totalprice", totalprice);
		request.put("depositpaid", depositpaid);
		
		
		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", checkin);
		bookingdates.put("checkout", checkout);
		request.put("bookingdates", bookingdates);
		request.put("additionalneeds", additionalneeds);
		
		return request.toString();
	}
	
	public String crearJsonBookingMalo(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {

		JSONObject request = new JSONObject();
		request.put("firstname", nombre);
		request.put("lastname", new Integer(apellido));
		request.put("totalprice", totalprice);
		request.put("depositpaid", depositpaid);
		
		
		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", checkin);
		bookingdates.put("checkout", checkout);
		request.put("bookingdates", bookingdates);
		request.put("additionalneeds", additionalneeds);
		
		return request.toString();
	}
	
	public String crearJsonBooking(String nombre, String apellido) {
		JSONObject request = new JSONObject();
		request.put("firstname", nombre);
		request.put("lastname", apellido);
		return request.toString();
	}
	public String crearJsonBookingMalo(String nombre, String apellido) {
		JSONObject request = new JSONObject();
		request.put("firstname", nombre);
		request.put("lastname", new Integer(apellido));
		return request.toString();
	}
	
	
}
