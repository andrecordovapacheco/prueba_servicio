package auto.prueba.apis.definition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import auto.prueba.apis.step.AutenticacionStep;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;

public class AutenticacionDefinition {

	@Steps
	private AutenticacionStep auth;
	
	@Given("^accedo al servicio de RESTFUL BOOKER$")
	public void accedo_al_servicio_de_RESTFUL_BOOKER() {
		auth.usuarioIngresaAlServicio();
	}
	
	@When("^ingreso al servicio de creacion de token de acuerdo al usuario \"([^\"]*)\" y contrasenia \"([^\"]*)\"$")
	public void ingreso_al_servicio_de_creacion_de_token_de_acuerdo_al_usuario_y_contrasenia(String usuario, String contrasenia) {
		auth.usuarioContraseniaToken(usuario, contrasenia);
	}

	@Then("^espero obtener un token y el estado code (\\d+)$")
	public void espero_obtener_un_token_y_el_estado_code(int estado) {
		assertTrue(auth.getToken()!=null);
		assertEquals(estado, auth.getEstado());
	}
}
