package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Login_SignUp.LoginKhachHang;

public class DAOLoginKH {
private LoginKhachHang login;
	public void insert(String id, String matKhau) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO dangnhapKhachHang(tendangnhap, matkhau)"
					+ "VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, matKhau);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
				
				JDBCUtil.closeConnection(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void update(String id, String matKhau) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE dangnhapKhachHang "
					+ "SET matKhau=?"
					+ " WHERE tenDangNhap =?";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, matKhau);
			ps.setString(2, id);
			if(ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "đổi mật khẩu thành công!");
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
			String sql = "SELECT tenDangNhap FROM dangnhapKhachHang WHERE tenDangNhap =?";
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
	        String sql = "SELECT COUNT(*) FROM dangnhapKhachHang WHERE tenDangNhap = ? AND matKhau =?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, tenDangNhap);
	        ps.setString(2, matKhau);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0;
	        }
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
