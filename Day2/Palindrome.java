package assignments.Day2;

public class Palindrome {

	public static void main(String[] args) {

		int num = 12121;
		int rem, rev = 0;

// Using while loop
//while(temp!=0) {
//	rem = temp%10;
//	rev=(rev*10)+rem;
//}

		// Using for loop
		for (int temp = num; temp != 0; temp /= 10) {
			rem = temp % 10;
			rev = (rev * 10) + rem;
		}

		if (num == rev) {
			System.out.println(num + " is a palindrome number");
		} else {
			System.out.println(num + " is not a palindrome number");
		}
	}

}
