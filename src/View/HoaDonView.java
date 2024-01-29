package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.HoaDonDAO;
import Model.HoaDonModel;

public class HoaDonView extends JFrame {
	private HoaDonModel model;
	private AdminView view;
	private Set<String> soLanTaoHD;
	private JLabel lbl_maHD;
	public static JTextField txt_loc;
	private HoaDonDAO dao = new HoaDonDAO();
	private JLabel lbl_5;
	private JLabel lbl_6;
	public static JLabel lbl_1;
	public static JLabel lbl_2;
	public static JLabel lbl_3;
	public static JLabel lbl_4;

	public HoaDonView() throws HeadlessException {
		super();
		this.model = new HoaDonModel();
		this.init();
		this.setVisible(true);
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hóa Đơn");
		setSize(850, 600);
		setLocationRelativeTo(null);

		Font font = new Font("Arial", Font.BOLD, 20);

		ImageIcon icon = new ImageIcon(
				"C:/Users/ASUS/Desktop/CK1/src/icon/403927727_324206310493932_2881960909550057928_n.jpg");
		this.setIconImage(icon.getImage());

		JLabel lbl_title = new JLabel("QUOCHUY PLAZA");
		lbl_title.setFont(new Font("Arial", Font.BOLD, 40));
		JPanel pn_North = new JPanel();
		pn_North.setBackground(new Color(179, 179, 77));
		pn_North.setLayout(new FlowLayout(FlowLayout.CENTER));
		pn_North.add(lbl_title);

		soLanTaoHD = new HashSet<>();// theo dõi các số lần tạo hóa đơn mà không bị trùng lặp.
		JLabel lbl_tenMaHD = new JLabel("Mã hóa đơn:");
		lbl_tenMaHD.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_maHD = new JLabel();
		lbl_maHD.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_maHD.setHorizontalAlignment(SwingConstants.CENTER);// ăn chỉnh ngang vào trung tâm của nhãn
		setMaHD();
		JPanel pn_maHd = new JPanel();
		pn_maHd.setBackground(new Color(135, 206, 235));
		pn_maHd.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pn_maHd.add(lbl_tenMaHD);
		pn_maHd.add(lbl_maHD);

		JLabel lbl_ten = new JLabel("Tên khách hàng:");
		lbl_ten.setFont(font);
		JLabel lbl_maPhong = new JLabel("Mã phòng:");
		lbl_maPhong.setFont(font);
		JLabel lbl_soPhong = new JLabel("Số Phòng:");
		lbl_soPhong.setFont(font);
		JLabel lbl_gia = new JLabel("Giá phòng:");
		lbl_gia.setFont(font);
		JLabel lbl_soNgayO = new JLabel("Số ngày ở:");
		lbl_soNgayO.setFont(font);
		JLabel lbl_tong = new JLabel("Tổng tiền:");
		lbl_tong.setFont(font);
		
		lbl_1 = new JLabel("");
		lbl_1.setFont(font);
		lbl_2 = new JLabel("");
		lbl_2.setFont(font);
		lbl_3 = new JLabel("");
		lbl_3.setFont(font);
		lbl_4 = new JLabel("");
		lbl_4.setFont(font);
		lbl_5 = new JLabel("");
		lbl_5.setFont(font);
		lbl_6 = new JLabel("");
		lbl_6.setFont(font);
			
		
		JPanel pn_in4 = new JPanel();
		pn_in4.setBackground(new Color(135, 206, 235));
		pn_in4.setLayout(new GridLayout(7, 1, 5, 5));
		pn_in4.add(lbl_ten);
		pn_in4.add(lbl_1);
		pn_in4.add(lbl_maPhong);
		pn_in4.add(lbl_2);
		pn_in4.add(lbl_soPhong);
		pn_in4.add(lbl_3);
		pn_in4.add(lbl_gia);
		pn_in4.add(lbl_4);
		pn_in4.add(lbl_soNgayO);
		pn_in4.add(lbl_5);
		pn_in4.add(lbl_tong);
		pn_in4.add(lbl_6);
		JPanel pn_center = new JPanel();
		pn_center.setBackground(new Color(135, 206, 235));
		pn_center.setLayout(new BorderLayout());
		pn_center.add(pn_maHd, BorderLayout.NORTH);
		pn_center.add(pn_in4, BorderLayout.CENTER);
		JLabel lbl_thanks = new JLabel("Cảm ơn đã đến với khách sạn của chúng tôi. Hẹn gặp lại!");
		lbl_thanks.setFont(new Font("Arial", Font.ITALIC, 15));
		pn_center.add(lbl_thanks, BorderLayout.SOUTH);
	

		JLabel lbl_loc = new JLabel("Nhập CCCD:");
		lbl_loc.setFont(new Font("Arial", Font.PLAIN, 20));
		txt_loc = new JTextField(12);
		txt_loc.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_loc.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
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
		JButton btn_loc = new JButton("Tìm");
		btn_loc.setFont(font);
		btn_loc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = txt_loc.getText();
				HoaDonModel hd = dao.selectByID(id);
				if (hd != null) {
					// Hiển thị thông tin trong lable
					lbl_1.setText(hd.getTenKhachHang());
					lbl_2.setText(hd.getMaPhong());
					lbl_3.setText(hd.getSoPhong()+"");
					lbl_4.setText(hd.getGiaPhong() + "");
					lbl_5.setText(hd.getSoNgayO() + "");
					lbl_6.setText(hd.getTongTien() + "");

				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin khách hàng");
				}

			}
		});

		JPanel pn_loc = new JPanel();
		pn_loc.setLayout(new GridLayout(3, 1, 20, 10));
		pn_loc.add(lbl_loc);
		pn_loc.add(txt_loc);
		pn_loc.add(btn_loc);
		JPanel pn_chuaLoc = new JPanel();
		pn_chuaLoc.setBackground(new Color(192, 192, 192));
		;
		pn_chuaLoc.setLayout(new BorderLayout());
		pn_chuaLoc.add(pn_loc, BorderLayout.SOUTH);

		JButton btn_thanhToan = new JButton("Thanh toán");
		btn_thanhToan.setFont(new Font("Arial", Font.BOLD, 25));
		btn_thanhToan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_loc.getText().isEmpty()) {
					String id = txt_loc.getText();
					if (dao.isIdKhachHangExist(id)) {
						dispose();
						QRThanhToan qr = new QRThanhToan();
						qr.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Số CCCD không tồn tại");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin CCCD cần thanh toán");
				}
			}
		});
		JButton btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 25));
		btn_QuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				KhachHangView kh = new KhachHangView();
				kh.setVisible(true);
			}
		});
		JPanel pn_button = new JPanel();
		pn_button.setLayout(new FlowLayout());
		pn_button.add(btn_thanhToan);
		pn_button.add(btn_QuayLai);

		JPanel pn_East = new JPanel();
		pn_East.setLayout(new BorderLayout());
		pn_East.add(pn_button, BorderLayout.SOUTH);
		pn_East.add(pn_chuaLoc, BorderLayout.CENTER);

		JLabel lbl_img = new JLabel("");
		lbl_img.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl_img.setIcon(new ImageIcon("D:\\eclipse\\Icon_png\\c6255f59db135a6389c5accff0e7cf8a.jpg"));
		pn_chuaLoc.add(lbl_img, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(pn_North, BorderLayout.NORTH);
		this.add(pn_center, BorderLayout.CENTER);
		this.add(pn_East, BorderLayout.EAST);
	}

	private void setMaHD() {
		String maHD = UUID.randomUUID().toString().substring(0, 8);// tạo ra một chuỗi UUID dưới dạng chuỗi ký tự lấy 8
																	// kí tự đầu
		while (soLanTaoHD.contains(maHD)) {
			maHD = UUID.randomUUID().toString().substring(0, 8);
		}
		soLanTaoHD.add(maHD);
		lbl_maHD.setText(maHD);
	}

}
