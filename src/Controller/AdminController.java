package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.AdminDAO;
import Login_SignUp.LoginAdmin;
import View.AdminView;

public class AdminController implements ActionListener {
	private AdminView view;
	private AdminDAO dao = new AdminDAO();

	public AdminController(AdminView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Thêm")) {
			if (view.isEmptyAll()) {
				String id = view.txt_idKhachHang.getText();
				String ten = view.txt_tenKhachHang.getText();
				String sdt = view.txt_sdt.getText();
				String diachi = view.combobox_tinh.getSelectedItem().toString();
				String email = view.txt_email.getText();
				String gioiTinh = view.combo_gioiTinh.getSelectedItem().toString();
				String maPhong = view.combobox_IdPhong.getSelectedItem().toString();
				int soPhong = Integer.valueOf(view.combobox_soPhong.getSelectedItem().toString());
				float giaphong =Float.valueOf(view.combobox_gia.getSelectedItem().toString());
				int soNguoi = Integer.valueOf(view.txt_soNguoi.getText());
				String ngayd = view.txt_ngayDatPhong.getText();
				String ngayt = view.txt_ngayHetHan.getText();
				String thanhToan = view.combo_thanhToan.getSelectedItem().toString();
				if (!dao.isIdKhachHangExist(id)) {
					if (!dao.isPhoneExist(sdt)) {
						if (!dao.isEmailExist(email)) {
							if (!dao.isExistRoom(maPhong, soPhong)) {
								if (view.checkDate(ngayd) && view.checkDate(ngayt)) {
									if (view.checkDinhDang(ngayd) && view.checkDinhDang(ngayt)) {
										dao.insert(id, ten, sdt, diachi, email, gioiTinh, maPhong, soPhong, giaphong,
												soNguoi, ngayd, ngayt, thanhToan);
										view.xoaForm();
									}
								}
							} else {
								JOptionPane.showMessageDialog(view, "Phòng đã tồn tại");
							}
						} else {
							JOptionPane.showMessageDialog(view, "Email khách hàng đã tồn tại");
						}
					} else {
						JOptionPane.showMessageDialog(view, "Số điện thoại khách hàng đã tồn tại");
					}
				} else {
					JOptionPane.showMessageDialog(view, "Số CCCD đã tồn tại");
				}
			}

		}

		if (cm.equals("Cập nhật")) {
			if (view.isEmptyAll()) {
				String id = view.txt_idKhachHang.getText();
				String ten = view.txt_tenKhachHang.getText();
				String sdt = view.txt_sdt.getText();
				String diachi = view.combobox_tinh.getSelectedItem().toString();
				String email = view.txt_email.getText();
				String gioiTinh = view.combo_gioiTinh.getSelectedItem().toString();
				String maPhong = view.combobox_IdPhong.getSelectedItem().toString();
				int soPhong = Integer.valueOf(view.combobox_soPhong.getSelectedItem().toString());
				float giaphong = Float.valueOf(view.combobox_gia.getSelectedItem().toString());
				int soNguoi = Integer.valueOf(view.txt_soNguoi.getText());
				String ngayd = view.txt_ngayDatPhong.getText();
				String ngayt = view.txt_ngayHetHan.getText();
				String thanhToan = view.combo_thanhToan.getSelectedItem().toString();
				if (dao.isIdKhachHangExist(id)) {
					if(!dao.isExistRoom(maPhong, soPhong)) {
						dao.update(id, ten, sdt, diachi, email, gioiTinh, maPhong, soPhong, giaphong, soNguoi, ngayd, ngayt,
								thanhToan);
					}else {
						JOptionPane.showMessageDialog(view, "Phòng đã tồn tại");
					}
				}else {
					JOptionPane.showMessageDialog(view, "Số cccd không tồn tại");
				}
			}
		}

		if (cm.equals("Lọc")) {
			String id = view.txt_idKhachHang.getText();
			String ten = view.txt_tenKhachHang.getText();
			if(id.isEmpty() && ten.isEmpty()) {
			JOptionPane.showMessageDialog(view, "Vui lòng chọn 1 tiêu chí để lọc (CCCD / tenKhachHang)");
			}
			if (!id.isEmpty()) {
				dao.selectById(id);
			} 
			if(!ten.isEmpty()) {
				dao.selectByTen(ten);
			}
			
		} else if (cm.equals("Xóa")) {
			int x = JOptionPane.showConfirmDialog(view, "Bạn chắc chắn muốn xóa khách hàng này!", "",
					JOptionPane.YES_NO_OPTION);
			if (x == JOptionPane.YES_OPTION) {
				dao.delete();
			}
		} else if (cm.equals("Hiển thị danh sách")) {
			dao.selectAll();
		} else if (cm.equals("Đăng xuất")) {
			int x = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn đăng xuất không?", "Đăng xuất",
					JOptionPane.YES_NO_OPTION);
			if (x == JOptionPane.YES_OPTION) {
				view.dispose();
				LoginAdmin lg = new LoginAdmin();
				lg.setVisible(true);
			}
		}

	}

}
