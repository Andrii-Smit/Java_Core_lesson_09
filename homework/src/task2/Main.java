package task2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws MyException {

		Scanner scanner = new Scanner(System.in);

		int a;
		int b;

		System.out.println("Enter the first integer:");

		if (scanner.hasNextInt()) {
			a = scanner.nextInt();

			System.out.println("Enter the second integer:");

			if (scanner.hasNextInt()) {
				b = scanner.nextInt();

				Methods calc = new Methods(a, b);

				Methods.viewCalcResult(calc.plus());
				Methods.viewCalcResult(calc.minus());
				Methods.viewCalcResult(calc.multiply());
				Methods.viewCalcResult(calc.devide());
			}

			else
				System.out.println("Mistake! It was necessary to enter an INTEGER number");
		}

		else
			System.out.println("Mistake! It was necessary to enter an INTEGER number");

	}
}