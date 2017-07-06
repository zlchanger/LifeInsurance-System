package LIFE.A;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.UTIL.DBselect;
import LIFE.UTIL.DChange;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEA006Servlet
 */
@WebServlet("/LIFEA006Servlet")
public class LIFEA006Servlet extends NwCommonServlet {
	private static final long serialVersionUID = 1L;
	private String nextJsp="";
	private String errJsp="LIFEA006";
	private String[] Msg = {"","",""};
	private DChange dc = new DChange();
	private DBselect db = new DBselect();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEA006Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		// TODO Auto-generated method stub
		exec(req, res, formBean);
		if (Msg[0] != "") {
			nextJsp = errJsp;
		} else {
			nextJsp = "LIFEA008";
		}
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

	private void exec(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean) {
		// TODO Auto-generated method stub
		LIFEA006Form form = (LIFEA006Form)formBean;
		String jgycd = (String)form.getJyscd();
		String userid = (String)form.getUserid();
		String passwd = (String)form.getPasswd();
		String hid_passwd = (String)req.getParameter("password");
		String newpasswd = (String)form.getNewpasswd();
		Vector<String> query = new Vector<String>();
		if (dc.isEmpty(jgycd) || dc.isEmpty(userid) || dc.isEmpty(passwd) 
				|| dc.isEmpty(hid_passwd) || dc.isEmpty(newpasswd)) {
			Msg[0] = "������Ϣ���㣡";
		} else if (!passwd.trim().equals(hid_passwd.trim())) {
			Msg[0] = "Sorry,�������������󣡲����޸Ĵ��˺����룡";
		} else if (passwd.trim().equals(newpasswd.trim())) {
			Msg[0] = "���벻����ͬ��";
		} else {
			check(jgycd, userid, passwd);
		}
		if (Msg[0] == "") {
			StringBuffer sb = new StringBuffer();
			sb.append("update USERS set PASSWORD = '").append(newpasswd).append("' ");
			sb.append("where JGYCD = '").append(jgycd).append("' and USERID = '").append(userid).append("'");
			query.add(sb.toString());
			try {
				db.sqlexcute(query);
				Msg[1]="�����޸ĳɹ���";
				req.setAttribute("newPasswd", newpasswd);
			}catch(Exception e){
				e.printStackTrace();
				Msg[0] = "���˺������޸�ʧ�ܣ�";
			}
		}
	}

	private void check(String jgycd, String userid, String passwd) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from USERS where JGYCD = '").append(jgycd).append("' ");
		sb.append("and USERID = '").append(userid).append("'");
		Vector<Hashtable<String, String>> tec = new Vector<Hashtable<String, String>>();
		try {
			tec = db.getVector(sb.toString());
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Msg[0] = "���˺Ų����ڣ�";
		}
		if (tec == null || tec.size() == 0) {
			Msg[0] = "���˺Ų����ڣ�";
		} else if (!passwd.equals((String)tec.get(0).get("PASSWORD"))) {
			Msg[0] = "�޸��˺�ʧ�ܣ�";
		}
	}
		

}
