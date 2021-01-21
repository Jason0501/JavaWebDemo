package com.jason.controller;

import com.jason.dao.StudentDao;
import com.jason.entity.Student;

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
public class UserFindStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> list = studentDao.queryAll();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<table border='1' align='center'>");
        writer.print("<tr>");
        writer.print("<td>学号</td>");
        writer.print("<td>姓名</td>");
        writer.print("<td>性别</td>");
        writer.print("<td>年龄</td>");
        writer.print("<td>操作</td>");
        writer.print("</tr>");
        for (Student student : list) {
            writer.print("<tr>");
            writer.print("<td>" + student.getNumber() + "</td>");
            writer.print("<td>" + student.getName() + "</td>");
            writer.print("<td>" + student.getSex() + "</td>");
            writer.print("<td>" + student.getAge() + "</td>");
            writer.print("<td><a href='/JavaWebDemo/user/deleteStudent?id=" + student.getId() + "'>删除用户</a></td>");
            writer.print("</tr>");
        }
        writer.print("<table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}