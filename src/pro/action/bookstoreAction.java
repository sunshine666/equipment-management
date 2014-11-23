package pro.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import pro.model.Bookstore;
import pro.db.bookstoreDAO;
import java.util.ArrayList;

public class bookstoreAction  extends ActionSupport{
	
	private Bookstore b;
	private bookstoreDAO bsd;
	private String buyDate_s;
	private String buyDate_e;
	private ArrayList bookstoreList;
	private String myid;
	private String mystatus;
	
	public bookstoreAction()
	{
		bsd=new bookstoreDAO();
	}

	public Bookstore getB() {
		return b;
	}

	public void setB(Bookstore b) {
		this.b = b;
	}

	public String getBuyDate_s() {
		return buyDate_s;
	}

	public void setBuyDate_s(String buyDate_s) {
		this.buyDate_s = buyDate_s;
	}

	
	public void setBookstoreList(ArrayList bookstoreList) {
		this.bookstoreList = bookstoreList;
	}
	
	public ArrayList getBookstoreList()
	{
		return this.bookstoreList;
	}

	public String getBuyDate_e() {
		return buyDate_e;
	}

	public void setBuyDate_e(String buyDate_e) {
		this.buyDate_e = buyDate_e;
	}
	
	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}
	
	public String getMystatus() {
		return mystatus;
	}

	public void setMystatus(String mystatus) {
		this.mystatus = mystatus;
	}
	
	public String delep()
	{
		System.out.println(this.myid);
		System.out.println(this.mystatus);
		System.out.println(ActionContext.getContext().getSession().get("unit").toString());
		if(bsd.delep(this.myid,this.mystatus,ActionContext.getContext().getSession().get("unit").toString()))
			return SUCCESS;
		else
			return ERROR;
	}

	public String getBookstores()
	{
		this.bookstoreList=bsd.getBookstoreList(this.b.getBookISBN(), this.b.getBookName(), String.valueOf(this.b.getPublisherID()), String.valueOf(this.b.getCategoryID()),this.b.getUnit());
		return SUCCESS;
	}
	
}
