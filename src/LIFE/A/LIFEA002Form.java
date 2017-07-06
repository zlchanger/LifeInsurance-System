package LIFE.A;

import java.util.Vector;

/*
 * 2017/3/25
 */
import javax.servlet.http.HttpServletRequest;


import LIFE.UTIL.NwCommonForm;

public class LIFEA002Form extends NwCommonForm{
	public String kekno = "";
	public String member = "";
	public String copcd = "";
	public String telephone = "";
	public String tskyNum = "";
	public String ikyNum = "";
	public String lkyNum = "";
	public Vector tsky = new Vector();
	public Vector iky = new Vector();
	public Vector lky = new Vector();
	public Vector history = new Vector();
	public String wheret = "";
	public String wherei = "";
	public String wherel = "";
	
	public void setKekno(String kekno) {
		this.kekno = kekno;
	}
	
	public String getKekno() {
		return kekno;
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
	
	public void setMember(String member) {
		this.member = member;
	}
	
	public String getMember() {
		return member;
	}
	
	public void setTskyNum(String tskyNum) {
		this.tskyNum = tskyNum;
	}
	
	public String getTskyNum() {
		return tskyNum;
	}
	
	public void setIkyNum(String ikyNum) {
		this.ikyNum = ikyNum;
	}
	
	public String getIkyNum() {
		return ikyNum;
	}
	
	public void setLkyNum(String lkyNum) {
		this.lkyNum = lkyNum;
	}
	
	public String getLkyNum() {
		return lkyNum;
	}
	
	public void setTsky(Vector tsky) {
		this.tsky = tsky;
	}
	
	public Vector getTsky() {
		return tsky;
	}
	
	public void setIky(Vector iky) {
		this.iky = iky;
	}
	
	public Vector getIky() {
		return iky;
	}
	
	public void setLky(Vector lky) {
		this.lky = lky;
	}
	
	public Vector getLky() {
		return lky;
	}
	
	public void setHistory(Vector history) {
		this.history = history;
	}
	
	public Vector getHistory() {
		return history;
	}
	
	public void setWheret(String wheret) {
		this.wheret = wheret;
	}
	
	public String getWheret() {
		return wheret;
	}
	
	public void setWherei(String wherei) {
		this.wherei = wherei;
	}
	
	public String getWherei() {
		return wherei;
	}
	
	public void setWherel(String wherel) {
		this.wherel = wherel;
	}
	
	public String getWherel() {
		return wherel;
	}
	
	public void setNextList(HttpServletRequest request) {
		return;
	}
}

