package util;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class DBUtil {
    //sql数据库连接字符串
    private static final String URL="jdbc:mysql://localhost:3306/bookshop";
    //sql用户名 和密码 用作连接用
    private static final String USERNAME="root";
    private static final String PWD="wangyifan52199";

    public static Connection connection=null;
    public static PreparedStatement pst =null;
    public static ResultSet rs =null;

    /*
     * 得到PreparedStatement减少代码冗余
     */
    public static PreparedStatement getPreparedStatement(String sql,Object[] params) {
        //导入驱动，加载具体驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立链接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            pst= connection.prepareStatement(sql);
            if(params!=null) {
                for(int i=0;i<params.length;i++){
                    pst.setObject(i+1,params[i]);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pst;
    }
    /*
     * 最后关闭所有
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(connection!=null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * 通用的增删改 通过传入的sql和obj数组确认语句
     */
    public static boolean  executeUpdate(String sql,Object[] params) {
        try {
            int count = getPreparedStatement(sql,params).executeUpdate();
            if(count>0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll(null, pst, connection);
        }
    }
    /*
     * 通用的查询（只能返回到ResultSet）之后必须与具体类型耦合
     */
    public static ResultSet executeQuery(String sql, Object[] params) {
        try {
            rs= getPreparedStatement(sql,params).executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

