package LIFE.UTIL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.ThreadLocal;
import java.lang.reflect.Method;;

public class NwCommonServletEx extends NwCommonServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
	protected static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();
	protected static ThreadLocal<NwCommonForm> formHolder = new ThreadLocal<>();
	protected static ThreadLocal<String> resourceIdHodler = new ThreadLocal<>();
	protected static ThreadLocal<String> actionnameHolder = new ThreadLocal<>();
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	public String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean,
			String actionName) throws NwException {
		try {
			saveContent(req, res, formBean, actionName);
			req.setAttribute("view", formBean);
			NwCommonAction action = creatAction();
			String resourceId = execteAction(action, actionName, formBean);
			if (resourceId == null) {
				resourceId = NwCommonServlet.NEXT_RESOURCE_NOT_EXIST;
			}
			return resourceId;
		}finally {
			clearContent();
		}
	}

	private String execteAction(NwCommonAction action, String actionName, NwCommonForm formBean) throws NwException {
		Method method = findExecteMethod(action.getClass(), actionName, formBean.getClass());
		if (method == null) {
			throw new NwException();
		}
		try {
			String result = (String)method.invoke(action, formBean);
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Method findExecteMethod(Class<? extends NwCommonAction> actionClass, String actionName,
			Class<? extends NwCommonForm> formClass) {
		Method[] methods = actionClass.getMethods();
		Method method = null;
		for (int i = 0; i < methods.length; i++) {
			Method mth = methods[i];
			if (!mth.getName().equals(actionName)) {
				continue;
			}
			if (!(mth.getReturnType().equals(String.class))) {
				continue;
			}
			if (mth.getParameterTypes().length != 1) {
				continue;
			}
			Class<?> paramClass =mth.getParameterTypes()[0];
			if (!paramClass.isAssignableFrom(formClass)) {
				continue;
			}
			method = mth;
			break;
		}
		return method;
	}

	private NwCommonAction creatAction() {
		String sid = resourceIdHodler.get();
		if (sid == null) {
			
		}
		String className = getActionName(sid);
		try {
			return (NwCommonAction)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private String getActionName(String sid) {
		String pkg1 = sid.substring(0,4);
		String pkg2 = sid.substring(4,5);
		return pkg1+"."+pkg2+"."+sid+"Action";
	}

	private void clearContent() {
		requestHolder.remove();
		responseHolder.remove();
		formHolder.remove();
		actionnameHolder.remove();
		resourceIdHodler.remove();
	}

	private void saveContent(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean,
			String actionName) {
		requestHolder.set(req);
		responseHolder.set(res);
		formHolder.set(formBean);
		actionnameHolder.set(actionName);
		String sid = req.getParameter("sid");
		resourceIdHodler.set(sid);
	}
	
}
