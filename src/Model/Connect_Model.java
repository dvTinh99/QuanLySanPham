package Model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Connect_Model {
	Connection con = null ;
	public boolean Validate_SP(JTextField id, JTextField name, JTextField gia, JTextField soLuong,JTextField moTa) {
		try {
			if (id.getText().toString()==""||
					name.getText().toString()==""||
					gia.getText().toString()==""||
					gia.getText().toString()==""||
					soLuong.getText().toString()==""||
					moTa.getText().toString()=="") 
			{
				JOptionPane.showMessageDialog(null,"Điền đầy đủ thông tin".toString(), "fail", JOptionPane.INFORMATION_MESSAGE);
				return false ;
			}
			try {
				double gia1 = Double.parseDouble(gia.getText().toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"giá là một số".toString(), "fail", JOptionPane.INFORMATION_MESSAGE);
			}
			try {
				int soLuong1 = Integer.parseInt(soLuong.getText().toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Số lượng là một số nguyên".toString(), "fail", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true ;
	}
	public boolean Validate_DanhMuc(JTextField id, JTextField name) {
		try {
			if (id.getText().toString()==""||
					name.getText().toString()=="") {
				JOptionPane.showMessageDialog(null,"Điền đầy đủ thông tin".toString(), "fail", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true ;
	}
	
	public Connection Connection_model() {
	String userName  = "root";
	String pass = "";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		con =DriverManager.getConnection(  
				"jdbc:mysql://localhost/qlsp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				userName,
				pass);  
		
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage().toString(), "fail", JOptionPane.INFORMATION_MESSAGE);
	}
	return con ;
}
}
