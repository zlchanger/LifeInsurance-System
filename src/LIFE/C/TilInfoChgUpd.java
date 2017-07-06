package LIFE.C;

import java.util.Hashtable;

import LIFE.UTIL.DChange;

public class TilInfoChgUpd {
	public DChange dc = new DChange();
	public String uktkno = "";
	public String sido = "";
	public String cdflg = "";
	public String copcd = "";
	public String copmember = "";
	public String telephone = "";
	public String kamanam = "";
	public String kamanax = "";
	public String birthday = "";
	public String sex = "";
	public String addre = "";
	public String zipcode = "";
	public String tele = "";
	public String applyymd = "";
	public String effectymd = "";
	public String happpenymd = "";
	public String kekno = "";
	public String kamanaflg = "";
	public String bkamanam = "";
	public String bkamanax = "";
	public String birthdayflg = "";
	public String bbirthday = "";
	public String sexflg = "";
	public String bsex = "";
	public String addreflg = "";
	public String baddre = "";
	public String teleflg = "";
	public String btele = "";
	public String othflg = "";
	public String bzipcode = "";
	public String physi = "";
	public String bphysi = "";
	public String occupation = "";
	public String boccupation = "";
	
	public void init() {
		uktkno = "";
		sido = "";
		cdflg = "1";
		copcd = "";
		copmember = "";
		telephone = "";
		kamanam = "";
		kamanax = "";
		birthday = "";
		sex = "";
		addre = "";
		zipcode = "";
		tele = "";
		applyymd = "";
		effectymd = "";
		happpenymd = "";
		kekno = "";
		kamanaflg = "0";
		bkamanam = "";
		bkamanax = "";
		birthdayflg = "0";
		bbirthday = "";
		sexflg = "0";
		bsex = "";
		addreflg = "0";
		baddre = "";
		teleflg = "0";
		btele = "";
		othflg = "0";
		bzipcode = "";
		physi = "";
		bphysi = "";
		occupation = "";
		boccupation = "";
	}
	
	public void setUktkno(String uktkno) {
		this.uktkno = uktkno;
	}
	
	public String getUktkno() {
		return uktkno;
	}
	
	public void setSido(String sido) {
		this.sido = sido;
	}
	
	public String getSido() {
		return sido;
	}
	
	public void setCdflg(String cdflg) {
		this.cdflg = cdflg;
	}
	
	public String getCdflg() {
		return cdflg;
	}
	
	public void setCopcd(String copcd) {
		this.copcd = copcd;
	}
	
	public String getCopcd() {
		return copcd;
	}
	
	public void setCopmember(String copmember) {
		this.copmember = copmember;
	}
	
	public String getCopmember() {
		return copmember;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setKamanam(String kamanam) {
		this.kamanam = kamanam;
	}
	
	public String getKamanam() {
		return kamanam;
	}
	
	public void setKamanax(String kamanax) {
		this.kamanax = kamanax;
	}
	
	public String getKamanax() {
		return kamanax;
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
	
	public void setAddre(String addre) {
		this.addre = addre;
	}
	
	public String getAddre() {
		return addre;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public String getTele() {
		return tele;
	}
	
	public void setApplyymd(String applyymd) {
		this.applyymd = applyymd;
	}
	
	public String getApplyymd() {
		return applyymd;
	}
	
	public void setEffectymd(String effectymd) {
		this.effectymd = effectymd;
	}
	
	public String getEffectymd() {
		return effectymd;
	}
	
	public void setHapppenymd(String happpenymd) {
		this.happpenymd = happpenymd;
	}
	
	public String getHapppenymd() {
		return happpenymd;
	}
	
	public void setKekno(String kekno) {
		this.kekno = kekno;
	}
	
	public String getKekno() {
		return kekno;
	}
	public void setKamanaflg(String kamanaflg) {
		this.kamanaflg = kamanaflg;
	}
	
	public String getKamanaflg() {
		return kamanaflg;
	}
	
	public void setBkamanam(String bkamanam) {
		this.bkamanam = bkamanam;
	}
	
	public String getBkamanam() {
		return bkamanam;
	}
	
	public void setBkamanax(String bkamanax) {
		this.bkamanax = bkamanax;
	}
	
	public String getBkamanax() {
		return bkamanax;
	}
	
	public void setBirthdayflg(String birthdayflg) {
		this.birthdayflg = birthdayflg;
	}
	
	public String getBirthdayflg() {
		return birthdayflg;
	}
	
	public void setBBirthday(String bbirthday) {
		this.bbirthday = bbirthday;
	}
	
	public String getBBirthday() {
		return bbirthday;
	}
	
	public void setSexflg(String sexflg) {
		this.sexflg = sexflg;
	}
	
	public String getSexflg() {
		return sexflg;
	}
	
	public void setBsex(String bsex) {
		this.bsex = bsex;
	}
	
	public String getBsex() {
		return bsex;
	}
	
	public void setAddreflg(String addreflg) {
		this.addreflg = addreflg;
	}
	
	public String getAddreflg() {
		return addreflg;
	}
	
	public void setBAddre(String baddre) {
		this.baddre = baddre;
	}
	
	public String getBaddre() {
		return baddre;
	}
	
	public void setTeleflg(String teleflg) {
		this.teleflg = teleflg;
	}
	
	public String getTeleflg() {
		return teleflg;
	}
	
	public void setBtele(String btele) {
		this.btele = btele;
	}
	
	public String getBtele() {
		return btele;
	}
	
	public void setOthflg(String othflg) {
		this.othflg = othflg;
	}
	
	public String getOthflg() {
		return othflg;
	}
	
	public void setBzipcode(String bzipcode) {
		this.bzipcode = bzipcode;
	}
	
	public String getBzipcode() {
		return bzipcode;
	}
	
	public void setPhysi(String physi) {
		this.physi = physi;
	}
	
	public String getPhysi() {
		return physi;
	}
	
	public void setBphysi(String bphysi) {
		this.bphysi = bphysi;
	}
	
	public String getBphysi() {
		return bphysi;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setBoccupation(String boccupation) {
		this.boccupation = boccupation;
	}
	
	public String getBoccupation() {
		return boccupation;
	}
	public void setData(Hashtable<String, String> tilvec, LIFEC001Form form, String uktkno) {
		init();
		setUktkno(uktkno);
		setSido(tilvec.get("SEIDO"));
		setCopcd(tilvec.get("COPCD"));
		setCopmember(tilvec.get("COPMEMBER"));
		setTelephone(tilvec.get("TELEPHONE"));
		setKamanam(form.getKamanam());
		setKamanax(form.getKamanax());
		setBirthday(dc.toYMD((String)form.getBirthday()));
		setSex(dc.sexcode(form.getSex()));
		setAddre(form.getAddre());
		setZipcode(form.getZipcode());
		setTele(dc.telecode(form.getTele().trim()));
		setPhysi(dc.physicalCode(form.getPhysicalcase()));
		setOccupation(form.getOccupation());
		setApplyymd(tilvec.get("APPLYYMD"));
		setEffectymd(tilvec.get("EFFECTYMD"));
		setHapppenymd(tilvec.get("HAPPENYMD"));
		setKekno(tilvec.get("KEKNO"));
		setKamanaflg(form.getnameflg());
		setBirthdayflg(form.getbirthflg());
		setSexflg(form.getsexflg());
		setAddreflg(form.getwheflg());
		setTeleflg(form.getteleflg());
		setOthflg(form.getothflg());
	}
	
	public void setData(LIFEC001Form form) {
		setBkamanam(form.getKamanam());
		setBkamanax(form.getKamanax());
		setBBirthday(dc.toYMD((String)form.getBirthday()));
		setBsex(dc.sexcode(form.getSex()));
		setBAddre(form.getAddre());
		setBzipcode(form.getZipcode());
		setBtele(dc.telecode(form.getTele().trim()));
		setBphysi(dc.physicalCode(form.getPhysicalcase()));
		setBoccupation(form.getOccupation());
	}
	
	public void setFlg(String nameflg, String birflg, String teleflg, String sexflg, String wheflg, String othflg) {
		setKamanaflg(nameflg);
		setBirthdayflg(birflg);
		setTeleflg(teleflg);
		setSexflg(sexflg);
		setAddreflg(wheflg);
		setOthflg(othflg);
	}
	
	public String executeTil() {
		StringBuffer qry = new StringBuffer();
		StringBuffer qry1 = new StringBuffer();
		StringBuffer query = new StringBuffer();
		qry.append(" UKTKNO");
		qry1.append("'").append(uktkno).append("', ");
		qry.append(", SIDO");
		qry1.append("'").append(sido).append("', ");
		qry.append(", CDFLG");
		qry1.append("'").append(cdflg).append("', ");
		qry.append(", COPCD");
		qry1.append("'").append(copcd).append("', ");
		qry.append(", COPMEMBER");
		qry1.append("'").append(copmember).append("', ");
		qry.append(", TELEPHONE");
		qry1.append("'").append(telephone).append("', ");
		qry.append(", KAMANAM");
		qry1.append("'").append(kamanam).append("', ");
		qry.append(", KAMANAX");
		qry1.append("'").append(kamanax).append("', ");
		qry.append(", BIRTHDAY");
		qry1.append("'").append(birthday).append("', ");
		qry.append(", SEX");
		qry1.append("'").append(sex).append("', ");
		qry.append(", ADDRE");
		qry1.append("'").append(addre).append("', ");
		qry.append(", ZIPCODE");
		qry1.append("'").append(zipcode).append("', ");
		qry.append(", TELE");
		qry1.append("'").append(tele).append("', ");
		qry.append(", APPLYYMD");
		qry1.append("'").append(applyymd).append("', ");
		qry.append(", EFFECTYMD");
		qry1.append("'").append(effectymd).append("', ");
		qry.append(", HAPPENYMD");
		qry1.append("'").append(happpenymd).append("', ");
		qry.append(", KEKNO");
		qry1.append("'").append(kekno).append("', ");
		qry.append(", KAMANAFLG");
		qry1.append("'").append(kamanaflg).append("', ");
		qry.append(", BKAMANAM");
		qry1.append("'").append(bkamanam).append("', ");
		qry.append(", BKAMANAX");
		qry1.append("'").append(bkamanax).append("', ");
		qry.append(", BIRTHDAYFLG");
		qry1.append("'").append(birthdayflg).append("', ");
		qry.append(", BBIRTHDAY");
		qry1.append("'").append(bbirthday).append("', ");
		qry.append(", SEXFLG");
		qry1.append("'").append(sexflg).append("', ");
		qry.append(", BSEX");
		qry1.append("'").append(bsex).append("', ");
		qry.append(", ADDREFLG");
		qry1.append("'").append(addreflg).append("', ");
		qry.append(", BADDRE");
		qry1.append("'").append(baddre).append("', ");
		qry.append(", TELEFLG");
		qry1.append("'").append(teleflg).append("', ");
		qry.append(", BTELE");
		qry1.append("'").append(btele).append("', ");
		qry.append(", OTHFLG");
		qry1.append("'").append(othflg).append("', ");
		qry.append(", BZIPCODE");
		qry1.append("'").append(bzipcode).append("', ");
		qry.append(", PHYSI");
		qry1.append("'").append(physi).append("', ");
		qry.append(", BPHYSI");
		qry1.append("'").append(bphysi).append("', ");
		qry.append(", OCCUPATION");
		qry1.append("'").append(occupation).append("', ");
		qry.append(", BOCCUPATION");
		qry1.append("'").append(boccupation).append("'");
		
		query.append("insert into TILINFOCHG (");
		query.append(qry.toString());
		query.append(") values (");
		query.append(qry1.toString()).append(")");
		return query.toString();
	}
	
	public String dele(String uktkno) {
		StringBuffer qry = new StringBuffer();
		qry.append("DELETE FROM TILINFOCHG WHERE UKTKNO = '").append(uktkno).append("'");
		return qry.toString();
	}
	
	public String selects(String uktkno) {
		StringBuffer qry = new StringBuffer();
		qry.append("SELECT * FROM TILINFOCHG WHERE UKTKNO = '").append(uktkno).append("'");
		return qry.toString();
	}
	
	public String updateTil(String uktkno) {
		StringBuffer qry = new StringBuffer();
		int flg = 0;
		qry.append("update TILINFOCHG set ");
		if ("1".equals(kamanaflg)) {
			qry.append("BKAMANAM = '").append(bkamanam).append("', ");
			qry.append("BKAMANAX = '").append(bkamanax).append("'");
			flg++;
		}
		if ("1".equals(birthdayflg)) {
			if (flg > 0) {
				qry.append(", ");
			}
			qry.append("BBIRTHDAY = '").append(bbirthday).append("'");
			flg++;
		}
		if ("1".equals(teleflg)) {
			if (flg > 0) {
				qry.append(", ");
			}
			qry.append("BTELE = '").append(btele).append("'");
			flg++;
		}
		if ("1".equals(sexflg)) {
			if (flg > 0) {
				qry.append(", ");
			}
			qry.append("BSEX = '").append(bsex).append("'");
			flg++;
		}
		if ("1".equals(addreflg)) {
			if (flg > 0) {
				qry.append(", ");
			}
			qry.append("BADDRE = '").append(baddre).append("', ");
			qry.append("BZIPCODE = '").append(bzipcode).append("'");
			flg++;
		}
		if ("1".equals(othflg)) {
			if (flg > 0) {
				qry.append(", ");
			}
			qry.append("BPHYSI = '").append(bphysi).append("', ");
			qry.append("BOCCUPATION = '").append(boccupation).append("'");
		}
		if (flg > 0) {
			qry.append(", ");
		}
		qry.append("CDFLG = '2'");
		qry.append(" where UKTKNO = '").append(uktkno).append("'");
		return qry.toString();
	}
}
