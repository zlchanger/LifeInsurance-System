package LIFE.A;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import LIFE.UTIL.NwCommonForm;

public class LIFEA003Form extends NwCommonForm{
	public Vector tsky = new Vector();
	public Vector iky = new Vector();
	public Vector lky = new Vector();
	public int count;
	
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
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setNextList(HttpServletRequest request) {
		return;
	}
}
