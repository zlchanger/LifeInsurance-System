package LIFE.Z;

import java.util.Hashtable;
import java.util.Vector;

public class LIFEZ000Form {
	public Vector<Hashtable<String, String>> user = new Vector<Hashtable<String, String>>();
	public String jjscd = "";
	public String userid = "";
	
	public void setuser(Vector<Hashtable<String, String>> user) {
		this.user = user;
	}
	
	public Vector<Hashtable<String, String>> getuser() {
		return user;
	}
	
	public void setjjscd(String jjscd){
		this.jjscd = jjscd;
	}
	
	public String getjjscd() {
		return jjscd;
	}
	
	public void setuserid(String userid) {
		this.userid = userid;
	}
	
	public String getuserid() {
		return userid;
	}
}
