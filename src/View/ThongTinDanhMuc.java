package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bean.DanhMuc;
import Model.DanhMuc_Model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongTinDanhMuc extends JFrame {

	private JPanel contentPane;
	public JTextField txtCateID;
	public JTextField txtCateName;
	public ThongTinDanhMuc frame ;
	public JButton btnOk ;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ThongTinDanhMuc() {
		setTitle("Cate information");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cate ID");
		lblNewLabel.setBounds(50, 48, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCateID = new JTextField();
		txtCateID.setBounds(147, 45, 226, 20);
		contentPane.add(txtCateID);
		txtCateID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cate Name");
		lblNewLabel_1.setBounds(50, 109, 87, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCateName = new JTextField();
		txtCateName.setBounds(147, 106, 226, 20);
		contentPane.add(txtCateName);
		txtCateName.setColumns(10);
		
		btnOk = new JButton("OK");
		
	
		btnOk.setBounds(172, 198, 89, 23);
		contentPane.add(btnOk);
	}

}
