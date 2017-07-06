package LIFE.E;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class LIFEE002Servlet
 */
@WebServlet("/LIFEE002Servlet")
public class LIFEE002Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "";
	private String errJsp = "LIFEE002";
	private DBselect db = new DBselect();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEE002Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"", "" ,""};
		String actionexcute = req.getParameter("actionexcute");
		LIFEE001Form form = (LIFEE001Form)formBean;
		if ("alter".equals(actionexcute)) {
			Msg = excuteAlter(req, res, form, Msg);
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
		String uktk = (String)form.getUktk();
		String kanama = (String)form.getKanama();
		kanama = kanama.substring(0, 1) + " " + kanama.substring(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String ukymd = String.valueOf(df.format(new Date())).substring(0,10);
		String uktime = String.valueOf(df.format(new Date())).substring(11);
		Vector<String> query = new Vector<String>();
		StringBuffer sb = new StringBuffer();
		sb.append("update DHISTORY set ");
		sb.append("UKCONTENT = '").append((String)form.getUkContent()).append("', ");
		sb.append("KANAMA = '").append(kanama).append("', ");
		sb.append("JJSCD = '").append((String)form.getJjscd()).append("', ");
		sb.append("USERID = '").append((String)form.getUserid()).append("', ");
		sb.append("UKYMD = '").append(ukymd).append("', ");
		sb.append("UKTIME = '").append(uktime).append("' ");
		sb.append("where uktk = '").append(uktk).append("'");
		query.add(sb.toString());
		try {
			db.sqlexcute(query);
			msg[1]="履历修改成功！";
		}catch(Exception e){
			e.printStackTrace();
			msg[0] = "DB更改失败！";
			return msg;
		}
		
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

	private String[] excuteAlter(HttpServletRequest req, HttpServletResponse res, LIFEE001Form form, String[] msg) {
		// TODO Auto-generated method stub
		String kanama = (String)form.getKanama();
		kanama = kanama.substring(0, 1) + " " + kanama.substring(1);
		form.setKanama(kanama);
		req.setAttribute("nextform", form);
		msg[2] = "LIFEE001";
		return msg;
	}


}
