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
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEZ005Servlet
 */
@WebServlet("/LIFEZ005Servlet")
public class LIFEZ005Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBselect db = new DBselect();
	private String nextJsp = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEZ005Servlet() {
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
		String[] Msg = {"", "", ""};
		Msg = exec(request, response, Msg);
		if (Msg[0] == "" && Msg[2] != "") {
			nextJsp = Msg[2];
		} else {
			String jjscd = (String)request.getParameter("jjscd");
			String userid = (String)request.getParameter("userid");
			String power = (String)request.getParameter("pow");
			request.setAttribute("jjscd", jjscd);
			request.setAttribute("userid", userid);
			request.setAttribute("pow", power);
			nextJsp = "/LIFEZ/LIFEZ005.jsp";
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

	private String[] exec(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String jjscd = (String)request.getParameter("jjscd").trim();
		String userid = (String)request.getParameter("userid").trim();
		String power = (String)request.getParameter("pow").trim();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from OFFICE where JGYCD = '").append(jjscd).append("'");
		Vector<Hashtable<String, String>> offices = new Vector<Hashtable<String, String>>();
		try {
			offices = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索失败！";
			return msg;
		}
		if (offices == null || offices.size() == 0) {
			msg[0] = "不存在该事务所！";
			return msg;
		}
		sb = new StringBuffer();
		sb.append("select * from USERS where JGYCD ='").append(jjscd).append("'");
		Vector<Hashtable<String, String>> users = new Vector<Hashtable<String, String>>();
		try {
			users = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索失败！";
			return msg;
		}
		for(int i = 0; i < users.size(); i++) {
			String usersid = users.get(i).get("USERID");
			if (userid.equals(usersid)) {
				msg[0] = "该账号已经存在！";
				return msg;
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datetime = String.valueOf(df.format(new Date()));
		Vector<String> query = new Vector<String>();
		sb = new StringBuffer();
		sb.append("insert into USERS (JGYCD, USERID, PASSWORD, ISLOGIN, DATETIME, POWER, LOGINDATE) values ('").append(jjscd);
		sb.append("', '").append(userid).append("', 'passwd', '0', '").append(datetime).append("', '").append(power).append("', '");
		sb.append(datetime).append("')");
		query.add(sb.toString());
		try {
			db.sqlexcute(query);
			msg[1]="账号创建成功！";
			msg[2] = "/LIFEZ/LIFEZ005.jsp";
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			msg[0] = "账号创建失败！";
			return msg;
		}
	}

}
