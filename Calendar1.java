public class Calendar1 {	
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;   
	static int nDaysInMonth = 31;
	
	public static void main(String args[]) {
	    int debugDaysCounter = 0; 
		int SundayFirstDay = 0;
	 	while (year < 2000) {
			if (dayOfWeek==1 && dayOfMonth==1) SundayFirstDay++;
			if (dayOfWeek==1) {
				System.out.println(dayOfMonth+"/"+month+"/"+year+" Sunday");
			} else System.out.println(dayOfMonth+"/"+month+"/"+year);
	 		advance();
	 		debugDaysCounter++;
	 		// if (debugDaysCounter == 5000) break;
        }
		System.out.println("During the 20th century, "+SundayFirstDay+" Sundays fell on the first day of the month");
	 }
	
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
