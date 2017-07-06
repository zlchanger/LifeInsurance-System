package LIFE.L;

import java.util.Hashtable;
import java.util.Vector;

import LIFE.UTIL.DBselect;
import LIFE.UTIL.NwException;

public class DbLky {
	Vector<Hashtable<String,String>> lky = new Vector<Hashtable<String,String>>();
	DBselect db = new DBselect();
	public String getDbSql() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from LKY ");
		return sb.toString();
	}
	
	public Vector<Hashtable<String,String>> getLkysByKekno(String[] kekno,String[] msg) {
		if (kekno == null || kekno.length == 0) {
			msg[0] = "ERR001";
			return lky;
		}
		StringBuffer wheres = new StringBuffer();
		wheres.append("where kekno in ( ");
		for(int i = 0; i < kekno.length-1; i++) {
			wheres.append("'").append(kekno[i]).append("', ");
		}
		wheres.append("'").append(kekno[kekno.length-1]).append("' )");
		String sql = getDbSql() + wheres.toString();
		try {
			lky = db.getVector(sql);
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lky;
	}
	
	public Vector<Hashtable<String,String>> getLkysByKekno(String[] kekno) {
		if (kekno == null || kekno.length == 0) {
			return lky;
		}
		StringBuffer wheres = new StringBuffer();
		wheres.append("where kekno in ( ");
		for(int i = 0; i < kekno.length-1; i++) {
			wheres.append("'").append(kekno[0]).append("', ");
		}
		wheres.append("'").append(kekno[kekno.length-1]).append("' )");
		String sql = getDbSql() + wheres.toString();
		try {
			lky = db.getVector(sql);
		} catch (NwException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lky;
	}
}
