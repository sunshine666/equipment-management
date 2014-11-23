package pro.db;
import pro.model.Bookin;
import pro.model.Bookstore;
import pro.db.bookstoreDAO;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class bookinDAO
{
	private Connection conn;
	private Statement state1,state2;
	private PreparedStatement pstate1,pstate2,pstate3;
	private ResultSet rs1,rs2;

	public bookinDAO()
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
	
    public int addBookin(Bookin b,String picadr)
	{
			int jg=0;
			int NowNum=0;
			try
			{	
				state1=conn.createStatement();
				rs1=state1.executeQuery("select * from bookstore where bookISBN='"+b.getBook().getBookISBN()+"'"+" and unit='"+b.getUnit()+"'");
				if(rs1.next())
				{
					NowNum=rs1.getInt("NowNum");
					pstate3=conn.prepareStatement("update bookstore set NowNum=?,salePrice=? where bookISBN=? and unit=?");
					int newCount= b.getBuyNum() + NowNum;
					pstate3.setInt(1,newCount);
					pstate3.setDouble(2, b.getBook().getSalePrice());
					pstate3.setString(3, b.getBook().getBookISBN());
					pstate3.setString(4, b.getUnit());

					pstate3.executeUpdate();
					pstate3.close();
				}
				else
				{
					pstate1=conn.prepareStatement("insert into bookstore (bookISBN,bookName,bookDesc,publisherID,author,categoryID,salePrice,NowNum,status,unit,picadr) values (?,?,?,?,?,?,?,?,?,?,?)");
					pstate1.setString(1, b.getBook().getBookISBN());	
					pstate1.setString(2, b.getBook().getBookName());
					pstate1.setString(3, b.getBook().getBookDesc());
					pstate1.setInt(4, b.getBook().getPublisherID());
					pstate1.setString(5, b.getBook().getAuthor());
					pstate1.setInt(6, b.getBook().getCategoryID());
					pstate1.setDouble(7, b.getBook().getSalePrice());
					pstate1.setInt(8, b.getBuyNum());
					pstate1.setInt(9, 1);
					pstate1.setString(10, b.getUnit());
					pstate1.setString(11, picadr);
					
					pstate1.executeUpdate();
					pstate1.close();
				}
				
				pstate2=conn.prepareStatement("insert into bookin (bookISBN,buyDate,buyNum,operator,unit) values (?,?,?,?,?)");
				pstate2.setString(1, b.getBook().getBookISBN());
				pstate2.setString(2, b.getBuyDate());
				pstate2.setInt(3, b.getBuyNum());
				pstate2.setString(4, b.getOperator());
				pstate2.setString(5, b.getUnit());
				
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
					rs1.close();
					state1.close();
					pstate2.close();
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		
		    return jg;
	}
    
	public ArrayList getBookinList(String bookISBN,String bookName,String publisherID,String categoryID,String buyDate_s,String buyDate_e,String unit)
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
			if(buyDate_s!=null && !buyDate_s.equals("") && buyDate_e!=null && !buyDate_e.equals(""))
				sql5=" where buyDate >="+buyDate_s+" and buyDate<="+buyDate_e;
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
				
				System.out.println("select * from bookin "+sql5+" and bookISBN in "+firstList);
				
				rs2=state2.executeQuery("select * from bookin "+sql5+" and bookISBN in "+firstList+" and unit='"+unit+"'");
				
				bookstoreDAO bd=new bookstoreDAO();
				while(rs2.next())
				{
					Bookin bi=new Bookin();
					bi.setBook(bd.getBookByISBN(rs2.getString("bookISBN"), unit));
					bi.setBuyDate(rs2.getString("buyDate"));
					bi.setBuyNum(rs2.getInt("buyNum"));
					bi.setOperator(rs2.getString("operator"));
					c.add(bi);
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
