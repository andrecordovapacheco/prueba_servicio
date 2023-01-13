package auto.prueba.apis.step;

import net.thucydides.core.annotations.Step;

public class PingStep {
	protected HomeStep home = HomeStep.getInstancia();
	private String respServicio;
	
	@Step("El usuario hace una consulta al servicio HealthCheck haciendo un ping")
	public void consultaHealthCheck() {
		home.url=home.url+"/ping";
		home.response=home.util.conexion(home.url, "GET", null, null,null);
		respServicio=home.response.then().extract().body().asString();
		
		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());	
	}
	
	@Step("El usuario espera el mensaje respuesta")
	public String msnServicio() {
		return respServicio;
	}
}
