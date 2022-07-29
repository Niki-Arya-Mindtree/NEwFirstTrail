package Example;
import java.sql.*;
public class JDBC {

	public static void main(String[] args) {
		try {
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("Select * from studentdata");
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}	
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
