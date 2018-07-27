/**
 * This course project is copyright of CyberTek ©CyberTek[2017]. All rights reserved. 
 * Any redistribution or reproduction of part or all of the contents in any form is 
 * prohibited without the express consent of CyberTek.
 */

package date;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

public class Date implements Comparable<Date> {

	private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	protected final int month;
	protected final int day;
	protected final int year;

	/*
	 * Initialized a new date from the month, day and year.
	 * 
	 * @param month the month (between 1 and 12)
	 * 
	 * @param day the day (between 1 and 28-31, depending on the month)
	 * 
	 * @param year the year
	 * 
	 */

	public Date(int month, int day, int year) {
		if (!isValid(month, day, year)) {
			System.out.println("Invalid Date");
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/*
	 * @return month of that month
	 */
	public int getMonth() {
		return this.month;
	}

	/*
	 * @return day of that day
	 */
	public int getDay() {
		return this.day;
	}

	/*
	 * @return year of that year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * This method checks if a given date is a valid calendar date
	 * 
	 * @param m
	 *            month
	 * @param d
	 *            day
	 * @param y
	 *            year. (A year is no less than 1900, and no greater than 2100)
	 * @return true if the given date is a valid calendar date. false otherwise
	 */
	public static boolean isValid(int m, int d, int y) {
		boolean result = false;
		// month from 1 to 12
		// year from 1900 to 2100
		// depends on a month DAYS
		if (1 <= m && m <= 12 && 1 <= d && d <= 31 && 1900 < y && y < 2100) {
			result = true;
		}

		return result;
	}

	/**
	 * @param year
	 * @return true if the given year is a leap year. false otherwise.
	 */
	public static boolean isLeapYear(int year) {
		boolean result = false;
		if (year % 4 == 0) {
			result = true;
		}
		return result;
	}

	/**
	 * return -1 or 1 Compare this date to that day.
	 * 
	 * @return {a negative integer or zero or a positive integer}, depending on
	 *         whether this date is {before, equal to, after} that date
	 */

	public int compareTo(Date that) {
		int result = 0;
		if (this.year > that.year) {
			result = 1;
		} else if (this.year < that.year) {
			result = -1;
		} else if (this.year == that.year && this.month > that.month) {
			result = 1;
		} else if (this.year == that.year && this.month < that.month) {
			result = -1;
		} else if (this.year == that.year && this.month == that.month && this.day > that.day) {
			result = 1;
		} else if (this.year == that.year && this.month == that.month && this.day < that.day) {
			result = -1;
		}

		return result;
	}

	/**
	 * Return a string representation of this date.
	 * 
	 * @return the string representation in the format MM/DD/YYYY
	 */
	public String toString() {
		String result = "";
		result = this.month + "/" + this.day + "/" + this.year;

		return result;
	}

	/**
	 * 
	 * @return the word representation of the date. Example: (new
	 *         Date(12,1,2017)).dateToWords() returns "December One Two Thousand
	 *         Seventeen"
	 */
	public String dateToWords() {
		String[] monthWords = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] numbersLessThanTen = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		String[] numbersBetweenTenAndTwenty = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen" };
		String[] multiplesOfTen = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
				"Ninety" };
		String[] yearWords = { "Hundred", "Thousand" };
		String result = "";

		result += monthWords[this.month - 1] + " ";
		if (this.day < 11) {
			result += numbersLessThanTen[this.day] + " ";
		} else if (this.day > 10 && this.day < 20) {
			result += numbersBetweenTenAndTwenty[this.day - 1] + " ";
		} else if (this.day > 19 && this.day < 30) {
			result += multiplesOfTen[1] + " " + numbersLessThanTen[this.day % 10 - 1] + " ";
		} else if (this.day > 19 && this.day < 30) {
			result += multiplesOfTen[2] + " " + numbersLessThanTen[this.day % 10 - 1] + " ";
		}

		if (this.year < 2000) {
			int yil = this.year;
			String yeni = yil + "";
			result += numbersLessThanTen[0] + " " + yearWords[1] + " " + numbersLessThanTen[8] + " "+yearWords[0]+" "
					+ numbersLessThanTen[yeni.charAt(2) - 1] + " " + numbersLessThanTen[yeni.charAt(3) - 1] + " ";
		} else if (this.year > 1999) {
			int yil = this.year;
			String yeni = yil + "";
			result += numbersLessThanTen[1] + " " + yearWords[1] + " " +  numbersLessThanTen[yeni.charAt(2) - 1] + " " + numbersLessThanTen[yeni.charAt(3) - 1] + " ";
		}
		result.trim();
		
		return result;
	}

	public int age() {
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int m = cal.get(Calendar.MONTH); // starts from 0 to 11
		int y = cal.get(Calendar.YEAR);

		int age = 0;
		// TO DO

		return age;
	}

}
