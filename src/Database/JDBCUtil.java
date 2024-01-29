package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Dang ky MySQL Driver voi DriverManager
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Cac thong so
			String url = "jdbc:mySQL://127.0.0.1:3306/quanlikhachsan";
			String usename = "root";
			String passwork = "";

			// Tao ket noi
			c = DriverManager.getConnection(url, usename, passwork);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				java.sql.DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
