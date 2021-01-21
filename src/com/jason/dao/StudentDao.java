package com.jason.dao;

import com.jason.entity.Student;
import com.jason.utils.CommonUtils;
import com.jason.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author：Jason
 * @date：2021/1/21 13:55
 * @email：1129847330@qq.com
 * @description:
 */
public class StudentDao {
    public static final int RESULT_ERROR = -1;

    /**
     * 插入数据
     *
     * @param student
     * @return
     */
    public int add(Student student) {
        String sql = "insert into student (number,name,age,sex) values(?,?,?,?)";
        JDBCUtils utils = getJdbcUtils();
        PreparedStatement ps = utils.getPrepareStatement(sql);
        try {
            ps.setString(1, student.getNumber());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getSex());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (utils != null) {
                utils.close();
            }
        }
        return RESULT_ERROR;
    }

    private JDBCUtils getJdbcUtils() {
        return new JDBCUtils();
    }

    /**
     * 删除数据
     *
     * @param number
     * @return
     */
    public int deleteByNumber(String number) {
        String sql = "delete from student where number=?";
        JDBCUtils utils = getJdbcUtils();
        PreparedStatement ps = utils.getPrepareStatement(sql);
        try {
            ps.setString(1, number);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (utils != null) {
                utils.close();
            }
        }
        return RESULT_ERROR;
    }

    public int deleteById(int id) {
        String sql = "delete from student where id=?";
        JDBCUtils utils = getJdbcUtils();
        PreparedStatement ps = utils.getPrepareStatement(sql);
        try {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (utils != null) {
                utils.close();
            }
        }
        return RESULT_ERROR;
    }

    /**
     * 更新
     *
     * @param number
     * @param age
     * @return
     */
    public int update(String number, int age) {
        String sql = "update student set age=? where number=?";
        JDBCUtils utils = getJdbcUtils();
        PreparedStatement ps = utils.getPrepareStatement(sql);
        try {
            ps.setInt(1, age);
            ps.setString(2, number);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (utils != null) {
                utils.close();
            }
        }
        return RESULT_ERROR;
    }

    /**
     * 查询
     *
     * @param number
     * @return
     */
    public ArrayList<Student> query(String number) {
        String sql;
        PreparedStatement ps;
        ResultSet resultSet = null;
        JDBCUtils utils = getJdbcUtils();
        if (CommonUtils.isEmpty(number)) {
            sql = "select * from student";
            ps = utils.getPrepareStatement("");
        } else {
            sql = "select * from student where number=?";
            ps = utils.getPrepareStatement(sql);
        }
        try {
            if (CommonUtils.isNotEmpty(number)) {
                ps.setString(1, number);
                resultSet = ps.executeQuery();
            } else {
                resultSet = ps.executeQuery(sql);
            }
            ArrayList<Student> list = new ArrayList<>();
            while (resultSet.next()) {
                int sid = resultSet.getInt("id");
                String snumber = resultSet.getString("number");
                String sname = resultSet.getString("name");
                int sage = resultSet.getInt("age");
                String ssex = resultSet.getString("sex");
                list.add(new Student(sid, snumber, sname, sage, ssex));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (utils != null) {
                utils.close();
            }
        }
        return null;
    }

    public ArrayList<Student> queryAll() {
        return query(null);
    }
}