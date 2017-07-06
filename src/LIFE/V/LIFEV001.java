package LIFE.V;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LIFE.UTIL.DBselect;
import LIFE.UTIL.NwException;

public class LIFEV001 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nextJsp;
	public LIFEV001() {
		super();
	}
	public void service(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		String method = req.getMethod();
		if ("post".equalsIgnoreCase(method)) {
			doPost(req, res);
		}
		if ("get".equalsIgnoreCase(method)) {
			doGet(req,res);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String errJsp = "/LIFEV/LIFEV001.jsp";
		String norJsp = "/LIFEV/LIFEV002.jsp";
		String[] Msg = {"","",""};
		try {
			req.setCharacterEncoding("UTF-8");
			confrim(req, Msg);
			if (Msg[0].length() == 0){
					nextJsp = norJsp;
			} else {
				nextJsp = errJsp;
			}
			req.setAttribute("ErrMsg", Msg[0]);
			req.setAttribute("WarMsg", Msg[1]);
			req.setAttribute("NorMsg", Msg[2]);
			res.setHeader("pragma", "no-cache");
			res.setHeader("Cache-Control", "no-cache");
			RequestDispatcher rd = 
					getServletConfig().getServletContext().getRequestDispatcher(nextJsp);
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String[] confrim(HttpServletRequest req,String[] Msg) {
		int loginF_i = 0;
		Vector<Hashtable<String,String>> pw = new Vector<Hashtable<String,String>>();
		String jgyCd = checkNull((String)req.getParameter("Jgycd"));
		String userId = checkNull((String)req.getParameter("Userid"));
		String passWord = checkNull((String)req.getParameter("Password"));
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM USERS ");
		sb.append("WHERE ");
		sb.append("JGYCD = '");
		sb.append(jgyCd);
		sb.append("' and USERID = '");
		sb.append(userId);
		sb.append("'");

		DBselect dbselect = new DBselect();
		try {
			pw = dbselect.getVector(sb.toString());
		} catch (NwException e) {
			e.printStackTrace();
		}

		if (pw != null && pw.size() > 0) {
			String islogin = (String)pw.get(0).get("ISLOGIN");
			if (!"0".equals(islogin)) {
				Msg[2] = "/LIFEV/LIFEV001.jsp";
				Msg[0] = "该账号已被登陆，请确认账号！";
				return Msg;
			}
			if (passWord.equals((String)pw.get(0).get("PASSWORD"))) {
				Msg[2] = "/LIFEV/LIFEV002.jsp";
				String power = (String)pw.get(0).get("POWER");
				req.setAttribute("power", power);
				HttpSession session = req.getSession();
				session.setAttribute("jjscd", jgyCd);
				session.setAttribute("userid", userId);
				session.setAttribute("passwd", passWord);
				sb = new StringBuffer();
				sb.append("update USERS set ISLOGIN = '1' ");
				sb.append("where JGYCD = '").append(jgyCd).append("' and ");
				sb.append("USERID = '").append(userId).append("'");
				Vector<String> query = new Vector<String>();
				query.add(sb.toString());
				try{
					dbselect.sqlexcute(query);
				}catch(Exception e){
					e.printStackTrace();
				}
			} else {
				Msg[2] = "/LIFEV/LIFEV001.jsp";
				Msg[0] = "账号密码错误，请重新输入！";
			}
		} else {
			Msg[2] = "/LIFEV/LIFEV001.jsp";
			Msg[0] = "不存在该用户账号！";
		}
		req.setAttribute("Jgycd", jgyCd);
		req.setAttribute("Userid", userId);
		return Msg;
	}
	public String checkNull(String str) {
		if (str == null) {
			return "";
		} else if (str.trim().length() == 0) {
			return "";
		}
		return str;
	}
}
