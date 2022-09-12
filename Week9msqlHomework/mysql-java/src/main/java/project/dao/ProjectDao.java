package project.dao;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import projects.entity.Project; 
import projects.exception.DbException;
import provided.util.DaoBase;



@SuppressWarnings("unused")


public class ProjectDao  extends DaoBase{
	private static final String CATEGORY_TABLE = "category"; 
	private static final String MATERIAL_TABLE = "material";
	private static final String PROJECT_TABLE = "project";
	private static final String PROJECT_CATEGORY_TABLE = "project_category"; 
	private static final String STEP_TABLE = "step"; 
	

//	public ProjectsDao() {

		public Project insertProject(Project project) { 
			//@formatter:off  
			String sql = ""
					+ "INSERT INTO " + PROJECT_TABLE + " "
					+ "(project_name, estimated_hours, actual_hours, difficulty, notes)"
					+ " VALUES" 
					+ "(?, ?, ?, ?, ?)";
			//@formatter:on
			
		 
		
		// Dr Rob's version: 	
	
	//	public class ProjectsDao extends DaoBase { 
	//	public void executeBatch(List<String> sqlBatch) {
			
	/*		public Project insertProject(Project project) { 
				//@formatter:off 
				String sql = ""
						+ "INSERT INTO " + PROJECT_TABLE + " "
						+ "(project_name, estimated_hours, actual_hours, difficulty, notes)"
						+ " VALUES" 
						+ "(?, ?, ?. ?, ?)"; 
				//@formatter:on
				
				
			try(Connection conn = DbConnection.getConnection()) {
			startTransaction(conn); 
			
			try(PreparedStatement stmt = conn.prepareStatement(sql)) { 
				setParameter(stmt, 1, project.getProjectName(), String.class);
				setParameter(stmt, 2, project.getEstimatedHours(), BigDecimal.class); 
				setParameter(stmt, 3, project.getActualHours(), BigDecimal.class);
				setParameter(stmt, 4, project.getDifficulty(), Integer.class); 
				setParameter(stmt, 5, project.getNotes(), String.class);
								
			//	for(String sql : sqlBatch) {
			//		stmt.addBatch(sql);
			//	}
			
				stmt.executeBatch(); 
		
			
	// end of Dr Robs version		
			
			
	// Instructors version: 
			
	//	public void executeBatch(List<String> sqlStatements) {
		*/		
			try (Connection conn = DbConnection.getConnection()) { 
				startTransaction(conn); 
				
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					setParameter(stmt, 1, project.getProjectName(), String.class);
					setParameter(stmt, 2, project.getEstimatedHours(), BigDecimal.class); 
					setParameter(stmt, 3, project.getActualHours(), BigDecimal.class);
					setParameter(stmt, 4, project.getDifficulty(), Integer.class); 
					setParameter(stmt, 5, project.getNotes(), String.class);
				
					
			//		for(String sql : sqlBatch) {  *** don't think I need this anymore since 93 is same
			//			stmt.addBatch(sql);
						
			stmt.executeUpdate(); 
					
				Integer projectId = getLastInsertId(conn, PROJECT_TABLE); 
					commitTransaction(conn); 
					
					project.setProjectId(projectId); 
					return project; 
								}
			
			catch(Exception e) { 
				rollbackTransaction(conn); 
				throw new DbException(e); 
			}
			
		} catch (SQLException e) { 
				throw new DbException(e);
				
					}
		
		}
			
		}
		


		
		


