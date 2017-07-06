package LIFE.V;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class LIFEV001Top extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) {
		String nextJsp = "/LIFEV/LIFE001.jsp";
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
