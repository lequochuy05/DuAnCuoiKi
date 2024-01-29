package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.DAOLoginKH;
import Login_SignUp.LoginKhachHang;
import View.DemoView;
import View.KhachHangView;

public class LoginKH_Controller implements ActionListener {
	private LoginKhachHang dn;
	private DAOLoginKH dao = new DAOLoginKH();

	public LoginKH_Controller(LoginKhachHang dn) {
		this.dn = dn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Quay lại")) {
			dn.dispose();
			DemoView d = new DemoView();
			d.setVisible(true);
		}
		
		
		if (cm.equals("Hiện mật khẩu")) {
			LoginKhachHang.txt_matKhau.setEchoChar((char) 0);
		} else {
			LoginKhachHang.txt_matKhau.setEchoChar('*');
		}
			
		if (cm.equals("Đăng kí")) {
			if (dn.isEmptyKhachHang()) {
				String id = dn.txt_tenDangNhap.getText();
				char[] arr_matKhau = dn.txt_matKhau.getPassword();
				String matKhau = new String(arr_matKhau);
				if (!dao.isTonTaiIdKhachHang(id)) {
					dao.insert(id, matKhau);
					dn.txt_tenDangNhap.setText("");
					dn.txt_matKhau.setText("");
				} else {
					JOptionPane.showMessageDialog(dn, "Tên đăng nhập đã tồn tại!");
				}
			}
		}
		if (cm.equals("Đổi mật khẩu")) {
			if (dn.isEmptyKhachHang()) {
				String id = dn.txt_tenDangNhap.getText();
				char[] arr_matKhau = dn.txt_matKhau.getPassword();
				String matKhau = new String(arr_matKhau);
				if (dao.isTonTaiIdKhachHang(id)) {
					dao.update(id, matKhau);
				} else {
					JOptionPane.showMessageDialog(dn, "Tên đăng nhập không tồn tại");
				}
			}

		}
		if (cm.equals("Đăng nhập")) {
			if(dn.isEmptyKhachHang()) {
				String id = dn.txt_tenDangNhap.getText();
				char[] arr_matKhau = dn.txt_matKhau.getPassword();
				String matKhau = new String(arr_matKhau);
				if(dao.isTonTaiKhachHang(id, matKhau)){
					dn.dispose();
					KhachHangView kh = new KhachHangView();
					kh.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(dn, "Tên đăng nhập hoặc mật khẩu không đúng!");
				}
			}
		}
			
		

	}
}