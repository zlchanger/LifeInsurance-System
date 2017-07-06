package LIFE.A;

import java.util.Hashtable;
import java.util.Vector;

public class LIFEA010Form {
	public Vector<Hashtable<String, String>> offices = new Vector<Hashtable<String, String>>();
	public String jjscd = "";
	public String jgyname = "";
	
	public void setoffices(Vector<Hashtable<String, String>> offices) {
		this.offices = offices;
	}
	
	public Vector<Hashtable<String, String>> getoffices() {
		return offices;
	}
	
	public void setjjscd(String jjscd) {
		this.jjscd = jjscd;
	}
	
	public String getjjscd() {
		return jjscd;
	}
}
