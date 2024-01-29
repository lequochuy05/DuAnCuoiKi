package Test;

import javax.swing.UIManager;

import View.DemoView;

public class TestDemoView {
	public static void main(String[] args) {
		try {
			//setGiao dien do hoa
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new DemoView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
