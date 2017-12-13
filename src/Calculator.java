import java.util.Scanner;

/**
 * A class that do different kinds of calculations.
 */

public class Calculator {
	/**
	 * Minimum valid factorial input.
	 */
	public static final int Gamma_MIN = 0;

	/**
	 * Maximum valid factorial input.
	 */
	public static final int Gamma_MAX = 20;

	/**
	 * Invalid factorial return value.
	 */
	public static final int Gamma_INVALID = -1;

	/**
	 * a subroutine that inplement gamma function.
	 * 
	 * @param input the input.
	 * @return result
	 */
	public static double Gamma(double input) {
		double f = 1;
		if (input > Gamma_MAX || input < Gamma_MIN) {
			return Gamma_INVALID;
		} else {
			for (double n = input; n > 1; n--) {
				f = f * n;
			}
		}
		return f;
	}

	public static double pSeries(double startNum, double p) {
		if (p <= 1) {
			return -1;
		} else {
			double result = 0;
			for (int i = (int) startNum; i < 100000000; i++) {
				result += Math.pow(i, p);
			}
			return result;
		}
	}

	public static void degree1(final double a, final double b) {

		double temp = -b / a;
		System.out.println(temp);

	}

	public static void degree2(final double a, final double b, final double c) {

		if (b * b - 4 * a * c < 0) {
			System.out.println("No Real Roots");
		}

		double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

		System.out.println("The roots are " + x1 + " and " + x2);

	}

	public static void degree3(final double a, final double b, final double c, final double d) {

		double A, B, C, delta;
		double x1, x2, x3;

		A = b * b - 3 * a * c;
		B = b * c - 9 * a * d;
		C = c * c - 3 * b * d;
		delta = B * B - 4 * A * C;

		if (A == 0 && B == 0) {
			x1 = x2 = x3 = -c / b;
		}

		if (delta > 0) {

			double y1 = A * b + 3 * a * (-B + Math.pow(B * B - 4 * A * C, 0.5)) * 0.5;
			double y2 = A * b + 3 * a * (-B - Math.pow(B * B - 4 * A * C, 0.5)) * 0.5;
			x1 = (-b - (Math.pow(y1, 1 / 3.0) + Math.pow(y2, 1 / 3.0))) / (3 * a);
			x2 = x3 = -999999999;

		} else if (delta == 0) {

			double K = B / A;
			x1 = -b / a + K;
			x2 = x3 = -K * 0.5;

		} else {

			double T = (2 * A * b - 3 * a * B) / (2 * Math.pow(A, 3 / 2.0));
			double temp = Math.acos(T);
			x1 = (-b - 2 * (2 * Math.pow(Math.cos(temp / 3.0), 0.5))) / (3 * a);
			x2 = (-b + Math.pow(A, 0.5) * Math.cos(temp / 3.0) + Math.pow(3, 0.5) * Math.sin(temp / 3.0)) / (3 * a);
			x3 = (-b + Math.pow(A, 0.5) * Math.cos(temp / 3.0) - Math.pow(3, 0.5) * Math.sin(temp / 3.0)) / (3 * a);

		}

		System.out.println("The roots are " + x1 + ", " + x2 + " and " + x3);

	}

	public static void simultaneous(final double a1, final double b1, final double c1, final double a2, final double b2,
			final double c2) {

		if (b1 * a2 - b2 * a1 != 0) {
			double y = (c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1);
			double x = (b1 * c2 - b2 * c1) / (b1 * a2 - b2 * a1);

			System.out.println("x = " + x + " , " + "y = " + y);

		} else if (b1 * a2 - b2 * a1 == 0 && c1 * a2 - c2 * a1 != 0) {

			System.out.println("DNE");

		} else if (b1 * a2 - b2 * a1 == 0 && c1 * a2 - c2 * a1 == 0) {

			System.out.println("Infinity Solutions");

		} else {
			System.out.println("Error");
		}

	}

	public static void main(String[] args) {
		System.out.println("What would you like to do with the calculator");
		System.out.println("Enter 1 if you want to deal with normal numerical calculations");
		System.out.println("Enter 2 if you want to solve equations");
		int code = TextIO.getlnInt();

		if (code == 1) {

			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Enter an expression of the form 3 * 5");
				double n1 = scanner.nextDouble();
				String operation = scanner.next();
				double n2 = scanner.nextDouble();

				switch (operation) {

				/**
				 * Input must be in the form of "n1 + n2", prints n1 plus n2.
				 */
				case "+":
					System.out.println("The result is " + (n1 + n2));
					break;

				/**
				 * Input must be in the form of "n1 - n2", prints n1 minus n2.
				 */
				case "-":
					System.out.println("The result is " + (n1 - n2));
					break;

				/**
				 * Input must be in the form of "n1 / n2", prints n1 divided by n2.
				 */
				case "/":
					System.out.println("The result is " + (n1 / n2));
					break;

				/**
				 * Input must be in the form of "n1 * n2", prints n1 times n2.
				 */
				case "*":
					System.out.println("The result is " + (n1 * n2));
					break;

				/**
				 * Input must be in the form of "n1 ^ n2", prints n1 to the power of n2.
				 */
				case "^":
					System.out.println("The result is " + (Math.pow(n1, n2)));
					break;

				/**
				 * Input must be in the form of "n1 log n2", prints logarithm to base n1 of n2.
				 */
				case "log":
					System.out.println("The result is " + ((Math.log(n2)) / (Math.log(n1))));
					break;

				/**
				 * Input must be in the form of "n1 C n2", prints the result of n1 choose n2.
				 * Note that n1 and n2 must be positive and smaller than 20.
				 */
				case "C":
					if (n1 < n2) {
						System.out.println("The result is 0");
						break;
					} else {
						double result = Gamma(n1) / (Gamma(n2) * Gamma(n1 - n2));
						System.out.println("The result is " + result);
						break;
					}

					/**
					 * Calculate the P-series starting from term n1 to infinity, with the P equals
					 * n2.
					 */
				case "pSeries":
					System.out.println("The result is " + pSeries(n1, n2));
					break;

				default:
					System.out.println("Try that again!");
					System.out.println("Essayez encore ca!");
					System.out.println("M¨­ichido yarinaosu!");
					System.out.println("Zai shi yi ci!");
				}
			}
		} else if (code == 2) {
			System.out.println("How many unknown variable does the equation have? (1 or 2)");
			int numOfUnknownVariable = TextIO.getlnInt();
			if (numOfUnknownVariable == 1) {
				System.out.println("Degrees? 1, 2 or 3");
				System.out.println("Please type in the degree.");
				int degree = TextIO.getlnInt();

				if (degree != 1 && degree != 2 && degree != 3) {

					for (int n = 1; degree != 1 && degree != 2 && degree != 3; n++) {

						System.out.println("Invalid Degree");
						System.out.println("Please try again");
						degree = TextIO.getlnInt();

						if (n > 3) {

							System.out.println(":(");
							return;

						}
					}
				}

				if (degree == 1) {

					System.out.println("ax + b = 0");
					System.out.println("Please type in a");
					double a = TextIO.getlnDouble();
					System.out.println("Please type in b");
					double b = TextIO.getlnDouble();

					degree1(a, b);

				} else if (degree == 2) {

					System.out.println("ax^2 + bx + c = 0");
					System.out.println("Please type in a");
					double a = TextIO.getlnDouble();
					System.out.println("Please type in b");
					double b = TextIO.getlnDouble();
					System.out.println("Please type in c");
					double c = TextIO.getlnDouble();

					degree2(a, b, c);

				} else {
					System.out.println("ax^3 + bx^2 + cx + d = 0");
					System.out.println("Please type in a");
					double a = TextIO.getlnDouble();
					System.out.println("Please type in b");
					double b = TextIO.getlnDouble();
					System.out.println("Please type in c");
					double c = TextIO.getlnDouble();
					System.out.println("Please type in d");
					double d = TextIO.getlnDouble();

					degree3(a, b, c, d);
				}
			} else if (numOfUnknownVariable == 2) {

				System.out.println("a1x + b1y = c1");
				System.out.println("a2x + b2y = c2");
				System.out.println("Please type in a1");
				double a1 = TextIO.getlnDouble();
				System.out.println("Please type in b1");
				double b1 = TextIO.getlnDouble();
				System.out.println("Please type in c1");
				double c1 = TextIO.getlnDouble();
				System.out.println("Please type in a2");
				double a2 = TextIO.getlnDouble();
				System.out.println("Please type in b2");
				double b2 = TextIO.getlnDouble();
				System.out.println("Please type in c2");
				double c2 = TextIO.getlnDouble();

				simultaneous(a1, b1, c1, a2, b2, c2);

			} else {

				for (int n = 1; numOfUnknownVariable != 1 && numOfUnknownVariable != 2; n++) {

					System.out.println("Invalid unknown variable number.");
					System.out.println("Please try again");
					numOfUnknownVariable = TextIO.getlnInt();

					if (n > 3) {

						System.out.println(":) MMP");
						return;

					}
				}
			}

		} else {
			System.out.println(
					"It's not a valid input, please enter a number either 1 or 2 depending on which function of the calculaor you want to use.");
		}
	}
}
