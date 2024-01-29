package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Database.JDBCUtil;
import View.KhachHangView;

import java.sql.*;

public class KhachHangDAO {
	public void selectAll() {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql= "SELECT * FROM qlks";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model_table = (DefaultTableModel) KhachHangView.table.getModel();
			model_table.setRowCount(0);

			while (rs.next()) {
				String maKH = rs.getString("cccd");
				String tenKH = rs.getString("tenKhachHang");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				String email = rs.getString("email");
				String gioiTinh = rs.getString("gioiTinh");
				String maPhong = rs.getString("maPhong");
				int soPhong = rs.getInt("soPhong");
				float giaPhong = rs.getFloat("giaPhong");
				int soNguoi = rs.getInt("soNguoi");
				String ngayDat = rs.getString("ngayDatPhong");
				String ngayHet = rs.getString("ngayHetHan");
				String thanhToan = rs.getString("thanhToan");
				Object object_list[] = { maKH, tenKH, sdt, diaChi, email, gioiTinh, maPhong, soPhong, giaPhong, soNguoi,
						ngayDat, ngayHet, thanhToan };
				model_table.addRow(object_list);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectById(String id) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql ="SELECT * FROM qlks WHERE cccd=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			DefaultTableModel model_table = (DefaultTableModel) KhachHangView.table.getModel();
			model_table.setRowCount(0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString("cccd");
				String tenKH = rs.getString("tenKhachHang");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				String email = rs.getString("email");
				String gioiTinh = rs.getString("gioiTinh");
				String maPhong = rs.getString("maPhong");
				int soPhong = rs.getInt("soPhong");
				float giaPhong = rs.getFloat("giaPhong");
				int soNguoi = rs.getInt("soNguoi");
				String ngayDat = rs.getString("ngayDatPhong");
				String ngayHet = rs.getString("ngayHetHan");
				String thanhToan = rs.getString("thanhToan");

				Object object_list[] = { maKhachHang, tenKH, sdt, diaChi, email, gioiTinh, maPhong, soPhong, giaPhong,
						soNguoi, ngayDat, ngayHet, thanhToan };
				model_table.addRow(object_list);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void selectByTen(String ten) {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM qlks WHERE tenKhachHang like ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,"%" + ten + "%");
			ResultSet rs = ps.executeQuery();

			DefaultTableModel model_table = (DefaultTableModel) KhachHangView.table.getModel();
			model_table.setRowCount(0);

			while (rs.next()) {
				String maKhachHang = rs.getString("cccd");
				String tenKH = rs.getString("tenKhachHang");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				String email = rs.getString("email");
				String gioiTinh = rs.getString("gioiTinh");
				String maPhong = rs.getString("maPhong");
				int soPhong = rs.getInt("soPhong");
				float giaPhong = rs.getFloat("giaPhong");
				int soNguoi = rs.getInt("soNguoi");
				String ngayDat = rs.getString("ngayDatPhong");
				String ngayHet = rs.getString("ngayHetHan");
				String thanhToan = rs.getString("thanhToan");

				Object object_list[] = { maKhachHang, tenKH, sdt, diaChi, email, gioiTinh, maPhong, soPhong, giaPhong,
						soNguoi, ngayDat, ngayHet, thanhToan };
				model_table.addRow(object_list);

			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
