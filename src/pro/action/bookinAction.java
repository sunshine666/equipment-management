package pro.action;
import com.opensymphony.xwork2.ActionSupport;
import pro.model.Bookin;
import pro.model.Bookstore;
import pro.db.bookinDAO;
import java.util.ArrayList;

public class bookinAction  extends ActionSupport{
	
	private Bookin bi;
	private Bookstore b;
	private bookinDAO bid;
	private ArrayList bookinList;
	private String buyDate_s;
	private String buyDate_e;
	
	public bookinAction()
	{
		bid=new bookinDAO();
	}

	public Bookin getBi() {
		return bi;
	}

	public void setBi(Bookin bi) {
		this.bi = bi;
	}

	public Bookstore getB() {
		return b;
	}

	public void setB(Bookstore b) {
		this.b = b;
	}
	
	
	public void setBookinList(ArrayList bookinList) {
		this.bookinList = bookinList;
	}
	
	public ArrayList getBookinList()
	{
		return this.bookinList;
	}

	public String getBuyDate_s() {
		return buyDate_s;
	}

	public void setBuyDate_s(String buyDate_s) {
		this.buyDate_s = buyDate_s;
	}

	public String getBuyDate_e() {
		return buyDate_e;
	}

	public void setBuyDate_e(String buyDate_e) {
		this.buyDate_e = buyDate_e;
	}

	public String addBookin()
	{
		if(bid.addBookin(this.bi)==1)
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String getBookins()
	{
		this.bookinList=bid.getBookinList(this.b.getBookISBN(), this.b.getBookName(), String.valueOf(this.b.getPublisherID()), String.valueOf(this.b.getCategoryID()), this.buyDate_s, this.buyDate_e,this.b.getUnit());
		return SUCCESS;
	}

}
