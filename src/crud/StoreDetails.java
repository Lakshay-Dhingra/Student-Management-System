package crud;
import java.io.*;

public class StoreDetails
{
//add details of mysql database
	public static boolean setUpDB(String admin_username,String admin_password,String dbname,String mysql_username,String mysql_password)
	{
		addData(dbname,mysql_username,mysql_password);
		boolean ans= databases.CreateTable.createTables();
		ans = ans && databases.AdminOperations.addAdmin(admin_username, admin_password);
		return ans;
	}
	
	
	public static void addData(String dbname,String mysql_username,String mysql_password)
	{
		try(FileOutputStream fout=new FileOutputStream("db_details.txt"))
		{
			DataOutputStream dout=new DataOutputStream(fout);
			dout.writeUTF(dbname);
			dout.writeUTF(mysql_username);
			dout.writeUTF(mysql_password);
			dout.close();
		}
		catch(Exception e)
		{
			System.out.println("Error occurred while writing db_details file!");
		}
	}
	
	public static String[] getData()
	{
		try(FileInputStream fin=new FileInputStream("db_details.txt"))
		{
			DataInputStream din=new DataInputStream(fin);
			String arr[]=new String[3];
			arr[0]=din.readUTF();
			arr[1]=din.readUTF();
			arr[2]=din.readUTF();
			din.close();
			return arr;
		}
		catch(Exception e)
		{
			System.out.println("Error occurred while reading db_details file!");
		}
		return new String[3];
	}
}
