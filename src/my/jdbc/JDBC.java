package my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static void main(String[] args) throws Exception {
		Class.forName(DBDRIVER); // 1、进行驱动程序的加载，必须要用
		// 每一次使用DriverManager.getConnection()方法都表示打开一个新的连接，每一个线程只能用一个连接
		Connection conn = DriverManager.getConnection(DBURL, USER, PASSWORD);// 利用DriverManager打开数据库连接对象
		System.out.println(conn); // 可以返回连接对象
		conn.close(); // 操作完成后关闭数据库连接
	}
}
