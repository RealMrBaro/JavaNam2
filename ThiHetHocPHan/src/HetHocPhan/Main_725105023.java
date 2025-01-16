package HetHocPhan;

import java.io.*;
import java.util.*;

public class Main_725105023 {

    public static void main(String[] args) {
        List<PhongKham> danhSachPhongKham = new ArrayList<>();
        Scanner scanner = new Scanner(System.in); // Khởi tạo Scanner một lần

        nhapDanhSachPhongKham(danhSachPhongKham, scanner); // Truyền Scanner vào
        luuThongTinVaoFile(danhSachPhongKham);
        docThongTinTuFile(danhSachPhongKham); // Truyền danh sách vào hàm đọc
        hienThiPhongKhamKhongTuNguyen(danhSachPhongKham);
        sapXepTheoGia(danhSachPhongKham);

        scanner.close(); // Đóng Scanner khi kết thúc
    }

    public static void nhapDanhSachPhongKham(List<PhongKham> danhSachPhongKham, Scanner scanner) {
        System.out.print("Nhập số lượng phòng khám: ");
        int soLuong = 0;
        try{
            soLuong = scanner.nextInt();
            if(soLuong < 0){
                System.out.println("Số lượng phải lớn hơn 0");
                return;
            }
        }catch(InputMismatchException e){
            System.out.println("Số lượng phải là số");
            return;
        }

        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin cho phòng khám thứ " + (i + 1) + ":");
            PhongKham phongKham = new PhongKham("", "", "", 0, new PhanLoai(0, false));
            phongKham.nhapThongTin(scanner);
            danhSachPhongKham.add(phongKham);
        }
    }

    public static void luuThongTinVaoFile(List<PhongKham> danhSachPhongKham) {
        try (FileWriter writer = new FileWriter("phongkham.txt")) {
            for (PhongKham phongKham : danhSachPhongKham) {
                writer.write(phongKham.toString() + "\n");
            }
            System.out.println("Dữ liệu đã được lưu vào file phongkham.txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void docThongTinTuFile(List<PhongKham> danhSachPhongKham) {
        try (Scanner scanner = new Scanner(new File("phongkham.txt"))) { // try-with-resources
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file phongkham.txt");
        }
    }

    public static void hienThiPhongKhamKhongTuNguyen(List<PhongKham> danhSachPhongKham) {
        System.out.println("\nThông tin các phòng khám không tự nguyện:");
        for (PhongKham phongKham : danhSachPhongKham) {
            if (!phongKham.getPhanLoai().isLoaiPhong()) {
                System.out.println("Tên phòng khám: " + phongKham.getTenPhongKham());
                System.out.println("Giá: " + phongKham.getGia());
                System.out.println("------------------------------");
            }
        }
    }

    public static void sapXepTheoGia(List<PhongKham> danhSachPhongKham) {
        Collections.sort(danhSachPhongKham, Comparator.comparingDouble(PhongKham::getGia));

        System.out.println("\nDanh sách sau khi sắp xếp theo giá (tăng dần):");
        for (PhongKham phongKham : danhSachPhongKham) {
            System.out.println("Tên phòng khám: " + phongKham.getTenPhongKham());
            System.out.println("Giá: " + phongKham.getGia());
            System.out.println("------------------------------");
        }
    }
}