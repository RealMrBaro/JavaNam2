// De2_VuQuangBao_725105023
package HetHocPhan;

public class PhanLoai {
    private int soLuong;
    private boolean loaiPhong;

    // Phương thức khởi tạo
    public PhanLoai(int soLuong, boolean loaiPhong) {
        this.soLuong = soLuong;
        this.loaiPhong = loaiPhong;
    }

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public boolean isLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(boolean loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	@Override
	public String toString() {
		return "PhanLoai [soLuong=" + soLuong + ", loaiPhong=" + loaiPhong + ", getSoLuong()=" + getSoLuong()
				+ ", isLoaiPhong()=" + isLoaiPhong() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}