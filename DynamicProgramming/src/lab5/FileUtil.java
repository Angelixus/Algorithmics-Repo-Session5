package lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileUtil {

	public static HashMap<String, Integer> loadFile(String filename) {
		BufferedReader reader = null;
		HashMap<String, Integer> res = new HashMap<>();
		
		try {
			reader = new BufferedReader(new FileReader(filename));

			while (reader.ready()) {
				String[] line = reader.readLine().split(" ");
				res.put(line[0], Integer.parseInt(line[1]));
			}
			reader.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return res;
	}

}
