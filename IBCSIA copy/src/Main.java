import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import java.util.*;
import Objects.*;
import BackEnd.*;


public class Main {
	
	public static void main(String[] args) {
//		Athlete alina = new Athlete("Alina", true, "07-13-2003");
//		Athlete baka = new Athlete("Baka", false, "01-20-2005");
//		
		 
//		Event bs = new Event("02-24-17",Stroke.BACKSTROKE,1000,"0:7:13" );
//		Event as = new Event("4-19-19", Stroke.BREASTSTROKE,100, "0:23:21");
//		alina.insertEvents(bs.toString(), bs);
//		alina.insertEvents(as.toString(), as);
		
//		Event ss = new Event("5-01-18", Stroke.BREASTSTROKE,100, "0:23:01");
//		baka.insertEvents(ss.toString(), ss);
		
		String FILEPATH = "BDSTTimeLogs.json";
		JsonClient js = new JsonClient(FILEPATH);
		Client client = new Client();
		
		System.out.print(client.backTimeString(36));;
		
		ArrayList<Athlete> athletes = js.read();
		
	/*	Map<String, Integer> test = client.sortedEventTimes(athletes, "100BREASTSTROKE");
		
		for(Map.Entry<String, Integer> en : test.entrySet()) {
			System.out.println("Name:" + en.getKey() + ", " + "Time: " + en.getValue());
		}
		*/
		
		
		
//		ArrayList<Athlete> athletes = new ArrayList<>();
//		athletes.add(alina);
//		athletes.add(baka);
		
	//	js.write(athletes);
		
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
