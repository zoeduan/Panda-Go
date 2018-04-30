package edu.uncc.edu.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import edu.uncc.ssdi.util.DBConnection;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;

@SpringBootTest
@RunWith(JMockit.class)
public class PermDaoImplTest {

	@Injectable
    private DBConnection test_conn;
	
	private Connection conn;
	
	private PreparedStatement stmt ;

	
	@Before
	public void setup() {
		new Expectations() {{
			test_conn.getDBConnectionTest(); 
			result = conn;
			 }};
			
			conn =  test_conn.getDBConnectionTest(); 
			 
			 
	}

	
	@Test
	public void givePermissionTest() throws Exception{
	
	
		
			
			int bool = 0;
			
/*
				conn = DBConnection.getDBConnection();

				String query = "update `permission` set  `status` = ? where `access_id` =  ? and `access_by` = ? ";
				stmt = conn.prepareStatement(query);
				
				stmt.setInt(1, permObject.getStatus());
				stmt.setString(2, permObject.getAccessId());
				stmt.setLong(3, permObject.getAccessByUserId());
				
			
				
				 bool = stmt.executeUpdate();
		

				stmt.close();
			
			
			
		*/
		
		
		
		
	}

}
