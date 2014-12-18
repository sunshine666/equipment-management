package pro.model;

import java.text.SimpleDateFormat;

public class Bookout {
	
	private Bookstore book;
	private String saleDate;
	private int SaleNum;
	private double allPrice;
	private String operator;
	private String unit;
	private String jingshou;
	private String deldesc;

	public Bookout() {}

	public Bookout(Bookstore book, String saleDate, int saleNum,
			double allPrice, String operator, String unit,String jingshou,String deldesc) {


		this.book = book;
		this.saleDate = saleDate;
		this.SaleNum = saleNum;
		this.allPrice = allPrice;
		this.operator = operator;
		this.unit = unit;
		this.jingshou=jingshou;
		this.deldesc=deldesc;
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
		this.saleDate = saleDate;
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
	
	public String getDeldesc() {
		return deldesc;
	}

	public void setDeldesc(String deldesc) {
		this.deldesc = deldesc;
	}
	
	public String getJingshou() {
		return jingshou;
	}

	public void setJingshou(String jingshou) {
		this.jingshou = jingshou;
	}
	
	

}
