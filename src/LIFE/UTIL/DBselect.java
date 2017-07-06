package LIFE.UTIL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class DBselect {
	public Vector getVector(String qry)throws NwException {
		Connection con = null;
		Vector tilvec = new Vector<>();
		Vector typvec = new Vector<>();
		Vector recvec = new Vector<>();
		GetDbCon dbcon = new GetDbCon();
		int sti = 0;
		try {
			dbcon.DBDriverLoad();
			con = dbcon.getConnection();
			if (con == null) {
				sti = -1;
			}
		} catch (NwException e) {
			e.printStackTrace();
		}
		try { 
			ResultSet rset = null;
			Statement stmt = null;
			if (sti == 0) {
				stmt = con.createStatement();
				if (stmt == null) {
					sti = -1;
				}
			}
			if (sti == 0) {
				rset = stmt.executeQuery(qry);
				if (rset == null) {
					sti = -1;
				}
			}
			if (sti == 0) {
				ResultSetMetaData dbTitle = rset.getMetaData();
				int colcnt = dbTitle.getColumnCount();
				for (int i = 1; i <= colcnt; i++) {
					tilvec.addElement(dbTitle.getColumnName(i));
					typvec.addElement(dbTitle.getColumnTypeName(i));
				}
				while (rset.next()) {
					Hashtable bufhash = new Hashtable<>();
					for (int i = 0; i < colcnt; i++) {
						String colum = (String)tilvec.get(i);
						String coltp = (String)typvec.get(i);
						String data = "";
						if (coltp.equalsIgnoreCase("DATE")) {
							java.sql.Timestamp dt = rset.getTimestamp(colum);
							if (dt == null) {
								data = "";
							} else {
								data = checkNull(dt.toString());
							}
						} else {
							data = checkNull(rset.getString(colum));
						}
						bufhash.put(colum, data);
					}
					recvec.addElement(bufhash);
				}
			}
			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			dbcon.ConnectionClose();
		} catch (SQLException e) {
			dbcon.ConnectionClose();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recvec;
	}

	public ArrayList getArrayList(String qry)throws NwException {

		Connection con = null;
		ArrayList tilvec = new ArrayList();
		ArrayList typvec = new ArrayList();
		ArrayList recvec = new ArrayList();
		GetDbCon dbcon = new GetDbCon();
		int sti = 0;
		try {
			dbcon.DBDriverLoad();
			con = dbcon.getConnection();
			if (con == null) {
				sti = -1;
			}
		} catch (NwException e) {
			e.printStackTrace();
		}
		try { 
			ResultSet rset = null;
			Statement stmt = null;
			if (sti == 0) {
				stmt = con.createStatement();
				if (stmt == null) {
					sti = -1;
				}
			}
			if (sti == 0) {
				rset = stmt.executeQuery(qry);
				if (rset == null) {
					sti = -1;
				}
			}
			if (sti == 0) {
				ResultSetMetaData dbTitle = rset.getMetaData();
				int colcnt = dbTitle.getColumnCount();
				for (int i = 1; i < colcnt; i++) {
					tilvec.add(dbTitle.getColumnName(i));
					typvec.add(dbTitle.getColumnTypeName(i));
				}
				while (rset.next()) {
					Hashtable bufhash = new Hashtable<>();
					for (int i = 0; i < colcnt; i++) {
						String colum = (String)tilvec.get(i);
						String coltp = (String)typvec.get(i);
						String data = "";
						if (coltp.equalsIgnoreCase("DATE")) {
							java.sql.Date dt = rset.getDate(colum);
							if (dt == null) {
								data = "";
							} else {
								data = checkNull(dt.toString());
							}
						} else {
							data = checkNull(rset.getString(colum));
						}
						bufhash.put(colum, data);
					}
					recvec.add(bufhash);
				}
			}
			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			dbcon.ConnectionClose();
		} catch (SQLException e) {
			dbcon.ConnectionClose();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recvec;
	
	}
	public String checkNull(String str) {
		 if (str == null) {
			 return "";
		 } else if (str.trim().length() == 0) {
			 return "";
		 }
		 return str;
	 }
	
	public void sqlexcute(Vector query) {
		Connection con = null;
		Statement stmt = null;
		String Errcd = "";
		GetDbCon dbcon = new GetDbCon();
		int sti = 0;
		try {
			dbcon.DBDriverLoad();
			con = dbcon.getConnection();
			if (con == null) {
				Errcd = "ERR001";
				sti = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String qry = "";
		if (sti == 0) {
			try {
				con.setAutoCommit(false);
				for (int i = 0; i < query.size(); i++) {
					qry = (String)query.get(i);
					if (qry.length() > 0) {
						stmt = con.createStatement();
						int ret = stmt.executeUpdate(qry);
						if (ret == 0) {
							sti = -1;
							Errcd = "ERR001";
							con.rollback();
							break;
						}
						stmt.close();
						if (sti == 0) {
							con.commit();
						} else {
							con.rollback();
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				if (stmt != null) {
					try {
						stmt.close();
						con.setAutoCommit(true);
						dbcon.ConnectionClose();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
