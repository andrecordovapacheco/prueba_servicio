package auto.prueba.apis.definition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import auto.prueba.apis.step.AutenticacionStep;
import auto.prueba.apis.step.BookingStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BookingDefinition {

	@Steps
	private BookingStep booking;
	@Steps
	private AutenticacionStep auth;
	private String token;

	@When("^consulto el servicio de todos las reservas$")
	public void consulto_el_servicio_de_todos_las_reservas() {
		booking.consultaServicioReservaAll();
	}

	@Then("^espero obtener todas las reservas$")
	public void espero_obtener_todas_las_reservas() {
		assertTrue(booking.reservaAll()>0);
	}

	@When("^consulto el servicio de todos las reservas de acuerdo  \"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\"$")
	public void consulto_el_servicio_de_todos_las_reservas_de_acuerdo(String nombre, String apellido, String checkin) {
		booking.filtro(nombre,apellido,checkin);
	}


	@When("^consulto el servicio de reserva especifica \"([^\"]*)\"$")
	public void consulto_el_servicio_de_reserva_especifica(String id) {
		booking.reservaID(id);
	}

	@Then("^espero obtener la reserva indicada \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void espero_obtener_la_reserva_indicada(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout) {
		assertEquals(booking.reporteNombreID(),nombre);
		assertEquals(booking.reporteApellidoID(),apellido);
		assertEquals(booking.reportePrecioID(),totalprice);
		assertEquals(booking.reporteDepositoPaidID(),depositpaid);
		assertEquals(booking.reporteCheckinID(),checkin);
		assertEquals(booking.reporteCheckoutID(),checkout);
	}

	@When("^consulto el servicio de reserva especifica \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void consulto_el_servicio_de_reserva_especifica(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		booking.crearReserva(nombre, apellido, totalprice , depositpaid, checkin, checkout, additionalneeds);

	}
	
	@When("^consulto el servicio de reserva especificas \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void consulto_el_servicio_de_reserva_especificas(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		booking.crearReservas(nombre, apellido, totalprice , depositpaid, checkin, checkout, additionalneeds);

	}

	@Then("^espero obtener la reserva  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void espero_obtener_la_reserva(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout) {
		assertTrue(booking.generacionNuevoID());
		assertEquals(booking.reporteNombreID(),nombre);
		assertEquals(booking.reporteApellidoID(),apellido);
		assertEquals(booking.reportePrecioID(),totalprice);
		assertEquals(booking.reporteDepositoPaidID(),depositpaid);
		assertEquals(booking.reporteCheckinID(),checkin);
		assertEquals(booking.reporteCheckoutID(),checkout);
	}


	@Given("^genero el token con el usuario \"([^\"]*)\" y contrasenia \"([^\"]*)\"$")
	public void genero_el_token_con_el_usuario_y_contrasenia(String user, String contrasenia) {
		token=auth.usuarioContraseniaToken(user, contrasenia);
	}

	@When("^actualizo los datos del id \"([^\"]*)\" a \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void actualizo_los_datos_del_id_a(String id,String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		booking.updateReserva(token,id,nombre, apellido, totalprice , depositpaid, checkin, checkout, additionalneeds);

	}

	@When("^actualizo los datos del ids \"([^\"]*)\" a \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void actualizo_los_datos_del_id_as(String id,String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout, String additionalneeds) {
		booking.updateReservas(token,id,nombre, apellido, totalprice , depositpaid, checkin, checkout, additionalneeds);

	}

	@Then("^espero obtener la actualizacion  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void espero_obtener_la_actualizacion(String nombre, String apellido, String totalprice , String depositpaid, String checkin, String checkout) {
		assertEquals(booking.reporteNombreID(),nombre);
		assertEquals(booking.reporteApellidoID(),apellido);
		assertEquals(booking.reportePrecioID(),totalprice);
		assertEquals(booking.reporteDepositoPaidID(),depositpaid);
		assertEquals(booking.reporteCheckinID(),checkin);
		assertEquals(booking.reporteCheckoutID(),checkout);
	}

	@When("^actualizo los datos del id parcialmente \"([^\"]*)\" a \"([^\"]*)\",\"([^\"]*)\"$")
	public void actualizo_los_datos_del_id_parcialmente_a(String id, String nombre, String apellido) {
		booking.updateReservaParcial(token,id,nombre, apellido);

	}
	
	@When("^actualizo los datos del id parcialmentes \"([^\"]*)\" a \"([^\"]*)\",\"([^\"]*)\"$")
	public void actualizo_los_datos_del_id_parcialmente_as(String id, String nombre, String apellido) {
		booking.updateReservaParcials(token,id,nombre, apellido);

	}

	@When("^elimino la reserva \"([^\"]*)\"$")
	public void elimino_la_reserva(String id) {
		booking.deleteReserva( id,token);
	}

	@Then("^espero la eliminacion de la reserva$")
	public void espero_la_eliminacion_de_la_reserva() {
		assertEquals(booking.msnDelete(), "Created");
	}
	
	@When("^consulto el servicio de reserva especificas \"([^\"]*)\"$")
	public void consulto_el_servicio_de_reserva_especificas(String id) {
		booking.reservaIDs(id);
	}

	
	@Then("^espero obtener el codigo de estado \"([^\"]*)\"$")
	public void espero_obtener_el_codigo_de_estado(String estado) {
		assertEquals(booking.retornoCodigoEstado(),estado);
	}
}
