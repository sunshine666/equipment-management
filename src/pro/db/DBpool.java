package pro.db;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.naming.*;
import javax.sql.DataSource;


public class DBpool
{
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException,NamingException
	{
			try
			{
				Properties p = new Properties(); 
				InputStream in = DBpool.class.getResourceAsStream("/1.properties");  
	            p.load(in);  
	            in.close(); 
	            String url=p.getProperty("url"); 
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection(url,"root","");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		    return conn;		
	}
}