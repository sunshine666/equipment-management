package pro.model;

public class Bookstore {
	
	private String bookISBN;
	private String bookName;
	private String bookDesc;
	private int publisherID;
	private String author;
	private int categoryID;
	private double salePrice;
	private int nowNum;
	private int status;
	private String unit;
	private String picadr;

	public Bookstore() {}

	public Bookstore(String bookISBN,String bookName,String bookDesc,int publisherID,String author,int categoryID,double salePrice, int nowNum, int status,String unit,String picadr) {
		
		this.bookISBN=bookISBN;
		this.bookName=bookName;
		this.bookDesc=bookDesc;
		this.publisherID=publisherID;
		this.author=author;
		this.categoryID=categoryID;
		this.salePrice=salePrice;
		this.nowNum = nowNum;
		this.status = status;
		this.unit = unit;
		this.picadr = picadr;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public int getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getNowNum() {
		return nowNum;
	}

	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getPicadr() {
		return picadr;
	}

	public void setPicadr(String picadr) {
		this.picadr = picadr;
	}

}
