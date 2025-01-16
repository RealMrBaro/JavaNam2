package HetHocPhan;

import java.util.Scanner;

public class PhongKham extends BenhVien {
    private String tenPhongKham;
    private double gia;
    private PhanLoai phanLoaiPhongKham;

    public PhongKham(String maBenhVien, String tenBenhVien, String tenPhongKham, double gia, PhanLoai phanLoaiPhongKham) {
        super(maBenhVien, tenBenhVien);
        this.tenPhongKham = tenPhongKham;
        this.gia = gia;
        this.phanLoaiPhongKham = (phanLoaiPhongKham != null) ? phanLoaiPhongKham : new PhanLoai(0, false);
    }

    public void nhapThongTin(Scanner scanner) {
        super.nhapThongTin(scanner);
        System.out.print("Nhập tên phòng khám: ");
        this.tenPhongKham = scanner.nextLine();
        while (this.tenPhongKham.isEmpty()){
            System.out.print("Tên phòng khám không được để trống. Vui lòng nhập lại: ");
            this.tenPhongKham = scanner.nextLine();
        }
        System.out.print("Nhập giá: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Giá phải là một số. Vui lòng nhập lại:");
            scanner.next(); // Đọc bỏ input không hợp lệ
        }
        this.gia = scanner.nextDouble();
        while (this.gia < 0){
            System.out.println("Giá phải lớn hơn 0. Vui lòng nhập lại:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Giá phải là một số. Vui lòng nhập lại:");
                scanner.next(); // Đọc bỏ input không hợp lệ
            }
            this.gia = scanner.nextDouble();
        }
        scanner.nextLine(); // Đọc dòng new line còn sót lại
    }

    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Tên phòng khám: " + tenPhongKham);
        System.out.println("Giá: " + gia);
        System.out.println("Phân loại phòng khám: " + phanLoaiPhongKham);
    }

    public double getGia() {
        return gia;
    }

    public PhanLoai getPhanLoai() {
        return phanLoaiPhongKham;
    }
        public String getTenPhongKham(){
        return tenPhongKham;
    }
    public void setTenbenhVien(String tenBenhVien){
        super.setTenbenhVien(tenBenhVien);
    }
    public String getTenBenhVien(){
        return super.getTenbenhVien();
    }
    public int getSoLuong(){
        return phanLoaiPhongKham.getSoLuong();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tên phòng khám: " + tenPhongKham + "\n" +
                "Giá: " + gia + "\n" +
                "Phân loại phòng khám: " + phanLoaiPhongKham;
    }
}