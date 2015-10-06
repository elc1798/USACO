import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class SeptaScheduling {

	public static HashMap<Integer, Integer> schedule;
	static {
		schedule = new HashMap<Integer, Integer>();
		schedule.put(69, 10);
		schedule.put(63, 7);
		schedule.put(60, 6);
		schedule.put(56, 4);
		schedule.put(52, 3);
		schedule.put(46, 2);
		schedule.put(34, 2);
		schedule.put(30, 3);
		schedule.put(15, 5);
		schedule.put(13, 6);
		schedule.put(11, 7);
		schedule.put(8, 8);
		schedule.put(5, 9);
		schedule.put(2, 10);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader ("SeptaSchedulingIN.txt"));
		
		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			System.out.println(returnTime(data[0], 
					Integer.parseInt(data[1]), Integer.parseInt(data[2])));
		}
		
		
		br.close ();
	
	}
	
	public static String returnTime(String leavingTime, int dest, int timeThere) {
		
		
		//Calculate time spent waiting for train
		
		int lTime = Integer.parseInt(leavingTime.substring(0, 2))*60 + 
					Integer.parseInt(leavingTime.substring(2, 4));
		int waitTime1 = 0;
		if ((lTime-10)%30 != 0)
			waitTime1 = 30-(lTime-10)%30;
		
		
		
		//Calculate time spent riding the train
		int travelTime = schedule.get(dest);
		
		//Calculate time after finishing the ride 
		int finalTime = lTime + waitTime1 + travelTime+timeThere;
		
		//Time until next train
		int waitTime2 = 0;
		if ((finalTime-(10 - schedule.get(dest)))%30 != 0)
			waitTime2 = 30-(finalTime-(10 -schedule.get(dest)))%30;
		
		//total travel time
		int totalTime = waitTime1 + travelTime + timeThere + waitTime2 + travelTime;
		
		//Convert to time to get back
		int Time = (totalTime + lTime)%(24*60);
		return formatTime(Time);
	}
	
	public static String formatTime(int Time) {
		String h = Integer.toString(Time/60);
		String m = Integer.toString(Time%60);
		
		while (h.length() < 2)
			h = "0" + h;
		
		while (m.length() < 2)
			m = "0" + m;
		
		
		return h+m;
	}

}
