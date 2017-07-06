package LIFE.C;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

public class LIFEC001Servlet extends NwCommonServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nextJsp = "LIFEC002";
	private String errJsp = "LIFEC001";
	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""}; 
		LIFEC001Form lifec001 = (LIFEC001Form)formBean;
		String uktkno = (String)req.getParameter("reUktkno");
		req.setAttribute("reUktkno", uktkno);
		req.setAttribute("nextform", lifec001);
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

}
