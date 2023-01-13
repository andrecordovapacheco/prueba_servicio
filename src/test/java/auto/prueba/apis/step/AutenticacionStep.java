package auto.prueba.apis.step;

import java.util.TreeMap;

import auto.prueba.apis.request.TokenRequest;
import auto.prueba.apis.response.TokenResponse;
import auto.prueba.apis.util.ServiciosUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AutenticacionStep  {
	protected HomeStep home = HomeStep.getInstancia();
	
	@Step("El usuario debe poder ingresar al servicio de RESTFUL - BOOKER")
	public void usuarioIngresaAlServicio() {
		home.url="https://restful-booker.herokuapp.com";
	}
		
	@Step("El usuario debe poder generar un token de autentificación de acuerdo al usuario y contraseña")
	public String usuarioContraseniaToken(String usuario, String contrasenia) {
		
		home.url=home.url+"/auth";
		String tokenRequest=new TokenRequest().crearJsonToken(usuario, contrasenia);
		home.response=home.util.conexion(home.url, "POST", tokenRequest, null,null);
		
		home.token= home.response.then().extract().body().as(TokenResponse.class);
		System.out.println("RESPONSE: "+home.response.then().extract().body().asString());
		return home.token.getToken();
	}
	
	@Step("Obtener el estado de la consulta")
	public int getEstado() {
		return home.response.getStatusCode();
	}
	
	@Step("Obtener el token")
	public String getToken() {
		return home.token.getToken();
	}
	
	
}
