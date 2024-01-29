package Model;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDonModel {
	private String tenKhachHang;
	private String maPhong;
	private int soPhong;
	private float giaPhong;
	private long soNgayO;
	private double tongTien;
	public HoaDonModel() {
		super();
	}
	public HoaDonModel(String tenKhachHang, String maPhong, int soPhong, float giaPhong, long soNgayO,
			double tongTien) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.giaPhong = giaPhong;
		this.soNgayO = soNgayO;
		this.tongTien = tongTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(giaPhong, maPhong, soNgayO, soPhong, tenKhachHang, tongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonModel other = (HoaDonModel) obj;
		return Float.floatToIntBits(giaPhong) == Float.floatToIntBits(other.giaPhong)
				&& Objects.equals(maPhong, other.maPhong) && soNgayO == other.soNgayO && soPhong == other.soPhong
				&& Objects.equals(tenKhachHang, other.tenKhachHang)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien);
	}
	@Override
	public String toString() {
		return "HoaDonModel [tenKhachHang=" + tenKhachHang + ", maPhong=" + maPhong + ", soPhong=" + soPhong
				+ ", giaPhong=" + giaPhong + ", soNgayO=" + soNgayO + ", tongTien=" + tongTien + "]";
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}
	public float getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(float giaPhong) {
		this.giaPhong = giaPhong;
	}
	public long getSoNgayO() {
		return soNgayO;
	}
	public void setSoNgayO(long soNgayO) {
		this.soNgayO = soNgayO;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
}