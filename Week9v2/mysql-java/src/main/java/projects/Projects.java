package projects;

import java.util.List;
import java.util.Objects;

import java.util.Scanner;

import projects.exception.DbException;
import projects.service.ProjectsService; 


public class Projects {

	private Scanner scanner = new Scanner(System.in); 
			private ProjectsService projectsService = new ProjectsService(); 
			
	private List<String> operations = List.of(
			"1) Add a project"			
			); 
	
	

	public static void main(String[] args) {
		
new Projects().displayMenu(); 

	}
	private void displayMenu() { 
		boolean done = false; 
		
		while(!done) { 
					
			try {
				int operation = getOperation(); 
				
				switch(operation) { 
			case -1:
			done = exitMenu(); 
			break; 
			
						
			case 1: 
				addProject(); 
				break; 
			
				default: 
				System.out.println("\n" + operation + " is not valid. Try again. "); 
			break; 	
			}
			}catch(Exception e) {
				System.out.println("\nError: " + e.toString() + " Try again."); 
				
			}
		}
	}
	
	private void addProject() {
	String name = getStringInput("Enter the project name"); 
	String notes = getStringInput("Enter project notes"); 
	Integer numProjects = getIntInput("Enter number of projects"); 
	Integer PrepMinutes = getIntInput("Enter dificulty");
		
	}
//	private void createTables() { 
//		projectsService.createAndPopulateTables(); 
//		System.out.println("\nTables create and populated!"); 
// }
	
	private boolean exitMenu() {
System.out.println("\nExiting the menu. TTFN!"); 
		return true;
	}
	private int getOperation() {
		printOperations();
		Integer line = getIntInput("Enter an operation number (press Enter to quit)");
		
		return Objects.isNull(line) ? -1 : line; 
	}
	private void printOperations() {
		System.out.println(); 
		System.out.println("Here is what you can do:"); 
		
		operations.forEach(line -> System.out.println("    " + line)); 
		
	}
	
	private Integer getIntInput(String prompt) { 
		String input = getStringInput(prompt); 
		
		if(Objects.isNull(input)) { 
			return null; 
		} 
		try { 
			return Integer.valueOf(input); 
		}
		catch(NumberFormatException e) { 
			throw new DbException(input + " is not a valid number."); 
			
		}
	}

		private Double getDoubleInput(String prompt) { 
			String input = getStringInput(prompt); 
			
			if(Objects.isNull(input)) { 
				return null; 
			} 
			try { 
				return Double.valueOf(input); 
			}
			catch(NumberFormatException e) { 
				throw new DbException(input + " is not a valid number."); 
				
			}
	}
	
	private String getStringInput(String prompt) { 
		System.out.print(prompt +  ": "); 
		String line = scanner.nextLine(); 
		
		return line.isBlank() ? null : line.trim(); 
	}

}
