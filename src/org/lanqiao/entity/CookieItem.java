package org.lanqiao.entity;

public class CookieItem {
	private String gid;
	private int amount;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public CookieItem(String gid, int amount) {
		super();
		this.gid = gid;
		this.amount = amount;
	}
	public CookieItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CookieItem [gid=" + gid + ", amount=" + amount + "]";
	}
	
}
