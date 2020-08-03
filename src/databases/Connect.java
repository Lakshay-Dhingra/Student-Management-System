package databases;
import java.sql.*;

public class Connect
{	
	private static String dbname;
	private static String mysql_username;
	private static String mysql_password;
	
	public static void setProperties()
	{
		String[] arr=crud.StoreDetails.getData();
		dbname=arr[0];
		mysql_username=arr[1];
		mysql_password=arr[2];
	}
	
	public static Connection getConnection()
	{
		setProperties();
		if(dbname==null)
			return null;
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
		     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,mysql_username,mysql_password);
		}
		catch(Exception e)
		{
			System.out.println("Error: unable to connect to database!");
		}
		return con;
	}
	
//	public static boolean checkAdmin()
//	{
//		try(Connection conn=Connect.getConnection())
//		{
//			Statement stmt = conn.createStatement();
//		    ResultSet rs =stmt.executeQuery("select * from admin");
//		    if(rs.next())
//			{	
//				return true;
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some Error Occured in fetching data from database in checkAdmin().");
//		}
//		return false;
//	}
	
}
