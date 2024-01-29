package Test;

import javax.swing.UIManager;

import View.AdminView;

public class TestAdminView {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new AdminView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
