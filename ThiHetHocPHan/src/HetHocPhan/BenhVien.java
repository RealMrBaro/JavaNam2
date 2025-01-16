package HetHocPhan;

import java.util.Scanner;

public class BenhVien {
    private String mabenhVien;
    private String tenbenhVien;

    public BenhVien(String mabenhVien, String tenBenhVien) {
        this.mabenhVien = (mabenhVien != null) ? mabenhVien : "";
        this.tenbenhVien = (tenBenhVien != null) ? tenBenhVien : "";
    }

    public void nhapThongTin(Scanner scanner) {
        System.out.print("Nhập mã bệnh viện: ");
        this.mabenhVien = scanner.nextLine();
        while (this.mabenhVien.isEmpty()){
            System.out.print("Mã bệnh viện không được để trống. Vui lòng nhập lại: ");
            this.mabenhVien = scanner.nextLine();
        }
        System.out.print("Nhập tên bệnh viện: ");
        this.tenbenhVien = scanner.nextLine();
    }

    public void xuatThongTin() {
        System.out.println("Mã bệnh viện: " + mabenhVien);
        System.out.println("Tên bệnh viện: " + tenbenhVien);
    }

    public String getMabenhVien() {
        return mabenhVien;
    }

    public void setMabenhVien(String mabenhVien) {
        this.mabenhVien = mabenhVien;
    }

    public String getTenbenhVien() {
        return tenbenhVien;
    }

    public void setTenbenhVien(String tenbenhVien) {
        this.tenbenhVien = tenbenhVien;
    }

    @Override
    public String toString() {
        return "Mã bệnh viện: " + mabenhVien + ", Tên bệnh viện: " + tenbenhVien;
    }
}