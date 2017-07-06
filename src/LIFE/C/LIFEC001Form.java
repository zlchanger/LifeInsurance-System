package LIFE.C;

import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import LIFE.I.DbIky;
import LIFE.L.DbLky;
import LIFE.T.DbTsky;
import LIFE.UTIL.NwCommonForm;

public class LIFEC001Form extends NwCommonForm {
	public Vector<Hashtable<String, String>> tsky = new Vector<Hashtable<String, String>>();
	public Vector<Hashtable<String, String>> iky = new Vector<Hashtable<String, String>>();
	public Vector<Hashtable<String, String>> lky = new Vector<Hashtable<String, String>>();
	public String tele = "";
	public String zipcode = "";
	public String addre = "";
	public String physicalcase = "";
	public String occupation = "";
	public String kamanax = "";
	public String kamanam = "";
	public String birthday = "";
	public String sex = "";
	public String assign = "";
	public String note1 = "";
	public String note2 = "";
	public String note3 = "";
	public String nameflg = "0";
	public String birthflg = "0";
	public String teleflg = "0";
	public String sexflg = "0";
	public String wheflg = "0";
	public String othflg = "0";
	
	public void settsky(Vector tsky) {
		this.tsky = tsky;
	}
	
	public Vector gettsky() {
		return tsky;
	}
	
	public void setiky(Vector iky) {
		this.iky = iky;
	}
	
	public Vector getiky() {
		return iky;
	}
	
	public void setlky(Vector lky) {
		this.lky = lky;
	}
	
	public Vector getlky() {
		return lky;
	}
	
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public String getTele() {
		return tele;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setAddre(String addre) {
		this.addre = addre;
	}
	
	public String getAddre() {
		return addre;
	}
	
	public void setPhysicalcase(String physicalcase) {
		this.physicalcase = physicalcase;
	}
	
	public String getPhysicalcase() {
		return physicalcase;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setKamanax(String kamanax) {
		this.kamanax = kamanax;
	}
	
	public String getKamanax() {
		return kamanax;
	}
	
	public void setKamanam(String kamanam) {
		this.kamanam = kamanam;
	}
	
	public String getKamanam() {
		return kamanam;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setAssign(String assign) {
		this.assign = assign;
	}
	
	public String getAssign() {
		return assign;
	}
	
	public void setNote1(String note1) {
		this.note1 = note1;
	}
	
	public String getNote1() {
		return note1;
	}
	
	public void setNote2(String note2) {
		this.note2 = note2;
	}
	
	public String getNote2() {
		return note2;
	}
	
	public void setNote3(String note3) {
		this.note3 = note3;
	}
	
	public String getNote3() {
		return note3;
	}
	
	public void setnameflg(String nameflg) {
		this.nameflg = nameflg;
	}
	
	public String getnameflg() {
		return nameflg;
	}
	
	public void setbirthflg(String birthflg) {
		this.birthflg = birthflg;
	}
	
	public String getbirthflg() {
		return birthflg;
	}
	
	public void setteleflg(String teleflg) {
		this.teleflg = teleflg;
	}
	
	public String getteleflg() {
		return teleflg;
	}
	
	public void setsexflg(String sexflg) {
		this.sexflg = sexflg;
	}
	
	public String getsexflg() {
		return sexflg;
	}
	
	public void setwheflg(String wheflg) {
		this.wheflg = wheflg;
	}
	
	public String getwheflg() {
		return wheflg;
	}
	
	public void setothflg(String othflg) {
		this.othflg = othflg;
	}
	
	public String getothflg() {
		return othflg;
	}
	
	public void setNextList(HttpServletRequest request) {
		String[] tflg = (String[])request.getParameterValues("tsky");
		String[] iflg = (String[])request.getParameterValues("iky");
		String[] lflg = (String[])request.getParameterValues("lky");
		if (tflg != null && tflg.length > 0) {
			DbTsky dbtsky = new DbTsky();
			tsky = dbtsky.getTskysByKekno(tflg);
		}
		if (iflg != null && iflg.length > 0) {
			DbIky dbiky = new DbIky();
			iky = dbiky.getIkysByKekno(iflg);
		}
		if (lflg != null && lflg.length > 0) {
			DbLky dblky = new DbLky();
			lky = dblky.getLkysByKekno(lflg);
		}
		String[] nf = (String[])request.getParameterValues("nam");
		String[] bf = (String[])request.getParameterValues("bir");
		String[] tf = (String[])request.getParameterValues("telep");
		String[] sf = (String[])request.getParameterValues("se");
		String[] wf = (String[])request.getParameterValues("whe");
		String[] of = (String[])request.getParameterValues("oth");
		if (nf != null && nf.length > 0) {
			setnameflg("1");
		}
		if (bf != null && bf.length > 0) {
			setbirthflg("1");
		}
		if (tf != null && tf.length > 0) {
			setteleflg("1");
		}
		if (sf != null && sf.length > 0) {
			setsexflg("1");
		}
		if (wf != null && wf.length > 0) {
			setwheflg("1");
		}
		if (of != null && of.length > 0) {
			setothflg("1");
		}
	}
	
	public String checkName() {
		if ("1".equals(nameflg)) {
			return "checked";
		} else {
			return "";
		}
	}
	
	public String checkBir() {
		if ("1".equals(birthflg)) {
			return "checked";
		} else {
			return "";
		}
	}
	
	public String checkTele() {
		if ("1".equals(teleflg)) {
			return "checked";
		} else {
			return "";
		}
	}
	
	public String checkSex() {
		if ("1".equals(sexflg)) {
			return "checked";
		} else {
			return "";
		}
	}
	
	public String checkWhe() {
		if ("1".equals(wheflg)) {
			return "checked";
		} else {
			return "";
		}
	}
	
	public String checkOth() {
		if ("1".equals(othflg)) {
			return "checked";
		} else {
			return "";
		}
	}
	
	public String disableName() {
		if ("0".equals(nameflg)) {
			return "disabled";
		} else {
			return "";
		}
	}
	
	public String disableBir() {
		if ("0".equals(birthflg)) {
			return "disabled";
		} else {
			return "";
		}
	}
	
	public String disableTele() {
		if ("0".equals(teleflg)) {
			return "disabled";
		} else {
			return "";
		}
	}
	
	public String disableSex() {
		if ("0".equals(sexflg)) {
			return "disabled";
		} else {
			return "";
		}
	}
	
	public String disableWhe() {
		if ("0".equals(wheflg)) {
			return "disabled";
		} else {
			return "";
		}
	}
	
	public String disableOth() {
		if ("0".equals(othflg)) {
			return "disabled";
		} else {
			return "";
		}
	}
}
