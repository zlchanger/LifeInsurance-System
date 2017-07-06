package LIFE.UTIL;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NwResourceMap {
	private static final String fileName = "RESOURCECTL.resourcectl_zh";
	Pattern URL_RES_KEY_PTN = Pattern.compile("resourceid.(.*?).url");
	private static  NwResourceMap instance = new NwResourceMap();
	private ResourceBundle resource = null;
	private Hashtable mapTable = null;
	private Map<String,String> urlResMap = null;
	private static final String RESOURCE_F = "resourceid.";
	private NwResourceMap() {
		try {
			resource = ResourceBundle.getBundle(fileName);
		}catch(Exception e) {
			instance = null;
			return;
		}
		Enumeration keys = resource.getKeys();
		mapTable = new Hashtable();
		while(keys.hasMoreElements()) {
			String resourceId = (String)keys.nextElement();
			String val = resource.getString(resourceId);
			mapTable.put(resourceId, val);
			urlResMap = loadUrlResMap(resource);
		}
	}
	private Map<String,String> loadUrlResMap(ResourceBundle bundle) {
		Map<String,String> map = new HashMap();
		for (Enumeration<String> e = bundle.getKeys(); e.hasMoreElements();) {
			String key = e.nextElement();
			Matcher m = URL_RES_KEY_PTN.matcher(key);
			if (m.matches()) {
				String resourceId = m.group(1);
				String v = bundle.getString(key);
				map.put(v, resourceId);
			}
		}
		return map;
	}
	public static NwResourceMap getInstance() {
		return instance;
	}

	public String getUrl(String resourceId) {
		String key = RESOURCE_F + resourceId + ".url";
		return getvalue(key);
	}

	public String getFormBeanName(String resourceId) {
		String key = RESOURCE_F + resourceId + ".form";
		return getvalue(key);
	}

	private String getvalue(String key) {
		try {
			String val = (String)mapTable.get(key);
			if (val != null) {
				return val;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
