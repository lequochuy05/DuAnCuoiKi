package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QRThanhToan extends JFrame{
	private HoaDonView view;
	public QRThanhToan() {
		init();
		setVisible(true);
	}
	public void init() {
		setTitle("Thanh toán");
		setSize(1100,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ImageIcon img_tiltle = new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/donate-icon.png");
		Image img = img_tiltle.getImage();
		this.setIconImage(img);
		
		JLabel lbl = new JLabel();
		lbl.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/403927727_324206310493932_2881960909550057928_n.jpg"));
		
		JButton btn_xacNhan = new JButton("Xác nhận");
		btn_xacNhan.setFont(new Font("Arial", Font.BOLD, 30));
		btn_xacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "thanh toán thành công");
						dispose();
						KhachHangView kh = new KhachHangView();
						kh.setVisible(true);

			}
		});
		JButton btn_huy = new JButton("Hủy bỏ");
		btn_huy.setFont(new Font("Arial", Font.BOLD, 30));
		btn_huy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy bỏ thao tác này không? ", "", JOptionPane.YES_NO_OPTION);
				if(x==JOptionPane.YES_OPTION) {
						dispose();
						KhachHangView kh = new KhachHangView();
						kh.setVisible(true);
				}
				
			}
		});
		
		JPanel pn_west = new JPanel();
		pn_west.setBackground(new Color(135, 206, 235));
		pn_west.setLayout(new FlowLayout());
		pn_west.add(lbl);
		
		JPanel pn_east = new JPanel();
		pn_east.setBackground(new Color(135, 206, 235));
		pn_east.setLayout(new FlowLayout());
		pn_east.add(btn_xacNhan);
		pn_east.add(btn_huy);
		
		JPanel pn_chuaEast = new JPanel();
		pn_chuaEast.setBackground(new Color(135, 206, 235));
		pn_chuaEast.setLayout(new BorderLayout());
		pn_chuaEast.add(pn_east, BorderLayout.EAST);
		
		
		
		
		this.setLayout(new BorderLayout());
		this.add(pn_west, BorderLayout.WEST);
		this.add(pn_chuaEast, BorderLayout.CENTER);
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
		new QRThanhToan();
	}
	
}
