package com.jason.controller;

import com.jason.dao.TeacherDao;
import com.jason.entity.Teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：Jason
 * @date：2021/1/18 17:52
 * @email：1129847330@qq.com
 * @description:
 */
public class UserAddTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        TeacherDao teacherDao = new TeacherDao();
        int result = teacherDao.add(new Teacher(number, username, age, sex, password, email));

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (result != TeacherDao.RESULT_ERROR) {
            writer.print("<p style='font-size:40px;color:green;'>注册成功</p>");
        } else {
            writer.print("<p style='font-size:40px;color:red;'>注册失败</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}