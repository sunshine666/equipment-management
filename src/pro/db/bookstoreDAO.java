package pro.db ;
import pro.model.Bookstore;
import java.sql.*;

import javax.naming.*;
import java.util.*;

public class bookstoreDAO
{
	private Connection conn;
	private Statement state;
	private ResultSet rs;

	public bookstoreDAO()
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
	
	public Bookstore getBookByISBN(String ISBN,String unit)
	{
		Bookstore b=new Bookstore();
	
		try
		{	
			state=conn.createStatement();
			rs=state.executeQuery("select * from bookstore where bookISBN='"+ISBN+"'");
			if(rs.next())
			{
				b.setBookISBN(rs.getString("bookISBN"));
				b.setBookName(rs.getString("bookName"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setAuthor(rs.getString("author"));
				b.setCategoryID(rs.getInt("categoryID"));
				b.setPublisherID(rs.getInt("publisherID"));
				b.setNowNum(rs.getInt("NowNum"));
				b.setSalePrice(rs.getDouble("salePrice"));
				b.setStatus(rs.getInt("status"));
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

	return b; 		
	}
	
	public ArrayList getBookstoreList(String bookISBN,String bookName,String publisherID,String categoryID,String unit,String role,String author)
	{
		ArrayList c=new ArrayList();
		System.out.println();
		int count=Integer.parseInt(role);

		String wheresql="";
		String sql1="1=1";
		String sql2="1=1";
		String sql3="1=1";
		String sql4="1=1";
		String sqll="1=1";

		if(bookISBN!=null && !bookISBN.equals(""))
			sql1="bookISBN='"+bookISBN+"'";
		if(author!=null && !author.equals(""))
			sql1="author='"+author+"'";
		if(bookName!=null && !bookName.equals(""))
			sql2="bookName like '"+bookName+"'";
		if(publisherID!=null && !publisherID.equals("") && !publisherID.equals("0"))
			sql3="publisherID="+publisherID;
		if(categoryID!=null && !categoryID.equals("") && !categoryID.equals("0"))
			sql4="categoryID="+categoryID;
		wheresql=" where "+sql1+" and "+sql2+" and "+sql3+" and "+sql4;
		System.out.println(wheresql);
		try
		{	
			state=conn.createStatement();
			rs=state.executeQuery("select * from bookstore"+wheresql);
			if(count==1)
			{
				rs=state.executeQuery("select * from bookstore"+wheresql);
			}
			else
			{
				rs=state.executeQuery("select * from bookstore"+wheresql+" and unit='"+unit+"'");
			}
			while(rs.next())
			{		
				Bookstore b=new Bookstore();
				b.setBookISBN(rs.getString("bookISBN"));
				b.setBookName(rs.getString("bookName"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setAuthor(rs.getString("author"));
				b.setCategoryID(rs.getInt("categoryID"));
				b.setPublisherID(rs.getInt("publisherID"));
				b.setNowNum(rs.getInt("NowNum"));
				b.setSalePrice(rs.getDouble("salePrice"));
				b.setStatus(rs.getInt("status"));
				b.setPicadr(rs.getString("picadr"));
				c.add(b);	
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
	
	public boolean delep(String id,String status,String unit)
	{
			int jg=0;
			try
			{	
				state=conn.createStatement();
				int i=Integer.parseInt(status);
				if(i==0)
				    jg=state.executeUpdate("update bookstore set status=1 where bookISBN='"+id+"'");
				else if(i==1)
					jg=state.executeUpdate("update bookstore set status=0 where bookISBN='"+id+"'");	
	
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