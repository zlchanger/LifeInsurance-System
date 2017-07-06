package LIFE.UTIL;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NwCommonForm {
	public void getParamter(HttpServletRequest request, HttpServletResponse response) {
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()) {
			Object obj = e.nextElement();
			String name = (String)obj;
			String[] sName = request.getParameterValues(name);
			if (sName.length == 1) {
				String sName1 = sName[0];
				this.setter(name,sName1);
			} else {
				this.setter(name,sName);
			}
		}
	}

	public void setFormNextList(HttpServletRequest request) {
		String className = getClass().getName();
		try {
			Method[] m = Class.forName(className).getMethods();
			for (int i = 0; i < m.length; i++) {
				if (m[i].getName().equals("setNextList")) {
					Object[] prm = { request };
					m[i].invoke(this, prm);
					break;
				}
			}
		}catch(ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

	public void setFormBackList(HttpServletRequest request) {
		String className = getClass().getName();
		try {
			Method[] m = Class.forName(className).getMethods();
			for (int i = 0; i < m.length; i++) {
				if (m[i].getName().equals("setBackList")) {
					Object[] prm = { request };
					m[i].invoke(this, prm);
					break;
				}
			}
		}catch(ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

	public void setter(String methodname, String[] setVal) {
		try {
			String className = getClass().getName();
			Method[] m = Class.forName(className).getMethods();
			String setMethodname = "";
			for (int i = 0; i < m.length; i++) {
				String first = methodname.substring(0,1);
				String last = methodname.substring(1);
				setMethodname = "set" + first.toUpperCase() + last;
				if (m[i].getName().equals(setMethodname)) {
					Object[] prm = { setVal };
					m[i].invoke(this, prm);
				}
			}
		}catch(ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

	public void setter(String methodname, String setVal) {
		try {
			String className = getClass().getName();
			Method[] m = Class.forName(className).getMethods();
			String setMethodname = "";
			for (int i = 0; i < m.length; i++) {
				String first = methodname.substring(0,1);
				String last = methodname.substring(1);
				setMethodname = "set" + first.toUpperCase() + last;
				if (m[i].getName().equals(setMethodname)) {
					Object[] prm = { setVal };
					m[i].invoke(this, prm);
				}
			}
		}catch(ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
}
