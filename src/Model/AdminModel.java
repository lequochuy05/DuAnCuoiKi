package Model;

import java.util.Objects;

public class AdminModel {
	private String CCCD;
	private String tenKH;
	private String sdt;
	private String diaChi;
	private String email;
	private String gioiTinh;
	private String maPhong;
	private Integer soPhong;
	private Float giaPhong;
	private String tinhTrangPhong;
	private String soLuongNguoiO;
	private String ngayDatPhong;
	private String ngayHetHan;
	private String thanhToan;

	public AdminModel() {
		super();
	}

	public AdminModel(String CCCD, String tenKH, String sdt, String diaChi, String email, String gioiTinh, String maPhong,
			Integer soPhong, Float giaPhong, String tinhTrangPhong, String soLuongNguoiO, String ngayDatPhong,
			String ngayHetHan, String thanhToan) {
		super();
		this.CCCD = CCCD;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.giaPhong = giaPhong;
		this.tinhTrangPhong = tinhTrangPhong;
		this.soLuongNguoiO = soLuongNguoiO;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayHetHan = ngayHetHan;
		this.thanhToan = thanhToan;
	}

	public String getMaKH() {
		return CCCD;
	}

	public void setMaKH(String CCCD) {
		this.CCCD = CCCD;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public Integer getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(Integer soPhong) {
		this.soPhong = soPhong;
	}

	public Float getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(Float giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getTinhTrangPhong() {
		return tinhTrangPhong;
	}

	public void setTinhTrangPhong(String tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}

	public String getSoLuongNguoiO() {
		return soLuongNguoiO;
	}

	public void setSoLuongNguoiO(String soLuongNguoiO) {
		this.soLuongNguoiO = soLuongNguoiO;
	}

	public String getNgayDatPhong() {
		return ngayDatPhong;
	}

	public void setNgayDatPhong(String ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(String thanhToan) {
		this.thanhToan = thanhToan;
	}

	@Override
	public String toString() {
		return "AdminModel [CCCD=" + CCCD + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diaChi=" + diaChi + ", email="
				+ email + ", gioiTinh=" + gioiTinh + ", maPhong=" + maPhong + ", soPhong=" + soPhong + ", giaPhong="
				+ giaPhong + ", tinhTrangPhong=" + tinhTrangPhong + ", soLuongNguoiO=" + soLuongNguoiO
				+ ", ngayDatPhong=" + ngayDatPhong + ", ngayHetHan=" + ngayHetHan + ", thanhToan=" + thanhToan + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, giaPhong, gioiTinh, CCCD, maPhong, ngayDatPhong, ngayHetHan, sdt,
				soLuongNguoiO, soPhong, tenKH, thanhToan, tinhTrangPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminModel other = (AdminModel) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(giaPhong, other.giaPhong) && Objects.equals(gioiTinh, other.gioiTinh)
				&& CCCD == other.CCCD && Objects.equals(maPhong, other.maPhong)
				&& Objects.equals(ngayDatPhong, other.ngayDatPhong) && Objects.equals(ngayHetHan, other.ngayHetHan)
				&& Objects.equals(sdt, other.sdt) && Objects.equals(soLuongNguoiO, other.soLuongNguoiO)
				&& Objects.equals(soPhong, other.soPhong) && Objects.equals(tenKH, other.tenKH)
				&& Objects.equals(thanhToan, other.thanhToan) && Objects.equals(tinhTrangPhong, other.tinhTrangPhong);
	}

	
	

	
}
