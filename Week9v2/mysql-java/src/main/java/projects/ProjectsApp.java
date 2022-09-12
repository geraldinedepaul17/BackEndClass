package projects;

import java.nio.file.Files;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import project.dao.ProjectDao;
import projects.entity.Project; 
import projects.exception.DbException; 
import projects.service.ProjectsService;

public class ProjectsApp {

//	private static final String SCHEMA_FILE = "project_schema.sql";

//	private ProjectsDao projectDao = new ProjectsDao();

//	private void createAndPopulateTables() {
//		loadFormFile(SCHEMA_FILE);
//	}
//	private void processUserSelections() {
//		loadFormFile(SCHEMA_FILE); 
		
		
//	}

//	private void loadFormFile(String fileName) {
//		String content = readFileContent(fileName);
//		List<String> sqlStatements = convertContentToSqlStatements(content);

//		sqlStatements.forEach(line -> System.out.println(line)); 
		
//		
//		projectDao.executeBatch(sqlStatements);
//	}

//	private List<String> convertContentToSqlStatements(String content) {
//		content = removeComments(content);
//		content = replaceWhitespaceSequenceWithSingleSpace(content);

//		return extractLinesFromContent(content);
//	}

//	private List<String> extractLinesFromContent(String content) {
//		List<String> lines = new LinkedList<>();
//		
//		while(!content.isEmpty()) {
//			int semicolon = content.indexOf(";"); 
			
//			if(semicolon == -1) { 
//				if(!content.isBlank()) {
//					lines.add(content); 
//				}
				
//				content = ""; 
//			}
//			else {
//				lines.add(content.substring(0, semicolon).trim());
//				content = content.substring(semicolon +1); 
//			}
//		}
		
//	}

//	private String replaceWhitespaceSequenceWithSingleSpace(String content) {
//		return content.replaceAll("\\s+", " ");
//	}

//	private String removeComments(String content) {
//		StringBuilder builder = new StringBuilder(content);
	//	int commentPos = 0;

		
//		while((commentPos = builder.indexOf("-- ", commentPos)) != -1) {
//			int eolPos = builder.indexOf("/n", commentPos +1); 
			
//			if(eolPos == -1) {
//				builder.replace(commentPos,  builder.length(), ""); 
//			}
//			else {
//				builder.replace(commentPos, eolPos, ""); // look at the video to see why +1 was in here?
//			}
	//	}
//		return builder.toString();

//	}

//	private String readFileContent(String fileName) {
// didn't get a throw catch error on path line
// try {
//		Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
//		return Files.readString(path);
 //} catch (Exception e) {
//		 throw new DbException(e); }
 //}
		 

//	public static void main(String[] args) {
//		new ProjectsApp().createAndPopulateTables(); 
		
//			new ProjectsApp().processUserSelections(); 
//		}

		
//	}
// my other file: 

	private Scanner scanner = new Scanner(System.in) ;
			private ProjectsService projectsService = new ProjectsService(); 
	
	// @formatter:0ff
	private List<String> operations = List.of(
			"1) Add a project"
			); 
	//@formatter:on
	

	public static void main(String[] args) {
		
new ProjectsApp().processUserSelections();  // is this the same as processUserSelections - displayMenu

	}
	void processUserSelections() { 
		boolean done = false; 
		
		while(!done) { 
					
			try {
				int selection = getUserSelection(); 
				
				switch(selection) {
				
			case -1:
			done = exitMenu(); 
			break; 
			
			
			case 1: 
				createProject(); 
				break;
				
				
				default:
				System.out.println("\n" + selection + " is not valid. Try again. "); 
			break; 	
			}
			}catch(Exception e) {
				System.out.println("\nError: " + e.toString() + " Try again."); 
				
			}
		}
	}
	
	private void createProject() {
		String projectName = getStringInput("Enter the project name: "); 
		BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours: "); //change go java math? or add parameter to prjoects app
		BigDecimal actualHours = getDecimalInput("Enter the actual hours: "); 
		Integer difficulty = getIntInput("Enter the project difficulty (1-5): "); 
		String notes = getStringInput("Enter the project notes: "); 
		
		Project project = new Project(); 
		
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours); 
		project.setActualHours(actualHours); 
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		Project dbProject = projectsService.addProject(project); 
		System.out.println("You have successfully created project: " + dbProject);
	}
	private BigDecimal getDecimalInput(String prompt) {
	String input = getStringInput(prompt); 
		
		if(Objects.isNull(input)) { 
			return null; 
		} 
		try { 
			return new BigDecimal(input).setScale(2); 
		}
		catch(NumberFormatException e) { 
			throw new DbException(input + " is not a valid decimal number."); 
		}
		
	}

		// 4b I had to add lines 83 & 84 to get rid of the BigDecimal underline in line 74: 
		
	//private BigDecimal BigDecimal(String input) {
			//	return null;
		
		// end here
	//}
// video notes: 
	
//private void createTables() { 
//		projectsService.createAndPopulateTables(); 
//		System.out.println("\nTables create and populated!"); 
//	}
	// end video notes. 
	
	
	private boolean exitMenu() {
System.out.println("\nExiting the menu."); 
		return true;
	}
	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter an menu selection (press Enter to quit)");
		
		return Objects.isNull(input) ? -1 : input; 
	}
	private void printOperations() {
		//System.out.println(); 
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
// this part is not on homework: 
		private Double getDoubleInput(String prompt) { 
			String input = getStringInput(prompt); 
			
			if(Objects.isNull(input)) { 
				return null; 
			} 
			try { 
				return Double.parseDouble(input); 
			}
			catch(NumberFormatException e) { 
				throw new DbException(input + " is not a valid number."); 
				
			}
			// end of the video notes. 
	}
	
	private String getStringInput(String prompt) { 
		System.out.print(prompt +  ": "); 
		String input = scanner.nextLine(); 
		
		return input.isBlank() ? null : input.trim(); 
	}
}


