package org.lanqiao.entity;

public class Cart {
	private String gid;
	private String gtitle;
	@Override
	public String toString() {
		return "Cart [gid=" + gid + ", gtitle=" + gtitle + ", gsaleprice="
				+ gsaleprice + ", ginprice=" + ginprice + ", amount=" + amount
				+ "]";
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String gid, String gtitle, double gsaleprice, double ginprice,
			int amount) {
		super();
		this.gid = gid;
		this.gtitle = gtitle;
		this.gsaleprice = gsaleprice;
		this.ginprice = ginprice;
		this.amount = amount;
	}
	private double gsaleprice;
	private double ginprice;
	private int amount;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public double getGsaleprice() {
		return gsaleprice;
	}
	public void setGsaleprice(double gsaleprice) {
		this.gsaleprice = gsaleprice;
	}
	public double getGinprice() {
		return ginprice;
	}
	public void setGinprice(double ginprice) {
		this.ginprice = ginprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
