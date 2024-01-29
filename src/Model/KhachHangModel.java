package Model;

import java.util.Objects;

public class KhachHangModel {
	private int CCCD;
	private String tenKhachHang;
	private String diaChi;

	public KhachHangModel() {
		super();
	}

	public KhachHangModel(int cCCD, String tenKhachHang, String diaChi) {
		super();
		CCCD = cCCD;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
	}

	public int getCCCD() {
		return CCCD;
	}

	public void setCCCD(int cCCD) {
		CCCD = cCCD;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CCCD, diaChi, tenKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHangModel other = (KhachHangModel) obj;
		return CCCD == other.CCCD && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}

	@Override
	public String toString() {
		return "KhachHangModel [CCCD=" + CCCD + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi + "]";
	}
	
}
