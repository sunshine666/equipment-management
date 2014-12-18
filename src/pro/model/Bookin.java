package pro.model;

import java.text.SimpleDateFormat;

public class Bookin {
	

	private Bookstore book;
	private String buyDate;
	private int buyNum;
	private String operator;
	private String unit;
	private String jingshou;

	public Bookin() {}

	public Bookin(Bookstore book, String buyDate, int buyNum, String operator, String unit,	String jingshou) {


		this.book = book;
		this.buyDate = buyDate;
		this.buyNum = buyNum;
		this.operator = operator;
		this.unit = unit;
		this.jingshou=jingshou;
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
		this.buyDate = buyDate;
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
	
	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}
	
}
