package Test;

import java.sql.Connection;

import Database.JDBCUtil;

public class testDatabase {
		public static void main(String[] args) {
			Connection connection=JDBCUtil.getConnection();
			
			JDBCUtil.printInfo(connection);
			
			JDBCUtil.closeConnection(connection);
		}
}
