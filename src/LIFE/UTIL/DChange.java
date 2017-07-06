package LIFE.UTIL;

/*
 * 2017/3/25
 */

public class DChange {
	public String nullCheck(String ob) {
		if(ob == null || ob.length() == 0) {
			return "";
		} else if(ob.trim().length() == 0) {
			return "";
		}
		return ob;
	}
	
	public String toYYMMDD(String date) {
		date = date.trim();
		StringBuffer ymd = new StringBuffer();
		if (isEmpty(date)) {
			return date;
		}  else {
			ymd.append(date.substring(0,4)).append("/").append(date.substring(4,6)).append("/").append(date.substring(6));
			date = ymd.toString();
			return date;
		}
	}
	
	public boolean isEmpty(String ob) {
		if(ob == null || ob.length() == 0) {
			return true;
		} else if (ob.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public String sexShow(String code) {
		if(isEmpty(code)) {
			return DConstants.sexUnknow;
		} else {
			if ("1".equals(code.trim())) {
				return DConstants.sexMale;
			} else if("2".equals(code.trim())) {
				return DConstants.sexFemale;
			} else {
				return DConstants.sexUnknow;
			}
		}
	}
	
	public String changeShow(String code) {
		if (isEmpty(code)) {
			return DConstants.nochange;
		} else {
			if ("1".equals(code.trim())) {
				return DConstants.nochange;
			} else if ("2".equals(code.trim())) {
				return DConstants.onechange;
			} else if ("3".equals(code.trim())) {
				return DConstants.endchange;
			} else {
				return DConstants.nochange;
			}
		}
	}
	
	public String teleChange(String tele) {
		StringBuffer telephone = new StringBuffer();
		if (isEmpty(tele)) {
			return tele;
		} else {
			if (tele.trim().length() != 11) {
				return "";
			} else {
				telephone.append(tele.substring(0,3)).append("-").append(tele.substring(3,7)).append("-").append(tele.substring(7));
				tele = telephone.toString();
				return tele;
			}
		}
	}
	
	public String modeChange(String code) {
		if(isEmpty(code)) {
			return "";
		} else {
			if ("1".equals(code.trim())) {
				return DConstants.monthPay;
			} else if ("2".equals(code.trim())) {
				return DConstants.quarterPay;
			} else if ("3".equals(code.trim())) {
				return DConstants.yearPay;
			} else {
				return "";
			}
		}
	}
	
	public String physicalChange(String physical) {
		if(isEmpty(physical)) {
			return "";
		} else {
			if ("1".equals(physical.trim())) {
				return DConstants.phygood;
			} else if ("2".equals(physical.trim())) {
				return DConstants.phynormal;
			} else if ("3".equals(physical.trim())) {
				return DConstants.phybad;
			} else if ("4".equals(physical.trim())) {
				return DConstants.phybader;
			} else {
				return "";
			}
		}
	}
	
	public String toYMD(String date) {
		date = date.trim();
		StringBuffer ymd = new StringBuffer();
		if(isEmpty(date)) {
			return "";
		} else {
			ymd.append(date.substring(0,4)).append(date.substring(5,7)).append(date.substring(8));
			date = ymd.toString();
			return date;
		}
	}
	
	public String sexcode(String sex) {
		if (sex.equals(DConstants.sexMale)) {
			return "1";
		} else if (sex.equals(DConstants.sexFemale)) {
			return "2";
		} else {
			return "";
		}
	}
	
	public String telecode(String tele) {
		StringBuffer telephone = new StringBuffer();
		if (isEmpty(tele)) {
			return tele;
		} else {
			if (tele.trim().length() != 13) {
				return "";
			} else {
				telephone.append(tele.substring(0,3)).append(tele.substring(4,8)).append(tele.substring(9));
				tele = telephone.toString();
				return tele;
			}
		}
	}
	
	public String physicalCode(String physical) {
		if(isEmpty(physical)) {
			return "";
		} else {
			if (physical.equals(DConstants.phygood)) {
				return "1";
			} else if (physical.equals(DConstants.phynormal)) {
				return "2";
			} else if (physical.equals(DConstants.phybad)) {
				return "3";
			} else if (physical.equals(DConstants.phybader)) {
				return "4";
			} else {
				return "";
			}
		}
	}
	
	public String deedChange(String deedcode) {
		if (isEmpty(deedcode)) {
			return "";
		} else {
			if (DConstants.tsido.equals(deedcode)) {
				return DConstants.taskei;
			} else if (DConstants.isido.equals(deedcode)) {
				return DConstants.aipic;
			} else if (DConstants.lsido.equals(deedcode)) {
				return DConstants.aiai;
			} else {
				return "";
			}
		}
	}
	
	public String login(String islogin) {
		if (isEmpty(islogin)) {
			return "ÊÇ";
		} else {
			if ("0".equals(islogin)) {
				return "·ñ";
			} else {
				return "ÊÇ";
			}
		}
	}
	
	public String power(String power) {
		if (isEmpty(power)) {
			return DConstants.normal;
		} else {
			if ("1".equals(power)) {
				return DConstants.manager;
			} else {
				return DConstants.normal;
			}
		}
	}
}
