package LIFE.A;

import javax.servlet.http.HttpServletRequest;

import LIFE.UTIL.NwCommonForm;

public class LIFEA001Form extends NwCommonForm{
	public String member = "";
	public String copcd = "";
	public String telephone = "";
	public String insurance = "";
	public String kekno = "";
	
	public void setMember(String member) {
		this.member = member;
	}
	
	public String getMember() {
		return member;
	}
	
	public void setCopcd(String copcd) {
		this.copcd = copcd;
	}
	
	public String getCopcd() {
		return copcd;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setKekno(String kekno) {
		this.kekno = kekno;
	}
	
	public String getKekno() {
		return kekno;
	}
	
	public void setInsurance1(String insurance) {
		this.insurance = insurance;
	}
	
	public String getInsurance1() {
		return insurance;
	}
	
	public void setNextList(HttpServletRequest request) {
		
	}
}
