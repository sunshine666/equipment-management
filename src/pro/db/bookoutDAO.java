package pro.db;
import pro.model.Bookout;
import java.sql.*;

import javax.naming.*;
import java.util.*;

public class bookoutDAO
{
	private Connection conn;
	private Statement state1,state2;
	private PreparedStatement pstate1,pstate2;
	private ResultSet rs1,rs2;

	public bookoutDAO()
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
	
    public int addBookout(Bookout b,String jingshou,String desc)
	{
			int jg=0;
			int NowNum=0;
			int Status=0;
			System.out.println(b.getBook().getCategoryID());
			System.out.println(b.getBook().getPublisherID());
			try
			{	
				state1=conn.createStatement();
				rs1=state1.executeQuery("select * from bookstore where bookISBN='"+b.getBook().getBookISBN()+"'");
				if(rs1.next())
					NowNum=rs1.getInt("NowNum");
				Status=rs1.getInt("status");
				if(Status==1)
				{
				pstate1=conn.prepareStatement("insert into bookout (bookISBN,saleDate,SaleNum,allPrice,operator,unit,jingshou,outdesc) values (?,?,?,?,?,?,?,?)");
				pstate1.setString(1, b.getBook().getBookISBN());
				pstate1.setString(2, b.getSaleDate());
				pstate1.setInt(3, 1);
				pstate1.setDouble(4, b.getAllPrice());
				pstate1.setString(5, b.getOperator());
				pstate1.setString(6, b.getBook().getUnit());
				pstate1.setString(7, jingshou);
				pstate1.setString(8, desc);
				
				pstate1.executeUpdate();
				pstate2=conn.prepareStatement("update bookstore set author=?,bookDesccs=?,bookDescid=?,bookDescrq=?,bookDescxh=?,unit=?,categoryID=?,publisherID=? where bookISBN=?");
				pstate2.setString(1, b.getBook().getAuthor());
				pstate2.setString(2, b.getBook().getBookDesccs());
				pstate2.setString(3, b.getBook().getBookDescid());
				pstate2.setString(4, b.getBook().getBookDescrq());
				pstate2.setString(5, b.getBook().getBookDescxh());
				pstate2.setString(6, b.getBook().getUnit());
				pstate2.setInt(7, b.getBook().getCategoryID());
				pstate2.setInt(8, b.getBook().getPublisherID());
				pstate2.setString(9, b.getBook().getBookISBN());

				jg=pstate2.executeUpdate();
				}
				else
					jg=0;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					rs1.close();
					state1.close();
					pstate1.close();	
					pstate2.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		
		    return jg;
	}
    
    public int delBook(Bookout b,String desc,String jingshou)
    {
		int jg=0;
		int NowNum=0;
		int Status=0;
		try
		{	
			state1=conn.createStatement();
			rs1=state1.executeQuery("select * from bookstore where bookISBN='"+b.getBook().getBookISBN()+"'");
			if(rs1.next())
				NowNum=rs1.getInt("NowNum");
			Status=rs1.getInt("status");
			if(Status==1)
			{
			pstate1=conn.prepareStatement("insert into delshop (ISBN,name,deldate,deldesc,operator,jingshou) values (?,?,?,?,?,?)");
			pstate1.setString(1, b.getBook().getBookISBN());
			pstate1.setString(2, b.getBook().getBookName());
			pstate1.setString(3, b.getSaleDate());
			pstate1.setString(4, desc);
			pstate1.setString(5, b.getOperator());
			pstate1.setString(6, jingshou);
			
			pstate1.executeUpdate();
			pstate2=conn.prepareStatement("update bookstore set NowNum=? where bookISBN=?");
			pstate2.setInt(1, -1);
			pstate2.setString(2, b.getBook().getBookISBN());

			jg=pstate2.executeUpdate();
			}
			else
				jg=0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs1.close();
				state1.close();
				pstate1.close();	
				pstate2.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	    return jg;	
    }
    
    public int delBook1(Bookout b,String desc,String jingshou,String sbr)
    {
		int jg=0;
		int NowNum=0;
		int Status=0;
		try
		{	
			state1=conn.createStatement();
			rs1=state1.executeQuery("select * from bookstore where bookISBN='"+b.getBook().getBookISBN()+"'");
			if(rs1.next())
				NowNum=rs1.getInt("NowNum");
			Status=rs1.getInt("status");
			if(Status==1)
			{
			pstate1=conn.prepareStatement("insert into delshop (ISBN,name,deldate,deldesc,operator,jingshou,st,sbr) values (?,?,?,?,?,?,?,?)");
			pstate1.setString(1, b.getBook().getBookISBN());
			pstate1.setString(2, b.getBook().getBookName());
			pstate1.setString(3, b.getSaleDate());
			pstate1.setString(4, desc);
			pstate1.setString(5, b.getOperator());
			pstate1.setString(6, jingshou);
			pstate1.setInt(7, 0);
			pstate1.setString(8, sbr);
			pstate1.executeUpdate();
			
			pstate2=conn.prepareStatement("update bookstore set NowNum=? where bookISBN=?");
			pstate2.setInt(1, 0);
			pstate2.setString(2, b.getBook().getBookISBN());

			jg=pstate2.executeUpdate();
			System.out.println(jg);
			}
			else
				jg=0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs1.close();
				state1.close();
				pstate1.close();
				pstate2.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	    return jg;	
    }
    
	public ArrayList getBookoutList(String bookISBN,String bookName,String publisherID,String categoryID,String saleDate_s,String saleDate_e,String unit)
	{
		ArrayList c=new ArrayList();
		System.out.println(saleDate_s);
		/*
		select bi.buyID bi.buyDate bi.buyNum bs.bookISBN bs.bookName bs.bookDesc bs.publisherID bs.author bs.categoryID bs.salePrice 
		*/
		String firstList=" (";
		String wheresql="";
		String sql1="1=1";
		String sql2="1=1";
		String sql3="1=1";
		String sql4="1=1";
		String sql5=" where 1=1";
		if(bookISBN!=null && !bookISBN.equals(""))
			sql1="bookISBN='"+bookISBN+"'";
		if(bookName!=null && !bookName.equals(""))
			sql2="bookName like '"+bookName+"'";
		if(publisherID!=null && !publisherID.equals("") && !publisherID.equals("0"))
			sql3="publisherID="+publisherID;
		if(categoryID!=null && !categoryID.equals("") && !categoryID.equals("0"))
			sql4="categoryID="+categoryID;
		if(saleDate_s!=null && !saleDate_s.equals("") && saleDate_e!=null && !saleDate_e.equals(""))
			sql5=" where saleDate >='"+saleDate_s+"' and saleDate<='"+saleDate_e+"'";
		wheresql=" where "+sql1+" and "+sql2+" and "+sql3+" and "+sql4;
		
		try
		{	
			state1=conn.createStatement();
			rs1=state1.executeQuery("select * from bookstore"+wheresql);
			while(rs1.next())
			{
				firstList=firstList+"'"+rs1.getString("bookISBN")+"',";	
			}
			firstList=firstList.substring(0, firstList.length()-1);
			firstList=firstList+")";
			state2=conn.createStatement();
			rs2=state2.executeQuery("select * from bookout "+sql5+" and bookISBN in "+firstList);
			
			bookstoreDAO bd=new bookstoreDAO();
			while(rs2.next())
			{
				Bookout bo=new Bookout();
				bo.setBook(bd.getBookByISBN(rs2.getString("bookISBN"), unit));
				System.out.println(rs2.getString("saleDate"));
				bo.setSaleDate(rs2.getString("saleDate"));
				bo.setSaleNum(rs2.getInt("SaleNum"));
				bo.setOperator(rs2.getString("operator"));
				bo.setAllPrice(rs2.getDouble("allPrice"));
				bo.setJingshou(rs2.getString("jingshou"));
				bo.setDeldesc(rs2.getString("outdesc"));
				
				c.add(bo);
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
				rs1.close();
				rs2.close();
				state1.close();	
				state2.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	return c; 		
	}
	
	public ArrayList getdelBook1()
	{
		ArrayList c=new ArrayList();
		/*
		select bi.buyID bi.buyDate bi.buyNum bs.bookISBN bs.bookName bs.bookDesc bs.publisherID bs.author bs.categoryID bs.salePrice 
		*/
       
		
		try
		{	
			state1=conn.createStatement();
			rs1=state1.executeQuery("select * from delshop where st=0");
			bookstoreDAO bd=new bookstoreDAO();
			while(rs1.next())
			{
				System.out.println("-bbb-");
				Bookout bo=new Bookout();
				bo.setBook(bd.getBookByISBN(rs1.getString("ISBN"), "1"));
				bo.setSaleDate(rs1.getString("deldate"));
				bo.setJingshou(rs1.getString("jingshou"));
				bo.setDeldesc(rs1.getString("deldesc"));
				bo.setOperator(rs1.getString("operator"));
				
				c.add(bo);
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
				rs1.close();
				state1.close();	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	return c; 		
	}
	
	public ArrayList getdelBook(String bookISBN,String bookName,String publisherID,String categoryID,String saleDate_s,String saleDate_e,String unit)
	{
		ArrayList c=new ArrayList();
		System.out.println(bookISBN+" "+categoryID+"????");
		/*
		select bi.buyID bi.buyDate bi.buyNum bs.bookISBN bs.bookName bs.bookDesc bs.publisherID bs.author bs.categoryID bs.salePrice 
		*/
		String firstList=" (";
		String wheresql="";
		String sql1="1=1";
		String sql2="1=1";
		String sql3="1=1";
		String sql4="1=1";
		String sql5=" where 1=1";
		if(bookISBN!=null && !bookISBN.equals(""))
			sql1="bookISBN='"+bookISBN+"'";
		if(bookName!=null && !bookName.equals(""))
			sql2="bookName like '"+bookName+"'";
		if(publisherID!=null && !publisherID.equals("") && !publisherID.equals("0"))
			sql3="publisherID="+publisherID;
		if(categoryID!=null && !categoryID.equals("") && !categoryID.equals("0"))
			sql4="categoryID="+categoryID;
		if(saleDate_s!=null && !saleDate_s.equals("") && saleDate_e!=null && !saleDate_e.equals(""))
			sql5=" where deldate >='"+saleDate_s+"' and deldate<='"+saleDate_e+"'";
		wheresql=" where "+sql1+" and "+sql2+" and "+sql3+" and "+sql4;
		
		try
		{	
			state1=conn.createStatement();
			rs1=state1.executeQuery("select * from bookstore"+wheresql);
			while(rs1.next())
			{
				firstList=firstList+"'"+rs1.getString("bookISBN")+"',";	
			}
			firstList=firstList.substring(0, firstList.length()-1);
			firstList=firstList+")";
			state2=conn.createStatement();
			System.out.println("select * from delshop "+sql5+" and st=1 and ISBN in "+firstList);
			rs2=state2.executeQuery("select * from delshop "+sql5+" and st=1 and ISBN in "+firstList);
			
			bookstoreDAO bd=new bookstoreDAO();
			while(rs2.next())
			{
				Bookout bo=new Bookout();
				bo.setBook(bd.getBookByISBN(rs2.getString("ISBN"), unit));
				bo.setSaleDate(rs2.getString("deldate"));
				bo.setJingshou(rs2.getString("jingshou"));
				bo.setDeldesc(rs2.getString("deldesc"));
				bo.setOperator(rs2.getString("operator"));
				
				c.add(bo);
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
				rs1.close();
				rs2.close();
				state1.close();	
				state2.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	return c; 		
	}
	
	public boolean queren(String id)
	{
			int jg=0;
			try
			{	
				state1=conn.createStatement();
				state1.executeUpdate("update delshop set st=1 where ISBN='"+id+"'");	
				pstate2=conn.prepareStatement("update bookstore set NowNum=? where bookISBN=?");
				pstate2.setInt(1, -1);
				pstate2.setString(2, id);
				jg=pstate2.executeUpdate();
	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{	
					state1.close();	
					pstate2.close();
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
	
	public ArrayList getdellist(String name)
	{
		ArrayList c=new ArrayList();
		/*
		select bi.buyID bi.buyDate bi.buyNum bs.bookISBN bs.bookName bs.bookDesc bs.publisherID bs.author bs.categoryID bs.salePrice 
		*/
       
		
		try
		{	
			state1=conn.createStatement();
			rs1=state1.executeQuery("select * from delshop where sbr='"+name+"'");
			bookstoreDAO bd=new bookstoreDAO();
			while(rs1.next())
			{
				System.out.println("-bbb-");
				Bookout bo=new Bookout();
				bo.setBook(bd.getBookByISBN(rs1.getString("ISBN"), "1"));
				bo.setSaleDate(rs1.getString("deldate"));
				bo.setJingshou(rs1.getString("jingshou"));
				bo.setDeldesc(rs1.getString("deldesc"));
				bo.setOperator(rs1.getString("operator"));
				
				c.add(bo);
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
				rs1.close();
				state1.close();	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	return c; 		
	}
	
	public boolean shan(String id)
	{
			int jg=0;
			try
			{	
				state1=conn.createStatement();
				state1.executeUpdate("delete from delshop where ISBN='"+id+"'");
				pstate2=conn.prepareStatement("update bookstore set NowNum=? where bookISBN=?");
				pstate2.setInt(1, 1);
				pstate2.setString(2, id);
				jg=pstate2.executeUpdate();
	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{	
					state1.close();	
					pstate2.close();
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
