package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import DAO.DAOLoginAdmin;
import Login_SignUp.LoginAdmin;
import View.AdminView;
import View.DemoView;

public class LoginAdmin_Controller implements ActionListener {
	private LoginAdmin dn;
	private DAOLoginAdmin dao = new DAOLoginAdmin();

	public LoginAdmin_Controller(LoginAdmin dn) {
		this.dn = dn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Hiện mật khẩu")) {
			LoginAdmin.txt_matKhau.setEchoChar((char) 0);
		} else {
			LoginAdmin.txt_matKhau.setEchoChar('*');
		}
		if (cm.equals("Quay lại")) {
			dn.dispose();
			DemoView d = new DemoView();
			d.setVisible(true);

		}
		if (cm.equals("Đăng nhập")) {
			if (dn.isEmptyAdmin()) {
				String id = dn.txt_tenDangNhap.getText();
				char[] arr_matKhau = dn.txt_matKhau.getPassword();
				String matKhau = new String(arr_matKhau);
				JPasswordField nhapmk = new JPasswordField();
				Object[] mess = { "Nhập mật khẩu truy cập", nhapmk };
				int luachon = JOptionPane.showConfirmDialog(dn, mess, "", JOptionPane.YES_NO_OPTION);
				if (luachon == JOptionPane.YES_OPTION) {
					char[] mk = nhapmk.getPassword();

					if (new String(mk).equals("10062005")) {
						if (dao.isTonTaiKhachHang(id, matKhau)) {
							dn.dispose();
							AdminView ad = new AdminView();
							ad.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(dn, "Tên đăng nhập hoặc mật khẩu không đúng!");
						}
					} else {
						JOptionPane.showMessageDialog(dn, "mã xác nhận không đúng!");
					}
				}
			}
		}
		if (cm.equals("Đổi mật khẩu")) {
			if (dn.isEmptyAdmin()) {
				String id = dn.txt_tenDangNhap.getText();
				char[] arr_matKhau = dn.txt_matKhau.getPassword();
				String matKhau = new String(arr_matKhau);
				JPasswordField nhapmk = new JPasswordField();
				Object[] mess = { "Nhập mật khẩu truy cập", nhapmk };
				int luachon = JOptionPane.showConfirmDialog(dn, mess, "", JOptionPane.YES_NO_OPTION);
				if (luachon == JOptionPane.YES_OPTION) {
					char[] mk = nhapmk.getPassword();
					if (new String(mk).equals("123")) {
						dao.changePassword(id, matKhau);
					} else {
						JOptionPane.showMessageDialog(dn, "mã xác nhận không đúng!");
					}
				}
			}
		}
	}
}
