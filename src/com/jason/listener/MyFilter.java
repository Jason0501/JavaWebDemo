package com.jason.listener;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author：Jason
 * @date：2021/1/23 17:08
 * @email：1129847330@qq.com
 * @description:
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if (session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/login_fail.html").forward(servletRequest, servletResponse);
        }
//        String age = servletRequest.getParameter("age");
//        if (CommonUtils.isNotEmpty(age) && Integer.parseInt(age) > 70) {
//            servletResponse.setContentType("text/html;charset=utf-8");
//            PrintWriter writer = servletResponse.getWriter();
//            writer.print("<p style='color:red;'>被拦截了</p>");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }

    @Override
    public void destroy() {

    }
}