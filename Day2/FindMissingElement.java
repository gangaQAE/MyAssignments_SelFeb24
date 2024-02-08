package assignments.Day2;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {

		int array[] = { 1, 4, 3, 2, 8, 6, 7 };

		// To find the element, we are sorting the elements
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			// System.out.println(array[i]);

			if (array[i + 1] != array[i] + 1) {
				System.out.println((array[i] + 1) + " is the missing element");
				break;
			}
		}
	}
}
