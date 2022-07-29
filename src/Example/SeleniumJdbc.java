package Example;

import java.sql.*;

import org.testng.annotations.*;

public class SeleniumJdbc {
	private static Connection con;
	private static Statement stm;
	private static ResultSet rs;
	private static String sqlQuery ="Select * from studentdata";
	private static String sqlQueryStart ="Use student";
	private static String sqlQueryInsert ="insert into StudentData values (9,'Gautham','I',86,'Krishna','gutte',906567);";
	
	public static void main(String[] args) {
		MySqlCredentials sqlCred = new MySqlCredentials();
		try {
			beforTestDB(sqlCred);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public static void beforTestDB(MySqlCredentials sqlCred) throws Exception 
	{
		try 
		{
			System.out.println("Connection Establishing");
			//System.out.println(sqlCred.getUrl());
			con=DriverManager.getConnection(sqlCred.getUrl(),sqlCred.getUser(),sqlCred.getPassword());
			stm=con.createStatement();
			System.out.println("Connection Establisshed");
			testDB();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void testDB() throws Exception {
		try 
		{
			System.out.println("Executing The Querry");
			rs= stm.executeQuery(sqlQuery);
			System.out.println("Results");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}
//			System.out.println("Closing");
//			afterTestDB();
			testDBInseryt();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public static void testDBInseryt() throws Exception {
		try 
		{
			System.out.println("Executing The Querry");
			
			stm.executeUpdate(sqlQueryStart);
			stm.executeUpdate(sqlQueryInsert);
			System.out.println("Closing");
			afterTestDB();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public static void afterTestDB() throws Exception {
		if(con!=null)
			con.close();
	}
	
}
