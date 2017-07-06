package LIFE.A;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LIFE.C.TilInfoChgUpd;
import LIFE.D.TilKInfoChgUpd;
import LIFE.UTIL.DBselect;
import LIFE.UTIL.DChange;
import LIFE.UTIL.DHistorytblUpd;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEA007Servlet
 */
@WebServlet("/LIFEA007Servlet")
public class LIFEA007Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "";
	private String errJsp = "/LIFEA/LIFEA007.jsp";
	private String[] Msg = {"","",""};
	private DBselect db = new DBselect();
	private DChange dc = new DChange();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEA007Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uktkno = (String)request.getParameter("UKTKNO");
		if (uktkno == null || uktkno == "") {
			nextJsp = errJsp;
			Msg[0] = "该受付号码不存在！";
		} else {
			task(request, response, uktkno);
			if (Msg[0] != "") {
				nextJsp = errJsp;
			}
		}
		if (nextJsp == errJsp) {
			StringBuffer sb = new StringBuffer(); 
			sb.append("select * from DHISTORY where UKTKNO = '").append(uktkno).append("' and DEFEFLG = '0'");
			Vector<Hashtable<String, String>> datas = new Vector<Hashtable<String, String>>();
			try {
				datas = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LIFEA004Form form = new LIFEA004Form();
			form.setCount(String.valueOf(datas.size()));
			form.setUkdata(datas);
			request.setAttribute("datas", form);
		}
		request.setAttribute("ErrMsg", Msg[0]);
		request.setAttribute("WarMsg", Msg[1]);
		request.setAttribute("NorMsg", Msg[2]);
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		try {
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher(nextJsp);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String task(HttpServletRequest request, HttpServletResponse response, String uktkno) {
		// TODO Auto-generated method stub
		Vector<Hashtable<String,String>> his = new Vector<Hashtable<String,String>>();
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select * from DHISTORY where UKTKNO = '").append(uktkno).append("' and DEFEFLG = '0'");
		try {
			his = db.getVector(sb1.toString());
		} catch (NwException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Msg[0] = "DB检索失败！";
			nextJsp = errJsp;
			return nextJsp;
		}
		if (his == null || his.size() == 0) {
			Msg[0] = "该受付号已受付完了！";
			nextJsp = errJsp;
			return nextJsp;
		}
		
		String czlcd = his.get(0).get("CZLCD");
		String sel = "";
		String ukcontents = "";
		if ("C01".equals(czlcd)) {
			TilInfoChgUpd tilupd = new TilInfoChgUpd();
			sel = tilupd.selects(uktkno);
			ukcontents = "契约者情报变更(受付取消)";
		} else if ("D01".equals(czlcd)) {
			TilKInfoChgUpd tilupd = new TilKInfoChgUpd();
			sel = tilupd.selects(uktkno);
			ukcontents = "被共济者情报变更(受付取消)";
		}
		
		Vector<Hashtable<String,String>> tilvec = new Vector<Hashtable<String,String>>();
		Vector<String> query = new Vector<String>();
		try {
			tilvec = (Vector<Hashtable<String,String>>)db.getVector(sel);
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Msg[0] = "DB检索失败！";
			nextJsp = errJsp;
			return nextJsp;
		}
		if (tilvec == null || tilvec.size() == 0) {
			Msg[0] = "不存在该契约者信息的变更的受付！";
			nextJsp = errJsp;
			return nextJsp;
		}
		String cdFlg = tilvec.get(0).get("CDFLG");
		if ("2".equals(cdFlg.trim())) {
			Msg[0] = "该受付号已受付完了！";
			nextJsp = errJsp;
			return nextJsp;
		} else if ("C01".equals(czlcd)){
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE TILINFOCHG SET CDFLG = '3' where UKTKNO = '").append(uktkno).append("'");
			query.add(sb.toString());
		} else if ("D01".equals(czlcd)) {
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE TILKINFOCHG SET CDFLG = '3' where UKTKNO = '").append(uktkno).append("'");
			query.add(sb.toString());
		}
		
		DHistorytblUpd dhis = new DHistorytblUpd();
		query.add(dhis.executeDhi2(uktkno));
		String kanama = his.get(0).get("KANAMA");
		HttpSession session = request.getSession(false);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String ukymd = String.valueOf(df.format(new Date())).substring(0,10);
		String uktime = String.valueOf(df.format(new Date())).substring(11);
		for (int i = 0; i < his.size(); i++) {
			dhis.setUktkno(his.get(i).get("UKTKNO"));
			dhis.setSido(his.get(i).get("SIDO"));
			dhis.setKekno(his.get(i).get("KEKNO"));
			dhis.setUkcontent(ukcontents);
			dhis.setKanama(his.get(i).get("KANAMA"));
			dhis.setJjscd((String)session.getAttribute("jjscd"));
			dhis.setUserid((String)session.getAttribute("userid"));
			dhis.setUkymd(ukymd);
			dhis.setUktime(uktime);
			dhis.setCzlcd(his.get(i).get("CZLCD"));
			dhis.setDefeflg("2");
			query.add(dhis.executeDhi());
		}
		try {
			db.sqlexcute(query);
			Msg[1]="更新成功！受付完了！";
			nextJsp = "/LIFEA/LIFEA004.jsp";
			return nextJsp;
		}catch(Exception e){
			e.printStackTrace();
			Msg[0] = "DB检索失败！";
			nextJsp = errJsp;
			return nextJsp;
		}
	}

}
