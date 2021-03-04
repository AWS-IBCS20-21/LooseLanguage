package BackEnd;

import java.util.*;


import Objects.*;

public class Client {
	public static void main(String[] args) {
		
	}
	
	//check valid date
	public boolean validDate(String date) {
		if(date.length() != 10) {
			return false;
		}
		char[] dateChar = date.toCharArray();
		if(Character.getType(dateChar[0]) != 9 || Character.getType(dateChar[1]) != 9
				|| Character.getType(dateChar[3]) != 9 || Character.getType(dateChar[4]) != 9
				|| Character.getType(dateChar[6]) != 9 || Character.getType(dateChar[7]) != 9
				|| Character.getType(dateChar[8]) != 9 || Character.getType(dateChar[9]) != 9) {
			return false;
			
		}
		if(dateChar[2] != '-' && dateChar[5] != '-') {
			return false;
		}
		String[] stringTime = date.split("-", 3);
		if(Integer.parseInt(stringTime[0]) > 12) {
			return false;
		}
		if(Integer.parseInt(stringTime[1]) > 31) {
			return false;
		}
		return true;
		
	}
	
	//check valid time
	public boolean validTime(String time) {
		if(time.length() != 8) {
			return false;
		}
		char[] timeChar = time.toCharArray();
		if((Character.getType(timeChar[0])!= 9) || (Character.getType(timeChar[1]) != 9)
				|| (Character.getType(timeChar[3])!= 9) || (Character.getType(timeChar[4]) != 9)
				|| (Character.getType(timeChar[6])!= 9) || (Character.getType(timeChar[7]) != 9)) { //9 indicates timeChar[i] is an int
				return false;
			}
		if(timeChar[2] != ':' && timeChar[5] != ':') {
			return false;
		}
		String[] stringTime = time.split(":", 3);
		for(String str : stringTime) {
			if(Integer.parseInt(str) >= 60) {
				return false;
			}
		}
		return true;
		
		
	}
	
	//returns time string
	public String backTimeString(Integer time) {
		 return time/10000 + ":" + (time%10000)/100 + ":" + time%100;
		
		
	}
	
	//returns sorted hashmap of times for events with specific athlete
	public HashMap<String, Integer> sortedAthleteTimes(ArrayList<Athlete> allAths, String athName){
		HashMap<String, Integer> athTimes = new HashMap<>();
		
		for(int i=0; i<allAths.size(); i++) {
			if(allAths.get(i).getName().equals(athName)) {
				for(Event e : allAths.get(i).getEvents().values()) {
					athTimes.put(e.toString(), allAths.get(i).getEvents().get(e.toString()).getIntTime());
				}
				break;
			}
			
		}
		return this.sortByValue(athTimes);
	}
	
	
	
	
	
	//return sorted hashmap of times for athletes with specific event
	public HashMap<String, Integer> sortedEventTimes(ArrayList<Athlete> allAths, String targetEvent){
		
		//stores all athletes and times for specific event in hashmap
		HashMap<String, Integer> athleteTimes = new HashMap<>();
		
		for(int i=0; i<allAths.size(); i++) {
			for(Event event : allAths.get(i).getEvents().values()) {
				if(event.toString().equals(targetEvent)) {
					athleteTimes.put(allAths.get(i).getName(), event.getIntTime());
					break;
				}
			}
		}
		return this.sortByValue(athleteTimes);
		
		
	
		
	}
	
	public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
		//create list from elements of Hashmap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		
		//sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> o1, 
								Map.Entry<String, Integer> o2) {
				return (o1.getValue().compareTo(o2.getValue()));
			}
		});
		
		//put data from sorted list to new hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
	
	
	
	//merge sort algorithm
	public void mergeSort(ArrayList<Integer> collection, int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(collection, start, mid);
			mergeSort(collection, mid+1, end);
			merge(collection, start, mid, end);
		}
	}
	
	public void merge(ArrayList<Integer> arr, int start, int mid, int end) {
		ArrayList<Integer> temp = new ArrayList<>();
		
		int i=start, j=mid+1, k=0;
		
		while(i<=mid && j<=end) {
			if(arr.get(i) <= arr.get(j)) {
				temp.add(k, arr.get(i));;
				k++;
				i++;
			}
		}
		while(i<=mid) {
			temp.add(k, arr.get(i));
			k++;
			i++;
		}
		while(j<=end) {
			temp.add(k, arr.get(j));
			k++;
			j++;
		}
		for(i=start; i<=end; i++) {
			arr.set(i, temp.get(i-start));
		}
	}

}
