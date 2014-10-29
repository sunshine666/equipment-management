package pro.action;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import pro.model.Category;
import pro.db.categoryDAO;

public class categoryAction  extends ActionSupport{
	
	private Category c;
	private ArrayList categoryList;
	private String id;
	private categoryDAO cd;
	
	public categoryAction()
	{
		c=new Category();
		cd=new categoryDAO();
	}

	public Category getC() {
		return c;
	}


	public void setC(Category c) {
		this.c = c;
	}

	public ArrayList getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList categoryList) {
		this.categoryList = categoryList;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAllCategory()
	{
		this.categoryList=cd.getCategoryList();
		return SUCCESS;
	}
	
	public String addCategory()
	{
		int jg=cd.addCategory(this.c);
		if(jg==1)
			return SUCCESS;
		else if(jg==2)
		{
			this.addFieldError("p.name", "error");
			return NONE;
		}
		else
			return ERROR;
	}
	
	public String getCategory()
	{
		this.c=cd.getCategoryById(id);
		return SUCCESS;
	}
	
	public String editCategory()
	{
		if(cd.editCategory(this.c)==1)
			return SUCCESS;
		else
			return ERROR;
	}
	

}
