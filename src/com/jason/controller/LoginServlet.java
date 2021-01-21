package com.jason.controller;

import com.jason.dao.TeacherDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：Jason
 * @date：2021/1/21 17:32
 * @email：1129847330@qq.com
 * @description:
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.login(username, password);
        resp.setContentType("text/html;charset=utf-8");
        if (result > 0) {
            resp.sendRedirect("/JavaWebDemo/index.html");
        } else {
            resp.sendRedirect("/JavaWebDemo/login_fail.html");
        }
    }
}