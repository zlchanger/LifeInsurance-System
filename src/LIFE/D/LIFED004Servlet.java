package LIFE.D;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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

/**
 * Servlet implementation class LIFED004Servlet
 */
@WebServlet("/LIFED004Servlet")
public class LIFED004Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "LIFEA004";
	private String errJsp = "LIFED004";
	private DChange dc = new DChange();
	private String[] Msg = {"","",""};
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFED004Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String actionexcute = (String)req.getParameter("actionexcute");
		if ("alter".equals(actionexcute)) {
			nextJsp = "LIFED003";
			LIFED001Form form = (LIFED001Form)formBean;
			String namflg = (String)req.getParameter("namflg");
			form.setnameflg(namflg);
			String birflg = (String)req.getParameter("birflg");
			form.setbirthflg(birflg);
			String telflg = (String)req.getParameter("telflg");
			form.setteleflg(telflg);
			String sexflg = (String)req.getParameter("sexflg");
			form.setsexflg(sexflg);
			String wheflg = (String)req.getParameter("wheflg");
			form.setwheflg(wheflg);
			String othflg = (String)req.getParameter("othflg");
			form.setothflg(othflg);
			req.setAttribute("nextform", form);
			String uktkno = (String)req.getParameter("reUktkno");
			req.setAttribute("reUktkno", uktkno);
		} else if ("implement".equals(actionexcute)) {
			exec(req, res, formBean);
		}
		if (Msg[0] != "") {
			nextJsp = errJsp;
		} else {
			nextJsp = "LIFEA004";
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

	private void exec(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean) {
		// TODO Auto-generated method stub
		LIFED001Form form = (LIFED001Form)formBean;
		Vector<String> query = new Vector<String>();
		Vector<Hashtable<String, String>> tsky = (Vector<Hashtable<String, String>>) form.gettsky();
		Vector<Hashtable<String, String>> iky = (Vector<Hashtable<String, String>>) form.getiky();
		Vector<Hashtable<String, String>> lky = (Vector<Hashtable<String, String>>) form.getlky();
		String uktkno = (String)req.getParameter("reUktkno");
		String namflg = (String)req.getParameter("namflg");
		String birthflg = (String)req.getParameter("birflg");
		String teleflg = (String)req.getParameter("telflg");
		String sexflg = (String)req.getParameter("sexflg");
		String wheflg = (String)req.getParameter("wheflg");
		String othflg = (String)req.getParameter("othflg");
		if ((tsky == null || tsky.size() == 0) && (iky == null || iky.size() == 0) &&
				(lky == null || lky.size() == 0)) {
			Msg[0] = "ERR001";
		}
		if (tsky != null && tsky.size() > 0) {
			StringBuffer sb = new StringBuffer();
			int numflg = 0;
			sb.append("update TSKY set ");
			if ("1".equals(namflg)) {
				sb.append("KAMANNX = '").append(form.getKamannx().trim()).append("', ");
				sb.append("KAMANNM = '").append(form.getKamannm().trim()).append("'");
				numflg++;
			}
			if ("1".equals(birthflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KBIRTHDAY = '").append(dc.toYMD((String)form.getKbirthday())).append("'");
				numflg++;
			}
			if ("1".equals(sexflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KSEX = '").append(dc.sexcode(form.getKsex().trim())).append("'");
				numflg++;
			}
			if ("1".equals(teleflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KTELE = '").append(dc.telecode(form.getKtele().trim())).append("'");
				numflg++;
			}
			if ("1".equals(wheflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KZIPCODE = '").append(form.getKzipcode().trim()).append("', ");
				sb.append("KADDRE = '").append(form.getKaddre().trim()).append("'");
				numflg++;
			}
			if ("1".equals(othflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KPHYSICAL = '").append(dc.physicalCode(form.getKphysical().trim())).append("', ");
				sb.append("KOCCUPATION = '").append(form.getKoccupation()).append("'");
			}
			if (numflg > 0) {
				sb.append(", ");
			}
			sb.append("DELE = '1' ");
			StringBuffer wheres = new StringBuffer();
			wheres.append("where kekno in ( ");
			for(int i = 0; i < tsky.size()-1; i++) {
				wheres.append("'").append(tsky.get(i).get("KEKNO")).append("', ");
			}
			wheres.append("'").append(tsky.get(tsky.size()-1).get("KEKNO")).append("' )");
			sb.append(wheres.toString());
			query.add(sb.toString());
		}
		if (iky != null && iky.size() > 0) {
			StringBuffer sb = new StringBuffer();
			int numflg = 0;
			sb.append("update IKY set ");
			if ("1".equals(namflg)) {
				sb.append("KAMANNX = '").append(form.getKamannx().trim()).append("', ");
				sb.append("KAMANNM = '").append(form.getKamannm().trim()).append("'");
				numflg++;
			}
			if ("1".equals(birthflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KBIRTHDAY = '").append(dc.toYMD((String)form.getKbirthday())).append("'");
				numflg++;
			}
			if ("1".equals(sexflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KSEX = '").append(dc.sexcode(form.getKsex().trim())).append("'");
				numflg++;
			}
			if ("1".equals(teleflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KTELE = '").append(dc.telecode(form.getKtele().trim())).append("'");
				numflg++;
			}
			if ("1".equals(wheflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KZIPCODE = '").append(form.getKzipcode().trim()).append("', ");
				sb.append("KADDRE = '").append(form.getKaddre().trim()).append("'");
				numflg++;
			}
			if ("1".equals(othflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KPHYSICAL = '").append(dc.physicalCode(form.getKphysical().trim())).append("', ");
				sb.append("KOCCUPATION = '").append(form.getKoccupation()).append("'");
			}
			if (numflg > 0) {
				sb.append(", ");
			}
			sb.append("DELE = '1' ");
			StringBuffer wheres = new StringBuffer();
			wheres.append("where kekno in ( ");
			for(int i = 0; i < iky.size()-1; i++) {
				wheres.append("'").append(iky.get(i).get("KEKNO")).append("', ");
			}
			wheres.append("'").append(iky.get(iky.size()-1).get("KEKNO")).append("' )");
			sb.append(wheres.toString());
			query.add(sb.toString());
		}
		if (lky != null && lky.size() > 0) {
			StringBuffer sb = new StringBuffer();
			int numflg = 0;
			sb.append("update LKY set ");
			if ("1".equals(namflg)) {
				sb.append("KAMANNX = '").append(form.getKamannx().trim()).append("', ");
				sb.append("KAMANNM = '").append(form.getKamannm().trim()).append("'");
				numflg++;
			}
			if ("1".equals(birthflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KBIRTHDAY = '").append(dc.toYMD((String)form.getKbirthday())).append("'");
				numflg++;
			}
			if ("1".equals(sexflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KSEX = '").append(dc.sexcode(form.getKsex().trim())).append("'");
				numflg++;
			}
			if ("1".equals(teleflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KTELE = '").append(dc.telecode(form.getKtele().trim())).append("'");
				numflg++;
			}
			if ("1".equals(wheflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KZIPCODE = '").append(form.getKzipcode().trim()).append("', ");
				sb.append("KADDRE = '").append(form.getKaddre().trim()).append("'");
				numflg++;
			}
			if ("1".equals(othflg)) {
				if (numflg > 0) {
					sb.append(", ");
				}
				sb.append("KPHYSICAL = '").append(dc.physicalCode(form.getKphysical().trim())).append("', ");
				sb.append("KOCCUPATION = '").append(form.getKoccupation()).append("'");
			}
			if (numflg > 0) {
				sb.append(", ");
			}
			sb.append("DELE = '1' ");
			StringBuffer wheres = new StringBuffer();
			wheres.append("where kekno in ( ");
			for(int i = 0; i < lky.size()-1; i++) {
				wheres.append("'").append(lky.get(i).get("KEKNO")).append("', ");
			}
			wheres.append("'").append(lky.get(lky.size()-1).get("KEKNO")).append("' )");
			sb.append(wheres.toString());
			query.add(sb.toString());
		}
		
		TilKInfoChgUpd tilChg = new TilKInfoChgUpd();
		tilChg.setData(form);
		tilChg.setFlg(namflg, birthflg, teleflg, sexflg, wheflg, othflg);
		query.add(tilChg.updateTil(uktkno));
		
		String kanama = "";
		String ukcontent = "被共济者情报变更(返送受付)";
		String czlcd = "D01";
		HttpSession session = req.getSession(false); 
		DHistorytblUpd dhis = new DHistorytblUpd();
		query.add(dhis.executeDhi2(uktkno));
		if (tsky != null && tsky.size() > 0) {
			for (int i = 0; i < tsky.size(); i++) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)tsky.get(i);
				kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
				dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
				query.add(dhis.executeDhi());
			}
		}
		if (iky != null && iky.size() > 0) {
			for (int i = 0; i < iky.size(); i++) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)iky.get(i);
				kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
				dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
				query.add(dhis.executeDhi());
			}
		}
		if (lky != null && lky.size() > 0) {
			for (int i = 0; i < iky.size(); i++) {
				Hashtable<String, String> tilvec = (Hashtable<String, String>)lky.get(i);
				kanama = tilvec.get("KAMANAX") + " " + tilvec.get("KAMANAM");
				dhis.setData(tilvec, uktkno, ukcontent, kanama, session, czlcd);
				query.add(dhis.executeDhi());
			}
		}
		
		DBselect db = new DBselect();
		try {
			db.sqlexcute(query);
			Msg[1]="更新成功！受付完了！";
		}catch(Exception e){
			e.printStackTrace();
			Msg[0] = "ERR001";
		}
	}
}
