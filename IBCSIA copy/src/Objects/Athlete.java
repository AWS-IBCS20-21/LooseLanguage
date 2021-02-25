package Objects;
import java.util.*;
import java.time.LocalDateTime;
public class Athlete {
	private boolean female; 
	public int age;
	String name; 
	HashMap<String,Event> events; 
	// Key: Event,  value: Time, Time "minute:second:ms"
	String birthday;
	//Month-Day-Year   xx-xx-xxxx
	
	
	
	public Athlete(String name,boolean female, String birthday){ 
		this.name = name; 
		this.female = female; 
		this.birthday = birthday; 
		this.age = getAge();
		this.events = new HashMap<String,Event>();
		
	}
	//Inserting events 
	public void insertEvents(String eventName, Event eventInfo) {
		events.put(eventName, eventInfo);
	}
	private int getAge() {
		age = 0; 
		LocalDateTime time = LocalDateTime.now(); 
		int year = time.getYear(); 
		int month = time.getMonthValue();
		int day = time.getDayOfMonth();
		String[] bday = this.birthday.split("-"); 
		int[] bdayInt = new int[3]; 
		for(int i = 0; i <3;i++) {
			bdayInt[i] = Integer.valueOf(bday[i]);
		}
		if(bdayInt[0] < month) {
			age = year-bdayInt[2];
		}else if(bdayInt[0] > month) {
			age = year-bdayInt[2]-1;
		}else {
			age = year-bdayInt[2]; 
			age -= (day < bdayInt[1]) ? 1 : 0;
		}
		return age;
	}
	public boolean isFemale() {
		//souperior 
		return female;
	}
	public void setFemale(boolean female) {
		this.female = female;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public HashMap<String,Event> getEvents(){
		return this.events;
	}
	
}
