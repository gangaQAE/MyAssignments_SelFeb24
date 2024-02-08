package assignments.Day2;

public class IsPrime {

	public static void main(String[] args) {

		int number = 71;
		boolean cond = false;

		for (int i = 2; i <= number - 1; i++) {

			if (number % i == 0) {
				cond = true;
				break;
			}
		}

		if (cond) {
			System.out.println(number + " is not a prime number");
		} else {
			System.out.println(number + " is a prime number");
		}
	}

}
