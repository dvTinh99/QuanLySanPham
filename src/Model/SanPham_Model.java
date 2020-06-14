package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Bean.SanPham;

public class SanPham_Model {
	public SanPham_Model() {
		
	}
	
	Connection conn =  new Connect_Model().Connection_model();
	
	
	public ArrayList<SanPham> getAllSP(String maDanhMucSanPham){
		ArrayList<SanPham> arr = new ArrayList<>();
		//String sql = "select * from thongtinsp where Madmsp = ?";
		try {
			Statement stmt=conn.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from thongtinsp where Madmsp = '"+maDanhMucSanPham+"'");  
			while (rs.next()) {
				SanPham sp = new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6)
						);
				arr.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return arr;
	}
	public boolean checkBeforRemove(String maDanhMucSanPham){
		try {
			Statement stmt=conn.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from thongtinsp where Madmsp = '"+maDanhMucSanPham+"'");  
			 while (rs.next()) {
					return false;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	public boolean addSamPham(SanPham sanPham) {
		String sql = " INSERT INTO thongtinsp(IDsp, TenSP, Dongia,Soluong,Mota,Madmsp) VALUES (?,?,?,?,?,?)";
		PreparedStatement pres ;
		try {
			pres = conn.prepareStatement(sql);
			pres.setString(1, sanPham.getIdSP());
			pres.setString(2, sanPham.getTenSP());
			pres.setDouble(3, sanPham.getDonGia());
			pres.setInt(4, sanPham.getSoLuong());
			pres.setString(5, sanPham.getMoTa());
			pres.setString(6, sanPham.getMaDanhMuc());
			if (pres.executeUpdate() != 1 ) {
				return false ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		
		return true;
	}
	public String checkAndChane(SanPham sanPham) {
		String message=" " ;
		try {
			Statement stmt=conn.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from thongtinsp where IDsp = '"+sanPham.getIdSP()+"'");  
			if (rs.next()) {
				message = "sản phẩm đã tồn tại," ;
				if (Update(sanPham) ) {
					message += "sửa đổi thành công";
				}else {
					message += "sửa đổi thất bại";
				}
			}else {
				message += "sản phẩm chưa tồn tại,";
				if (addSamPham(sanPham)) {
					message += "insert thành công" ;
				}else {
					message +=  "inser thất bại";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message ;
	}
	public boolean Update(SanPham sanPham) {
		String sql = "UPDATE thongtinsp SET IDsp = ?, Dongia = ?, Soluong= ?,Mota= ?,Madmsp = ? WHERE IDsp = ?";
		try {
			PreparedStatement pres = conn.prepareStatement(sql);
			pres.setString(1, sanPham.getIdSP());
			pres.setDouble(2, sanPham.getDonGia());
			pres.setInt(3, sanPham.getSoLuong());
			pres.setString(4, sanPham.getMoTa());
			pres.setString(5, sanPham.getMaDanhMuc());
			pres.setString(6, sanPham.getIdSP());
			
			if (pres.executeUpdate()!=1) {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	return true ;
	}
	public boolean delete(String  idSanPham) {
		String sql = "DELETE FROM thongtinsp WHERE IDsp = ?";
		try {
			PreparedStatement pres = conn.prepareStatement(sql);
			pres.setString(1,idSanPham);
			if (pres.executeUpdate()!=1) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true ;
	}

}
