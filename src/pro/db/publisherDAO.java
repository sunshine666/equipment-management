package pro.db;
import pro.model.Publisher;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class publisherDAO
{
	private Connection conn;
	private Statement state;
	private PreparedStatement pstate;
	private ResultSet rs;

	public publisherDAO()
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
    public int addPublisher(Publisher p)
	{
			int jg=0;
			System.out.println(p.getName()+"!!!");
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select publisherName from publisher where publisherName='"+p.getName()+"'");
				if(rs.next())
					jg=2;
				else
				{
					pstate=conn.prepareStatement("insert into publisher (publisherName) values (?)");
					pstate.setString(1,p.getName());
			
					jg=pstate.executeUpdate();					
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
					pstate.close();	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		
		    return jg;
	}
    
	public ArrayList getPublisherList()
	{
			ArrayList c=new ArrayList();
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select * from publisher");
				while(rs.next())
				{
					Publisher p=new Publisher();
					p.setId(rs.getInt("publisherID"));
					p.setName(rs.getString("publisherName"));
					c.add(p);
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
		
		return c; 		
	}
    
	public Publisher getPublisherById(String id)
	{
		    Publisher p=new Publisher();
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select * from Publisher where publisherID="+id);
				if(rs.next())
				{
					p.setId(rs.getInt("publisherID"));
					p.setName(rs.getString("publisherName"));
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
		
		return p; 		
	}
    
	public int editPublisher(Publisher p)
	{
			int jg=0;
			try
			{	
				pstate=conn.prepareStatement("update publisher set publisherName=? where publisherID=?");
				pstate.setString(1,p.getName());
				pstate.setInt(2,p.getId());
		
				jg=pstate.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{		
					pstate.close();	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		
		    return jg;
	}    
}
