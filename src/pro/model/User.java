package pro.model;

public class User {
	
	private int id;
	private String name;
	private String pwd;
	private int roleID;
	private String unit;
	
	public User(){}
	
	public User(int id,String name,String pwd,int roleID)
	{
		this.id=id;
		this.name=name;
		this.pwd=pwd;
		this.roleID=roleID;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
