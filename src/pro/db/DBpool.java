package pro.db;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class DBpool
{
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException,NamingException
	{
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		    return conn;		
	}
}