package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.JDBCUtil;
import View.AdminView;

import java.sql.*;

public class AdminDAO {
	public void insert(String id, String tenKH, String sdt, String diaChi, String email, String gioiTinh,
			String maPhong, int soPhong, float giaPhong, int soNguoi, String ngayDat, String ngayHet,
			String thanhToan) {
		Connection con = JDBCUtil.getConnection();

		String sql = "INSERT INTO qlks (cccd, tenKhachHang, sdt,"
				+ "diaChi, email, gioiTinh, maPhong, sophong, giaphong,"
				+ " soNguoi, ngayDatPhong, ngayHetHan, thanhToan)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, tenKH);
			ps.setString(3, sdt);
			ps.setString(4, diaChi);
			ps.setString(5, email);
			ps.setString(6, gioiTinh);
			ps.setString(7, maPhong);
			ps.setInt(8, soPhong);
			ps.setFloat(9, giaPhong);
			ps.setInt(10, soNguoi);
			ps.setString(11, ngayDat);
			ps.setString(12, ngayHet);
			ps.setString(13, thanhToan);

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int delete() {
		String id = AdminView.txt_idKhachHang.getText();
		int ketqua = 0;
		try {

			Connection con = JDBCUtil.getConnection();
			String sql = "DELETE FROM qlks WHERE cccd = ?";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ketqua = st.executeUpdate();
			if(ketqua>0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}else {
				JOptionPane.showMessageDialog(null, "Xóa thất bại");
			}

			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketqua;
	}

	public void update(String cccd, String tenKH, String sdt, String diaChi, String email, String gioiTinh,
			String maPhong, int soPhong, float giaPhong, int soNguoi, String ngayDat, String ngayHet,
			String thanhToan) {
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "UPDATE qlks SET "
					+ " tenKhachHang =?, sdt=?, diaChi =?, email=?, gioiTinh=?, maPhong =?, soPhong=?, "
					+ " giaPhong = ?, soNguoi=?, ngayDatPhong=?, ngayHetHan=?, thanhToan=?" + " WHERE CCCD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tenKH);
			ps.setString(2, sdt);
			ps.setString(3, diaChi);
			ps.setString(4, email);
			ps.setString(5, gioiTinh);
			ps.setString(6, maPhong);
			ps.setInt(7, soPhong);
			ps.setFloat(8, giaPhong);
			ps.setInt(9, soNguoi);
			ps.setString(10, ngayDat);
			ps.setString(11, ngayHet);
			ps.setString(12, thanhToan);
			ps.setString(13, cccd);

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			}else {
				JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectAll() {

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM qlks";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model_table = (DefaultTableModel) AdminView.table.getModel();
			model_table.setRowCount(0);

			while (rs.next()) {
				String maKH = rs.getString("cccd");
				String tenKH = rs.getString("tenKhachHang");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				String email = rs.getString("email");
				String gioiTinh = rs.getString("gioiTinh");
				String maPhong = rs.getString("maPhong");
				String soPhong = rs.getString("soPhong");
				String giaPhong = rs.getString("giaPhong");
				String soNguoi = rs.getString("soNguoi");
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
			String sql = "SELECT * FROM qlks WHERE cccd =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			DefaultTableModel model_table = (DefaultTableModel) AdminView.table.getModel();
			model_table.setRowCount(0);

			while (rs.next()) {
				String maKhachHang = rs.getString("cccd");
				String tenKH = rs.getString("tenKhachHang");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				String email = rs.getString("email");
				String gioiTinh = rs.getString("gioiTinh");
				String maPhong = rs.getString("maPhong");
				String soPhong = rs.getString("soPhong");
				String giaPhong = rs.getString("giaPhong");
				String soNguoi = rs.getString("soNguoi");
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

			DefaultTableModel model_table = (DefaultTableModel) AdminView.table.getModel();
			model_table.setRowCount(0);

			while (rs.next()) {
				String maKhachHang = rs.getString("cccd");
				String tenKH = rs.getString("tenKhachHang");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				String email = rs.getString("email");
				String gioiTinh = rs.getString("gioiTinh");
				String maPhong = rs.getString("maPhong");
				String soPhong = rs.getString("soPhong");
				String giaPhong = rs.getString("giaPhong");
				String soNguoi = rs.getString("soNguoi");
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

	// -- //

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

	// -- //

	public boolean isEmailExist(String email) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT email FROM qlks WHERE email = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	// -- //

	public boolean isPhoneExist(String sdt) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT sdt FROM qlks WHERE sdt = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sdt);
			ResultSet rs = ps.executeQuery();
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

	// -- //

	public boolean isIdRoom(String idroom) {
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "SELECT maPhong FROM qlks WHERE maPhong =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idroom);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// -- //

	public boolean isNumberRoom(String soPhong) {
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "SELECT  soPhong FROM qlks WHERE soPhong =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, soPhong);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean isExistRoom(String mp, int sp) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM qlks WHERE maPhong = ? AND soPhong = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mp);
			ps.setInt(2, sp);
			if (ps.executeQuery().next()) {
				return true;
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int selectThongKe(int thang, int nam) {
		int soLuongDatPhong = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT Count(*) AS 'So_luong_dat_Phong' FROM qlks WHERE MONTH(ngayDatPhong) =? AND YEAR(ngayDatPhong) =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, thang);
			ps.setInt(2, nam);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				soLuongDatPhong = rs.getInt("So_luong_dat_Phong");
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return soLuongDatPhong;
	}

	// -- //

	public void tinhSoNgayO(String id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT ngayDatPHong, ngayHetHan FROM qlks WHERE cccd=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// Lấy ngày đặt phòng và ngày hết hạn từ kết quả truy vấn
                LocalDate ng_Dat = rs.getDate("ngayDatPHong").toLocalDate();
                LocalDate ng_Het = rs.getDate("ngayHetHan").toLocalDate();

                // Tính số ngày ở
                long soNgayO = ChronoUnit.DAYS.between(ng_Dat, ng_Het) + 1;
                
                
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
