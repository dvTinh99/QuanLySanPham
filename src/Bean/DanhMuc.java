package Bean;

import java.util.ArrayList;



public class DanhMuc {
	String maDanhMuc ;
	String TenDanhMuc ;
	
	public DanhMuc() {
		super();
	}
	public DanhMuc(String maDanhMuc, String TenDanhMuc) {
		this.maDanhMuc= maDanhMuc;
		this.TenDanhMuc =TenDanhMuc;
	}
	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return TenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		TenDanhMuc = tenDanhMuc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.TenDanhMuc;
	}
//	public ArrayList<SanPham> getArr() {
//		return arr;
//	}
//	public void setArr(ArrayList<SanPham> arr) {
//		this.arr = arr;
//	}
//	public SanPham findSanPhamById(String id)
//
//	{
//
//		for (SanPham p : this.arr)
//
//			if (p.idSP.equalsIgnoreCase(id))
//
//				return p;
//
//		return null;
//
//	}
//	public void removeSanPhamById(String id)
//
//	{
//
//		SanPham pFind = findSanPhamById(id);
//
//		if (pFind != null)
//
//			arr.remove(pFind);
//
//	}
//
//	public void removeSanPhamByIndex(String index)
//
//	{
//
//		arr.remove(index);
//
//	}
//	public boolean addSanPham(SanPham p)
//
//	{
//
//		SanPham pFind = findSanPhamById(p.getIdSP());
//
//		if (pFind != null)
//
//		{
//
//			System.err.println("Duplicate SanPham ID!");
//
//			return false;
//
//		}
//
//		arr.add(p);

//		return true;

	}


