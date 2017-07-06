package LIFE.A;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LIFE.UTIL.DBselect;
import LIFE.UTIL.DConstants;
import LIFE.UTIL.NwCommonForm;
import LIFE.UTIL.NwCommonServlet;
import LIFE.UTIL.NwException;

public class LIFEA001Servlet extends NwCommonServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean, String actionName)
			throws NwException {
		String errJsp = "LIFEA001";
		String nextJsp = "LIFEA002";
		String[] Msg = {"","",""};
		LIFEA001Form form = (LIFEA001Form)formBean;
		String kekno = form.getKekno();
		String member = form.getMember();
		String copcd = form.getCopcd();
		String telephone = form.getTelephone();
		String insurance = form.getInsurance1();
		Vector<Hashtable<String, String>> info = new Vector<Hashtable<String, String>>();
		Vector<Hashtable<String, String>> infoT = new Vector<Hashtable<String, String>>();
		Vector<Hashtable<String, String>> infoI = new Vector<Hashtable<String, String>>();
		Vector<Hashtable<String, String>> infoL = new Vector<Hashtable<String, String>>();
		DBselect db = new DBselect();
		int type = -1;
		int skFlag = -1;
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ");
		if (DConstants.allInsurance.equals(insurance)) {
			sb.append("TSKY t, IKY i, LKY l ");
			type = 0;
		} else if (DConstants.taskei.equals(insurance)) {
			sb.append("TSKY t ");
			type = 1;
		} else if (DConstants.aipic.equals(insurance)) {
			sb.append("IKY i ");
			type = 2;
		} else if (DConstants.aiai.equals(insurance)) {
			sb.append("LKY l ");
			type = 3;
		}
		sb.append("where ");
		StringBuffer wheret = new StringBuffer();
		if (kekno == null || "".equals(kekno)) {
			switch (type) {
			case 0:
				if (member == null || "".equals(member)) {
					wheret.append("t.copcd = i.copcd ");
					wheret.append("and i.copcd = l.copcd ");
					wheret.append("and t.copcd = '").append(copcd).append("' ");
					wheret.append("and t.telephone = i.telephone ");
					wheret.append("and i.telephone = l.telephone ");
					wheret.append("and t.telephone = '").append(telephone).append("'");
					skFlag = 0;
				} else if (copcd == null || "".equals(copcd)) {
					wheret.append("t.copmember = i.copmember ");
					wheret.append("and i.copmember = l.copmember ");
					wheret.append("and t.copmember = '").append(member).append("' ");
					wheret.append("and t.telephone = i.telephone ");
					wheret.append("and i.telephone = l.telephone ");
					wheret.append("and t.telephone = '").append(telephone).append("'");
					skFlag = 1;
				} else if (telephone == null || "".equals(telephone)) {
					wheret.append("t.copmember = i.copmember ");
					wheret.append("and i.copmember = l.copmember ");
					wheret.append("and t.copmember = '").append(member).append("' ");
					wheret.append("and t.copcd = i.copcd ");
					wheret.append("and i.copcd = l.copcd ");
					wheret.append("and t.copcd = '").append(copcd).append("'");
					skFlag = 2;
				} else {
					wheret.append("t.copmember = i.copmember ");
					wheret.append("and i.copmember = l.copmember ");
					wheret.append("and t.copmember = '").append(member).append("' ");
					wheret.append("and t.copcd = i.copcd ");
					wheret.append("and i.copcd = l.copcd ");
					wheret.append("and t.copcd = '").append(copcd).append("' ");
					wheret.append("and t.telephone = i.telephone ");
					wheret.append("and i.telephone = l.telephone ");
					wheret.append("and t.telephone = '").append(telephone).append("'");
					skFlag = 3;
				}
				break;
			case 1:
				if (member == null || "".equals(member)) {
					wheret.append("t.copcd = '").append(copcd).append("' ");
					wheret.append("and t.telephone = '").append(telephone).append("'");
					skFlag = 4;
				} else if (copcd == null || "".equals(copcd)) {
					wheret.append("t.copmember = '").append(member).append("' ");
					wheret.append("and t.telephone = '").append(telephone).append("'");
					skFlag = 5;
				} else if (telephone == null || "".equals(telephone)) {
					wheret.append("t.copmember = '").append(member).append("' ");
					wheret.append("and t.copcd = '").append(copcd).append("'");
					skFlag = 6;
				} else {
					wheret.append("t.copmember = '").append(member).append("' ");
					wheret.append("and t.copcd = '").append(copcd).append("' ");
					wheret.append("and t.telephone = '").append(telephone).append("'");
					skFlag = 7;
				}
				break;
			case 2:
				if (member == null || "".equals(member)) {
					wheret.append("i.copcd = '").append(copcd).append("' ");
					wheret.append("and i.telephone = '").append(telephone).append("'");
					skFlag = 8;
				} else if (copcd == null || "".equals(copcd)) {
					wheret.append("i.copmember = '").append(member).append("' ");
					wheret.append("and i.telephone = '").append(telephone).append("'");
					skFlag = 9;
				} else if (telephone == null || "".equals(telephone)) {
					wheret.append("i.copmember = '").append(member).append("' ");
					wheret.append("and i.copcd = '").append(copcd).append("'");
					skFlag = 10;
				} else {
					wheret.append("i.copmember = '").append(member).append("' ");
					wheret.append("and i.copcd = '").append(copcd).append("' ");
					wheret.append("and i.telephone = '").append(telephone).append("'");
					skFlag = 11;
				}
				break;
			case 3:
				if (member == null || "".equals(member)) {
					wheret.append("l.copcd = '").append(copcd).append("' ");
					wheret.append("and l.telephone = '").append(telephone).append("'");
					skFlag = 12;
				} else if (copcd == null || "".equals(copcd)) {
					wheret.append("l.copmember = '").append(member).append("' ");
					wheret.append("and l.telephone = '").append(telephone).append("'");
					skFlag = 13;
				} else if (telephone == null || "".equals(telephone)) {
					wheret.append("l.copmember = '").append(member).append("' ");
					wheret.append("and l.copcd = '").append(copcd).append("'");
					skFlag = 14;
				} else {
					wheret.append("l.copmember = '").append(member).append("' ");
					wheret.append("and l.copcd = '").append(copcd).append("' ");
					wheret.append("and l.telephone = '").append(telephone).append("'");
					skFlag = 15;
				}
				break;
			}
		} else {
			switch (type) {
			case 0:
				wheret.append("t.kekno = i.kekno ");
				wheret.append("and i.kekno = l.kekno ");
				wheret.append("and t.kekno = '").append(kekno).append("'");
				skFlag = 16;
				break;
			case 1:
				wheret.append("t.kekno = '").append(kekno).append("'");
				skFlag = 17;
				break;
			case 2:
				wheret.append("i.kekno = '").append(kekno).append("'");
				skFlag = 18;
				break;
			case 3:
				wheret.append("l.kekno = '").append(kekno).append("'");
				skFlag = 19;
				break;
			}
		}
		sb.append(wheret.toString());
		
		info = db.getVector(sb.toString());
		LIFEA002Form nextform = new LIFEA002Form();
		if (info != null && info.size() > 0) {
			nextform.setCopcd((String)info.get(0).get("COPCD"));
			nextform.setKekno((String)info.get(0).get("KEKNO"));
			nextform.setMember((String)info.get(0).get("COPMEMBER"));
			nextform.setTelephone((String)info.get(0).get("TELEPHONE"));
		} else {
			nextform.setCopcd(DConstants.noInput);
			nextform.setKekno(DConstants.noInput);
			nextform.setMember(DConstants.noInput);
			nextform.setTelephone(DConstants.noInput);
		}
		
		StringBuffer countT = new StringBuffer();
		StringBuffer wherets = new StringBuffer();
		countT.append("select count(*) as countt from TSKY where ");
		if (skFlag == 0 || skFlag ==4) {
			wherets.append("copcd = '").append(copcd).append("' ");
			wherets.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 1 || skFlag == 5) {
			wherets.append("copmember = '").append(member).append("' ");
			wherets.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 2 || skFlag == 6) {
			wherets.append("copmember = '").append(member).append("' ");
			wherets.append("and copcd = '").append(copcd).append("'");
		} else if (skFlag == 3 || skFlag == 7) {
			wherets.append("copmember = '").append(member).append("' ");
			wherets.append("and copcd = '").append(copcd).append("' ");
			wherets.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 16 || skFlag == 17) {
			wherets.append("kekno = '").append(kekno).append("'");
		} else {
			wherets.append("kekno = '111111111'");
		}
		countT.append(wherets.toString());
		StringBuffer countI = new StringBuffer();
		StringBuffer whereis = new StringBuffer();
		countI.append("select count(*) as counti from IKY where ");
		if (skFlag == 0 || skFlag == 8) {
			whereis.append("copcd = '").append(copcd).append("' ");
			whereis.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 1 || skFlag == 9) {
			whereis.append("copmember = '").append(member).append("' ");
			whereis.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 2 || skFlag == 10) {
			whereis.append("copmember = '").append(member).append("' ");
			whereis.append("and copcd = '").append(copcd).append("'");
		} else if (skFlag == 3 || skFlag == 11) {
			whereis.append("copmember = '").append(member).append("' ");
			whereis.append("and copcd = '").append(copcd).append("' ");
			whereis.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 16 || skFlag == 18) {
			whereis.append("kekno = '").append(kekno).append("'");
		} else {
			whereis.append("kekno = '111111111'");
		}
		countI.append(whereis.toString());
		StringBuffer countL = new StringBuffer();
		StringBuffer wherels = new StringBuffer();
		countL.append("select count(*) as countl from LKY where ");
		if (skFlag == 0 || skFlag == 12) {
			wherels.append("copcd = '").append(copcd).append("' ");
			wherels.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 1 || skFlag == 13) {
			wherels.append("copmember = '").append(member).append("' ");
			wherels.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 2 || skFlag == 14) {
			wherels.append("copmember = '").append(member).append("' ");
			wherels.append("and copcd = '").append(copcd).append("'");
		} else if (skFlag == 3 || skFlag == 15) {
			wherels.append("copmember = '").append(member).append("' ");
			wherels.append("and copcd = '").append(copcd).append("' ");
			wherels.append("and telephone = '").append(telephone).append("'");
		} else if (skFlag == 16 || skFlag == 19) {
			wherels.append("kekno = '").append(kekno).append("'");
		} else {
			wherels.append("kekno = '111111111'");
		}
		countL.append(wherels.toString());
		infoT = db.getVector(countT.toString());
		infoI = db.getVector(countI.toString());
		infoL = db.getVector(countL.toString());
		if (infoT != null && infoT.size() > 0) {
			nextform.setTskyNum((String)infoT.get(0).get("COUNTT"));
		} else {
			nextform.setTskyNum(DConstants.noInput);
		}
		if (infoI != null && infoI.size() > 0) {
			nextform.setIkyNum((String)infoI.get(0).get("COUNTI"));
		} else {
			nextform.setIkyNum(DConstants.noInput);
		}
		if (infoL != null && infoL.size() > 0) {
			nextform.setLkyNum((String)infoL.get(0).get("COUNTL"));
		} else {
			nextform.setLkyNum(DConstants.noInput);
		}
		StringBuffer tskys = new StringBuffer();
		tskys.append("select * from TSKY where ").append(wherets.toString());
		infoT = db.getVector(tskys.toString());
		nextform.setTsky(infoT);
		nextform.setWheret(tskys.toString());
		StringBuffer ikys = new StringBuffer();
		ikys.append("select * from IKY where ").append(whereis.toString());
		infoI = db.getVector(ikys.toString());
		nextform.setIky(infoI);
		nextform.setWherei(ikys.toString());
		StringBuffer lkys = new StringBuffer();
		lkys.append("select * from LKY where ").append(wherels.toString());
		infoL = db.getVector(lkys.toString());
		nextform.setLky(infoL);
		nextform.setWherel(lkys.toString());
		// 历史记录表
		Vector history = new Vector();
		StringBuffer dhis = new StringBuffer();
		dhis.append("select * from DHISTORY where KEKNO = '").append(info.get(0).get("KEKNO")).append("'");
		history = db.getVector(dhis.toString());
		nextform.setHistory(history);
		req.setAttribute("formdata", nextform);
		if ((infoT == null || infoT.size() == 0) && (infoI == null || infoI.size() == 0) &&
				(infoL == null || infoL.size() == 0)) {
			Msg[0] = "ERR001";
			nextJsp = errJsp;
		}
		Msg[2] = nextJsp;
		req.setAttribute("ErrMsg", Msg[0]);
		req.setAttribute("WarMsg", Msg[1]);
		req.setAttribute("NorMsg", Msg[2]);
		return nextJsp;
	}

}
