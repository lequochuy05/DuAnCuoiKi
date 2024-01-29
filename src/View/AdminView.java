package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.AdminController;
import Model.AdminModel;


public class AdminView extends JFrame {
	private AdminModel model;
	public static JComboBox<String> combobox_tinh;
	public static JComboBox<String> combobox_IdPhong;
	public static JComboBox<Integer> combobox_soPhong;
	public static JComboBox<Float> combobox_gia;
	public static JTextField txt_soNguoi;
	public static JComboBox<String> combo_gioiTinh;
	public static JTextField txt_idKhachHang;
	public static JTextField txt_tenKhachHang;
	public static JTextField txt_sdt;
	public static JTextField txt_email;
	public static JRadioButton btn_nam;
	public static JRadioButton btn_nu;
	public static ButtonGroup btn_gioiTinh;
	public static JTextField txt_ngayHetHan;
	public static JTable table;
	public static JTextField txt_ngayDatPhong;
	public static  JComboBox<String> combo_thanhToan;
	
	// ---- //
	

	public AdminView() throws HeadlessException {
		this.model = new AdminModel();
		this.init();
		this.setVisible(true);
		this.xoaForm();
	}

	public void init() {
		this.setTitle("Quản lí đặt/thuê phòng trong khách sạn");
		this.setSize(1400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		ImageIcon icon = new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/hotel-icon.png");
		Image image = icon.getImage();
		this.setIconImage(image);
		
		Font font = new Font("Arial", Font.BOLD, 17);
		ActionListener action = new AdminController(this);
		
		JMenuBar jMenuBar = new JMenuBar();
		jMenuBar.setToolTipText("");
		setJMenuBar(jMenuBar);

		JMenu menu_File = new JMenu("File");
		menu_File.setFont(new Font("Arial", Font.BOLD, 10));
		jMenuBar.add(menu_File);

		JMenuItem menuItem_Open = new JMenuItem("Open");
		menu_File.add(menuItem_Open);

		JSeparator separator_1 = new JSeparator();
		menu_File.add(separator_1);

		JMenuItem menuItem_Close = new JMenuItem("Close");
		menu_File.add(menuItem_Close);

		JSeparator separator = new JSeparator();
		menu_File.add(separator);

		JMenuItem menuItem_Exit = new JMenuItem("Exit\r\n");
		menu_File.add(menuItem_Exit);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.BOLD, 10));
		jMenuBar.add(mnAbout);

		JMenuItem menuItem_aboutMe = new JMenuItem("About me");
		mnAbout.add(menuItem_aboutMe);
		
		
		JButton btn_add = new JButton("Thêm");
		btn_add.setBackground(Color.RED);
		btn_add.setFont(font);
		btn_add.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/Sign-Add-icon.png"));
		btn_add.addActionListener(action);

		JButton btn_delete = new JButton("Xóa");
		btn_delete.setBackground(Color.RED);
		btn_delete.setFont(font);
		btn_delete.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/symbol-delete-icon.png"));
		btn_delete.addActionListener(action);

		JButton btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.setBackground(Color.RED);
		btn_capNhat.setFont(font);
		btn_capNhat.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/update-icon.png"));
		btn_capNhat.addActionListener(action);
		
		JButton btn_loc = new JButton("Lọc");
		btn_loc.setBackground(Color.RED);
		btn_loc.setFont(font);
		btn_loc.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/chart-search-icon.png"));
		btn_loc.addActionListener(action);
		
		JButton btn_showList = new JButton("Hiển thị danh sách");
		btn_showList.setBackground(Color.RED);
		btn_showList.setFont(font);
		btn_showList.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/Programming-Show-Property-icon.png"));
		btn_showList.addActionListener(action);
		
		JButton btn_logout = new JButton("Đăng xuất");
		btn_logout.setBackground(Color.RED);
		btn_logout.setFont(font);
		btn_logout.setIcon(new ImageIcon("C:/Users/ASUS/Desktop/CK1/src/icon/log-out-outline-icon.png"));
		btn_logout.addActionListener(action);
			
		

		JPanel pn_South = new JPanel();
		pn_South.setBackground(new Color(176, 150, 215));
		pn_South.setLayout(new GridLayout(1, 1, 10, 0));
		pn_South.add(btn_add);
		pn_South.add(btn_delete);
		pn_South.add(btn_capNhat);
		pn_South.add(btn_loc);
		pn_South.add(btn_showList);
		pn_South.add(btn_logout);

		JLabel lbl_idKhachHang = new JLabel("CCCD");
		lbl_idKhachHang.setFont(font);
		txt_idKhachHang = new JTextField(15);
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
		txt_tenKhachHang = new JTextField(30);
		txt_tenKhachHang.setFont(font);
		txt_tenKhachHang.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// KeyEvent (e) làm đối số đại diện cho sự kiện phím được gõ.
				//lấy chữ và dấu cách
				if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ') { 
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
					

		JLabel lbl_Sdt = new JLabel("SĐT");
		lbl_Sdt.setFont(font);
		txt_sdt = new JTextField(15);
		txt_sdt.setFont(font);
		txt_sdt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//Kiểm tra ký tự đó có phải là một ký tự số
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
		
			
		// -- //
		
		JLabel lbl_diaChi = new JLabel("Địa Chỉ");
		lbl_diaChi.setFont(font);
		String[] arr_tinh = new String[] {"Hà Giang", "Cao Bằng", "Lào Cai", "Sơn La", "Lai Châu", "Bắc Kạn", "Lạng Sơn",
				"Tuyên Quang", "Yên Bái", "Thái Nguyên", "Điện Biên", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang", "Bắc Ninh",
				"Hà Nội", "Quảng Ninh", "Hải Dương", "Hải Phòng", "Hòa Bình", "Hưng Yên", "Hà Nam", "Thái Bình",
				"Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế",
				"Đà Nẵng", "Quảng Nam", "Quảng Ngãi", "Kon Tum", "Gia Lai", "Bình Định", "Phú Yên", "Đắk Lắk",
				"Khánh Hòa", "Đắk Nông", "Lâm Đồng", "Ninh Thuận", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai",
				"Bình Thuận", "Thành phố Hồ Chí Minh", "Long An", "Bà Rịa – Vũng Tàu", "Đồng Tháp", "An Giang",
				"Tiền Giang", "Vĩnh Long", "Bến Tre", "Cần Thơ", "Kiên Giang", "Trà Vinh", "Hậu Giang", "Sóc Trăng",
				"Bạc Liêu", "Cà Mau", };
		combobox_tinh = new JComboBox<String>(arr_tinh);
		combobox_tinh.setFont(font);

		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(font);
		txt_email = new JTextField(50);
		txt_email.setFont(font);
		

		JLabel lbl_gioiTinh = new JLabel("Giới Tính");
		lbl_gioiTinh.setFont(font);
		String[] gioiTinh = new String[] {"Nam", "Nữ"};
		combo_gioiTinh = new JComboBox<String>(gioiTinh);
		combo_gioiTinh.setFont(font);
		
	
		JLabel lbl_maPhong = new JLabel("Mã phòng");
		lbl_maPhong.setFont(font);
		String[] maPhong = new String[] {"S", "A", "B", "C", "D", "E", "F"};
		combobox_IdPhong = new JComboBox<String>(maPhong);
		combobox_IdPhong.setFont(font);
		
		JLabel lbl_soPhong = new JLabel("Số phòng");
		lbl_soPhong.setFont(font);
		combobox_soPhong = new JComboBox<Integer>();
		for(int i = 1; i <=20; i++) {
			combobox_soPhong.addItem(i);
		}
		combobox_soPhong.setFont(font);
		

		JLabel lbl_giaPhong = new JLabel("Giá phòng");
		lbl_giaPhong.setFont(font);
		float[] gia = new float[] {1000, 800, 500, 200, 100};
		combobox_gia = new JComboBox<Float>();
		for(float x : gia) {
			combobox_gia.addItem(x);
		}
		combobox_gia.setFont(font);
		
		JLabel lbl_soNguoi = new JLabel("Số người ở");
		lbl_soNguoi.setFont(font);
		txt_soNguoi = new JTextField(5);
		txt_soNguoi.setFont(font);
		txt_soNguoi.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//Kiểm tra ký tự đó có phải là một ký tự số
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
		
		JLabel lbl_ngayDatPhong = new JLabel("Ngày đặt phòng");
		lbl_ngayDatPhong.setFont(font);
		txt_ngayDatPhong = new JTextField(10);
		txt_ngayDatPhong.setFont(font);

		JLabel lbl_ngayHetHan = new JLabel("Ngày hết hạn");
		lbl_ngayHetHan.setFont(font);
		txt_ngayHetHan = new JTextField(10);
		txt_ngayHetHan.setFont(font);
		
		JLabel lbl_thanhToan = new JLabel("Thanh toán");
		lbl_thanhToan.setFont(font);
		String[] thanhtoan = new String[] {"Đang xác nhận","Đã thanh toán", "Chưa thanh toán"};
		combo_thanhToan = new JComboBox<String>(thanhtoan);
		combo_thanhToan.setFont(font);
		
		JPanel pn_North = new JPanel();
		pn_North.setBackground(new Color(152, 251, 152));
		pn_North.setLayout(new GridLayout(5, 6, 10, 10));
		pn_North.add(lbl_idKhachHang);
		pn_North.add(txt_idKhachHang);
		pn_North.add(lbl_tenKhachHang);
		pn_North.add(txt_tenKhachHang);
		pn_North.add(lbl_Sdt);
		pn_North.add(txt_sdt);
		pn_North.add(lbl_diaChi);
		pn_North.add(combobox_tinh);
		pn_North.add(lbl_email);
		pn_North.add(txt_email);
		pn_North.add(lbl_gioiTinh);
		pn_North.add(combo_gioiTinh);
		pn_North.add(lbl_maPhong);
		pn_North.add(combobox_IdPhong);
		pn_North.add(lbl_soPhong);
		pn_North.add(combobox_soPhong);
		pn_North.add(lbl_giaPhong);
		pn_North.add(combobox_gia);
		pn_North.add(lbl_soNguoi);
		pn_North.add(txt_soNguoi);
		pn_North.add(lbl_ngayDatPhong);
		pn_North.add(txt_ngayDatPhong);
		pn_North.add(lbl_ngayHetHan);
		pn_North.add(txt_ngayHetHan);
		pn_North.add(lbl_thanhToan);
		pn_North.add(combo_thanhToan);

		table = new JTable();
		table.setModel(new DefaultTableModel(null, new Object[] {"CCCD", "Tên khách hàng", "SĐT",
				"Địa chỉ", "Email", "Giới tính", "Mã phòng", "Số phòng", "Giá phòng", "Số người ở", "Ngày đặt phòng", "Ngày hết hạn", 
				"Thanh toán"}));
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txt_idKhachHang.setText(table.getValueAt(row, 0).toString());
				txt_tenKhachHang.setText(table.getValueAt(row, 1).toString());
				txt_sdt.setText(table.getValueAt(row, 2).toString());
				combobox_tinh.setSelectedItem(table.getValueAt(row, 3));
				txt_email.setText(table.getValueAt(row, 4).toString());
				combo_gioiTinh.setSelectedItem(table.getValueAt(row, 5));
				combobox_IdPhong.setSelectedItem(table.getValueAt(row, 6));
				combobox_soPhong.setSelectedItem(Integer.valueOf(table.getValueAt(row, 7).toString()));
				combobox_gia.setSelectedItem(Float.valueOf(table.getValueAt(row, 8).toString()));
				txt_soNguoi.setText(table.getValueAt(row, 9).toString());
				txt_ngayDatPhong.setText(table.getValueAt(row, 10).toString());
				txt_ngayHetHan.setText(table.getValueAt(row, 11).toString());
				combo_thanhToan.setSelectedItem(table.getValueAt(row, 12));
			}
		});
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setOpaque(true);
        // Thiết lập màu nền cho JTable
        renderer.setBackground(new Color(135, 206, 235));
        // Thiết lập Renderer cho từng cột của JTable
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setSize(500, 300);
		jScrollPane.setLocation(400, 400);

		this.setLayout(new BorderLayout());
		this.add(pn_South, BorderLayout.SOUTH);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(pn_North, BorderLayout.NORTH);

	}

	public void xoaForm() {
		txt_idKhachHang.setText("");
		txt_tenKhachHang.setText("");
		combobox_tinh.setSelectedIndex(-1);
		txt_email.setText("");
		txt_sdt.setText("");
		txt_soNguoi.setText("");
		txt_ngayDatPhong.setText("");
		txt_ngayHetHan.setText("");	
		combobox_soPhong.setSelectedIndex(-1);
		combobox_IdPhong.setSelectedIndex(-1);
		combo_gioiTinh.setSelectedIndex(-1);
		combo_thanhToan.setSelectedIndex(-1);
		combobox_gia.setSelectedIndex(-1);
	}
	
	public boolean isEmptyAll() {
		if(txt_idKhachHang.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Số CCCD đang trống ! vui lòng nhập CCCD");	
			return false;
		}
		if (!txt_idKhachHang.getText().matches("[0-9]{12}$")){// check cccd 12 so
			JOptionPane.showMessageDialog(null, "Số CCCD không đúng định dạng (12 chữ số)");	
			return false;
		}
		if(txt_tenKhachHang.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "tên khách hàng đang trống ! vui lòng nhập tên khách hàng");	
			return false;
		}
		if(txt_sdt.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "số điện thoại khách hàng đang trống ! vui lòng nhập số điện thoại khách hàng");	
			return false;
		}
		if(!txt_sdt.getText().matches("[0-9]{10}$"))//check định dạng so dien thoai  
		{
			JOptionPane.showMessageDialog(null, "số điện thoại khách hàng không đúng định dạng (10 chữ số)");	
			return false;
		}
		if(txt_email.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "email đang trống ! vui lòng nhập email khách hàng");	
			return false;
		}
		if(!txt_email.getText().matches("^.+@gmail.com")) //check đinh dang email
		{
			JOptionPane.showMessageDialog(null, "email không đúng định dạng (@gmail.com)");	
			return false;
		}
		if(txt_soNguoi.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Số người ở đang trống ! vui lòng nhập số người ở");	
			return false;
		}
		if(txt_ngayDatPhong.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "ngày đặt phòng đang trống ! vui lòng nhập ngày đặt phòng");	
			return false;
		}
		
		
		if(txt_ngayHetHan.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "ngày hết hạn đang trống ! vui lòng nhập ngày hết hạn");	
			return false;
		}
		return true;
	}
	
	//check theo định dạng yyyy-MM-dd
	public boolean checkDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			format.parse(date);
			return true;
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Lỗi Ngày đặt phòng hoặc ngày hết hạn không hợp lệ");
		}
		return false;
	}
	
	//check hợp lệ
	public boolean checkDinhDang(String s) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			Date date = format.parse(s);
			Calendar ca = Calendar.getInstance();
			ca.setTime(date);
			
			int year = ca.get(Calendar.YEAR);
			int month = ca.get(Calendar.MONTH)+1;//tháng bắt đầu bằng 0
			int day = ca.get(Calendar.DAY_OF_MONTH);
			//kiểm tra năm nhuận
			boolean isNamNhuan = (year % 4 == 0 && year % 100 != 0) || (year %400 ==0); 
				return year >0 && month > 0 && month <13 && day>0 && day<32 && (isNamNhuan || (month !=2 ||day<29));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Lỗi Ngày đặt phòng hoặc ngày hết hạn không hợp lệ");
		}
		return false;
	}
	

}