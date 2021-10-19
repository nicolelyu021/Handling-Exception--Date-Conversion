# Handling Exception: Date Conversion Machine

Absolute Java Chp 9 Project 5

Write a program that converts dates from numerical month/day/year format to normal “month day, year” format (for example, 12/25/2000 corresponds to December 
25, 2000). 

You will define three exception classes, one called MonthException, 
another called DayException, and a third called YearException. 

If the user enters anything other than a legal month number (integers from 1 to 12), your program 
will throw and catch a MonthException and ask the user to reenter the month. 
Similarly, if the user enters anything other than a valid day number (integers from 1 to 
either 28, 29, 30, or 31, depending on the month and year), then your program will 
throw and catch a DayException and ask the user to reenter the day. If the user enters 
a year that is not in the range 1000 to 3000 (inclusive), then your program will throw 
and catch a YearException and ask the user to reenter the year. (There is nothing 
very special about the numbers 1000 and 3000 other than giving a good range of likely 
dates.) See Self-Test Exercise 19 in Chapter 4 for details on leap years.

Requirement from Prof: 
When an illegal day, month or year is entered, the program will keep reprompting until a valid value is entered. Once a valid date is entered, keep reprompting the user to enter a new date. Use an array instead of a switch statement 
to get the name of the month.
