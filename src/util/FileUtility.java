package util;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class FileUtility {
	public String readFileAsString(String FILENAME){
		String text = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			String line;
			while ((line = reader.readLine()) != null) {
				text+=line;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public JSONObject getProjectAsJsonRoot(String fileLoc) {

		JSONParser parser = new JSONParser();
		
		String projectJson = readFileAsString(fileLoc);
		try {
			return (JSONObject) parser.parse(projectJson);
		} catch (ParseException e) {
			// TODO handle error
			e.printStackTrace();
		}
		return null;
	}
}
