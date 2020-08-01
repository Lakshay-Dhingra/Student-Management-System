package databases;
import java.sql.*;
public class ValidateLogin
{
	public static boolean authenticateUser(String username,String password)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
		    ResultSet rs =stmt.executeQuery("select * from users where username='"+username+"'and password='"+password+"'");
		    if(rs.next())
			{	
				return true;
			}
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in fetching data from database in ValidateLogin.");
		}
		return false;
	}
}
