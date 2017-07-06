package LIFE.UTIL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import LIFE.C.LIFEC001Form;

public class DHistorytblUpd {
	public String uktkno = "";
	public String sido = "";
	public String kekno = "";
	public String ukcontent = "";
	public String kanama = "";
	public String jjscd = "";
	public String userid = "";
	public String ukymd = "";
	public String uktime = "";
	public String czlcd = "";
	public String defeflg = "";
	
	public void init() {
		uktkno = "";
		sido = "";
		kekno = "";
		ukcontent = "";
		kanama = "";
		jjscd = "";
		userid = "";
		ukymd = "";
		uktime = "";
		czlcd = "";
		defeflg = "0";
	}
	
	public void setUktkno(String uktkno) {
		this.uktkno = uktkno;
	}
	
	public String getUktkno() {
		return uktkno;
	}
	
	public void setSido(String sido) {
		this.sido = sido;
	}
	
	public String getSido() {
		return sido;
	}
	
	public void setUkcontent(String ukcontent) {
		this.ukcontent = ukcontent;
	}
	
	public String getUkcontent() {
		return ukcontent;
	}
	
	public void setKanama(String kanama) {
		this.kanama = kanama;
	}
	
	public String getKanama() {
		return kanama;
	}
	
	public void setJjscd(String jjscd) {
		this.jjscd = jjscd;
	}
	
	public String getJjscd() {
		return jjscd;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUkymd(String ukymd) {
		this.ukymd = ukymd;
	}
	
	public String getUkymd() {
		return ukymd;
	}
	
	public void setUktime(String uktime) {
		this.uktime = uktime;
	}
	
	public String getUktime() {
		return uktime;
	}
	
	public void setKekno(String kekno) {
		this.kekno = kekno;
	}
	
	public String getKekno() {
		return kekno;
	}
	// 业务cd
	public void setCzlcd(String czlcd) {
		this.czlcd = czlcd;
	}
	
	public String getCzlcd() {
		return czlcd;
	}
	// 删除区分
	public void setDefeflg(String defeflg) {
		this.defeflg = defeflg;
	}
	
	public String getDefeflg() {
		return defeflg;
	}
	public void setData(Hashtable<String, String> tilvec, String uktkno, String ukc, String kanama, HttpSession session, String czl) {
		init();
		setUktkno(uktkno);
		setSido(tilvec.get("SEIDO"));
		setKekno(tilvec.get("KEKNO"));
		setUkcontent(ukc);
		setKanama(kanama);
		if (session!=null) {
			setJjscd((String)session.getAttribute("jjscd"));
			setUserid((String)session.getAttribute("userid"));
		} else {
			setJjscd("");
			setUserid("");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String ukymd = String.valueOf(df.format(new Date())).substring(0,10);
		String uktime = String.valueOf(df.format(new Date())).substring(11);
		setUkymd(ukymd);
		setUktime(uktime);
		setCzlcd(czl);
	}
	
	public String executeDhi() {
		StringBuffer qry = new StringBuffer();
		StringBuffer qry1 = new StringBuffer();
		StringBuffer query = new StringBuffer();
		qry.append(" UKTKNO");
		qry1.append("'").append(uktkno).append("', ");
		qry.append(", SIDO");
		qry1.append("'").append(sido).append("', ");
		qry.append(", KEKNO");
		qry1.append("'").append(kekno).append("', ");
		qry.append(", UKCONTENT");
		qry1.append("'").append(ukcontent).append("', ");
		qry.append(", KANAMA");
		qry1.append("'").append(kanama).append("', ");
		qry.append(", JJSCD");
		qry1.append("'").append(jjscd).append("', ");
		qry.append(", USERID");
		qry1.append("'").append(userid).append("', ");
		qry.append(", UKYMD");
		qry1.append("'").append(ukymd).append("', ");
		qry.append(", UKTIME");
		qry1.append("'").append(uktime).append("', ");
		qry.append(", CZLCD");
		qry1.append("'").append(czlcd).append("', ");
		qry.append(", DEFEFLG");
		qry1.append("'").append(defeflg).append("' ");
		
		query.append("insert into DHISTORY (");
		query.append(qry.toString());
		query.append(") values (");
		query.append(qry1.toString()).append(")");
		return query.toString();
	}
	
	public String executeDhi2(String uktkno) {
		StringBuffer qry = new StringBuffer();
		qry.append("update DHISTORY set DEFEFLG = '").append("1").append("'");
		qry.append(" where UKTKNO = '").append(uktkno).append("'");
		return qry.toString();
	}
}
