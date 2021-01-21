package com.jason.controller;

import com.jason.dao.StudentDao;
import com.jason.dao.TeacherDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：Jason
 * @date：2021/1/21 17:02
 * @email：1129847330@qq.com
 * @description:
 */
public class UserDeleteTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.deleteById(Integer.parseInt(id));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (result != StudentDao.RESULT_ERROR) {
            writer.print("<p style='font-size:40px;color:green;'>删除成功</p>");
        } else {
            writer.print("<p style='font-size:40px;color:red;'>删除失败</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}