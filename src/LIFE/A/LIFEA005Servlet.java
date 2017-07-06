package LIFE.A;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.C.LIFEC001Form;
import LIFE.D.LIFED001Form;
import LIFE.A.LIFEA004Form;
import LIFE.UTIL.DBselect;
import LIFE.UTIL.DChange;
import LIFE.UTIL.DConstants;
import LIFE.UTIL.NwException;

/**
 * Servlet implementation class LIFEA005Servlet
 */
@WebServlet("/LIFEA005Servlet")
public class LIFEA005Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String errJsp = "/LIFEA/LIFEA005.jsp";
    private String nextJsp = "";
    private String[] Msg = {"","",""};
    private DBselect db = new DBselect();
    private DChange dc = new DChange();
    private ArrayList<String> tkeknos = new ArrayList<String>();
    private ArrayList<String> ikeknos = new ArrayList<String>();
    private ArrayList<String> lkeknos = new ArrayList<String>();
    private Vector tsky = new Vector();
    private Vector iky = new Vector();
    private Vector lky = new Vector();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIFEA005Servlet() {
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
		task(request,response);
		if (Msg[0] != "") {
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

	private String task(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String[] uktknos = request.getParameterValues("uktil");
		String domessage = (String)request.getParameter("domessage");
		if (uktknos == null || uktknos.length == 0) {
			Msg[0] = "ERR001";
			nextJsp = errJsp;
			return nextJsp;
		} else {
			String uktkno = uktknos[0];
			StringBuffer sb = new StringBuffer(); 
			sb.append("select * from DHISTORY where UKTKNO = '").append(uktkno).append("' and DEFEFLG = '0'");
			Vector<Hashtable<String, String>> datas = new Vector<Hashtable<String, String>>();
			try {
				datas = db.getVector(sb.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Msg[0] = "DB¼ìË÷Ê§°Ü£¡";
				nextJsp = errJsp;
				return nextJsp;
			}
			if (datas == null || datas.size() == 0) {
				Msg[0] = "ERR001";
				nextJsp = errJsp;
				return nextJsp;
			} else {
				for(int i = 0; i < datas.size(); i++) {
					String sido = datas.get(i).get("SIDO");
					String keknos = datas.get(i).get("KEKNO");
					if (DConstants.tsido.equals(sido)) {
						tkeknos.add(keknos);
					} else if (DConstants.isido.equals(sido)) {
						ikeknos.add(keknos);
					} else if (DConstants.lsido.equals(sido)) {
						lkeknos.add(keknos);
					}
				}
				exec(tkeknos,ikeknos,lkeknos);
				Vector<Hashtable<String,String>> first = new Vector<Hashtable<String,String>>();
				if ((tsky == null || tsky.size() == 0) && (iky == null || iky.size() == 0) &&
						(lky == null || lky.size() == 0)) {
					Msg[0] = "ERR001";
					nextJsp = errJsp;
					return nextJsp;
				}String czlcd = datas.get(0).get("CZLCD");
				if ("C01".equals(czlcd)) {
					LIFEC001Form lifec001 = new LIFEC001Form();
					if (tsky != null && tsky.size() > 0) {
						lifec001.settsky(tsky);
						first = tsky;
					}
					if (iky != null && iky.size() > 0) {
						lifec001.setiky(iky);
						first = iky;
					}
					if (lky != null && lky.size() > 0) {
						lifec001.setlky(lky);
						first = lky;
					}
					lifec001.setTele(dc.teleChange((String)first.get(0).get("TELE")));
					lifec001.setZipcode((String)first.get(0).get("ZIPCODE"));
					lifec001.setAddre((String)first.get(0).get("ADDRE"));
					lifec001.setPhysicalcase(dc.physicalChange((String)first.get(0).get("PHYSICALCASE")));
					lifec001.setOccupation((String)first.get(0).get("KOCCUPATION"));
					lifec001.setKamanax((String)first.get(0).get("KAMANAX"));
					lifec001.setKamanam((String)first.get(0).get("KAMANAM"));
					lifec001.setBirthday(dc.toYYMMDD((String)first.get(0).get("BIRTHDAY")));
					lifec001.setSex(dc.sexShow((String)first.get(0).get("SEX")));
					
					StringBuffer stb = new StringBuffer();
					stb.append("select * from TILINFOCHG where UKTKNO = '").append(uktkno).append("' and CDFLG = '1'");
					Vector<Hashtable<String, String>> tilvec = new Vector<Hashtable<String, String>>();
					try {
						tilvec = db.getVector(stb.toString());
					} catch (NwException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Msg[0] = "DB¼ìË÷Ê§°Ü£¡";
						nextJsp = errJsp;
						return nextJsp;
					}
					if (tilvec != null && tilvec.size() >  0) {
						lifec001.setnameflg(tilvec.get(0).get("KAMANAFLG"));
						lifec001.setbirthflg(tilvec.get(0).get("BIRTHDAYFLG"));
						lifec001.setteleflg(tilvec.get(0).get("TELEFLG"));
						lifec001.setsexflg(tilvec.get(0).get("SEXFLG"));
						lifec001.setwheflg(tilvec.get(0).get("ADDREFLG"));
						lifec001.setothflg(tilvec.get(0).get("OTHFLG"));
					} else {
						Msg[0] = "¸ÃÆõÔ¼Î´ÔÚÊÜ¸¶ÖÐ£¡";
						nextJsp = errJsp;
						return nextJsp;
					}
					
					request.setAttribute("nextform", lifec001);
					request.setAttribute("reUktkno", uktkno);
					if (DConstants.keknoAlter.equals(domessage)) {
						nextJsp = "/LIFEC/LIFEC001.jsp";
					} else if (DConstants.keknoAgian.equals(domessage)) {
						nextJsp = "/LIFEC/LIFEC003.jsp";
					} else if (DConstants.keknoDele.equals(domessage)) {
						LIFEA004Form form = new LIFEA004Form();
						form.setCount(String.valueOf(datas.size()));
						form.setUkdata(datas);
						request.setAttribute("datas", form);
						nextJsp = "/LIFEA/LIFEA007.jsp"; 
					}
					return nextJsp;
				} else if ("D01".equals(czlcd)) {
					LIFED001Form lifed001 = new LIFED001Form();
					if (tsky != null && tsky.size() > 0) {
						lifed001.settsky(tsky);
						first = tsky;
					}
					if (iky != null && iky.size() > 0) {
						lifed001.setiky(iky);
						first = iky;
					}
					if (lky != null && lky.size() > 0) {
						lifed001.setlky(lky);
						first = lky;
					}
					lifed001.setKtele(dc.teleChange((String)first.get(0).get("KTELE")));
					lifed001.setKzipcode((String)first.get(0).get("KZIPCODE"));
					lifed001.setKaddre((String)first.get(0).get("KADDRE"));
					lifed001.setKphysical(dc.physicalChange((String)first.get(0).get("KPHYSICAL")));
					lifed001.setKoccupation((String)first.get(0).get("KOCCUPATION"));
					lifed001.setKamannx((String)first.get(0).get("KAMANNX"));
					lifed001.setKamannm((String)first.get(0).get("KAMANNM"));
					lifed001.setKbirthday(dc.toYYMMDD((String)first.get(0).get("KBIRTHDAY")));
					lifed001.setKsex(dc.sexShow((String)first.get(0).get("KSEX")));
					
					StringBuffer stb = new StringBuffer();
					stb.append("select * from TILKINFOCHG where UKTKNO = '").append(uktkno).append("'  and CDFLG = '1'");
					Vector<Hashtable<String, String>> tilvec = new Vector<Hashtable<String, String>>();
					try {
						tilvec = db.getVector(stb.toString());
					} catch (NwException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Msg[0] = "DB¼ìË÷Ê§°Ü£¡";
						nextJsp = errJsp;
						return nextJsp;
					}
					if (tilvec != null && tilvec.size() >  0) {
						lifed001.setnameflg(tilvec.get(0).get("KAMANAFLG"));
						lifed001.setbirthflg(tilvec.get(0).get("BIRTHDAYFLG"));
						lifed001.setteleflg(tilvec.get(0).get("TELEFLG"));
						lifed001.setsexflg(tilvec.get(0).get("SEXFLG"));
						lifed001.setwheflg(tilvec.get(0).get("ADDREFLG"));
						lifed001.setothflg(tilvec.get(0).get("OTHFLG"));
					} else {
						Msg[0] = "¸ÃÆõÔ¼Î´ÔÚÊÜ¸¶ÖÐ£¡";
						nextJsp = errJsp;
						return nextJsp;
					}
					
					request.setAttribute("nextform", lifed001);
					request.setAttribute("reUktkno", uktkno);
					if (DConstants.keknoAlter.equals(domessage)) {
						nextJsp = "/LIFED/LIFED001.jsp";
					} else if (DConstants.keknoAgian.equals(domessage)) {
						nextJsp = "/LIFED/LIFED003.jsp";
					} else if (DConstants.keknoDele.equals(domessage)) {
						LIFEA004Form form = new LIFEA004Form();
						form.setCount(String.valueOf(datas.size()));
						form.setUkdata(datas);
						request.setAttribute("datas", form);
						nextJsp = "/LIFEA/LIFEA007.jsp"; 
					}
				}	
			}
		}
		return nextJsp;
	}
	
	private void exec(ArrayList<String> tkekno, ArrayList<String> ikekno, ArrayList<String> lkekno) {
		if ((tkekno ==null || tkekno.size() ==0) && (ikekno == null || ikekno.size() == 0) &&
				(lkekno == null || lkekno.size() == 0)) {
			Msg[0] = "ERR001";
			nextJsp = errJsp;
		}
		if (tkekno != null && tkekno.size() > 0) {
			StringBuffer sbt = new StringBuffer();
			sbt.append("select * from TSKY where kekno in ( ");
			for(int i = 0; i < tkekno.size()-1; i++) {
				sbt.append("'").append(tkekno.get(i)).append("', ");
			}
			sbt.append("'").append(tkekno.get(tkekno.size()-1)).append("')");
			try {
				tsky = db.getVector(sbt.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Msg[0] = "DB¼ìË÷Ê§°Ü£¡";
				nextJsp = errJsp;
			}
		}
		if (ikekno != null && ikekno.size() > 0) {
			StringBuffer sbi = new StringBuffer();
			sbi.append("select * from IKY where kekno in ( ");
			for(int i = 0; i < ikekno.size()-1; i++) {
				sbi.append("'").append(ikekno.get(i)).append("', ");
			}
			sbi.append("'").append(ikekno.get(ikekno.size()-1)).append("')");
			try {
				iky = db.getVector(sbi.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Msg[0] = "DB¼ìË÷Ê§°Ü£¡";
				nextJsp = errJsp;
			}
		}
		if (lkekno != null && lkekno.size() > 0) {
			StringBuffer sbl = new StringBuffer();
			sbl.append("select * from LKY where kekno in ( ");
			for(int i = 0; i < lkekno.size()-1; i++) {
				sbl.append("'").append(lkekno.get(i)).append("', ");
			}
			sbl.append("'").append(lkekno.get(lkekno.size()-1)).append("')");
			try {
				lky = db.getVector(sbl.toString());
			} catch (NwException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Msg[0] = "DB¼ìË÷Ê§°Ü£¡";
				nextJsp = errJsp;
			}
		}
	}

}
