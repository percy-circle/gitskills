package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static  String user ;
	
	private static  String password;
	
	private static  String url;	
	
	private static String driver;
	
	//注册驱动
	static{
		
		try {
			
			
			Properties pro = new Properties();
			
			InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
			
			//加载
			pro.load(is);
			
			//获取配置文件的值
			url = pro.getProperty("url");
			password = pro.getProperty("password");
			user = pro.getProperty("user");
			driver = pro.getProperty("driver");
			
			//1.加载字节码驱动
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	/**
	 * 释放资源
	 */
	public static void close(Statement statement , Connection conn ,ResultSet rs){
		//关闭资源（后开先关）
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}}
