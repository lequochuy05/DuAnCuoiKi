package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Login_SignUp.LoginKhachHang;

public class DAOLoginAdmin {
private LoginKhachHang login;
	
	public void changePassword(String tenDN, String pass) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql ="UPDATE dangnhapAdmin"
					+ " SET matKhau=? WHERE tenDangNhap=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, tenDN);
			if(ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(login, "Sửa thành công");
			}else {
				JOptionPane.showMessageDialog(login, "Tên đăng nhập hoặc mật khẩu không đúng!");
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean isTonTaiIdKhachHang(String id) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT tenDangNhap FROM dangnhapadmin WHERE tenDangNhap = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isTonTaiKhachHang(String tenDangNhap, String matKhau) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "SELECT COUNT(*) FROM dangnhapadmin WHERE tenDangNhap = ? AND matKhau =?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, tenDangNhap);
	        ps.setString(2, matKhau);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);//lấy giá trị đầu tiên từ bản ghi đó
	            return count > 0;
	        }

	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
