package work_shift_validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Workshift {
	private Date date = null;
	private Date startTime = null;
	private Date endTime = null;
	private float shiftDuration;
	
	Scanner sc = new Scanner(System.in);
	
	public Workshift() {
		
	}
	
	SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
	SimpleDateFormat formatTime = new SimpleDateFormat("HH.mm");
	
	public boolean setDate() {
		System.out.println("Give date in a dd.MM.yyyy format");
		System.out.print("Working date: ");
		
		String tempDay = sc.nextLine();
		
		if (tempDay == null) {
			return false;
		}
		
		formatDate.setLenient(false);
		
		//Checking if the date is valid or not
		
		try {
			date = formatDate.parse(tempDay);
			//System.out.println("OK Date");
			setTime();
		} catch (ParseException e) {
			System.out.println("Invalid date.");
			return false;
		}
		
		if (shiftDuration != 0) {
			String duration = String.format("%.2f", shiftDuration);
			System.out.println("The given working date is " + tempDay + " and the duration " +
					"of the shift is " + duration + " hours.");
		}
		
		return true;
	}
	
	private boolean setTime() {
		System.out.println("Give shifts starting time in a HH.mm format");
		System.out.print("Starting time: ");
		String tempStartTime = sc.nextLine();
		
		System.out.println("Give shifts ending time in a HH.mm format");
		System.out.print("Ending time: ");
		String tempEndTime = sc.nextLine();
		
		if (tempStartTime == null || tempEndTime == null) {
			return false;
		}
		
		formatTime.setLenient(false);
		
		//Checking time validness
		
		try {
			startTime = formatTime.parse(tempStartTime);
			//System.out.println("OK start time");
			endTime = formatTime.parse(tempEndTime);
			//System.out.println("OK end time");
			if(startTime.after(endTime)) {
				System.out.println("Starting time can't before ending time.");
			} else {
				shiftDuration = workDuration(startTime, endTime);
			}
		} catch (ParseException e) {
			System.out.println("Invalid time.");
			return false;
		}
		return true;
	}
	
	private float workDuration(Date start, Date end) {	
		long difference = end.getTime() - start.getTime();
		
		long hours = difference / (60 * 60 * 1000) % 24;
		long tempMinutes = difference / (60 * 1000) % 60;
		float minutes = tempMinutes;
		minutes = minutes / 60;
		
		float duration = hours + minutes;
		
		if (duration > 16) {
			System.out.println("The maximum length of the workshift has been exceeded by " + (duration - 16) + " hours.");
		} else {
			return duration;
		}
		
		return 0;
		
	}
	
}
