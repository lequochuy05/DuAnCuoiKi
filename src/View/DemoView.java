package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.DemoContron;


public class DemoView extends JFrame{
	public DemoView() {
		this.setTitle("www//high-end hotel//quochuy.com");
		this.setSize(900,420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ActionListener action = new DemoContron(this);
		
		ImageIcon img_tiltle = new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/c6255f59db135a6389c5accff0e7cf8a.jpg");
		Image img = img_tiltle.getImage();
		this.setIconImage(img);
		
		JLabel lbl_welcome = new JLabel("QUOCHUY PLAZA HOTEL");
		lbl_welcome.setFont(new Font("Arial", Font.BOLD,45));
		lbl_welcome.setForeground(Color.RED);//setcolor chữ
		JPanel pn_North = new JPanel();
		pn_North.setLayout(new FlowLayout());
		pn_North.setBackground(Color.PINK);
		pn_North.add(lbl_welcome);
		
		JLabel lbl_title = new JLabel("Đăng nhập với tư cách:");
		lbl_title.setFont(new Font("Arial", Font.PLAIN, 20));
		JButton btn_admin = new JButton("Admin");
		btn_admin.addActionListener(action);
		btn_admin.setFont(new Font("Arial", Font.PLAIN,30));
		JButton btn_khachHang = new JButton("Client");
		btn_khachHang.addActionListener(action);
		btn_khachHang.setFont(new Font("Arial", Font.PLAIN,30));
		JPanel pn_btn = new JPanel();
		pn_btn.setBackground(new Color(135, 206, 235));
		pn_btn.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		pn_btn.add(lbl_title);
		pn_btn.add(btn_admin);
		pn_btn.add(btn_khachHang);
		
		
		JLabel lbl = new JLabel();
		lbl.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/caption.jpg"));
		JPanel pn_south = new JPanel();
		pn_south.setBackground(new Color(135, 206, 235));
		pn_south.setLayout(new FlowLayout());
		pn_south.add(lbl);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(pn_North, BorderLayout.NORTH);
		this.add(pn_btn, BorderLayout.CENTER);
		this.add(pn_south, BorderLayout.EAST);
		this.setVisible(true);
	}
	

}
