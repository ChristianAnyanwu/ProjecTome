package util;

import java.io.BufferedReader;
import java.io.FileReader;

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
}
