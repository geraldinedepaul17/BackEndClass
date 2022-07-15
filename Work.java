package week3Assignment;

import java.util.Arrays;

public class Work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(parrotString("hello", 3));
		System.out.println("Answer to question 7 above");
		System.out.println(getFullName("Gerri", "Ciancanelli"));
		System.out.println("Answer to question 8 above");
////////////////////////////////////////////////////////////////////////////		
// #1       Create an array of int called ages that contains the 
//      following values: 3, 9, 23, 64, 2, 8, 28, 93.
		int [] ages = { 3, 9 , 23, 64, 2, 8, 28, 93 }; 
////////////////////////////////////////////////////////////////////////////		
		double [] height = { 3, 9 , 23, 64, 2, 8, 28, 93 }; 
		double [] height2 = { 3, 9 , 23, 64, 55,42, 2};
		boolean hot = true;
		double temp = 99.9;
		System.out.println(trueAverage(height,height2));
		System.out.println("Answer to question 11 above"); 
		System.out.println(findAverage(height)); 
		System.out.println("Answer to question 10 above");
		
		System.out.println(hundredPlus(ages));
		System.out.println("Answer to question 9 above");
		System.out.println(willBuyDrink(hot, temp));
		System.out.println("Answer to question 12 above");
		int answer = 43;
		System.out.println(memberStatus(answer));
		System.out.println("Answer to question 13 above");
////////////////////////////////////////////////////////////////////////////	
		
// a. 	a.	Programmatically subtract the value of the first element 
//		in the array from the value in the last element of the array	
		
		System.out.println("Last age minus first age: " + (ages[ages.length-1] - ages[0]));
		System.out.println("Answer to question 1a above");
/////////////////////////////////////////////////////////////////////////////	
		
//b. 	Add a new age to your array and repeat the step above 
//		to ensure it is dynamic 	
//		
		int [] newAges = { 3, 9 , 23, 64, 2, 8, 28, 93, 43 }; 
		System.out.println("Last age minus first age: " + (newAges[newAges.length-1] - newAges[0]));	
		System.out.println("Answer to question 1b above");
////////////////////////////////////////////////////////////////////////////////		
		
//c. 	Use a loop to iterate through the array and calculate the average age. 
		int averageAge = 0; 
		for (int age : ages) { 
			averageAge += age; 
		}
		System.out.println(averageAge/ages.length);
		System.out.println("Answer to question 1c above");
////////////////////////////////////////////////////////////////////////////////		

//#2
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
	String concatNames = ""; 
	for (String name: names) {
		concatNames = concatNames + name + " ";

		
	}
	System.out.println(concatNames); 
	System.out.println("Answer to question 2 above");
///////////////////////////////////////////////////////////////////////////////
	
//#3 - Mentor helped and said to keep them in notes due to errors showing
	//System.out.println(element[element.length-1]);
//////////////////////////////////////////////////////////////////////////////
	
//#4 - Mentor helped and said to keep them in notes due to errors showing
	//System.out.println(element[0]); 
//////////////////////////////////////////////////////////////////////////////	
	
//#5
	int [] nameLengths = new int [6];
		for(int i = 0; i<names.length;i++) {
			nameLengths[i] = names[i].length();  
		}
		System.out.println(Arrays.toString(nameLengths));
		System.out.println("Answer to question 5 above");
/////////////////////////////////////////////////////////////////////////////
				
//#6   6.	Write a loop to iterate over the nameLengths array 
//		and calculate the sum of all the elements in the array. 
		
		int nameAverageLetters = 0; 
		for (int i = 0; i < nameLengths.length; i++) {
			nameAverageLetters = nameAverageLetters + nameLengths[i];
			}
		System.out.println(nameAverageLetters);
		System.out.println("Answer to question 6 above");
	}
////////////////////////////////////////////////////////////////////////////		
		
//#7
	
	
		public static String parrotString(String word, int r) {
			String answer = ""; 
			for (int i = 0; i < r; i++) { 
				answer += word; 
			}
		return answer; 
		}
////////////////////////////////////////////////////////////////////////////
		
	// #8 	Write a method that takes two Strings, firstName 
	//	and lastName, and returns a full name (the full name should be the first 
	//	and the last name as a String separated by a space).	
		
				
		public static String getFullName (String firstName, String lastName) {
			return firstName + " " + lastName;
		
		}
////////////////////////////////////////////////////////////////////////////////
		
//9.	Write a method that takes an array of int and returns true if the 
//		sum of all the ints in the array is greater than 100.	
	public static boolean hundredPlus(int[] test) {
		int answer = 0; 
		for (int i = 0; i < test.length; i++) {
			answer =  answer + test[i];
		}
		if (answer >100) {
		return true;
		} else { 
			return false;
		}
	}
//////////////////////////////////////////////////////////////////////////////////
	
//	10.	Write a method that takes an array of double and returns the 
//	average of all the elements in the array. 		
	public static double findAverage(double[] numbers) {
		return findSum(numbers)/numbers.length;
	}
	public static double findSum(double[] numArray) { 
	double sum = 0; 
	for (double num : numArray) { 
		sum += num; 
	}
		return sum;
	}
/////////////////////////////////////////////////////////////////////////////////
	
	//11.	Write a method that takes two arrays of double and returns 
//	true if the average of the elements in the first array is greater than 
//the average of the elements in the second array. 
	public static boolean trueAverage (double [] array1, double [] array2) {
		double sum = 0; 
		double sum2 = 0;
		double avg = 0;
		double avg2 = 0;
		for (double num : array1) {
			sum += num;
			avg = sum / array1.length;
		}
		for (double num : array2) { 
			sum2 +=num;
			avg = sum / array2.length; 
		}
		if (avg > avg2) {
			return true;
		}
		else {
			return false;
		}
	}
///////////////////////////////////////////////////////////////////////////////////	
	
//12.	Write a method called willBuyDrink that takes a boolean isHotOutside, 
//	and a double moneyInPocket, and returns true if it is hot outside and if 
//	moneyInPocket is greater than 10.50.
	public static boolean willBuyDrink (boolean isHotOutside, double moneyInPocket) {
		if (isHotOutside && moneyInPocket > 10.50) { 
			return true;
		}else {
			return false;
		}
		
	}
///////////////////////////////////////////////////////////////////////////////////	
	
	//13. 13.	Create a method of your own that solves a problem. In comments, 
	//write what the method does and why you created it.
	public static String memberStatus (int status1) {
		if (status1 > 50) {
			return "Gold Membership"; 
		}else {
			return "Silver Membership";
		}
	}
	
	
}
	
	


	
	
	

