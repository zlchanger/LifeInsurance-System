package LIFE.UTIL;

import javax.servlet.http.HttpServletRequest;

public class NwCommonAction {
	
	String NORMAL_KEY = "NorMsg";
	String WARNING_KEY = "WarMsg";
	String ERROR_KEY = "ErrMsg";
	String FORM_KEY = "view";
	String NONE_MESSAGE = "";
	
	public void setNormalMessage(String message ) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(NORMAL_KEY, message);
	}
	
	public String getNormalMessage() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		return (String)req.getAttribute(NORMAL_KEY);
	}
	
	public void removeNormalMessage() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(NORMAL_KEY, NONE_MESSAGE);
	}
	
	public void setWarningMessage(String message) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(WARNING_KEY, message);
	}
	
	public String getWarningMessage() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		return (String)req.getAttribute(WARNING_KEY);
	}
	
	public void removeWarningMessage() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(WARNING_KEY, NONE_MESSAGE);
	}
	
	public void setErrorMessage(String message) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(ERROR_KEY, message);
	}
	
	public String getErrorMessage() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		return (String)req.getAttribute(ERROR_KEY);
	}
	
	public void removeErrorMessage() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(ERROR_KEY, NONE_MESSAGE);
	}
	
	public void setRequest(String key, Object value) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(key, value);
	}
	
	public String getRequest(String key) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		return (String)req.getAttribute(key);
	}
	
	public void removeRequest(String key) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.removeAttribute(key);
	}
	
	protected NwCommonForm createForm(String resourceId) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		NwResourceMap map = NwResourceMap.getInstance();
		String className = map.getFormBeanName(resourceId);
		NwCommonForm form = (NwCommonForm)Class.forName(className).newInstance();
		form.setter("sid", resourceId);
		return form;
	}
	
	public void setForm(NwCommonForm form) {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(FORM_KEY, form);
	}
	
	public NwCommonForm getForm() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		return (NwCommonForm)req.getAttribute(FORM_KEY);
	}
	
	public void removeForm() {
		HttpServletRequest req = NwCommonServletEx.requestHolder.get();
		req.setAttribute(FORM_KEY, NONE_MESSAGE);
	}
}
