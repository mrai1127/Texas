package com.rai;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Total points / total credit
		Scanner scanner = new Scanner(System.in);

		Integer totalPoints = 0;
		Integer totalCredits = 0;

		boolean moreClasses = false;

		do {

			boolean validCredits = true;
			Integer credits = 0;
			do {
				validCredits = true;
				System.out.println("Enter number of credits:");
				String creditString = scanner.nextLine();

				try {
					credits = Integer.parseInt(creditString);

				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid integer:");
					validCredits = false;
				}
			} while (!validCredits);

			boolean validGrade = true;
			Integer gradeValue = 0;
			String grade = " ";

			do {
				System.out.println("Enter number of grade:");
				grade = scanner.nextLine();

				if (grade.equalsIgnoreCase("A")) {
					gradeValue = 4;
				} else if (grade.equalsIgnoreCase("B")) {
					gradeValue = 3;
				} else if (grade.equalsIgnoreCase("C")) {
					gradeValue = 2;
				} else if (grade.equalsIgnoreCase("D")) {
					gradeValue = 1;
				} else if (grade.equalsIgnoreCase("F")) {
					gradeValue = 0;
				} else {
					System.out.println("You did not enter a valid grade:");
					validGrade = false;
				}
			} while (!validGrade);

			Integer points = gradeValue * credits;
			totalPoints = totalPoints + points;
			totalCredits = totalCredits + credits;

			System.out.println("Would you like to enter another class? (y/n)");
			String moreClassesString = scanner.nextLine();

			moreClasses = moreClassesString.equalsIgnoreCase("Y");
		} while (moreClasses);

		Double gpa = Double.valueOf(totalPoints) / Double.valueOf(totalCredits);

		System.out.println("Credits :" + totalCredits);
		System.out.println("Points :" + totalPoints);
		System.out.println("GPA :" + gpa);

		scanner.close();
	}

}
