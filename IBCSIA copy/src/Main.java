import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import java.util.*;
import Objects.*;
import BackEnd.*;


public class Main {
	
	public static void main(String[] args) {
		Athlete alina = new Athlete("Alina", true, "07-13-2003");
		System.out.println(alina.age);
		HashMap<String,Event> even = alina.getEvents(); 
		Event bs = new Event("02-24-17",Stroke.BACKSTROKE,1000,"0:7:13" ); 
		even.put(bs.toString(), bs);
		String FILEPATH = "BDSTTimeLogs.json";
		JsonClient js = new JsonClient(FILEPATH);
		ArrayList<Athlete> athletes = new ArrayList<>();
		athletes.add(alina);
		js.write(athletes);
//		//creating a JSONOBject object for swim team time logs
//		JSONObject timeLogs = new JSONObject();
//		
//		//inserting key-value pairs into the json object
//		timeLogs.put("Date", "11-12-17");
//		try {
//			FileWriter file = new FileWriter("BDSTTimeLogs.json");
//			System.out.println("hello");
//			file.write(timeLogs.toJSONString());
//			file.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("JSON file create: " + timeLogs);
	}

}
