package LIFE.Z;

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

import LIFE.UTIL.DBselect;
import LIFE.UTIL.DChange;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEZ003Servlet
 */
@WebServlet("/LIFEZ003Servlet")
public class LIFEZ003Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "";
	private String errJsp = "/LIFEZ/LIFEZ003.jsp";
	private DBselect db = new DBselect();
	private DChange dc = new DChange();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEZ003Servlet() {
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
		String[] Msg = {"", "", ""};
		String actionexcute = (String)request.getParameter("actionexcute");
		if ("back".equals(actionexcute)) {
			Msg = excuteBack(request,response, Msg);
		} else if ("implement".equals(actionexcute)) {
			Msg = excuteImplement(request,response, Msg);
		}
		if (Msg[0] == "" && Msg[2] != "") {
			nextJsp = Msg[2];
		} else {
			nextJsp = errJsp;
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

	private String[] excuteBack(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String jjscd = (String)request.getParameter("jcd");
		String userid = (String)request.getParameter("uid");
		Vector<Hashtable<String, String>> user = new Vector<Hashtable<String, String>>();
		if (dc.isEmpty(jjscd) && dc.isEmpty(userid)) {
			msg[0] = "¼ìË÷Ìõ¼þ²»×ã£¡";
			return msg;
		}
		if (dc.isEmpty(userid) && !dc.isEmpty(jjscd)) {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from USERS where JGYCD = '").append(jjscd).append("'");
			try {
				user = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg[0] = "DB¼ìË÷´íÎó£¡";
				return msg;
			}
			if (user == null || user.size() == 0) {
				msg[0] = "²»´æÔÚ¸ÃÕËºÅ£¡";
				return msg;
			}
			LIFEZ000Form form = new LIFEZ000Form();
			form.setuser(user);
			form.setjjscd(jjscd);
			form.setuserid(userid);
			request.setAttribute("userdata", form);
			msg[2] = "/LIFEZ/LIFEZ002.jsp";
			return msg;
		}
		if (dc.isEmpty(jjscd) && !dc.isEmpty(userid)) {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from USERS where USERID = '").append(userid).append("'");
			try {
				user = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg[0] = "DB¼ìË÷´íÎó£¡";
				return msg;
			}
			if (user == null || user.size() == 0) {
				msg[0] = "²»´æÔÚ¸ÃÕËºÅ£¡";
				return msg;
			}
			LIFEZ000Form form = new LIFEZ000Form();
			form.setuser(user);
			form.setjjscd(jjscd);
			form.setuserid(userid);
			request.setAttribute("userdata", form);
			msg[2] = "/LIFEZ/LIFEZ002.jsp";
			return msg;
		}
		if (!dc.isEmpty(jjscd) && !dc.isEmpty(userid)) {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from USERS where JGYCD = '").append(jjscd).append("' and ");
			sb.append("USERID = '").append(userid).append("'");
			try {
				user = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg[0] = "DB¼ìË÷´íÎó£¡";
				return msg;
			}
			if (user == null || user.size() == 0) {
				msg[0] = "²»´æÔÚ¸ÃÕËºÅ£¡";
				return msg;
			}
			LIFEZ000Form form = new LIFEZ000Form();
			form.setuser(user);
			form.setjjscd(jjscd);
			form.setuserid(userid);
			request.setAttribute("userdata", form);
			msg[2] = "/LIFEZ/LIFEZ002.jsp";
			return msg;
		}
		return null;
	}

	private String[] excuteImplement(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String jcd = (String)request.getParameter("jjscd");
		String uid = (String)request.getParameter("userid");
		String power = (String)request.getParameter("pow");
		String oldjcd = (String)request.getParameter("oldjcd");
		String olduid = (String)request.getParameter("olduid");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datetime = String.valueOf(df.format(new Date()));
		StringBuffer sb = new StringBuffer();
		sb.append("update USERS set JGYCD = '").append(jcd).append("', ");
		sb.append("USERID = '").append(uid).append("', ");
		sb.append("PASSWORD = 'passwd', ISLOGIN = '0', ");
		sb.append("DATETIME = '").append(datetime).append("', ");
		sb.append("POWER = '").append(power).append("', ");
		sb.append("LOGINDATE = '").append(datetime).append("' ");
		sb.append("where JGYCD = '").append(oldjcd).append("' and ");
		sb.append("USERID = '").append(olduid).append("'");
		Vector<String> query = new Vector<String>();
		query.add(sb.toString());
		try {
			db.sqlexcute(query);
			msg[1]="ÕËºÅÐÞ¸Ä³É¹¦£¡";
			msg[2] = "/LIFEZ/LIFEZ001.jsp";
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			msg[0] = "ÕËºÅÐÞ¸ÄÊ§°Ü£¡";
			return msg;
		}
	}

}
