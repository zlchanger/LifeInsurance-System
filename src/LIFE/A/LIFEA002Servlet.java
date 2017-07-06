package LIFE.A;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.UTIL.DBselect;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

public class LIFEA002Servlet extends NwCommonServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errJsp = "LIFEA002";
	private String norJsp = "LIFEA003";
	private String nextJsp = "";
	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""};
		confirm(req,Msg);
		if (Msg[0] == "") {
			nextJsp = norJsp;
		} else {
			nextJsp = errJsp;
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

	private String[] confirm(HttpServletRequest req, String[] msg) {
		// TODO Auto-generated method stub
		String wheret = (String)req.getSession().getAttribute("tdata");
		String wherei = (String)req.getSession().getAttribute("idata");
		String wherel = (String)req.getSession().getAttribute("ldata");
		DBselect db = new DBselect();
		Vector<Hashtable<String, String>> tsky = new Vector<Hashtable<String, String>>();
		Vector<Hashtable<String, String>> iky = new Vector<Hashtable<String, String>>();
		Vector<Hashtable<String, String>> lky = new Vector<Hashtable<String, String>>();
		try {
			tsky = db.getVector(wheret);
			iky = db.getVector(wherei);
			lky = db.getVector(wherel);
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		LIFEA003Form nextform = new LIFEA003Form();
		if ((tsky == null || tsky.size() == 0) && (iky == null || iky.size() == 0) &&
				(lky == null || lky.size() == 0)) {
			msg[0] = "ERR001";
			msg[2] = errJsp;
			return msg;
		}
		if (tsky != null || tsky.size() > 0) {
			nextform.setTsky(tsky);
		}
		if (iky != null || iky.size() > 0) {
			nextform.setIky(iky);
		}
		if (lky != null || lky.size() > 0) {
			nextform.setLky(lky);
		}
		int cunt = 0;
		cunt = tsky.size() + iky.size() + lky.size();
		nextform.setCount(cunt);
		req.setAttribute("LIFEA003form", nextform);
		return msg;
	}

}
