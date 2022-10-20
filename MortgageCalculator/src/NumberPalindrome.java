
public class NumberPalindrome {
	
	public static boolean isPalindrome(int number) {
		
		int reverse = 0;
		int origin = number;
		while(number != 0) {
			int lastDigit = number % 10;
			reverse = (reverse*10) + lastDigit;
			number /= 10;
		}
		return origin == reverse;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(121));
	}

}
