package com.jason.entity;

/**
 * @author：Jason
 * @date：2021/1/20 14:24
 * @email：1129847330@qq.com
 * @description:
 */
public class Student {
    public int id;
    public String number;
    public String name;
    public int age;
    public String sex;

    public Student() {
    }

    public Student(String number, String name, int age, String sex) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Student(int id, String number, String name, int age, String sex) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}