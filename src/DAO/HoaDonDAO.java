package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Database.JDBCUtil;
import Model.HoaDonModel;
import View.AdminView;

public class HoaDonDAO {
	private AdminView view;

	public HoaDonModel selectByID(String id) {
		HoaDonModel hd = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT tenKhachHang, maPhong, soPhong, giaPhong, ngayDatPhong, ngayHetHan" 
						+ " FROM qlks WHERE cccd = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String tenKH = rs.getString("tenKhachHang");
				String maPhong = rs.getString("maPhong");
				int soPhong = rs.getInt("soPhong");
				float giaPhong = rs.getFloat("giaPhong");
				LocalDate checkInDate = rs.getDate("ngayDatPhong").toLocalDate();
	            LocalDate checkOutDate = rs.getDate("ngayHetHan").toLocalDate();
				long soNgayO = ChronoUnit.DAYS.between(checkInDate, checkOutDate) + 1;
				
				hd = new HoaDonModel(tenKH, maPhong, soPhong, giaPhong, soNgayO, 0);
				
				float gia = hd.getGiaPhong();
				double tongTien = soNgayO * gia;
				hd.setTongTien(tongTien);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hd;

	}
	
	
	public boolean isIdKhachHangExist(String id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT cccd FROM qlks WHERE cccd = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery(); // trong database có 1 dòng được tìm thấy
			if (rs.next()) {
				return true;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
