package auto.prueba.apis.definition;

import static org.junit.Assert.assertEquals;

import auto.prueba.apis.step.AutenticacionStep;
import auto.prueba.apis.step.PingStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PingDefinition {
	
	@Steps
	private PingStep ping;
	
	@When("^ingreso al servicio HealthCheck de ping$")
	public void ingreso_al_servicio_HealthCheck_de_ping() {
		ping.consultaHealthCheck();
	}
	
	@Then("^espero una respuesta satisfactoria$")
	public void espero_una_respuesta_satisfactoria() {
		assertEquals( ping.msnServicio(),"Created");
	}

}
