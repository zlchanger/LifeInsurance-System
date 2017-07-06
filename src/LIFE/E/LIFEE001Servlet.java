package LIFE.E;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LIFE.A.LIFEA002Form;
import LIFE.UTIL.DBselect;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEE001Servlet
 */
@WebServlet("/LIFEE001Servlet")
public class LIFEE001Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "";
	private String errJsp = "LIFEE001";
	private DBselect db = new DBselect();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEE001Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""};
		String actionexcute = (String)req.getParameter("actionexcute");
		LIFEE001Form form = (LIFEE001Form)formBean;
		if ("back".equals(actionexcute)) {
			Msg = excuteBack(req, res, form, Msg);
		} else if ("implement".equals(actionexcute)) {
			Msg = excuteImplement(req, res, form, Msg);
		}
		
		if (Msg[0] == "" && Msg[2] != "") {
			nextJsp = Msg[2];
		} else {
			nextJsp = errJsp;
			req.setAttribute("nextform", (LIFEE001Form)formBean);
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

	private String[] excuteImplement(HttpServletRequest req, HttpServletResponse res, LIFEE001Form form, String[] msg) {
		// TODO Auto-generated method stub
		String uktkno = (String)form.getUktkno();
		String uktk = (String)form.getUktk();
		String jjscd = (String)form.getJjscd();
		String userid = (String)form.getUserid();
		String tskyNum = (String)req.getParameter("tskyNum");
		String ikyNum = (String)req.getParameter("ikyNum");
		String lkyNum = (String)req.getParameter("lkyNum");
		
		Vector<Hashtable<String,String>> users = new Vector<Hashtable<String,String>>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from USERS where JGYCD = '").append(jjscd).append("'");
		try {
			users = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索失败！";
			return msg;
		}
		if (users == null || users.size() == 0) {
			msg[0] = "不存在该事务所CD！";
			return msg;
		}
		ArrayList<String> user = new ArrayList<String>();
		for (int i = 0; i < users.size(); i++) {
			String usid = (String)users.get(i).get("USERID");
			user.add(usid);
		}
		if (!user.contains(userid)) {
			msg[0] = "此事务所不存在该用户ID！";
			return msg;
		}
		
		Vector<Hashtable<String,String>> his = new Vector<Hashtable<String,String>>();
		sb = new StringBuffer();
		sb.append("select * from DHISTORY where UKTK = '").append(uktk).append("'");
		try {
			his = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索失败！";
			return msg;
		}
		if (his == null || his.size() == 0) {
			msg[0] = "不存在该历史记录！";
			return msg;
		}
		String _uktkno = his.get(0).get("UKTKNO");
		if (!uktkno.equals(_uktkno)) {
			msg[0] = "历史记录错误！";
			return msg;
		}
		
		form.setTskyNum(tskyNum);
		form.setIkyNum(ikyNum);
		form.setLkyNum(lkyNum);
		form.setUktk(uktk);
		req.setAttribute("nextform", form);
		msg[2] = "LIFEE002";
 		return msg;
	}

	private String[] excuteBack(HttpServletRequest req, HttpServletResponse res, LIFEE001Form form, String[] msg) {
		// TODO Auto-generated method stub
		String kekno = (String)form.getKekno();
		String member = (String)form.getMember();
		String copcd = (String)form.getCopcd();
		String telephone = (String)form.getTelephone();
		String tskyNum = (String)req.getParameter("tskyNum");
		String ikyNum = (String)req.getParameter("ikyNum");
		String lkyNum = (String)req.getParameter("lkyNum");
		
		LIFEA002Form a002form = new LIFEA002Form();
		a002form.setKekno(kekno);
		a002form.setMember(member);
		a002form.setCopcd(copcd);
		a002form.setTelephone(telephone);
		a002form.setTskyNum(tskyNum);
		a002form.setIkyNum(ikyNum);
		a002form.setLkyNum(lkyNum);
		
		HttpSession session = req.getSession(false);
		String wheret = (String)req.getSession().getAttribute("tdata");
		String wherei = (String)req.getSession().getAttribute("idata");
		String wherel = (String)req.getSession().getAttribute("ldata");
		a002form.setWheret(wheret);
		a002form.setWherei(wherei);
		a002form.setWherel(wherel);
		
		// 历史记录表
		Vector history = new Vector();
		StringBuffer dhis = new StringBuffer();
		dhis.append("select * from DHISTORY where KEKNO = '").append(kekno).append("'");
		try {
			history = db.getVector(dhis.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索失败！";
			return msg;
		}
		a002form.setHistory(history);
		req.setAttribute("formdata", a002form);
		msg[2] = "LIFEA002";
		return msg;
	}


}
