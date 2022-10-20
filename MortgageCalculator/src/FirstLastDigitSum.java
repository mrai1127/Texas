
public class FirstLastDigitSum {
	
	public static int sumFirstAndLastDigit(int number) {
		if(number<0) {
			return -1;
		}else {
			return Integer.parseInt(Integer.toString(number).substring(0, 1))+
					number%10;
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("The sum of first and last number is " +(sumFirstAndLastDigit(2345)));
	}

}

