package com.jason.entity;

/**
 * @author：Jason
 * @date：2021/1/21 14:40
 * @email：1129847330@qq.com
 * @description:
 */
public class Teacher {
    public int id;
    public String number;
    public String name;
    public int age;
    public String sex;
    public String password;
    public String email;

    public Teacher() {
    }

    public Teacher(String number, String name, int age, String sex, String password, String email) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.email = email;
    }

    public Teacher(int id, String number, String name, int age, String sex, String password, String email) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}