package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Login_SignUp.LoginAdmin;
import Login_SignUp.LoginKhachHang;
import View.DemoView;

public class DemoContron implements ActionListener {
	private DemoView view;

	public DemoContron(DemoView view) {

		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Client")) {
			view.dispose();
			LoginKhachHang lgkh = new LoginKhachHang();
			lgkh.setVisible(true);

		} else if (cm.equals("Admin")) {
			view.dispose();
			LoginAdmin lgad = new LoginAdmin();
			lgad.setVisible(true);

		}
	}

}
