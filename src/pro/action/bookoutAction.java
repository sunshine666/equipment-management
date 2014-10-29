package pro.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import pro.model.Bookout;
import pro.model.Bookstore;
import pro.db.bookoutDAO;
import pro.db.bookstoreDAO;
import java.util.ArrayList;

public class bookoutAction  extends ActionSupport{
	
	private String bookISBN;
	private Bookout bo;
	private Bookstore b;
	private bookoutDAO bod;
	private bookstoreDAO bsd;
	private ArrayList bookoutList;
	private String saleDate_s;
	private String saleDate_e;
	
	public bookoutAction()
	{
		bod=new bookoutDAO();
		bsd=new bookstoreDAO();
	}
	
	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public Bookout getBo() {
		return bo;
	}

	public void setBo(Bookout bo) {
		this.bo = bo;
	}

	public Bookstore getB() {
		return b;
	}

	public void setB(Bookstore b) {
		this.b = b;
	}
	
	public void setBookoutList(ArrayList bookoutList) {
		this.bookoutList = bookoutList;
	}
	public ArrayList getBookoutList()
	{
		return this.bookoutList;
	}
	public String getSaleDate_s() {
		return saleDate_s;
	}

	public void setSaleDate_s(String saleDate_s) {
		this.saleDate_s = saleDate_s;
	}

	public String getSaleDate_e() {
		return saleDate_e;
	}

	public void setSaleDate_e(String saleDate_e) {
		this.saleDate_e = saleDate_e;
	}
	
	public String addBookout()
	{
		if(bod.addBookout(this.bo)==1)
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String getBook()
	{
		this.b=bsd.getBookByISBN(this.bookISBN,ActionContext.getContext().getSession().get("unit").toString());
		this.bo=new Bookout();
		this.bo.setBook(this.b);
		return SUCCESS;
	}
	
	public String getBookouts()
	{
		this.bookoutList=bod.getBookoutList(this.b.getBookISBN(), this.b.getBookName(), String.valueOf(this.b.getPublisherID()), String.valueOf(this.b.getCategoryID()), this.saleDate_s, this.saleDate_e, this.b.getUnit());
		return SUCCESS;
	}

}
