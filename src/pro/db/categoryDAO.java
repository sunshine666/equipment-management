package pro.db;
import pro.model.Category;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class categoryDAO
{
	private Connection conn;
	private Statement state;
	private PreparedStatement pstate;
	private ResultSet rs;

	public categoryDAO()
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
    public int addCategory(Category c)
	{
			int jg=0;
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select categoryName  from category where categoryName ='"+c.getName()+"'");
				if(rs.next())
					jg=2;
				else
				{
					pstate=conn.prepareStatement("insert into category (categoryName,categoryDesc) values (?,?)");
					pstate.setString(1,c.getName());
					pstate.setString(2,c.getDesc());
			
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
    
	public ArrayList getCategoryList()
	{
			ArrayList cl=new ArrayList();
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select * from category");
				while(rs.next())
				{
					Category c=new Category();
					c.setId(rs.getInt("categoryID"));
					c.setName(rs.getString("categoryName"));
					c.setDesc(rs.getString("categoryDesc"));
					cl.add(c);
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
		
		return cl; 		
	}
    
	public Category getCategoryById(String id)
	{
		    Category c=new Category();
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select * from category where categoryID="+id);
				if(rs.next())
				{
					c.setId(rs.getInt("categoryID"));
					c.setName(rs.getString("categoryName"));
					c.setDesc(rs.getString("categoryDesc"));
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
    
	public int editCategory(Category c)
	{
			int jg=0;
			try
			{	
				pstate=conn.prepareStatement("update category set categoryName =? ,categoryDesc=? where categoryID=?");
				pstate.setString(1,c.getName());
				pstate.setString(2,c.getDesc());
				pstate.setInt(3,c.getId());
		
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
