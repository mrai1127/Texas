import java.text.NumberFormat;
import java.util.Scanner;

public class First {
	
	static final byte months_in_year = 12;
    static final byte percentage = 100;

	public static void main(String[] args) {

		int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
		float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
		byte years = (byte) readNumber("Peroid (years):", 1, 30);

		double mortgage = calculateMortgage(principal, annualInterest, years); 

		printMortgage(mortgage);

		printPaymentSchedula(principal, annualInterest, years);
	}

	public static void printMortgage(double mortgage) {
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println();
		System.out.println("MORTGAGE");
		System.out.println("--------");
		System.out.println("Mortgage:" + mortgageFormatted);
	}

	public static void printPaymentSchedula(int principal, float annualInterest, byte years) {
		System.out.println();
		System.out.println("PAYMENT SCHEDULE");
		System.out.println("----------------");
		
		for(short month = 1; month <= years *months_in_year; month++) {
			double balance = calculateBalance(principal, annualInterest, years, month);
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
		}
	}

	public static double readNumber(String prompt, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while (true) {
			System.out.println(prompt);
			value = scanner.nextFloat();
			if (value >= min && value <= max) 
				break;
				System.out.println("Enter a value between " + min + " and " + max);
			}
			return value;
		}
	

	public static double calculateMortgage(
			int principal,
			float annualInterest, 
			byte years) {


		float monthlyInterest = annualInterest / percentage / months_in_year;
		short numberOfPayments = (short) (years * months_in_year);
		
		double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

		return mortgage;

	}
	
	public static double calculateBalance(
			int principal, 
			float annualInterest,
			byte years,
			short numberOfPaymentsMade
			) {
		

		float monthlyInterest = annualInterest / percentage / months_in_year;
		short numberOfPayments = (short) (years * months_in_year);
		
		double balance = principal *(Math.pow(1+ monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
				/(Math.pow(1+ monthlyInterest, numberOfPayments) - 1);
		
		return balance;
	}
}
