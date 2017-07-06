package LIFE.D;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.D.LIFED001Form;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFED003Servlet
 */
@WebServlet("/LIFED003Servlet")
public class LIFED003Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "LIFED004";
	private String errJsp = "LIFED003";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFED003Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		String[] Msg = {"","",""}; 
		LIFED001Form lifed001 = (LIFED001Form)formBean;
		String uktkno = (String)req.getParameter("reUktkno");
		req.setAttribute("reUktkno", uktkno);
		String namflg = (String)req.getParameter("namflg");
		lifed001.setnameflg(namflg);
		String birflg = (String)req.getParameter("birflg");
		lifed001.setbirthflg(birflg);
		String telflg = (String)req.getParameter("telflg");
		lifed001.setteleflg(telflg);
		String sexflg = (String)req.getParameter("sexflg");
		lifed001.setsexflg(sexflg);
		String wheflg = (String)req.getParameter("wheflg");
		lifed001.setwheflg(wheflg);
		String othflg = (String)req.getParameter("othflg");
		lifed001.setothflg(othflg);
		req.setAttribute("nextform", lifed001);
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}


}
