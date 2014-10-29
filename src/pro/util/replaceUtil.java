package pro.util;
import pro.db.DBpool;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class replaceUtil 
{
	private Connection conn;
	private Statement state;
	private ResultSet rs;

	public replaceUtil()
	{
		if(conn==null)
		{
			try
			{
				conn=DBpool.getConnection();	//		
			}
			catch(NamingException e)
			{
				e.printStackTrace();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	
	public HashMap publisherMap()
	{
		HashMap hm=new HashMap();
		
		try
		{	
			state=conn.createStatement();
			rs=state.executeQuery("select * from publisher");

			while(rs.next())
			{
				hm.put(String.valueOf(rs.getInt("publisherID")), rs.getString("publisherName"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				state.close();	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	    return hm; 		
	}
	public HashMap categoryMap()
	{
		HashMap hm=new HashMap();

		try
		{	
			state=conn.createStatement();
			rs=state.executeQuery("select * from category");
			while(rs.next())
			{
				hm.put(String.valueOf(rs.getInt("categoryID")), rs.getString("categoryName"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				state.close();	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	    return hm; 		
	}
	
	
	
}
