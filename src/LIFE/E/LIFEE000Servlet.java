package LIFE.E;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.A.LIFEA002Form;
import LIFE.L.DbLky;
import LIFE.UTIL.DBselect;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEA002AX
 */
@WebServlet("/LIFEA002AX")
public class LIFEE000Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String errJsp = "LIFEA002";
	private String norJsp = "LIFEE001";
	private String nextJsp = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEE000Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""};
		LIFEA002Form form = (LIFEA002Form)formBean;
		Msg = confirm(req, form, Msg);
		if (Msg[0] == "") {
			nextJsp = Msg[2];
		} else {
			nextJsp = errJsp;
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

	private String[] confirm(HttpServletRequest req, LIFEA002Form form, String[] msg) {
		// TODO Auto-generated method stub
		String kekno = form.getKekno();
		String member = form.getMember();
		String copcd = form.getCopcd();
		String telephone = form.getTelephone();
		String tskyNum = form.getTskyNum();
		String ikyNum = form.getIkyNum();
		String lkyNum = form.getLkyNum();
		String[] uktk = req.getParameterValues("alter");
		DBselect db = new DBselect();
		
		LIFEE001Form e001Form = new LIFEE001Form();
		e001Form.setKekno(kekno);
		e001Form.setMember(member);
		e001Form.setCopcd(copcd);
		e001Form.setTelephone(telephone);
		e001Form.setTskyNum(tskyNum);
		e001Form.setIkyNum(ikyNum);
		e001Form.setLkyNum(lkyNum);
		
		Vector<Hashtable<String,String>> history = new Vector<Hashtable<String,String>>();
		StringBuffer dhis = new StringBuffer();
		dhis.append("select * from DHISTORY where UKTK = '").append(uktk[0]).append("'");
		try {
			history = db.getVector(dhis.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索失败！";
			return msg;
		}
		if (history == null || history.size() == 0) {
			msg[0] = "不存在该数据！";
			return msg;
		}
		e001Form.setUkContent(history.get(0).get("UKCONTENT"));
		e001Form.setKanama(history.get(0).get("KANAMA"));
		e001Form.setJjscd(history.get(0).get("JJSCD"));
		e001Form.setUserid(history.get(0).get("USERID"));
		e001Form.setUktkno(history.get(0).get("UKTKNO"));
		e001Form.setUktk(uktk[0]);
		req.setAttribute("nextform", e001Form);
		msg[2] = norJsp;
		return msg;
	}


}
