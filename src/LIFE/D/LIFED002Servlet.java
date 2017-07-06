package LIFE.D;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LIFE.D.LIFED001Form;
import LIFE.D.TilKInfoChgUpd;
import LIFE.UTIL.DBselect;
import LIFE.UTIL.DChange;
import LIFE.UTIL.DHistorytblUpd;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

public class LIFED002Servlet extends NwCommonServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nextJsp = "LIFEA001";
	private String errJsp = "LIFED002";
	private DChange dc = new DChange();
	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""}; 
		LIFED001Form form = (LIFED001Form)formBean;
		String actionexcute = (String)req.getParameter("actionexcute");
		if ("alter".equals(actionexcute)) {
			nextJsp = "LIFED001";
			req.setAttribute("nextform", form);
			String uktkno = (String)req.getParameter("reUktkno");
			req.setAttribute("reUktkno", uktkno);
		} else if ("implement".equals(actionexcute)) {
			excute(req, form, Msg);
		}
		if (Msg[0] != "") {
			nextJsp = errJsp;
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

	private void excute(HttpServletRequest req, LIFED001Form form, String[] msg) {
		Vector<String> query = new Vector<String>();
		Vector<Hashtable<String, String>> tsky = (Vector<Hashtable<String, String>>) form.gettsky();
		Vector<Hashtable<String, String>> iky = (Vector<Hashtable<String, String>>) form.getiky();
		Vector<Hashtable<String, String>> lky = (Vector<Hashtable<String, String>>) form.getlky();
		String uktkno = (String)req.getParameter("reUktkno");
		form.setnameflg((String)req.getParameter("namflg"));
		form.setbirthflg((String)req.getParameter("birflg"));
		form.setteleflg((String)req.getParameter("telflg"));
		form.setsexflg((String)req.getParameter("sexflg"));
		form.setwheflg((String)req.getParameter("wheflg"));
		form.setothflg((String)req.getParameter("othflg"));
		if (uktkno == null || uktkno == "") {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			uktkno = String.valueOf(df.format(new Date())).substring(2);
			TilKInfoChgUpd tilChg = new TilKInfoChgUpd();
			if (tsky != null && tsky.size() > 0) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)tsky.get(0);
				tilChg.setData(tilvec, form, uktkno);
				query.add(tilChg.executeTil());
			}
			if (iky != null && iky.size() > 0) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)iky.get(0);
				tilChg.setData(tilvec, form, uktkno);
				query.add(tilChg.executeTil());
			}
			if (lky != null && lky.size() > 0) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)lky.get(0);
				tilChg.setData(tilvec, form, uktkno);
				query.add(tilChg.executeTil());
			}
			String ukcontent = "被共济者情报变更(初回受付)";
			String czlcd = "D01";
			HttpSession session = req.getSession(false); 
			DHistorytblUpd dhis = new DHistorytblUpd();
			if (tsky != null && tsky.size() > 0) {
				for (int i = 0; i < tsky.size(); i++) {
					Hashtable<String, String> tilvec = (Hashtable<String, String>)tsky.get(i);
					String kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
					dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
					query.add(dhis.executeDhi());
				}
			}
			if (iky != null && iky.size() > 0) {
				for (int i = 0; i < iky.size(); i++) {
					Hashtable<String, String> tilvec = (Hashtable<String, String>)iky.get(i);
					String kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
					dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
					query.add(dhis.executeDhi());
				}
			}
			if (lky != null && lky.size() > 0) {
				for (int i = 0; i < iky.size(); i++) {
					Hashtable<String, String> tilvec = (Hashtable<String, String>)lky.get(i);
					String kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
					dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
					query.add(dhis.executeDhi());
				}
			}
		} else {
			TilKInfoChgUpd tilChg = new TilKInfoChgUpd();
			query.add(tilChg.dele(uktkno));
			if (tsky != null && tsky.size() > 0) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)tsky.get(0);
				tilChg.setData(tilvec, form, uktkno);
				query.add(tilChg.executeTil());
			}
			if (iky != null && iky.size() > 0) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)iky.get(0);
				tilChg.setData(tilvec, form, uktkno);
				query.add(tilChg.executeTil());
			}
			if (lky != null && lky.size() > 0) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)lky.get(0);
				tilChg.setData(tilvec, form, uktkno);
				query.add(tilChg.executeTil());
			}
			String ukcontent = "被共济者情报变更(契约修正)";
			String czlcd = "D01";
			HttpSession session = req.getSession(false); 
			DHistorytblUpd dhis = new DHistorytblUpd();
			query.add(dhis.executeDhi2(uktkno));
			if (tsky != null && tsky.size() > 0) {
				for (int i = 0; i < tsky.size(); i++) {
					Hashtable<String, String> tilvec = (Hashtable<String, String>)tsky.get(i);
					String kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
					dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
					query.add(dhis.executeDhi());
				}
			}
			if (iky != null && iky.size() > 0) {
				for (int i = 0; i < iky.size(); i++) {
					Hashtable<String, String> tilvec = (Hashtable<String, String>)iky.get(i);
					String kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
					dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
					query.add(dhis.executeDhi());
				}
			}
			if (lky != null && lky.size() > 0) {
				for (int i = 0; i < iky.size(); i++) {
					Hashtable<String, String> tilvec = (Hashtable<String, String>)lky.get(i);
					String kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
					dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
					query.add(dhis.executeDhi());
				}
			}
		}
		DBselect db = new DBselect();
		try {
			db.sqlexcute(query);
			msg[1]="更新成功！受付完了！";
		}catch(Exception e){
			e.printStackTrace();
			msg[0] = "ERR001";
		}
		
	}
}
