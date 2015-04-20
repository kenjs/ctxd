package com.cattsoft.webpub.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cattsoft.pub.util.StringUtil;


public class SessionFilter implements Filter {
 
    /** Ҫ���� session ������ */
    private String sessionKey;
     
    /** ��Ҫ�ų��������أ���URL��������ʽ */
    private Pattern excepUrlPattern;
     
    /** ��鲻ͨ��ʱ��ת����URL */
    private String forwardUrl;
 
    public void init(FilterConfig cfg) throws ServletException {
        sessionKey ="user";
        forwardUrl ="/page/login.jsp";
    }
 
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String servletPath = request.getServletPath();
 
        // ��������·����forwardUrl��ͬ���������·�����ų���URLʱ����ֱ�ӷ���
        if (validate(servletPath,req)) {
            chain.doFilter(req, res);
            return;
        }
 
        Object sessionObj = request.getSession().getAttribute(sessionKey);
        // ���SessionΪ�գ�����ת��ָ��ҳ��
        if (sessionObj == null) {
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath +"/page/login.jsp");
        } else {
            chain.doFilter(req, res);
        }
    }

	public void destroy() {
		
	}
	
	private boolean validate(String path,ServletRequest req) {
		String method=req.getParameter("method");
		if(path.equals("/page/login.jsp")) {
			return true;
		}
		if("login".equals(method)) {
			return true;
		}
		return false;
	}
 
}