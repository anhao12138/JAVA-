package Dao.impl;

import Dao.StudentDao;
import domain.Student;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentDaoImpl implements StudentDao {

    private JDBCUtil jdbc =new JDBCUtil();
    Connection conn= jdbc.getConnection();
    PreparedStatement preparedStatement = null;
    public void add(Student student) {

        try {
            String sql = "insert into first (username,email,age) values(?,?,?)";   //SQL语句
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement==null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn ==null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 删除一个信息
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        Statement statement= null;
        try {
        String sql="delete from first where id=?";
        preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int i = preparedStatement.executeUpdate();
            if (i!=0){
                System.out.println("执行成功了"+i+"条数据");
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 修改
     *
     * @param student
     */
    @Override
    public void update(Student student) {
        Statement statement =null;

        try {
            String sql = "update first set username = ? where id = ?";
            preparedStatement= conn.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,18);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement==null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn ==null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }



    /**
     * 查询一个信息
     *
     * @param id
     * @return
     */
    @Override
    public Student select(int id) {
        Statement statement= null;
        Student student=new Student();
        try {
        String sql = "select * from first where id=?";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                System.out.println(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3));
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("username"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement==null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn ==null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }


    @Override
    public List<Student> selectList() {
        List<Student> Lists =new ArrayList<>();
        Student student= new Student();
        try {
            String sql = "select * from first where id=?";
            preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1,"id");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Student s =new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("username"));
                s.setAge(rs.getInt("age"));
                s.setEmail(rs.getString("email"));
                Lists.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Lists;
    }


}
