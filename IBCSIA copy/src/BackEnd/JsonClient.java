package BackEnd;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;


import Objects.*;

public class JsonClient {
	String filepath;
	FileWriter fw;
	public JsonClient(String filepath) {
		this.filepath = filepath;
		
	}
	public ArrayList<Athlete> read(){
		ArrayList<Athlete> res = new ArrayList<>();
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
}

