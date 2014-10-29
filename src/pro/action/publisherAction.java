package pro.action;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import pro.model.Publisher;
import pro.db.publisherDAO;

public class publisherAction  extends ActionSupport{
	
	private Publisher p;
	private ArrayList publisherList;
	private String id;
	private publisherDAO pd;
	
	public publisherAction()
	{
		p=new Publisher();
		pd=new publisherDAO();
	}

	public Publisher getP() {
		return p;
	}

	public void setP(Publisher p) {
		this.p = p;
	}

	public ArrayList getPublisherList() {
		
		return this.publisherList;
	}

	public void setPublisherList(ArrayList publisherList) {
		this.publisherList = publisherList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAllPublisher()
	{
		this.publisherList=pd.getPublisherList();
		return SUCCESS;
	}
	
	public String addPublisher()
	{
		int jg=pd.addPublisher(this.p);
		if(jg==1)
			return SUCCESS;
		else if(jg==2)
		{
			this.addFieldError("p.name", getText("pro.admin.havepublisher"));
			return NONE;
		}
		else
			return ERROR;
	}
	
	public String getPublisher()
	{
		this.p=pd.getPublisherById(id);
		return SUCCESS;
	}
	
	public String editPublisher()
	{
		if(pd.editPublisher(this.p)==1)
			return SUCCESS;
		else
			return ERROR;
	}
	

}
