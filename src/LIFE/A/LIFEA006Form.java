package LIFE.A;

import javax.servlet.http.HttpServletRequest;

import LIFE.UTIL.NwCommonForm;

public class LIFEA006Form extends NwCommonForm{
	
	private String jyscd = "";
	private String userid = "";
	private String passwd = "";
	private String newpasswd = "";
	private String confirmpasswd = "";
	
	public void setJyscd(String jyscd) {
		this.jyscd = jyscd;
	}
	
	public String getJyscd() {
		return jyscd;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setNewpasswd(String newpasswd) {
		this.newpasswd = newpasswd;
	}
	
	public String getNewpasswd() {
		return newpasswd;
	}
	
	public void setConfirmpasswd(String confirmpasswd) {
		this.confirmpasswd = confirmpasswd;
	}
	
	public String getConfirmpasswd() {
		return confirmpasswd;
	}
	
	public void setNextList(HttpServletRequest request) {
	}
}
