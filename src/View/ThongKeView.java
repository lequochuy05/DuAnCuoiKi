package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.AdminModel;

public class ThongKeView extends JFrame{
	private AdminModel model;
	public ThongKeView()  {
		this.model = new AdminModel();
		setTitle("Thống kê");
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Font font = new Font("Arial", Font.BOLD, 30);
		
		JButton btn_quayLai = new JButton("Quay lại");
		btn_quayLai.setFont(font);
		JPanel pn_west = new JPanel();
		pn_west.setBackground(Color.green);
		pn_west.setLayout(new BorderLayout());
		pn_west.add(btn_quayLai, BorderLayout.SOUTH);
		
		
		
		
		
		
		
		
		
		this.setLayout(new BorderLayout());
		this.add(pn_west, BorderLayout.WEST);
		//this.add(pn_center, BorderLayout.CENTER);
		

		
		
	}
	public static void main(String[] args) {
		new ThongKeView().setVisible(true);
		
	}

}
