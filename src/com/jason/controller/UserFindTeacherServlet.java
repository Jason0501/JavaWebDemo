package com.jason.controller;

import com.jason.dao.TeacherDao;
import com.jason.entity.Teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：Jason
 * @date：2021/1/21 16:08
 * @email：1129847330@qq.com
 * @description:
 */
public class UserFindTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeacherDao teacherDao = new TeacherDao();
        ArrayList<Teacher> list = teacherDao.queryAll();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<table border='1' align='center'>");
        writer.print("<tr>");
        writer.print("<td>教师编号</td>");
        writer.print("<td>姓名</td>");
        writer.print("<td>性别</td>");
        writer.print("<td>年龄</td>");
        writer.print("<td>性别</td>");
        writer.print("<td>邮箱</td>");
        writer.print("<td>操作</td>");
        writer.print("</tr>");
        for (Teacher teacher : list) {
            writer.print("<tr>");
            writer.print("<td>" + teacher.getNumber() + "</td>");
            writer.print("<td>" + teacher.getName() + "</td>");
            writer.print("<td>" + teacher.getSex() + "</td>");
            writer.print("<td>" + teacher.getAge() + "</td>");
            writer.print("<td>" + teacher.getSex() + "</td>");
            writer.print("<td>" + teacher.getEmail() + "</td>");
            writer.print("<td><a href='/JavaWebDemo/user/deleteTeacher?id=" + teacher.getId() + "'>删除用户</a></td>");
            writer.print("</tr>");
        }
        writer.print("<table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}