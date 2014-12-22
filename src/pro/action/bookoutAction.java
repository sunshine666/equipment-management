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
	private String desc;
	private String jingshou;
	
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
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}
	
	public String addBookout()
	{
		if(bod.addBookout(this.bo,this.jingshou,this.desc)==1)
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String delBook()
	{
		if(bod.delBook(this.bo,this.desc,this.jingshou)==1)
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String delBook1()
	{
		if(bod.delBook1(this.bo,this.desc,this.jingshou,ActionContext.getContext().getSession().get("loginname").toString())==1)
		{
			System.out.println("wawa");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	public String getdellist()
	{
		this.bookoutList=bod.getdellist(ActionContext.getContext().getSession().get("loginname").toString());
		return SUCCESS;
	}
	
	public String shan()
	{
		if(bod.shan(this.bookISBN))
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
	
	public String getdelBook()
	{
		this.bookoutList=bod.getdelBook(this.b.getBookISBN(), this.b.getBookName(), String.valueOf(this.b.getPublisherID()), String.valueOf(this.b.getCategoryID()), this.saleDate_s, this.saleDate_e, this.b.getUnit());
		return SUCCESS;
	}
	
	public String getdelBook1()
	{
		System.out.println("-aaa-");
		this.bookoutList=bod.getdelBook1();
		return SUCCESS;
	}
	
	public String queren()
	{
		if(bod.queren(this.bookISBN))
			return SUCCESS;
		else
			return ERROR;
	}

}
