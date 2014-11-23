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
	
    public int addBookout(Bookout b)
	{
			int jg=0;
			int NowNum=0;
			int Status=0;
			try
			{	
				state1=conn.createStatement();
				rs1=state1.executeQuery("select * from bookstore where bookISBN='"+b.getBook().getBookISBN()+"'"+" and unit='"+b.getUnit()+"'");
				if(rs1.next())
					NowNum=rs1.getInt("NowNum");
				Status=rs1.getInt("status");
				if(Status==1)
				{
				pstate1=conn.prepareStatement("insert into bookout (bookISBN,saleDate,SaleNum,allPrice,operator,unit) values (?,?,?,?,?,?)");
				pstate1.setString(1, b.getBook().getBookISBN());
				pstate1.setString(2, b.getSaleDate());
				pstate1.setInt(3, b.getSaleNum());
				pstate1.setDouble(4, b.getAllPrice());
				pstate1.setString(5, b.getOperator());
				pstate1.setString(6, b.getUnit());
				
				pstate1.executeUpdate();
				pstate2=conn.prepareStatement("update bookstore set NowNum=? where bookISBN=? and unit=?");
				pstate2.setInt(1, NowNum-b.getSaleNum());
				pstate2.setString(2, b.getBook().getBookISBN());
				pstate2.setString(3, b.getUnit());

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
    
	public ArrayList getBookoutList(String bookISBN,String bookName,String publisherID,String categoryID,String saleDate_s,String saleDate_e,String unit)
	{
		ArrayList c=new ArrayList();
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
		if(saleDate_s!=null && saleDate_s!="" && saleDate_e!=null && saleDate_e!="")
			sql5=" where saleDate >="+saleDate_s+" and saleDate<="+saleDate_e;
		if(saleDate_s!=null && !saleDate_s.equals("") && saleDate_e!=null && !saleDate_e.equals(""))
			sql5=" where buyDate >="+saleDate_s+" and buyDate<="+saleDate_e;
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
			rs2=state2.executeQuery("select * from bookout "+sql5+" and bookISBN in "+firstList+" and unit='"+unit+"'");
			
			bookstoreDAO bd=new bookstoreDAO();
			while(rs2.next())
			{
				Bookout bo=new Bookout();
				bo.setBook(bd.getBookByISBN(rs2.getString("bookISBN"), unit));
				bo.setSaleDate(rs2.getString("saleDate"));
				bo.setSaleNum(rs2.getInt("SaleNum"));
				bo.setOperator(rs2.getString("operator"));
				bo.setAllPrice(rs2.getDouble("allPrice"));
				
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

}
