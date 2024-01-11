public class Calendar1 {	
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
		int SundayFirstDay = 0;
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition
	 	while (year < 2000) {
			if (dayOfWeek==1 && dayOfMonth==1) SundayFirstDay++;
			if (dayOfWeek==1) {
				System.out.println(dayOfMonth+"/"+month+"/"+year+" Sunday");
			} else System.out.println(dayOfMonth+"/"+month+"/"+year);
	 		advance();
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		debugDaysCounter++;
	 		if (debugDaysCounter == 5000) break;
        }
		System.out.println("During the 20th century, "+SundayFirstDay+" Sundays fell on the first day of the month");
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		dayOfMonth++;
		dayOfWeek++;
		if (dayOfWeek > 7) dayOfWeek = 1;
		nDaysInMonth = nDaysInMonth(month, year);
		if (dayOfMonth > nDaysInMonth) {
			dayOfMonth = 1;
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}
	}
		 
	public static boolean isLeapYear(int year) {
		return ((year%400==0) || ((year%4==0) && (year%100!=0)));
	}
	 
	public static int nDaysInMonth(int month, int year) {
		switch(month) {
			case 2: if (isLeapYear(year)) return 29; else return 28;
			case 4: return 30;
			case 6: return 30;
			case 9: return 30;
			case 11: return 30;
			default: return 31;
		} 
	}
}
