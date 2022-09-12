package projects.service;

import project.dao.ProjectDao;

//import java.net.URISyntaxException;

//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.LinkedList;
//import java.util.List;

import projects.entity.Project;
//import projects.exception.DbException;
//import projects.java; 
//import packages.java; 
//import java.sql.Connection; 


public class ProjectsService {
	
		private ProjectDao projectDao = new ProjectDao(); 
	
		public Project addProject(Project project) {
			return projectDao.insertProject(project);  
		}
	


	
// do we not need these this week? 
//	private static final String SCHEMA_FILE = "projects_schema.sql";
//	private static final String DATA_FILE = "project_data.sql";

 
//	public void createAndPopulateTables() {
//		loadFromFile(SCHEMA_FILE);
//		loadFromFile(DATA_FILE);

	//}

	/**
	 * @param fileName
	 */
//	private void loadFromFile(String fileName) {
//		String content = readFileContent(fileName);
	//	List<String> sqlStatements = convertContentToSqlStatements(content);

		// use sqlStatement.... to  print the list to test // 
	//	sqlStatements.forEach(line -> System.out.println(line));

	//	projectDao.executeBatch(sqlStatements);
	//}

//	private List<String> convertContentToSqlStatements(String content) {
//		content = removeComments(content);
//		content = replaceWhitespaceSequenceWithSingleSpace(content);

//		return extracLinesFromContent(content);

//	}

//	private List<String> extracLinesFromContent(String content) {
//		List<String> lines = new LinkedList<>();

//		while (!content.isEmpty()) {
	//		int semicolon = content.indexOf(";");

//			if (semicolon == -1) {
//				if (!content.isBlank()) {
//					lines.add(content);

//				}
//				content = "";
//			} else {
//				lines.add(content.substring(0, semicolon).trim());
//				content = content.substring(semicolon + 1);
//			}

//		}

//		return lines;

//	}

//	private String replaceWhitespaceSequenceWithSingleSpace(String content) {
//		return content.replaceAll("//s+", " ");
//	} // "//S+ white space

//	private String removeComments(String content) {
//		StringBuilder builder = new StringBuilder(content);
//		int commentPos = 0;
//		while ((commentPos = builder.indexOf("-- ", commentPos)) != -1) {
//			int eolPos = builder.indexOf("/n", commentPos + 1);

//			if (eolPos == -1) {
//				builder.replace(commentPos, builder.length(), "");
//			} else {
//				builder.replace(commentPos, eolPos + 1, "");
//			}
//		}

//		return builder.toString();
//	}

//	private String readFileContent(String fileName) {
//		try {
//			Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
//			return Files.readString(path);
//		} catch (Exception e) {
//			throw new DbException(e);

//		}
//	}
// take this out once you run and get the tables populate 
//	public static void main(String[] args) {
//		new ProjectsService().createAndPopulateTables();
	}




