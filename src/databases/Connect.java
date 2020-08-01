package databases;
import java.sql.*;

public class Connect
{	
	private static String dbname="crud";
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			try 
			{
			   Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException ex)
			{
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
			}			
		     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,"root","root");
		}
		catch(SQLException e)
		{
			System.out.println("Error: unable to connect to database!");
			System.exit(1);
		}
		return con;
	}
}
