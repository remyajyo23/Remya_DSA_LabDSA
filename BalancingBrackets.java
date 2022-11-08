import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	public static boolean checkBraces(String str) {

		Stack<Character> s1 = new Stack<Character>();
		boolean result = true;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == '{') || (str.charAt(i) == '(') || (str.charAt(i) == '[') || (str.charAt(i) == '<')) {
				s1.push(str.charAt(i));
				continue;
			} else if((str.charAt(i) == '}') || (str.charAt(i) == ')') || (str.charAt(i) == ']') || (str.charAt(i) == '>')) {
				if (str.charAt(i) == ')') {
					char c = (char) (!s1.isEmpty()?s1.pop():' ');
					if ('(' != c) {
						result = false;
						break;
					}
				} else if (str.charAt(i) == '}') {
					char c = (char) (!s1.isEmpty()?s1.pop():' ');
					if ('{' != c) {
						result = false;
						break;
					}
				} else if (str.charAt(i) == ']') {
					char c = (char) (!s1.isEmpty()?s1.pop():' ');
					if ('[' != c) {
						result = false;
						break;
					}
				} else if (str.charAt(i) == '>') {
					char c = (char) (!s1.isEmpty()?s1.pop():' ');
					if ('<' != c) {
						result = false;
						break;
					}
				}
			}
		}

		if (s1.isEmpty()) {
			if (result) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String str = sc.nextLine();

		boolean result = checkBraces(str);

		if (result) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

}
