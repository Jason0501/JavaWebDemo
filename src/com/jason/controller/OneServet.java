package com.jason.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：Jason
 * @date：2021/1/16 14:39
 * @email：1129847330@qq.com
 * @description:
 */
public class OneServet extends HttpServlet {
    public OneServet() {
        System.out.println("OneServlet被创建了");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
//        通过请求对象，读取【请求行】中url信息
        String url = request.getRequestURL().toString();
//        通过请求对象，读取【请求行】中method信息
        String method = request.getMethod();
//        通过请求对象，读取【请求行】中uri信息
        String uri = request.getRequestURI();
        System.out.println("url:" + url + ", method:" + method + ", uri:" + uri);
//        通过请求对象，读取【请求头】中参数信息
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            System.out.println("请求参数名称：" + paramName + ", 请求参数值：" + paramValue);
        }


        String result1 = "Hello, welcome to Java Web!</br>";
        int result2 = 97;
        String result3 = "</br>你好，我会:</br>Java</br>Mysql</br>Html";
        String result4 = "https://www.baidu.com/";
//        response.sendRedirect(result4);//重定向
        response.setContentType("text/html;charset=utf-8");
//        ---------------通过响应对象将结果写入到响应体中---------------------
//        1.通过响应对象，向Tomcat索要输出流
        PrintWriter out = response.getWriter();
//        2.通过输出流，将执行结果以二进制的形式写入到响应体当中
//        out.write(result);//这里会把数字当做ASCII码写入到response当中,使用print方法
        out.println(result1);
        out.println(result2);
        out.println(result3);
        out.println(result4);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println("doPost读取参数：" + username);

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}