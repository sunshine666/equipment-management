package pro.action;
import com.opensymphony.xwork2.ActionSupport;
import pro.model.Bookin;
import pro.model.Bookstore;
import pro.db.bookinDAO;
import java.util.ArrayList;
import java.io.File;  
import java.io.IOException;  
import java.util.List;  
import org.apache.commons.io.FileUtils;  
import org.apache.struts2.ServletActionContext;  
import com.opensymphony.xwork2.ActionSupport; 

public class bookinAction  extends ActionSupport{
	
	private Bookin bi;
	private Bookstore b;
	private bookinDAO bid;
	private ArrayList bookinList;
	private String buyDate_s;
	private String buyDate_e;
	
	private List<File> upload;  
    // /多个上传文件的类型集合  
    private List<String> uploadContentType;  
   // 多个上传文件的文件名集合  
    private List<String> uploadFileName; 
	
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

	//
	 public List<File> getUpload() {  
		  
	       return upload;  
	    }  
	  
	    public void setUpload(List<File> upload) {  
	  
	       this.upload = upload;  
	    }  
	  
	    public List<String> getUploadContentType() {  
	  
	       return uploadContentType;  
	    }  
	  
	    public void setUploadContentType(List<String> uploadContentType) {  
	  
	       this.uploadContentType = uploadContentType;  
	    }  
	  
	    public List<String> getUploadFileName() {  
	  
	       return uploadFileName;  
	    }  
	  
	    public void setUploadFileName(List<String> uploadFileName) {  
	  
	       this.uploadFileName = uploadFileName;  
	    }  
	    //
	    public String execute() {  
	    	  
	        // 把上传的文件放到指定的路径下  
	        String picture="";
	        String path = ServletActionContext.getServletContext().getRealPath("/uploadList");  
	   
	        // 写到指定的路径中  
	   
	        File file = new File(path);  
	   
	        // 如果指定的路径没有就创建  
	   
	        if (!file.exists()) {  
	   
	            file.mkdirs();  
	        }  
	   
	        // 把得到的文件的集合通过循环的方式读取并放在指定的路径下  
	   
	        for (int i = 0; i < upload.size(); i++) {  
	            try {  
	   
	               //list集合通过get(i)的方式来获取索引  
	            	int picc=uploadFileName.get(i).indexOf(".");
	            	String picname=this.bi.getBook().getBookISBN()+"-"+this.bi.getUnit()+uploadFileName.get(i).substring(picc);
	                System.out.println(picname);
	                picture=picname;
	               FileUtils.copyFile(upload.get(i), new File(file, picname));  
	   
	            } catch (IOException e) {  
	   
	               e.printStackTrace();  
	            }  
	        }  
	        System.out.println(path);
	        path=uploadFileName.get(0);
	        System.out.println(path);
	        if(bid.addBookin(this.bi,picture)==1)
				return SUCCESS;
			else
				return ERROR;
	     }   
   //7
	//public String addBookin()
	//{
	//	if(bid.addBookin(this.bi)==1)
	//		return SUCCESS;
	//	else
	//		return ERROR;
	//}
	
	public String getBookins()
	{
		this.bookinList=bid.getBookinList(this.b.getBookISBN(), this.b.getBookName(), String.valueOf(this.b.getPublisherID()), String.valueOf(this.b.getCategoryID()), this.buyDate_s, this.buyDate_e,this.b.getUnit());
		return SUCCESS;
	}

}
