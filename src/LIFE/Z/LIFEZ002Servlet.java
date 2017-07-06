package LIFE.Z;

import java.io.IOException;
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
 * Servlet implementation class LIFEZ002Servlet
 */
@WebServlet("/LIFEZ002Servlet")
public class LIFEZ002Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "";
	private String errJsp = "/LIFEZ/LIFEZ002.jsp";
	private DBselect db = new DBselect();
	private DChange dc = new DChange();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEZ002Servlet() {
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
		String jcd = (String)request.getParameter("jcd");
		String uid = (String)request.getParameter("uid");
		request.setAttribute("jcd", jcd);
		request.setAttribute("uid", uid);
		String actionexcute = (String)request.getParameter("actionexcute");
		if ("alter".equals(actionexcute)) {
			Msg = excuteAlter(request,response, Msg);
		} else if ("delete".equals(actionexcute)) {
			Msg = excuteDelete(request,response, Msg);
		}
		if (Msg[0] == "" && Msg[2] != "") {
			nextJsp = Msg[2];
		} else {
			nextJsp = errJsp;
			exec(request,response);
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

	private void exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String jjscd = (String)request.getParameter("jcd");
		String userid = (String)request.getParameter("uid");
		Vector<Hashtable<String, String>> user = new Vector<Hashtable<String, String>>();
		if (dc.isEmpty(userid) && !dc.isEmpty(jjscd)) {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from USERS where JGYCD = '").append(jjscd).append("'");
			try {
				user = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LIFEZ000Form form = new LIFEZ000Form();
			form.setuser(user);
			form.setjjscd(jjscd);
			form.setuserid(userid);
			request.setAttribute("userdata", form);
		}
		if (dc.isEmpty(jjscd) && !dc.isEmpty(userid)) {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from USERS where USERID = '").append(userid).append("'");
			try {
				user = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LIFEZ000Form form = new LIFEZ000Form();
			form.setuser(user);
			form.setjjscd(jjscd);
			form.setuserid(userid);
			request.setAttribute("userdata", form);
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
			}
			LIFEZ000Form form = new LIFEZ000Form();
			form.setuser(user);
			form.setjjscd(jjscd);
			form.setuserid(userid);
			request.setAttribute("userdata", form);
		}
	}

	private String[] excuteDelete(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String[] jjsuser = request.getParameterValues("user");
		if (jjsuser == null || jjsuser.length == 0) {
			msg[0] = "Î´Ñ¡ÔñÕËºÅ£¡";
			return msg;
		}
		StringBuffer wheres = new StringBuffer();
		int flg = 0;
		for (int i = 0; i < jjsuser.length; i++) {
			if (flg != 0) {
				wheres.append(" or ");
			}
			String jjscd = jjsuser[i].substring(0, 3);
			String userid = jjsuser[i].substring(3);
			wheres.append("(JGYCD = '").append(jjscd).append("' and USERID = '").append(userid).append("')");
			flg++;
		}
		Vector<Hashtable<String, String>> users = new Vector<Hashtable<String, String>>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from USERS where ").append(wheres.toString());
		try {
			users = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB¼ìË÷Ê§°Ü£¡";
			return msg;
		}
		if (users == null || users.size() == 0) {
			msg[0] = "DB¼ìË÷Ê§°Ü£¡";
			return msg;
		}
		for (int i = 0; i < users.size(); i++) {
			Hashtable<String, String> uuser = (Hashtable<String, String>)users.get(i);
			if ("1".equals((String)uuser.get("POWER"))) {
				msg[0] = "¹ÜÀíÔ±ÕËºÅ²»¿ÉÉ¾³ý£¡";
				return msg;
			}
		}
		LIFEZ000Form form = new LIFEZ000Form();
		form.setuser(users);
		request.setAttribute("userdata", form);
		msg[2] = "/LIFEZ/LIFEZ004.jsp";
		return msg;
	}

	private String[] excuteAlter(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String[] jjsuser = request.getParameterValues("user");
		if (jjsuser == null || jjsuser.length == 0) {
			msg[0] = "Î´Ñ¡ÔñÕËºÅ£¡";
			return msg;
		}
		if (jjsuser.length > 1) {
			msg[0] = "ÇëÑ¡ÔñÒ»¸öÕËºÅ£¡";
			return msg;
		}
		String jjscd = jjsuser[0].substring(0, 3);
		String userid = jjsuser[0].substring(3);
		Vector<Hashtable<String, String>> users = new Vector<Hashtable<String, String>>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from USERS where JGYCD = '").append(jjscd).append("' and ");
		sb.append("USERID = '").append(userid).append("'");
		try {
			users = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB¼ìË÷Ê§°Ü£¡";
			return msg;
		}
		LIFEZ000Form form = new LIFEZ000Form();
		form.setuser(users);
		request.setAttribute("userdata", form);
		msg[2] = "/LIFEZ/LIFEZ003.jsp";
		return msg;
	}

}
