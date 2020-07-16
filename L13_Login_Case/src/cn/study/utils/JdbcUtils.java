package cn.study.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid 连接池工具类
 * @author Harlan
 * @date 2020/7/13 23:56
 */
public class JdbcUtils {

    private static DataSource ds;

    //初始化连接对象
    static {
        Properties pro = new Properties();
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("DataBase.properties");
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return 连接对象
     * @throws SQLException 异常
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param conn 连接对象
     * @param stmt 读取对象
     */
    public static void close(Connection conn, Statement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(conn, stmt);
    }

    /**
     * 获取连接池
     * @return 连接池
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
