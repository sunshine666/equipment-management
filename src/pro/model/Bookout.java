package pro.model;

import java.text.SimpleDateFormat;

public class Bookout {
	
	private Bookstore book;
	private String saleDate;
	private int SaleNum;
	private double allPrice;
	private String operator;
	private String unit;

	public Bookout() {}

	public Bookout(Bookstore book, String saleDate, int saleNum,
			double allPrice, String operator, String unit) {


		this.book = book;
		this.saleDate = saleDate;
		this.SaleNum = saleNum;
		this.allPrice = allPrice;
		this.operator = operator;
		this.unit = unit;
	}
	
	public Bookstore getBook() {
		return book;
	}

	public void setBook(Bookstore book) {
		this.book = book;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		this.saleDate = tempDate.format(new java.util.Date());
	}

	public int getSaleNum() {
		return SaleNum;
	}

	public void setSaleNum(int saleNum) {
		SaleNum = saleNum;
	}

	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
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
