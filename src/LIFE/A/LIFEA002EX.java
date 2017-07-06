package LIFE.A;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LIFEA002EX extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String nextJsp = "/LIFEA/LIFEA001.jsp";
		try {
			res.setHeader("Pragma", "no-cache");
			res.setHeader("Cache-Control", "no-cache");
			RequestDispatcher rd = 
					getServletConfig().getServletContext().getRequestDispatcher(nextJsp);
			rd.forward(req, res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
