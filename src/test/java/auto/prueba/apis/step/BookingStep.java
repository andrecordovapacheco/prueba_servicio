package auto.prueba.apis.step;

import java.util.List;

import com.google.gson.Gson;

import auto.prueba.apis.request.BookingRequest;
import auto.prueba.apis.request.TokenRequest;
import auto.prueba.apis.response.BookingAllResponse;
import auto.prueba.apis.response.BookingBodyResponse;
import auto.prueba.apis.response.BookingIDResponse;
import auto.prueba.apis.response.TokenResponse;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Step;

public class BookingStep {

	protected HomeStep home = HomeStep.getInstancia();
	private BookingAllResponse [] list;
	private BookingIDResponse bookingid;
	private BookingBodyResponse bookingbody;
	private String respDelete;
	private String codigo;
	

	@Step("El usuario debe poder obtener todas las reservas")
	public void consultaServicioReservaAll() {

		home.url=home.url+"/booking";
		home.response=home.util.conexion(home.url, "GET", null, null,null);

		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());	

		Gson gson =new Gson();
		list=gson.fromJson(home.response.then().extract().body().asString(), BookingAllResponse[].class);

	}

	@Step("El usuario espera obtener todas las reservas")
	public int reservaAll() {

		if(list!=null) {
			return list.length;
		}

		return 0;
	}

	@Step("El usuario debe poder obtener todas las reservas")
	public void filtro(String nombre, String apellido, String checkin) {
		home.url=home.url+"/booking";
		home.queryParameters.put("firstname", nombre);
		home.queryParameters.put("lastname", apellido);
		home.queryParameters.put("checkin", checkin);

		home.response=home.util.conexion(home.url, "GET", null, home.queryParameters,null);

		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
		Gson gson =new Gson();
		list=gson.fromJson(home.response.then().extract().body().asString(), BookingAllResponse[].class);
	}

	@Step("El usuario debe poder obtener todas las reservas")
	public void reservaID(String id){

		home.url=home.url+"/booking/"+id;

		home.response=home.util.conexion(home.url, "GET", null, null,null);

		bookingid= home.response.then().extract().body().as(BookingIDResponse.class);

		System.out.println("RESPONSE: "+home.response.getStatusCode());

	}
	
	@Step("El usuario debe poder saber el codigo del estado")
	public String retornoCodigoEstado() {
		return codigo;
	}
	
	@Step("El usuario debe poder obtener todas las reservas")
	public void reservaIDs(String id){

		home.url=home.url+"/booking/"+id;

		home.response=home.util.conexion(home.url, "GET", null, null,null);

		//bookingid= home.response.then().extract().body().as(BookingIDResponse.class);

		codigo=String.valueOf( home.response.getStatusCode());
		System.out.println("RESPONSE: "+home.response.getStatusCode());

	}
	
	

	@Step("El usuario espera obtener el nombre")
	public String reporteNombreID() {
		if(bookingid!=null) {
			return bookingid.getFirstname();	
		}
		return bookingbody.getBooking().getFirstname();

	}

	@Step("El usuario espera obtener el apellido")
	public String reporteApellidoID() {
		if(bookingid!=null) {
			return bookingid.getLastname();
		}
		return bookingbody.getBooking().getLastname();
	}

	@Step("El usuario espera obtener el total del precio")
	public String reportePrecioID() {
		if(bookingid!=null) {
			return  String.valueOf(bookingid.getTotalprice());
		}
		return String.valueOf(bookingbody.getBooking().getTotalprice());
	}

	@Step("El usuario espera obtener el depositpaid")
	public String reporteDepositoPaidID() {
		if(bookingid!=null) {
			return String.valueOf(bookingid.getDepositpaid());	
		}
		return String.valueOf(bookingbody.getBooking().getDepositpaid());
	}

	@Step("El usuario espera obtener el checkin")
	public String reporteCheckinID() {
		if(bookingid!=null) {
			return bookingid.getBookingdates().getCheckin();
		}	
		return bookingbody.getBooking().getBookingdates().getCheckin();
	}

	@Step("El usuario espera obtener el checkout")
	public String reporteCheckoutID() {
		if(bookingid!=null) {
			return bookingid.getBookingdates().getCheckout();	
		}
		return bookingbody.getBooking().getBookingdates().getCheckout();
	}

	@Step("El usuario espera obtener el additionalneeds")
	public String reporteAdditionalneedsID() {
		if(bookingid!=null) {
			return bookingid.getAdditionalneeds();	
		}
		return bookingbody.getBooking().getAdditionalneeds();
	}

	@Step("El usuario espera crear reserva")
	public void crearReserva(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		home.url=home.url+"/booking";		

		String booking=new BookingRequest().crearJsonBooking(nombre, apellido, totalprice, depositpaid, checkin, checkout, additionalneeds);

		home.response=home.util.conexion(home.url, "POST", booking, null,null);

		bookingbody= home.response.then().extract().body().as(BookingBodyResponse.class);

		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
	}
	
	@Step("El usuario espera crear reserva")
	public void crearReservas(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		home.url=home.url+"/booking";		

		String booking=new BookingRequest().crearJsonBookingMalo(nombre, apellido, totalprice, depositpaid, checkin, checkout, additionalneeds);

		home.response=home.util.conexion(home.url, "POST", booking, null,null);

		codigo=String.valueOf( home.response.getStatusCode());

		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
	}

	@Step("El usuario espera actualizar la reserva")
	public void updateReserva(String token,String id,String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		String url="https://restful-booker.herokuapp.com/booking/"+id;		

		String booking=new BookingRequest().crearJsonBooking(nombre, apellido, totalprice, depositpaid, checkin, checkout, additionalneeds);

		home.response=home.util.conexion(url, "PUT", booking, null,token);
		home.response.then().assertThat().statusCode(200);
		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
		bookingid= home.response.then().extract().body().as(BookingIDResponse.class);

	}
	
	@Step("El usuario espera actualizar la reserva")
	public void updateReservas(String token,String id,String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		String url="https://restful-booker.herokuapp.com/booking/"+id;		

		String booking=new BookingRequest().crearJsonBookingMalo(nombre, apellido, totalprice, depositpaid, checkin, checkout, additionalneeds);

		home.response=home.util.conexion(url, "PUT", booking, null,token);
		codigo=String.valueOf( home.response.getStatusCode());

	}

	@Step("El usuario espera actualizar parcialmente la reserva")
	public void updateReservaParcial(String token,String id,String nombre, String apellido){
		String url="https://restful-booker.herokuapp.com/booking/"+id;		

		String booking=new BookingRequest().crearJsonBooking(nombre, apellido);

		home.response=home.util.conexion(url, "PATCH", booking, null,token);
		home.response.then().assertThat().statusCode(200);
		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
		bookingid= home.response.then().extract().body().as(BookingIDResponse.class);
	}
	
	@Step("El usuario espera actualizar parcialmente la reserva")
	public void updateReservaParcials(String token,String id,String nombre, String apellido){
		String url="https://restful-booker.herokuapp.com/booking/"+id;		

		String booking=new BookingRequest().crearJsonBookingMalo(nombre, apellido);

		home.response=home.util.conexion(url, "PATCH", booking, null,token);
		codigo=String.valueOf( home.response.getStatusCode());
	}
	
	@Step("El usuario espera que elimine la reserva")
	public void deleteReserva(String id,String token) {
		String url="https://restful-booker.herokuapp.com/booking/"+id;		

		home.response=home.util.conexion(url, "DELETE", null, null,token);
		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
		home.response.then().assertThat().statusCode(201);
		
		respDelete=home.response.then().extract().body().asString();
	}

	@Step("El usuario espera que se cree un nuevo id")
	public boolean generacionNuevoID() {
		return bookingbody.getBookingid()!=null;
	}
	
	@Step("El usuario espera el mensaje de eliminacion")
	public String msnDelete() {
		return respDelete;
	}
	
}
