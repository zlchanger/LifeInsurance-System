package LIFE.D;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.D.LIFED001Form;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

public class LIFED001Servlet extends NwCommonServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nextJsp = "LIFED002";
	private String errJsp = "LIFED001";

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""}; 
		LIFED001Form lifed001 = (LIFED001Form)formBean;
		req.setAttribute("nextform", lifed001);
		String uktkno = (String)req.getParameter("reUktkno");
		req.setAttribute("reUktkno", uktkno);
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

}
