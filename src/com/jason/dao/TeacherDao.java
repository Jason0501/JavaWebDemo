package com.jason.dao;

import com.jason.entity.Teacher;
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
public class TeacherDao {
    public static final int RESULT_ERROR = -1;

    /**
     * 插入数据
     *
     * @param teacher
     * @return
     */
    public int add(Teacher teacher) {
        String sql = "insert into teacher (name,password,sex,email,number,age) values(?,?,?,?,?,?)";
        JDBCUtils utils = getJdbcUtils();
        PreparedStatement ps = utils.getPrepareStatement(sql);
        try {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getPassword());
            ps.setString(3, teacher.getSex());
            ps.setString(4, teacher.getEmail());
            ps.setString(5, teacher.getNumber());
            ps.setInt(6, teacher.getAge());
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
        String sql = "delete from teacher where number=?";
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
        String sql = "delete from teacher where id=?";
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
        String sql = "update teacher set age=? where number=?";
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
    public ArrayList<Teacher> query(String number) {
        String sql;
        PreparedStatement ps;
        ResultSet resultSet = null;
        JDBCUtils utils = getJdbcUtils();
        if (CommonUtils.isEmpty(number)) {
            sql = "select * from teacher";
            ps = utils.getPrepareStatement("");
        } else {
            sql = "select * from teacher where number=?";
            ps = utils.getPrepareStatement(sql);
        }
        try {
            if (CommonUtils.isNotEmpty(number)) {
                ps.setString(1, number);
                resultSet = ps.executeQuery();
            } else {
                resultSet = ps.executeQuery(sql);
            }
            ArrayList<Teacher> list = new ArrayList<>();
            while (resultSet.next()) {
                int sid = resultSet.getInt("id");
                String spassword = resultSet.getString("password");
                String snumber = resultSet.getString("number");
                String sname = resultSet.getString("name");
                int sage = resultSet.getInt("age");
                String ssex = resultSet.getString("sex");
                String email = resultSet.getString("email");
                list.add(new Teacher(sid, snumber, sname, sage, ssex, spassword, email));
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

    public ArrayList<Teacher> queryAll() {
        return query(null);
    }

    public int login(String username, String password) {
        String sql = "select count(*) from teacher where name=? and password=?";
        JDBCUtils utils = getJdbcUtils();
        PreparedStatement ps = utils.getPrepareStatement(sql);
        try {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (utils != null) {
                utils.close();
            }
        }
        return RESULT_ERROR;
    }
}