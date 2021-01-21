package com.jason.utils;

import com.jason.dao.StudentDao;
import com.jason.entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author：Jason
 * @date：2021/1/21 14:10
 * @email：1129847330@qq.com
 * @description:
 */
public class DaoTest {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        while (true) {
            System.out.println("欢迎使用学生管理系统");
            System.out.println("1.添加学生");
            System.out.println("2.查询学生");
            System.out.println("3.删除学生");
            System.out.println("4.更新学生");
            Scanner scanner = new Scanner(System.in);
            String number, name, sex, flag;
            int age, result;
            flag = scanner.nextLine();
            switch (flag) {
                case "1":
                    System.out.println("请输入学生学号");
                    number = scanner.nextLine();
                    System.out.println("请输入学生姓名");
                    name = scanner.nextLine();
                    System.out.println("请输入学生年龄");
                    age = scanner.nextInt();
                    System.out.println("请输入学生性别");
                    sex = scanner.next();
                    result = studentDao.add(new Student(number, name, age, sex));
                    if (result == 1) {
                        System.out.println("插入成功");
                    } else {
                        System.out.println("插入失败");
                    }
                    break;
                case "2":
                    ArrayList<Student> students = studentDao.queryAll();
                    System.out.println(students);
                    break;
                case "3":
                    System.out.println("请输入要删除的学生学号");
                    number = scanner.nextLine();
                    result = studentDao.deleteByNumber(number);
                    if (result == 1) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                case "4":
                    System.out.println("请输入学生学号");
                    number = scanner.nextLine();
                    System.out.println("请输入要更改的年龄");
                    age = scanner.nextInt();
                    result = studentDao.update(number, age);
                    if (result == 1) {
                        System.out.println("更新成功");
                    } else {
                        System.out.println("更新失败");
                    }
                    break;
            }
            System.out.println("退出系统请按0，返回上一级请按任意键");
            String keycode = scanner.nextLine();
            if (keycode.equals("0")) {
                System.out.println("系统已关闭，谢谢使用！");
                break;
            }
        }
    }
}