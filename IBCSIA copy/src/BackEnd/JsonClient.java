package BackEnd;
import java.util.*;

	import java.io.FileWriter;
	import java.io.*;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.JSONArray;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import Objects.*;

public class JsonClient {
	String filepath;
	FileWriter fw;
	public JsonClient(String filepath) {
		this.filepath = filepath;
		
	}
	public ArrayList<Athlete> read(){
		ArrayList<Athlete> res = new ArrayList<>();
		JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(this.filepath))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
           
            JSONObject a = (JSONObject) obj;
            res = this.parseTimeLog(a);

            //Iterate over employee array
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return res;
	}
	
	public void write(ArrayList<Athlete> a) {
		JSONObject timeLogs = new JSONObject();
		for(Athlete at : a) {
			JSONObject ath = new JSONObject();
			timeLogs.put(at.getName(), ath);
			ath.put("Gender", at.isFemale());
			ath.put("Birthday", at.getBirthday());
			
			JSONObject times = new JSONObject();
			ath.put("Times", times);
			for(String key:at.getEvents().keySet()){
				JSONObject eve = new JSONObject();
				Event even = at.getEvents().get(key);
				times.put(key, eve);
				eve.put("Date", even.getDate());
				eve.put("Stroke", even.getStroke().ordinal());
				eve.put("Distance", even.getDistance());
				eve.put("Time", even.getTime());
			}

		}
		
		try {
			fw = new FileWriter(this.filepath);
			fw.write(timeLogs.toJSONString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//PROCEDURAL DECOMPOSITION
	private ArrayList<Athlete> parseTimeLog(JSONObject timeLogs) {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		//get athlete object from lsjfsajd
		for(String athName: (Set<String>)timeLogs.keySet()) {
			//System.out.print(athName);
			JSONObject athObject = (JSONObject) timeLogs.get(athName);
			athletes.add(this.parseAthlete(athName, athObject));
			
			
			
		}
		return athletes;
	 
		
	}
	private Athlete parseAthlete(String name, JSONObject ath) {
		
		boolean female = (boolean) ath.get("Gender");
		String birthday = (String) ath.get("Birthday");
		
		Athlete a = new Athlete(name, female, birthday);
		this.parseTimes(a, (JSONObject)ath.get("Times"));
		
		return a;
	}
	private void parseTimes(Athlete a, JSONObject time) {
		for(String key: (Set<String>)time.keySet()) {
			a.insertEvents(key, this.parseEvent((JSONObject)time.get(key)));
			
		}
	}
	private Event parseEvent(JSONObject eve) {
		String date = (String) eve.get("Date");
		Stroke stroke = Stroke.values()[Integer.valueOf(eve.get("Stroke").toString())];
		int distance = Integer.valueOf(eve.get("Distance").toString());
		String time  = (String) eve.get("Time");
	
		
		return new Event(date,stroke, distance, time);
	}
}

