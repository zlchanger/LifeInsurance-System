package LIFE.A;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.C.LIFEC001Form;
import LIFE.D.LIFED001Form;
import LIFE.I.DbIky;
import LIFE.L.DbLky;
import LIFE.T.DbTsky;
import LIFE.UTIL.DChange;
import LIFE.UTIL.DConstants;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

public class LIFEA003Servlet extends NwCommonServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errJsp = "LIFEA003";
	private String nextJsp = "";
	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		String[] Msg = {"","",""};
		DChange dc = new DChange();
		String handleone = req.getParameter("oneselect");
		String handletwo = req.getParameter("twoselect");
		String[] checkT = req.getParameterValues("tsky");
		String[] checkI = req.getParameterValues("iky");
		String[] checkL = req.getParameterValues("lky");
		Vector<Hashtable<String,String>> tsky = new Vector<Hashtable<String,String>>();
		Vector<Hashtable<String,String>> iky = new Vector<Hashtable<String,String>>();
		Vector<Hashtable<String,String>> lky = new Vector<Hashtable<String,String>>();
		Vector<Hashtable<String,String>> first = new Vector<Hashtable<String,String>>();
		if (checkL != null && checkL.length > 0) {
			DbLky dblky = new DbLky();
			lky = dblky.getLkysByKekno(checkL, Msg);
			first = lky;
		}
		if (checkI != null && checkI.length > 0) {
			DbIky dbiky = new DbIky();
			iky = dbiky.getIkysByKekno(checkI, Msg);
			first = iky;
		}
		if (checkT != null && checkT.length > 0) {
			DbTsky dbtsky = new DbTsky();
			tsky = dbtsky.getTskysByKekno(checkT, Msg);
			first = tsky;
		}		
		// ◊…—Ø
		if(DConstants.handleone.equals(handleone)){
			
		//  ‹¿Ì
		} else if (DConstants.handletwo.equals(handleone)) {
			if (DConstants.consuitone.equals(handletwo)) {
				if((tsky == null || tsky.size() == 0) && (iky == null || iky.size() == 0) &&
						(lky == null || lky.size() == 0)) {
					Msg[0] = "ERR001";
					Msg[2] = errJsp;
					nextJsp = errJsp;
				} else {
					LIFEC001Form lifec001 = new LIFEC001Form();
					lifec001.settsky(tsky);
					lifec001.setlky(lky);
					lifec001.setiky(iky);
					lifec001.setTele(dc.teleChange((String)first.get(0).get("TELE")));
					lifec001.setZipcode((String)first.get(0).get("ZIPCODE"));
					lifec001.setAddre((String)first.get(0).get("ADDRE"));
					lifec001.setPhysicalcase(dc.physicalChange((String)first.get(0).get("PHYSICALCASE")));
					lifec001.setOccupation((String)first.get(0).get("KOCCUPATION"));
					lifec001.setKamanax((String)first.get(0).get("KAMANAX"));
					lifec001.setKamanam((String)first.get(0).get("KAMANAM"));
					lifec001.setBirthday(dc.toYYMMDD((String)first.get(0).get("BIRTHDAY")));
					lifec001.setSex(dc.sexShow((String)first.get(0).get("SEX")));
					req.setAttribute("nextform", lifec001);
					req.setAttribute("reUktkno", "");
					nextJsp = "LIFEC001";
					Msg[2] = nextJsp;
				}
			} else if (DConstants.consuittwo.equals(handletwo)) {
				if((tsky == null || tsky.size() == 0) && (iky == null || iky.size() == 0) &&
						(lky == null || lky.size() == 0)) {
					Msg[0] = "ERR001";
					Msg[2] = errJsp;
					nextJsp = errJsp;
				} else {
					LIFED001Form lifed001 = new LIFED001Form();
					lifed001.settsky(tsky);
					lifed001.setlky(lky);
					lifed001.setiky(iky);
					lifed001.setKtele(dc.teleChange((String)first.get(0).get("KTELE")));
					lifed001.setKzipcode((String)first.get(0).get("KZIPCODE"));
					lifed001.setKaddre((String)first.get(0).get("KADDRE"));
					lifed001.setKphysical(dc.physicalChange((String)first.get(0).get("KPHYSICAL")));
					lifed001.setKoccupation((String)first.get(0).get("KOCCUPATION"));
					lifed001.setKamannx((String)first.get(0).get("KAMANNX"));
					lifed001.setKamannm((String)first.get(0).get("KAMANNM"));
					lifed001.setKbirthday(dc.toYYMMDD((String)first.get(0).get("KBIRTHDAY")));
					lifed001.setKsex(dc.sexShow((String)first.get(0).get("KSEX")));
					req.setAttribute("nextform", lifed001);
					req.setAttribute("reUktkno", "");
					nextJsp = "LIFED001";
					Msg[2] = nextJsp;
				}
			}
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

}
