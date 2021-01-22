package com.jason.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author：Jason
 * @date：2021/1/22 15:32
 * @email：1129847330@qq.com
 * @description:
 */
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        HttpSession session = request.getSession();
        Integer productNum = (Integer) session.getAttribute(productName);
        if (productNum == null) {
            session.setAttribute(productName, 1);
        } else {
            session.setAttribute(productName, productNum + 1);
        }
        ServletContext context = request.getServletContext();
        context.setAttribute("msg", "Hello");
        context.setAttribute("msg", "world");
        context.removeAttribute("msg");
    }
}