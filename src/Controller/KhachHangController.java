package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.KhachHangDAO;
import Login_SignUp.LoginKhachHang;
import View.HoaDonView;
import View.KhachHangView;

public class KhachHangController implements ActionListener {
	private KhachHangView view;
	private KhachHangDAO dao = new KhachHangDAO();

	public KhachHangController(KhachHangView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Lọc")) {
		    String cccd = view.txt_idKhachHang.getText();
		    String ten = view.txt_tenKhachHang.getText();
		    if(ten.isEmpty()) {
		    	dao.selectById(cccd);
		    }
		    if(cccd.isEmpty()) {
		    	dao.selectByTen(ten);
		    }
		    if(cccd.isEmpty() && ten.isEmpty()) {
		    	JOptionPane.showMessageDialog(view, "Vui lòng chọn một tiêu chí để lọc");
		    }
		    
		}

		if (cm.equals("Hiển thị danh sách")) {
			dao.selectAll();
		}
		if (cm.equals("Thanh toán")) {
			view.dispose();
			HoaDonView hoaDon = new HoaDonView();
			hoaDon.setVisible(true);
		}
		
		if (cm.equals("Đăng xuất")) {
			int x = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn đăng xuất không?", "Đăng xuất",
					JOptionPane.YES_NO_OPTION);
			if (x == JOptionPane.YES_OPTION) {
				view.dispose();
				LoginKhachHang lg = new LoginKhachHang();
				lg.setVisible(true);
			}
		}

	}

}
