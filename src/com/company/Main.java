package com.company;


import java.sql.*;


public class Main {

    public static Main mm=new Main();  //定义一个新方法
//  主程序入口
    public static void main(String[] args) throws Exception {
        mm.add("李思思");
        mm.delete("1");
        mm.updata("小黑");
        mm.select();
    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf-8&serverTimezone=UTC";  //数据库地址链接
        Connection conn = null;//链接到数据库
        try {
            conn = DriverManager.getConnection(URL,"root", "5201314yk@");  //数据库账号密码
        } catch (SQLException e) {   //程序错误报错点
            e.printStackTrace();
        }
        return conn;  //返回conn的内容
    }
    /**
     * 添加
     */

    public void add(String name) throws SQLException {
        Connection conn=mm.getConnection();
        Statement statement=null;
        String sql = "insert into first (username,age,email) values('"+name+"','18','123456@qq.com')";   //SQL语句
        try {
           statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            if (i!=0){
                System.out.println("添加成功"+i+"条数据");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement==null){
                statement.close();
            }
            if (conn==null){
                conn.close();
            }
        }
    }
    /**
     * 删除
     */
    public  void  delete(String n)throws Exception {
        Connection conn = mm.getConnection();
        Statement statement= null;
        String sql="delete from first where id="+n+"";
        try {
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            if (i!=0){
                System.out.println("删除成功"+i+"条数据");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement==null){
                statement.close();
            }
            if (conn==null){
                conn.close();
            }
        }

    }
    /**
     * 修改
     */
    public void updata(String username)throws Exception{
        Connection conn = mm.getConnection();
        Statement statement= null;
        String sql="update first set username='"+username+"' where id='1' ";
        try {
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            if (i!=0){
                System.out.println("修改"+i+"条数据");
            }else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement==null){
                statement.close();
            }
            if (conn==null){
                conn.close();
            }
        }
    }
    /**
     * 查
     */
    public  void select()throws Exception{
        Connection conn = mm.getConnection();
        Statement statement= null;
        String sql= "select * from first"; //查询数据看
        statement=conn.createStatement(); //添加容器

        ResultSet rs =statement.executeQuery(sql);     //将sql语句传至数据库，返回的值为一个字符集用一个变量接收
        while(rs.next()) {    //next（）获取里面的内容
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));//getString（n）获取第n列的内容
            //数据库中的列数是从1开始的
        }

    }

}
