package databases;
import java.sql.*;

public class StudentOperations
{
	public static boolean addStudent(long student_id,String student_name,String degree,float gpa)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="insert into student values("+student_id+",'"+student_name+"','"+degree+"',"+gpa+")";
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in storing data in database in addStudent().");
		}
		return false;
	}
	
	public static boolean updateStudent(long student_id,String student_name,String degree,float gpa)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="update student set student_name='"+student_name+"', degree='"+degree+"', gpa="+gpa+" where student_id="+student_id;
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in storing data in database in updateStudent().");
		}
		return false;
	}
	
	public static boolean deleteStudent(long student_id)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="delete from student where student_id="+student_id;
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in deleting data in deleteStudent().");
		}
		return false;
	}
	
	public static String[][] searchStudent(long student_id)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="select * from student where student_id='"+student_id+"'";
		    ResultSet rs=stmt.executeQuery(query);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    
		    int rows,cols;
		    cols=rsmd.getColumnCount();
		    if(rs.last())
		    {
		    	rows=rs.getRow();
		    }
		    else
		    {
		    	return new String[0][0];
		    }
		    
		    String[][] arr=new String[rows][cols];		    
		    rs.beforeFirst();
		    while(rs.next())
		    {
		    	for(int j=0;j<cols;j++)
		    	{
		    		arr[rs.getRow()-1][j]=rs.getString(j+1);
		    		System.out.print((arr[rs.getRow()-1][j])+" ");
		    	}
		    	System.out.println();
		    }
		    return arr;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in while reading student data in seachStudent().");
		}
		return null;
	}
	
	public static String[][] allStudents()
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="select * from student";
		    ResultSet rs=stmt.executeQuery(query);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    
		    int rows,cols;
		    cols=rsmd.getColumnCount();
		    if(rs.last())
		    {
		    	rows=rs.getRow();
		    }
		    else
		    {
		    	return new String[0][0];
		    }
		    
		    String[][] arr=new String[rows][cols];		    
		    rs.beforeFirst();
		    while(rs.next())
		    {
		    	for(int j=0;j<cols;j++)
		    	{
		    		arr[rs.getRow()-1][j]=rs.getString(j+1);
//		    		System.out.print((arr[rs.getRow()-1][j])+" ");
		    	}
//		    	System.out.println();
		    }
		    return arr;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in while reading student data in allStudents().");
		}
		return null;
	}
	
}
