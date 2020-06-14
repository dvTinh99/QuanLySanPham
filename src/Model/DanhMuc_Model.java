package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.DanhMuc;

public class DanhMuc_Model {
	
Connection conn =  new Connect_Model().Connection_model();
	
	public ArrayList<DanhMuc> getAllDM(){
		ArrayList<DanhMuc> arrDM = new ArrayList<>();
		String sql = "SELECT * FROM danhmucsp ";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery(sql);
			while (rs.next()) {
				arrDM.add(new DanhMuc(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrDM;
	}
	public boolean addDanhMuc(DanhMuc danhMuc) {
		String sql = " INSERT INTO danhmucsp(Madmsp, Tendanhmuc) VALUES (?,?)";
		PreparedStatement pres ;
		try {
			pres = conn.prepareStatement(sql);
			pres.setString(1, danhMuc.getMaDanhMuc());
			pres.setString(2,danhMuc.getTenDanhMuc());
			if (pres.executeUpdate() != 1 ) {
				return false ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		
		return true;
	}
	public boolean deleteDanhMuc(DanhMuc dm) {
		String sql = "DELETE FROM danhmucsp WHERE Madmsp = ?";
		try {
			PreparedStatement pres = conn.prepareStatement(sql);
			pres.setString(1, dm.getMaDanhMuc());
			if (pres.executeUpdate() != 1 ) {
				return false ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true ;
	}
	public boolean updateDanhMuc(DanhMuc dm) {
		String sql = "UPDATE danhmucsp SET Tendanhmuc = ?  WHERE Madmsp = ?";
		try {
			PreparedStatement pres = conn.prepareStatement(sql);
			pres.setString(1,dm.getTenDanhMuc());
			pres.setString(2, dm.getMaDanhMuc());
			
			if (pres.executeUpdate()!=1) {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	return true ;
	}
}
