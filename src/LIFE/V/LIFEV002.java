package LIFE.V;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LIFE.UTIL.DBselect;

public class LIFEV002 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LIFEV002() {
		super();
	}

	String nextJsp = "";

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String param = req.getParameter("parm");
		String param2 = req.getParameter("parm2");
		String errJsp = "/LIFEV/LIFEV002.jsp";
		if ("LIFEA001".equals(param)) {
			nextJsp = "/LIFEA/LIFEA001.jsp";
		} else if ("LIFEA004".equals(param)) {
			nextJsp = "/LIFEA/LIFEA004.jsp";
			if ("1".equals(param2)) {
				req.setAttribute("chooseflg", "ÐÞ¸Ä");
			} else if ("2".equals(param2)) {
				req.setAttribute("chooseflg", "·µËÍ");
			} else if ("3".equals(param2)){
				req.setAttribute("chooseflg", "È¡Ïû");
			}
		} else if ("LIFEA006".equals(param)) {
			nextJsp = "/LIFEA/LIFEA006.jsp";
		} else if ("LIFEA009".equals(param)) {
			nextJsp = "/LIFEA/LIFEA009.jsp";
		} else if ("LIFEZ001".equals(param)) {
			nextJsp="/LIFEZ/LIFEZ001.jsp";
		} else if ("LIFEZ005".equals(param)) {
			nextJsp="/LIFEZ/LIFEZ005.jsp";
		} else if ("LIFEJ001".equals(param)) {
			nextJsp="/LIFEJ/LIFEJ001.jsp";
		} else if ("LIFEJ002".equals(param)) {
			nextJsp="/LIFEJ/LIFEJ002.jsp";
		}
		String[] Msg = { "", "", "" };
		if (Msg[0].length() != 0) {
			nextJsp = errJsp;
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		res.setHeader("pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		try {
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher(nextJsp);
			rd.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String jjscd = (String)session.getAttribute("jjscd");
		String userid = (String)session.getAttribute("userid");
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String loginTime = String.valueOf(df.format(new Date()));
		StringBuffer sb = new StringBuffer();
		sb.append("update USERS set ISLOGIN = '0', LOGINDATE = '").append(loginTime).append("' ");
		sb.append("where JGYCD = '").append(jjscd).append("' and ");
		sb.append("USERID = '").append(userid).append("'");
		Vector<String> query = new Vector<String>();
		query.add(sb.toString());
		DBselect db = new DBselect();
		try{
			db.sqlexcute(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		nextJsp="/LIFEV/LIFEV001.jsp";
		req.setAttribute("Jgycd", jjscd);
		req.setAttribute("Userid", userid);
		res.setHeader("pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		try {
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher(nextJsp);
			rd.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
