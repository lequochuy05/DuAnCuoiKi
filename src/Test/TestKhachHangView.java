package Test;

import javax.swing.UIManager;

import View.KhachHangView;

public class TestKhachHangView {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new KhachHangView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
