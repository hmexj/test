package org.lanqiao.entity;

public class User {
	private String userid;
	private String email;
	private String loginid;
	private String upassword;
	private String usex;
	private String uaddress;
	private String utel;
	private String ustateid;
	private String uroleid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUstateid() {
		return ustateid;
	}
	public void setUstateid(String ustateid) {
		this.ustateid = ustateid;
	}
	public String getUroleid() {
		return uroleid;
	}
	public void setUroleid(String uroleid) {
		this.uroleid = uroleid;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public User(String userid, String uemail, String uloginid,
			String upassword, String usex, String uaddress, String utel,
			String ustateid, String uroleid) {
		super();
		this.userid = userid;
		this.email = uemail;
		this.loginid = uloginid;
		this.upassword = upassword;
		this.usex = usex;
		this.uaddress = uaddress;
		this.utel = utel;
		this.ustateid = ustateid;
		this.uroleid = uroleid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", uemail=" + email + ", uloginid="
				+ loginid + ", upassword=" + upassword + ", usex=" + usex
				+ ", uaddress=" + uaddress + ", utel=" + utel + ", ustateid="
				+ ustateid + ", uroleid=" + uroleid + "]";
	}
	
}
