package Test;

import javax.swing.UIManager;

import View.HoaDonView;

public class TestHoaDonView {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new HoaDonView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
