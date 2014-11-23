package pro.action;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import pro.db.userDAO;
import pro.model.User;
import pro.util.replaceUtil;

public class userAction extends ActionSupport implements Action{
	
	private String id;
	private User u;
	private String loginname;
	private String loginpwd;
	private userDAO ud;
	private ArrayList userList;
	private String newPwd;
	private String newPwd1;
	private String roleID;
	private replaceUtil ri;
	private String unit;
	
	public userAction()
	{
		u=new User();
		ud=new userDAO();
		ri=new replaceUtil();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	
	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	public String getNewPwd1() {
		return newPwd1;
	}

	public void setNewPwd1(String newPwd1) {
		this.newPwd1 = newPwd1;
	}
	
	public String getRoleId() {
		return roleID;
	}

	public void setRoleId(String roleID) {
		this.roleID = roleID;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public ArrayList getUserList() {
		return userList;
	}

	public void setUserList(ArrayList userList) {
		this.userList = userList;
	}

	public String getAllUsers()
	{
		userList=ud.getUserList(ActionContext.getContext().getSession().get("unit").toString());
		return SUCCESS;
	}
	
	public String getUser()
	{
		this.u=ud.getUserByName(this.loginname);
		return SUCCESS;
	}
	
	public String addUser() throws Exception
	{

		int jg=ud.addUser(this.u);
		if(jg==1)
			return SUCCESS;
		else if(jg==2)
		{
			this.addFieldError("u.name", getText("pro.errorpwd"));
			return NONE;
		}
		else
			return ERROR;
	}
	
	public String addUser1() throws Exception
	{

		int jg=ud.addUser(this.u);
		if(jg==1)
			return SUCCESS;
		else if(jg==2)
		{
			this.addFieldError("u.name", getText("pro.errorpwd"));
			return NONE;
		}
		else
			return ERROR;
	}
	
	public String editUser()
	{
		int jg=ud.editUser(this.loginname,this.loginpwd,this.newPwd);
		if(jg==1)
			return SUCCESS;
		else if(jg==2)
		{
			this.addFieldError("loginpwd", getText("pro.errorpwd"));
			return NONE;
		}
		else
			return ERROR;
	}
	
	public String editRole()
	{
		System.out.println(this.u.getRoleID());
		int jg=ud.editRole(this.u.getName(),this.u.getRoleID());
		if(jg==1)
			return SUCCESS;
		else
			return ERROR;
	}	

	public String delUser()
	{
		if(ud.delUser(this.id))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String checkLogin()  throws Exception
	{
		if(ud.checkLogin(this.loginname, this.loginpwd))
		{
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
			String datetime = tempDate.format(new java.util.Date());
			ActionContext.getContext().getSession().put("loginname" ,this.loginname);
			ActionContext.getContext().getSession().put("roleId",String.valueOf(ud.getUserByName(this.loginname).getRoleID()));
			ActionContext.getContext().getSession().put("unit",ud.getUserByName(this.loginname).getUnit());
			ActionContext.getContext().getSession().put("loginTime", datetime);
			ActionContext.getContext().getSession().put("categoryMap",ri.categoryMap());
			ActionContext.getContext().getSession().put("publisherMap",ri.publisherMap());
			HashMap roleMap=new HashMap();
			roleMap.put("1", getText("pro.admin"));
			roleMap.put("2", getText("pro.opterator"));
			ActionContext.getContext().getSession().put("roleMap", roleMap);
			
			
			return SUCCESS;
		}
		else 
			return LOGIN;	
	}
	
	public String exit()
	{
		ActionContext.getContext().getSession().put("loginname" ,null);
		ActionContext.getContext().getSession().put("roleId",null);
		ActionContext.getContext().getSession().put("loginTime",null);
		ActionContext.getContext().getSession().put("categoryMap",null);
		ActionContext.getContext().getSession().put("publisherMap",null);
		ActionContext.getContext().getSession().put("roleMap",null);
		return SUCCESS;
	}
	
	public String input()
	{
		return INPUT;
	}
}
