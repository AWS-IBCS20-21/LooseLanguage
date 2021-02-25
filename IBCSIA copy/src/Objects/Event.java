package Objects;

public class Event {
	private String date;
	private Stroke stroke;
	private int distance;
	private String time;
	
	
	public Event(String date, Stroke stroke, int distance, String time) {
		this.date = date;
		this.stroke = stroke;
		this.distance = distance;
		this.time = time;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Stroke getStroke() {
		return stroke;
	}


	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return distance + "" + stroke;
	}

}
