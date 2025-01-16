package HetHocPhan; 

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GiaooDienPhongKham extends JFrame {

    private JTextField txtTenPhongKham;
    private JTextField txtSoLuong;
    private JTextField txtTenBenhVien;
    private JRadioButton rdbtnPhongTuNguyen;
    private JRadioButton rdbtnPhongKhongTuNguyen;
    private List<PhongKham> danhSachPhongKham;

    public GiaooDienPhongKham() {
        super("Quản Lý Phòng Khám");
        danhSachPhongKham = new ArrayList<>();
        initComponents();
        createLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        txtTenPhongKham = new JTextField(15);
        txtSoLuong = new JTextField(5);
        txtTenBenhVien = new JTextField(15);
        rdbtnPhongTuNguyen = new JRadioButton("Tự nguyện");
        rdbtnPhongKhongTuNguyen = new JRadioButton("Không tự nguyện");

        ButtonGroup groupLoaiPhong = new ButtonGroup();
        groupLoaiPhong.add(rdbtnPhongTuNguyen);
        groupLoaiPhong.add(rdbtnPhongKhongTuNguyen);
    }

    private void createLayout() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Tên phòng khám:"));
        panel.add(txtTenPhongKham);
        panel.add(new JLabel("Tên bệnh viện:"));
        panel.add(txtTenBenhVien);
        panel.add(new JLabel("Số lượng:"));
        panel.add(txtSoLuong);
        panel.add(new JLabel("Loại phòng:"));
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(rdbtnPhongTuNguyen);
        radioPanel.add(rdbtnPhongKhongTuNguyen);
        panel.add(radioPanel);

        JButton btnThemPhongKham = new JButton("Thêm phòng khám");
        btnThemPhongKham.addActionListener(e -> themPhongKham());
        panel.add(btnThemPhongKham);

        JButton btnClear = new JButton("Xóa");
        btnClear.addActionListener(e -> clearFields());
        panel.add(btnClear);

        JButton btnLuu = new JButton("Lưu dữ liệu");
        btnLuu.addActionListener(e -> luuDulieu());
        panel.add(btnLuu);

        add(panel);
    }

    private void themPhongKham() {
        String tenPhongKham = txtTenPhongKham.getText();
        String tenBenhVien = txtTenBenhVien.getText();
        int soLuong = 0;
        boolean loaiPhong = rdbtnPhongTuNguyen.isSelected();

        if (tenPhongKham.isEmpty() || tenBenhVien.isEmpty() || txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        try {
            soLuong = Integer.parseInt(txtSoLuong.getText());
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số!");
            return;
        }

        PhongKham phongKham = new PhongKham("", tenBenhVien, tenPhongKham, soLuong, new PhanLoai(soLuong, loaiPhong));
        danhSachPhongKham.add(phongKham);

        String thongBao = "Đã thêm phòng khám:\n" +
                "Tên phòng khám: " + tenPhongKham + "\n" +
                "Loại phòng khám: " + (loaiPhong ? "Tự nguyện" : "Không tự nguyện") + "\n" +
                "Số lượng: " + soLuong + "\n" +
                "Tên bệnh viện: " + tenBenhVien;
        JOptionPane.showMessageDialog(this, thongBao);
    }

    private void luuDulieu() {
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu dữ liệu vào file phongkham.csv?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try (FileWriter writer = new FileWriter("phongkham.csv")) {
                writer.write("Tên phòng khám,Số lượng,Loại phòng khám,Tên bệnh viện\n");
                for (PhongKham phongKham : danhSachPhongKham) {
                    writer.write(phongKham.getTenPhongKham() + "," + phongKham.getSoLuong() + "," + (phongKham.getPhanLoai().isLoaiPhong() ? "Tự nguyện" : "Không tự nguyện") + "," + phongKham.getTenBenhVien() + "\n");
                }
                JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào file phongkham.csv thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi ghi file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void clearFields() {
        txtTenPhongKham.setText("");
        txtSoLuong.setText("");
        txtTenBenhVien.setText("");
        rdbtnPhongTuNguyen.setSelected(false);
        rdbtnPhongKhongTuNguyen.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GiaooDienPhongKham::new);
    }
}