package com.trunko.cms.session;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trunko.cms.dao.sysconfig.SysUserDao;
import com.trunko.cms.entity.ProYbUser;
import com.trunko.cms.entity.WebUser;

/**
 * 
 * @ClassName: session�Ĺ�����
 * 
 * @Description: ����
 * 
 * @author lhanliang
 * 
 * @date 2014-6-19 ����03:58:55
 */
public class SessionManager {

	/**
	 * �����û���session��Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param userLoginName
	 */
	public void setSession(HttpServletRequest request, HttpServletResponse response) {
		
		String userLoginName = (String)request.getAttribute("userLoginName"); // �û���¼��
		String userType = (String)request.getAttribute("userType"); // �û�����
		String responseUrl = "";
		HttpSession session =request.getSession();
		SysUserDao userDao =  new SysUserDao();
		if("sys".equals(userType) || "xmgl".equals(userType)){
			WebUser user=userDao.getWebUserByLoginName(userLoginName);
			if(user!=null){
				session.setAttribute("id", user.getId());
				session.setAttribute("yhm", user.getYhm());
				session.setAttribute("xm", user.getXm());
				session.setAttribute("qx", user.getQx());

				session.setAttribute("lb",userType);
				session.setMaxInactiveInterval(3600);
				//���õ�¼ҳ
				Cookie cookie = new Cookie("loginlb",userType);

				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
				responseUrl = "/admin/AjaxServlet?act=index&lb="+userType;

			}else{
				if ("sys".equals(userType)) {
					responseUrl = "/admin/login.jsp";
				}else {
					responseUrl = "/admin/xmgl_login.jsp";
				}
			}
		}else{
			ProYbUser user=userDao.getYbUserByLoginName(userLoginName);
			if(user!=null)
			{
				session.setAttribute("id", user.getId());
				session.setAttribute("yhm", user.getYhm());
				session.setAttribute("xm", user.getXm());
				session.setAttribute("lb", user.getLb());
				session.setMaxInactiveInterval(3600);
				
				//���õ�¼ҳ
				Cookie cookie = new Cookie("loginlb",userType);

				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
				responseUrl = "/admin/AjaxServlet?act=index_yb";
			}else{
				responseUrl = "/admin/zdxm_login.jsp";
			}
		}
		try {
			response.sendRedirect(request.getContextPath() + responseUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
