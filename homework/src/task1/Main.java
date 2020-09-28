/*
 * LOGOS IT Academy. First Java Core Console Application.
 */

package task1;

import java.util.Scanner;

/**
 * @author Andrii Koval
 * @since Java 1.8
 * @version 1.1 21 Sep 2020
 */

public class Main {

	/* displays the application menu on the console */
	static void menu() {
		System.out.println();
		System.out.println("Enter 0 to check if the entered month exists");
		System.out.println("Enter 1 to display all months with the same season");
		System.out.println("Enter 2 to display all months with the same number of days");
		System.out.println("Enter 3 to display all months with fewer days");
		System.out.println("Enter 4 to display all months with more days");
		System.out.println("Enter 5 to display the next season of the year");
		System.out.println("Enter 6 to display the previous season");
		System.out.println("Enter 7 to display all months with an even number of days");
		System.out.println("Enter 8 to display all months with an odd number of days");
		System.out.println("Enter 9 to check if the number of days in the entered month is even");
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {

		Scanner scanner = new Scanner(System.in);
		Months[] arrayMonths = Months.values();
		Seasons[] arraySeasons = Seasons.values();

		/* creates an infinite loop that calls the menu method */
		while (true) {
			menu();

			/* takes the values from the scanner and runs the corresponding case */
			switch (scanner.nextInt()) {

			case 0: {
				System.out.println("Program for checking the existence of the entered month");
				System.out.println("Enter the month:");
				String month1 = scanner.next();

				boolean flag = isMonthExists(arrayMonths, month1);

				if (flag == true) {
					System.out.println("The entered month exists!");
				} else {
					String message = "There is no such month!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			case 1: {
				System.out.println("The withdrawal program for all months with the introduced season");
				System.out.println("Enter the season:");
				String season2 = scanner.next();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getSeason().name().equalsIgnoreCase(season2)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Time of the year " + season2 + " in the following months:");

					for (Months months2 : arrayMonths) {
						if (months2.getSeason().toString().equalsIgnoreCase(season2)) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "There are no such months!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			case 2: {
				System.out.println("Output program for all months with the entered number of days");
				System.out.println("Enter the number of days:");
				int numberOfDays3 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() == numberOfDays3) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Amount of days " + numberOfDays3 + " in the following months:");

					for (Months months2 : arrayMonths) {
						if (months2.getNumberOfDays() == numberOfDays3) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "There are no such months!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			case 3: {
				System.out.println("Output program for all months with fewer days than entered");
				System.out.println("Enter the number of days:");
				int numberOfDays4 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() == numberOfDays4 && numberOfDays4 >= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Number of days less " + numberOfDays4 + " in the following months:");

					for (Months months2 : arrayMonths) {
						if (months2.getNumberOfDays() < numberOfDays4) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "There are no such months!";
					throw new WrongInputConsoleParametersException(message);
				}
				break;
			}

			case 4: {
				System.out.println("Output program for all months with more days than entered");
				System.out.println("Enter the number of days:");
				int numberOfDays5 = scanner.nextInt();

				boolean flag = false;

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() == numberOfDays5 && numberOfDays5 <= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Number of days more " + numberOfDays5 + " in the following months:");

					for (Months months2 : arrayMonths) {
						if (months2.getNumberOfDays() > numberOfDays5) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					String message = "There are no such months!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			case 5: {
				System.out.println("Output program for the next season");
				System.out.println("Enter the season:");
				String season6 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arraySeasons) {
					if (seasons.name().equalsIgnoreCase(season6)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Next season:");

					Seasons seasons2 = Seasons.valueOf(firstUpperCase(season6.toLowerCase()));
					int i = seasons2.ordinal();

					if (i == (arraySeasons.length - 1)) {
						i = 0;
						System.out.println(arraySeasons[i]);
					} else {
						System.out.println(arraySeasons[i + 1]);
					}
				}

				if (flag == false) {
					String message = "There is no such time of the year!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			case 6: {
				System.out.println("The withdrawal program of the previous season");
				System.out.println("Enter the season:");
				String season7 = scanner.next();

				boolean flag = false;

				for (Seasons seasons : arraySeasons) {
					if (seasons.name().equalsIgnoreCase(season7)) {
						flag = true;
					}
				}

				if (flag == true) {
					System.out.println("Previous season:");

					Seasons seasons2 = Seasons.valueOf(firstUpperCase(season7.toLowerCase()));
					int i = seasons2.ordinal();

					if (i == 0) {
						i = (arraySeasons.length - 1);
						System.out.println(arraySeasons[i]);
					} else {
						System.out.println(arraySeasons[i - 1]);
					}
				}

				if (flag == false) {
					String message = "There is no such time of the year!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			case 7: {
				System.out.println("Program for withdrawing months with an even number of days");

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() % 2 == 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 8: {
				System.out.println("Program for withdrawing months with an odd number of days");

				for (Months months : arrayMonths) {
					if (months.getNumberOfDays() % 2 != 0) {
						System.out.println(months);
					}
				}

				break;
			}

			case 9: {
				System.out.println("Parity program for the number of days in the entered month");
				System.out.println("Enter the month:");
				String month0 = scanner.next();

				boolean flag = isMonthExists(arrayMonths, month0);

				if (flag == true) {
					Months month = Months.valueOf(firstUpperCase(month0.toLowerCase()));

					if (month.getNumberOfDays() % 2 == 0) {
						System.out.println("Number of days in a month " + month0 + " - " + month.getNumberOfDays()
								+ ". This number is even");
					} else {
						System.out.println("Number of days in a month " + month0 + " - " + month.getNumberOfDays()
								+ ". This number is odd");
					}
				}

				if (flag == false) {
					String message = "There is no such month!";
					throw new WrongInputConsoleParametersException(message);
				}

				break;
			}

			default: {
				System.out.println("Please enter a number between 0 and 9!");

				break;
			}

			}
		}
	}

	/**
	 * Checks if the month exists in array and returns a boolean expression
	 * 
	 * @param arrayMonths, month
	 * 
	 * @return boolean expression
	 * 
	 */
	static boolean isMonthExists(Months[] arrayMonths, String month) {
		boolean flag = false;

		for (Months months : arrayMonths) {
			if (months.name().equalsIgnoreCase(month)) {
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * Converts the first character of a string to upper case
	 * 
	 * @param string
	 * 
	 * @return String (with first letter in UpperCase)
	 * 
	 */
	static String firstUpperCase(String string) {
		if (string == null || string.isEmpty()) {
			return string;
		} else {
			return string.substring(0, 1).toUpperCase() + string.substring(1);
		}
	}

}