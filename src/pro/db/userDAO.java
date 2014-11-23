package pro.db;
import pro.model.User;

import java.sql.*;
import javax.naming.*;
import java.util.*;

public class userDAO
{
	private Connection conn;
	private Statement state;
	private PreparedStatement pstate;
	private ResultSet rs;

	public userDAO()
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
    public int addUser(User u,String unit)
	{
			int jg=0;
			try
			{	
				state=conn.createStatement();
				pstate=conn.prepareStatement("insert into user (loginName,loginPwd,roleID,unit) values (?,?,?,?)");
				rs=state.executeQuery("select loginName from user where loginName='"+u.getName()+"'");
				if(rs.next())
					jg=2;
				else
				{
					pstate.setString(1,u.getName());
					pstate.setString(2,u.getPwd());
					pstate.setInt(3,u.getRoleID());
					pstate.setString(4, unit);
			
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
	public ArrayList getUserList(String unit)
	{
			ArrayList c=new ArrayList();
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select * from user where unit='"+unit+"'");
				while(rs.next())
				{
					User u=new User();
					u.setId(rs.getInt("userID"));
					u.setName(rs.getString("loginName"));
					u.setRoleID(rs.getInt("roleID"));
					c.add(u);
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
    
	public User getUserByName(String name)
	{
			User u=new User();
			try
			{	
				state=conn.createStatement();
				rs=state.executeQuery("select * from user where loginName='"+name+"'");
				if(rs.next())
				{
					u.setId(rs.getInt("userID"));
					u.setName(rs.getString("loginName"));
					u.setPwd(rs.getString("loginPwd"));
					u.setRoleID(rs.getInt("roleID"));
					u.setUnit(rs.getString("unit"));
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
		
		return u; 		
	}
	public boolean checkLogin(String name,String pwd)
	{
			boolean jg=false;
			try
			{	
				pstate=conn.prepareStatement("select * from user where loginname=? and loginPwd=?");
				pstate.setString(1, name);
				pstate.setString(2, pwd);
				rs=pstate.executeQuery();
				if(rs.next())
				{
					jg=true;
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
					pstate.close();	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
	
			}
		
		return jg; 		
	}
	public int editUser(String loginName,String oldPwd,String newPwd)
	{
			int jg=0;
			try
			{	
				if(this.checkLogin(loginName, oldPwd))
				{
					pstate=conn.prepareStatement("update user set loginPwd=? where loginName=?");
					pstate.setString(1,newPwd);
					pstate.setString(2,loginName);
		
					jg=pstate.executeUpdate();
				}
				else 
					jg=2;
	
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
	
	public int editRole(String loginName,int roleId)
	{
			int jg=0;
			try
			{		
				String name=loginName.substring(0,loginName.indexOf(","));
				System.out.println(name);
				pstate=conn.prepareStatement("update user set roleID=? where loginName=?");
				pstate.setInt(1,roleId);
				pstate.setString(2,name);
		
				jg=pstate.executeUpdate();
				System.out.println(jg);

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
	
	public boolean delUser(String id)
	{
			int jg=0;
			try
			{	
				state=conn.createStatement();
				jg=state.executeUpdate("delete from user where userID="+id);
	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{	
					state.close();	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		
		    if(jg>0)		
		    	return true;
		    else
		    	return false;
	}
}


