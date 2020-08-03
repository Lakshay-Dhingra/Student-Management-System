package databases;
import java.sql.*;

public class AdminOperations
{
	public static boolean addAdmin(String username,String password)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="insert into admin values('"+username+"', '"+password+"')";
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in addUser().");
		}
		return false;
	}
}
