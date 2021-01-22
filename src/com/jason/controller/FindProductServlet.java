package com.jason.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * @author：Jason
 * @date：2021/1/22 15:49
 * @email：1129847330@qq.com
 * @description:
 */
public class FindProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<table border='1' align='center'>");
        writer.print("<tr>");
        writer.print("<td>商品名称</td>");
        writer.print("<td>商品数量</td>");
        writer.print("</tr>");
        while (attributeNames.hasMoreElements()) {
            String productName = attributeNames.nextElement();
            int productNum = (int) session.getAttribute(productName);
            writer.print("<tr>");
            writer.print("<td>" + productName + "</td>");
            writer.print("<td>" + productNum + "</td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
    }
}