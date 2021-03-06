package pro.model;

import java.text.SimpleDateFormat;

public class Bookin {
	

	private Bookstore book;
	private String buyDate;
	private int buyNum;
	private String operator;
	private String unit;

	public Bookin() {}

	public Bookin(Bookstore book, String buyDate, int buyNum, String operator, String unit) {


		this.book = book;
		this.buyDate = buyDate;
		this.buyNum = buyNum;
		this.operator = operator;
		this.unit = unit;
	}

	public Bookstore getBook() {
		return book;
	}

	public void setBook(Bookstore book) {
		this.book = book;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		this.buyDate = tempDate.format(new java.util.Date());
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
