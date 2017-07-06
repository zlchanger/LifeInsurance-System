package LIFE.C;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEC003Servlet
 */
@WebServlet("/LIFEC003Servlet")
public class LIFEC003Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp = "LIFEC004";
	private String errJsp = "LIFEC003";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEC003Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		String[] Msg = {"","",""}; 
		LIFEC001Form lifec001 = (LIFEC001Form)formBean;
		String uktkno = (String)req.getParameter("reUktkno");
		req.setAttribute("reUktkno", uktkno);
		String namflg = (String)req.getParameter("namflg");
		lifec001.setnameflg(namflg);
		String birflg = (String)req.getParameter("birflg");
		lifec001.setbirthflg(birflg);
		String telflg = (String)req.getParameter("telflg");
		lifec001.setteleflg(telflg);
		String sexflg = (String)req.getParameter("sexflg");
		lifec001.setsexflg(sexflg);
		String wheflg = (String)req.getParameter("wheflg");
		lifec001.setwheflg(wheflg);
		String othflg = (String)req.getParameter("othflg");
		lifec001.setothflg(othflg);
		req.setAttribute("nextform", lifec001);
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

}
