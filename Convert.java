//CS 280 Assignment 3
//Creator: Nicole Lyu

import java.util.Scanner;

public class Convert {

	// check max day in a month during a specific month
	public static int maxDaysInMonth(int month) {
		if (month == 2)
			return 28;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		else
			return 31;
	}

	public static void main(String[] args) throws MonthException, DayException, YearException {

		Scanner kb = new Scanner(System.in);

		int theMonth = 0;
		int theDay = 0;
		int theYear = 0;

		String monthName = null;

		while(true) {
		
			System.out.println("Enter a numerical date in mm/dd/yyyy: ");

			while (true) {
	
				String enterDate = kb.nextLine();
				// read date as three separate strings
				int position_of_day = enterDate.indexOf("/");
				int position_of_year = enterDate.indexOf("/", position_of_day + 1);
	
				String enterMonth = enterDate.substring(0, position_of_day);
				String enterDay = enterDate.substring(position_of_day + 1, position_of_year);
				String enterYear = enterDate.substring(position_of_year + 1);
	
				// change string to integer
				theMonth = Integer.valueOf(enterMonth);
				theDay = Integer.valueOf(enterDay);
				theYear = Integer.valueOf(enterYear);
	
				// check month
				try {
					if (theMonth <= 0 || theMonth > 12)
						throw new MonthException();
				} catch (MonthException e) {
					System.out.println("Please enter a correct month!");
					kb.hasNextLine();
					continue;
				}
	
				// check day
				try {
					//check if it is a leap year first
					if (((theYear % 4 == 0) && (theYear % 100 != 0) || (theYear % 400 == 0))){
						if (theMonth != 2 && (theDay > maxDaysInMonth(theMonth)))
							throw new DayException();
						//February has 29 days during a leap year
						if (theMonth == 2 && (theDay > 29))
							throw new DayException();
					}
					else
					{
						if(theDay > maxDaysInMonth(theMonth))
							throw new DayException();
					}
						
				} catch (DayException e) {
					System.out.println("Please enter a correct day!");
					kb.hasNextLine();
					continue;
				}
	
				// check year
				try {
					if (theYear < 1000 || theYear > 3000)
						throw new YearException();
				} catch (YearException e) {
					System.out.println("Please enter a correct year!");
					kb.hasNextLine();
					continue;
				}
	
				// Convert numerical month to a string
				String[] monthsArray = { "January", "Februrary", "March", "April", "May", "June", "July", "August",
						"September", "October", "Octomber", "December" };
				for (int i = 1; i <= 12; i++) {
					if (i == theMonth)
						monthName = monthsArray[i - 1];
				}
				break;
			}

		System.out.println(monthName + " " + theDay + ", " + theYear);

		boolean isLeapYear = ((theYear % 4 == 0) && (theYear % 100 != 0) || (theYear % 400 == 0));

		if (isLeapYear) {
			System.out.println(theYear + " is a leap year.");
		} else
			System.out.println(theYear + " is not a leap year.");
		continue;
		
		}
		
	}
	
}
