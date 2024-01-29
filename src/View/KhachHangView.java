package View;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.KhachHangController;
import Model.KhachHangModel;


public class KhachHangView extends JFrame {
	private KhachHangModel model;
	public static JTextField txt_idKhachHang;
	public static JTextField txt_tenKhachHang;
	public static JTable table;

	public KhachHangView() throws HeadlessException {
		this.model = new KhachHangModel();
		this.init();
		this.setVisible(true);

	}

	public void init() {
		this.setTitle("Kiểm tra đặt phòng của khách hàng");
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		ImageIcon icon = new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/hotel-icon.png");
		Image image = icon.getImage();
		this.setIconImage(image);

		Font font = new Font("Arial", Font.BOLD, 22);
		Font font_btn = new Font("Arial", Font.BOLD, 15);
		ActionListener action = new KhachHangController(this);
		
		JLabel lbl_img = new JLabel();
		lbl_img.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/caption.jpg"));
		JPanel pn_North = new JPanel();
		pn_North.setBackground(new Color(135, 206, 235));
		pn_North.setLayout(new FlowLayout());
		pn_North.add(lbl_img);
		
		
		JButton btn_loc = new JButton("Lọc");
		btn_loc.setFont(font_btn);
		btn_loc.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/chart-search-icon.png"));
		btn_loc.addActionListener(action);
		
		
		JButton btn_showList = new JButton("Hiển thị danh sách");
		btn_showList.setFont(font_btn);
		btn_showList.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/Programming-Show-Property-icon.png"));
		btn_showList.addActionListener(action);
		
		JButton btn_thanhToan = new JButton("Thanh toán");
		btn_thanhToan.setFont(font_btn);
		btn_thanhToan.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/home-sale-icon.png"));
		btn_thanhToan.addActionListener(action);

		JButton btn_logout = new JButton("Đăng xuất");
		btn_logout.setFont(font_btn);
		btn_logout.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/log-out-outline-icon.png"));
		btn_logout.addActionListener(action);
			
		

		JPanel pn_East = new JPanel();
		pn_East.setBackground(new Color(176, 150, 215));
		pn_East.setLayout(new GridLayout(4,1,10,10));
		pn_East.add(btn_loc);
		pn_East.add(btn_showList);
		pn_East.add(btn_thanhToan);
		pn_East.add(btn_logout);

		JLabel lbl_idKhachHang = new JLabel("CCCD");
		lbl_idKhachHang.setFont(font);
		txt_idKhachHang = new JTextField(20);
		txt_idKhachHang.setFont(font);
		txt_idKhachHang.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) { 
					e.consume(); // tiêu thụ 
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		JLabel lbl_tenKhachHang = new JLabel("Tên Khách Hàng");
		lbl_tenKhachHang.setFont(font);
		txt_tenKhachHang = new JTextField(20);
		txt_tenKhachHang.setFont(font);
		txt_tenKhachHang.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// KeyEvent (e) làm đối số đại diện cho sự kiện phím được gõ.
				if(!Character.isLetter(e.getKeyChar())) { 
					e.consume(); // tiêu thụ 
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		
		JPanel pn_South = new JPanel();
		pn_South.setLayout(new FlowLayout());
		pn_South.setBackground(new Color(135, 206, 235));
		pn_South.add(lbl_idKhachHang);
		pn_South.add(txt_idKhachHang);
		pn_South.add(lbl_tenKhachHang);
		pn_South.add(txt_tenKhachHang);

		

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CCCD", "Tên khách hàng", "SĐT",
				"Địa chỉ", "Email", "Giới tính", "Mã phòng","Số phòng","Giá phòng","Số người ở", "Ngày đặt phòng", "Ngày hết hạn", 
				"Thanh toán"}));
		//setBackgroud cho table
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setOpaque(true); // Để có thể hiển thị màu nền

        // Thiết lập màu nền cho JTable
        renderer.setBackground(Color.YELLOW);

        // Thiết lập Renderer cho từng cột của JTable
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setSize(500, 300);
		jScrollPane.setLocation(400, 400);
		

		this.setLayout(new BorderLayout());
		
		this.add(pn_North,BorderLayout.NORTH);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(pn_East, BorderLayout.EAST);
		this.add(pn_South, BorderLayout.SOUTH);

	}

	public void xoaForm() {
		txt_idKhachHang.setText("");
		txt_tenKhachHang.setText("");
	}
	
		

	
	
}