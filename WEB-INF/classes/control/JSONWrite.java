package control;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JSONWrite {
	
	public static void main(String[] args) {
		
		JSONObject jsonObject = new JSONObject();
		FileWriter filewrite = null;
		
		jsonObject.put("nome", "Bruno");
		jsonObject.put("sobrenome", "Gama Wu");
		
		try {
			filewrite = new FileWriter("eventos.json");
			filewrite.write(jsonObject.toJSONString());
			filewrite.close();
			System.out.println(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
