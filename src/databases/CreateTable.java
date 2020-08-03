package databases;
import java.sql.*;

public class CreateTable
{
	public static boolean createTables()
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="create table users(username varchar(20) not null, password varchar(20) not null, PRIMARY KEY (username))";
		    stmt.executeUpdate(query);
		    query="create table admin(username varchar(20) not null, password varchar(20) not null, PRIMARY KEY (username))";
		    stmt.executeUpdate(query);
		    query="create table student (student_id bigint(15) NOT NULL, student_name varchar(30) NOT NULL, degree varchar(30), gpa float,"
					+ " PRIMARY KEY (student_id))";
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(Exception e)
		{
			System.out.println("Some Error Occured in creating table.");
		}
		return false;
	}
}
