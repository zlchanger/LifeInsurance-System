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
import sun.nio.cs.ext.ISCII91;

/**
 * Servlet implementation class LIFEZ001Servlet
 */
@WebServlet("/LIFEZ001Servlet")
public class LIFEZ001Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "";
	private String errJsp = "/LIFEZ/LIFEZ001.jsp";
	private DBselect db = new DBselect();
	private DChange dc = new DChange();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEZ001Servlet() {
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
		Msg = excute(request, response, Msg);
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

	private String[] excute(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String jjscd = (String)request.getParameter("jjscd");
		String userid = (String)request.getParameter("userid");
		request.setAttribute("Jjscd", jjscd);
		request.setAttribute("Userid", userid);
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

}
