package Bean;

public class SanPham {
	String  idSP ;
	String tenSP;
	double donGia ;
	int soLuong ;
	String moTa ;
	String maDanhMuc ;
	
	public SanPham(String idSP,String tenSP,double donGia, int soLuong, String moTa, String maDanhMuc) {
		this.idSP =idSP ;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.moTa = moTa;
		this.maDanhMuc = maDanhMuc;
	}
	public String getIdSP() {
		return idSP;
	}
	public void setIdSP(String idSP) {
		this.idSP = idSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	
	

}
