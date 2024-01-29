package Login_SignUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Controller.LoginKH_Controller;
import Model.DangNhap;

public class LoginKhachHang extends JFrame {
	private DangNhap dn;
	public static JButton btn_resetPass;
	public static JToggleButton btn_showPass;
	public static JButton btn_login;
	public static JTextField txt_tenDangNhap;
	public static JPasswordField txt_matKhau;
	public static JButton btn_signUp;
	public static JCheckBox check;
	public static JButton btn_comBack;
	public static JButton btn_deleteUser;

	public LoginKhachHang() {
		this.dn = new DangNhap();
		this.setTitle("QUOCHUY HOTEL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		// this.getContentPane().setBackground(Color.PINK);//set mau cho JFRAME

		ImageIcon img_tiltle = new ImageIcon(
				"C:/Users/ASUS/Desktop/CK1/src/icon/Apps-preferences-system-login-icon.png");
		Image img = img_tiltle.getImage();
		this.setIconImage(img);

		Font font = new Font("Arial", Font.PLAIN, 20);
		ActionListener action = new LoginKH_Controller(this);

		JLabel lbl_title = new JLabel("Welcome To QUOCHUY Hotel");
		lbl_title.setFont(new Font("Arial", Font.BOLD, 40));
		// lbl_title.setBackground(Color.ORANGE);
		// lbl_title.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
		JPanel pn_North = new JPanel();
		pn_North.setBackground(new Color(0, 255, 0));
		pn_North.setLayout(new FlowLayout());
		pn_North.add(lbl_title);

		JLabel lbl_tenDangNhap = new JLabel("Tên Đăng Nhập");
		lbl_tenDangNhap.setFont(font);
		JLabel lbl_matKhau = new JLabel("Mật khẩu");
		lbl_matKhau.setFont(font);
		txt_tenDangNhap = new JTextField(20);
		txt_tenDangNhap.setFont(font);
		txt_matKhau = new JPasswordField(20);
		txt_matKhau.setFont(font);

		btn_resetPass = new JButton("Đổi mật khẩu");
		btn_resetPass.setFont(font);
		btn_resetPass.addActionListener(action);

		btn_showPass = new JToggleButton("Hiện mật khẩu");
		btn_showPass.setFont(font);
		btn_showPass.addActionListener(action);

//		btn_deleteUser = new JButton("Xóa tài khoản");
//		btn_deleteUser.setFont(font);
//		btn_deleteUser.addActionListener(action) ;

		btn_login = new JButton("Đăng nhập");
		btn_login.setFont(font);
		btn_login.addActionListener(action);

		btn_signUp = new JButton("Đăng kí");
		btn_signUp.setFont(font);
		btn_signUp.addActionListener(action);

		btn_comBack = new JButton("Quay lại");
		btn_comBack.setFont(font);
		btn_comBack.addActionListener(action);

		JPanel pn_Center = new JPanel();
		pn_Center.setBackground(new Color(135, 206, 235));
		pn_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pn_Center.add(lbl_tenDangNhap);
		pn_Center.add(txt_tenDangNhap);
		pn_Center.add(lbl_matKhau);
		pn_Center.add(txt_matKhau);

		pn_Center.add(btn_resetPass);
		pn_Center.add(btn_showPass);
		// pn_Center.add(btn_deleteUser);
		pn_Center.add(btn_login);
		pn_Center.add(btn_signUp);
		pn_Center.add(btn_comBack);

		this.setLayout(new BorderLayout(10, 10));
		this.add(pn_North, BorderLayout.NORTH);
		this.add(pn_Center, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public boolean isEmptyKhachHang() {

		if (txt_tenDangNhap.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập đang trống!");
			return false;
		}
		char[] arr_pas = txt_matKhau.getPassword();
		String matKhau = new String(arr_pas);
		if (matKhau.isEmpty()) {
			JOptionPane.showMessageDialog(null, "mật khẩu đang trống!");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new LoginKhachHang();
	}

}
