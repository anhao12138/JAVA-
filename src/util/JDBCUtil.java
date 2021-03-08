package util;

import java.sql.*;

public class JDBCUtil {
//    链接数据地址
    private  static  final     String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf-8&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "5201314yk@";

//    public JDBCUtil() throws SQLException {
//    }

//    //    原方法
//public static void main(String[] args) throws ClassNotFoundException ,SQLException
//    /*
//    * 加载驱动
//    * */
//    Class.forName("com.mysql.jdbc.Driver");
////    获得链接
//    Connection conn=DriverManager.getConnection(URL,username,password);
////    通过链接数据库进行造作
//    Statement stmt = conn.createStatement();
////    执行查询语句的查询结果
//    ResultSet rs = stmt.executeQuery("select username,age from  first");
////    遍历查询结果
//    while(rs.next()){
//        System.out.println(rs.getString("username")+","+rs.getString("age"));
//    }
//
//}

    private  Connection conn = null;

    static {

    }
    public Connection getConnection(){
        try {
//            加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
//            获得数据库链接
            conn = DriverManager.getConnection(URL,username,password);

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
