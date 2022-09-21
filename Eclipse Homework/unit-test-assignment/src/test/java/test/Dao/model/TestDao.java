package test.Dao.model;

import java.sql.PreparedStatement;

public class TestDao {

	public TestDao() {
		public void dropTables() { 
			//formatter: off 
			String sql = ""
					+ "DROP TABLE type; "
					+ "DROP TABLE name";
			//formater: on
			
			try(PreparedStatement stmt = conn.prepareStatement(sql)) { 
				stmt.executeUpdate(); 
				System.out.println("Dropped type and name tables");
			} catch (SQLException e) { 
				throw new MemDbException(e); 
			}
		}
	}
		
		public void createName(String listName)
		String sql = "INSERT INTO name (list_name) VALUES (?)"; 			
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) { 
			stmt.setString(1,listName); 
			System.out.println("Dropped type and name tables");
		} catch (SQLException e) { 
			throw new MemDbException(e); 
	

}
