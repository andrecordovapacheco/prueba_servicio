package auto.prueba.apis.request;

import org.json.JSONArray;
import org.json.JSONObject;

public class TokenRequest {

	public String crearJsonToken(String username,String password) {
		
		JSONObject request = new JSONObject();
		request.put("username", username);
		request.put("password", password);
	
		return request.toString();
	}
	
}
