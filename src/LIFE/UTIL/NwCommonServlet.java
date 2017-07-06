package LIFE.UTIL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class NwCommonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 下一个Page不存在
	protected static final String NEXT_RESOURCE_NOT_EXIST = "NEXT_RESOURCE_NOT_EXIST";

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) {
		String actionName = null;
		String resourceId = null;
		String formBeanName = null;
		String nextResource = null;
		String backPageUrl = null;
		NwCommonForm formBean = new NwCommonForm();
		try {
			String errMsg = null;
			request.setAttribute("ErrMsg", "");
			request.setAttribute("WarMsg", "");
			request.setAttribute("NorMsg", "");
			NwResourceMap remap = NwResourceMap.getInstance();
			request.setCharacterEncoding("UTF-8");
			actionName = request.getParameter("actionname");
			resourceId = request.getParameter("sid");
			if (resourceId == null) {
				formBean = null;
			} else {
				backPageUrl = remap.getUrl(resourceId);
				formBeanName = remap.getFormBeanName(resourceId);
				if ("".equals(formBeanName)) {
					formBean = null;
				} else {
					formBean = (NwCommonForm) Class.forName(formBeanName).newInstance();
					formBean.getParamter(request, response);
					formBean.setFormNextList(request);
				}
			}
			errMsg = (String) request.getAttribute("ErrMsg");
			if (errMsg == null || errMsg.trim().length() == 0) {
				nextResource = performTask(request, response, formBean, actionName);
			}
			if (NEXT_RESOURCE_NOT_EXIST.equals(nextResource)) {
				return;
			}
			if (nextResource.length() != 0) {
				String nextPage = remap.getUrl(nextResource);
				this.forward(nextPage, request, response);
			} else {
				errMsg = (String) request.getAttribute("ErrMsg");
				if (errMsg == null || errMsg.trim().length() == 0) {
					putReqMsgOut(request, 2, "AMF001");
				}
				backPageUrl = backView(backPageUrl, formBean, request);
				try {
					this.forward(backPageUrl, request, response);
				} catch (Exception e) {
					e.printStackTrace();
					putHTML(response);
				}
			}
		} catch (Exception e) {
			String errMsg = (String) request.getAttribute("ErrMsg");
			if (errMsg == null || errMsg.trim().length() == 0) {
				putReqMsgOut(request, 2, "AMF001");
			}
			backPageUrl = backView(backPageUrl, formBean, request);
			try {
				this.forward(backPageUrl, request, response);
			} catch (Exception ex) {
				ex.printStackTrace();
				putHTML(response);
			}
		}
	}

	private String backView(String backPageUrl, NwCommonForm formBean, HttpServletRequest request) {
		try {
			if (backPageUrl == null) {
				backPageUrl = "/LIFEUTIL/DError.jsp";
			}
			if (formBean != null) {
				formBean.setFormBackList(request);
				request.setAttribute("view", formBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backPageUrl;
	}

	private void forward(String url, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, res);
	}

	private void putHTML(HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<HTML><HEAD>");
			out.println("<TITLE>页面错误！</TITLE>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("<H3>***********</H3>");
			out.println("<HR>");
			out.println("<BR>");
			out.println(getClass() + "********</BR>");
			out.println("<BR>&&&&&&</BR>");
			out.println("</BODY>");
			out.println("</HTML>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void putReqMsgOut(HttpServletRequest req, int msgFlg, String msg) {
		switch (msgFlg) {
		case 0:
			msg = (String) req.getAttribute("ErrMsg");
			req.setAttribute("ErrMsg", "err");
			break;
		case 1:
			msg = (String) req.getAttribute("WarMsg");
			req.setAttribute("WarMsg", "err");
			break;
		case 2:
			msg = (String) req.getAttribute("NorMsg");
			req.setAttribute("NorMsg", "err");
			break;
		}
	}

	public abstract String performTask(HttpServletRequest req, HttpServletResponse res, NwCommonForm formBean,
			String actionName) throws NwException;
}
