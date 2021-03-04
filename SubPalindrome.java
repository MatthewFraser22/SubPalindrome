package cp213;
import java.util.Scanner;

public class SubPalindrome {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String SubPal = "";
		String s;
		int minLen = 2;
		
		System.out.println("Enter a string of size 1-10 characters: ");
		s = keyboard.nextLine();
		
		if (s.length() < 1) {
			System.out.println("'"+s+"' is not a valid input, size less than 1");
		} else if (s.length()> 10){
			System.out.println("'"+s+"' is not a valid input, size more than 10");
		} else {
		
			SubPalindrome.testSubPalindromes(s, minLen);
			SubPalindrome.isPalindrome(s);
			keyboard.close();
			
		}
		
	}
	
	public static void testSubPalindromes(final String s, int minLen) {
		String Sub = "";
		String finalstring = "";
		boolean palindrome = false;
		boolean isSub = false;

		for (int i =0; i < s.length(); i++) {
			Sub = "";
			if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
				Sub = Sub+Character.toString(s.charAt(i));
			}
			
			for (int j=i+1; j < s.length();j++) {
				if (Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j))) {
					Sub = Sub + Character.toString(s.charAt(j));
					if (Sub.length() >= minLen) {
					palindrome = SubPalindrome.isPalindrome(Sub);
					
					if (palindrome == true) {
						finalstring = finalstring+"'"+Sub+"'"+", ";
						isSub = true;
					}
					}
				}
				
			}
		}
		if (isSub == true) {
			finalstring = finalstring.substring(0,finalstring.length()-2);
		}
		
		if (isSub == true){
			System.out.println("Following substring(s) of the string '"+s+"' are palindromes: "+ finalstring);
		} else {
			System.out.println("No substrings of the string '" + s+ "' are palindrome.");
		}
		
		}
	
	
	public static boolean isPalindrome(final String s) {
		String newStr = "";
		String reverse = "";
		
		boolean palindrome = false;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				newStr = newStr + s.charAt(i);

			}
			}
		for (int i = newStr.length()-1; i>=0; i--) {
			reverse = reverse + newStr.charAt(i);
		}
		
		if (newStr.equalsIgnoreCase(reverse)) {
			palindrome = true;
		}else {
			palindrome = false;
		}

		return palindrome;
	}
}

