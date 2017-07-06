package LIFE.A;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.UTIL.DBselect;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEA009Servlet
 */
@WebServlet("/LIFEA009Servlet")
public class LIFEA009Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBselect db = new DBselect();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEA009Servlet() {
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
	}

	private String[] exec(HttpServletRequest request, HttpServletResponse response, String[] msg) {
		// TODO Auto-generated method stub
		String jjscd = request.getParameter("jjscd");
		StringBuffer sb = new StringBuffer();
		sb.append("select * from OFFICE where JGYCD = '").append(jjscd).append("'");
		Vector<Hashtable<String, String>> offices = new Vector<Hashtable<String, String>>();
		try {
			offices = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg[0] = "DB检索错误！";
			return msg;
		}
		if (offices == null || offices.size() == 0) {
			msg[0] = "不存在事务所CD为" + jjscd + "事务所信息！";
			return msg;
		}
		return null;
	}

}
