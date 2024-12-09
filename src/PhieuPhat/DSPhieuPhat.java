package PhieuPhat;

import Format.ANSI;
import Interface.IList;
import PhieuMuon.ChiTietPhieuMuon;
import PhieuMuon.DSChiTietPM;
import Validate.Ngay;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSPhieuPhat implements IList<PhieuPhat> {
    private static PhieuPhat[] dsPP = new PhieuPhat[0];
    private Scanner input = new Scanner(System.in);
    private DSChiTietPP dsChiTietPP;
    private DSChiTietPM dsCTPM;

    public DSPhieuPhat(DSChiTietPM dsChiTietPM) {
        this.dsCTPM = dsChiTietPM;
    }

    public DSPhieuPhat() {
    }

    public DSPhieuPhat(DSChiTietPP dsChiTietPP) {
        this.dsChiTietPP = dsChiTietPP;
    }

    public DSPhieuPhat(DSChiTietPP dsChiTietPP, DSChiTietPM dsChiTietPM) {
        this.dsChiTietPP = dsChiTietPP;
        this.dsCTPM = dsChiTietPM;
    }

    public PhieuPhat[] getList() {
        return dsPP;
    }

    public void nhap() {
        System.out.print("Nhap so luong phieu phat: ");
        int n = Integer.parseInt(input.nextLine());
        dsPP = new PhieuPhat[n];
        for (int i = 0; i < n; i++) {
            dsPP[i] = new PhieuPhat();
            dsPP[i].nhap();
            System.out.println("-------------------------");
        }
    }

    public void them() {
        PhieuPhat pp = new PhieuPhat();
        System.out.println("Nhap thong tin phieu phat muon them");
        pp.nhap();
        boolean result = add(pp);
        while (result == false) {
            System.out.println("Ma phieu phat da ton tai, vui long nhap lai");
            pp.nhap();
            result = add(pp);
        }
        System.out.println("Them phieu phat thanh cong");
    }

    public void xuat() {
        String[] header = { "Ma Phieu Muon", "Ma Phieu Phat", "Ma Doc Gia", "Ma Nhan Vien", "Tong Phat" };
        String[][] data = new String[dsPP.length][];
        for (int i = 0; i < dsPP.length; i++) {
            data[i] = dsPP[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/PhieuPhat.txt"))) {
            for (PhieuPhat pp : dsPP) {
                bw.write(pp.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e);
        }
    }

    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./lib/PhieuPhat.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                PhieuPhat pp = new PhieuPhat(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                add(pp);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e);
        }
    }

    public boolean isEmpty() {
        return dsPP.length == 0;
    }

    public int size() {
        return dsPP.length;
    }

    public PhieuPhat get(String ma) {
        for (PhieuPhat pp : dsPP) {
            if (pp.getMaPP().equals(ma)) {
                return pp;
            }
        }
        return null;
    }

    public boolean add(PhieuPhat pp) {
        int n = dsPP.length;
        if (indexOf(pp.getMaPP()) == -1) {
            dsPP = Arrays.copyOf(dsPP, n + 1);
            dsPP[n] = pp;
            return true;
        }
        return false;
    }

    public int indexOf(String maPP) {
        for (int i = 0; i < dsPP.length; i++) {
            if (dsPP[i].getMaPP().equals(maPP)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(String maPP) {
        int index = indexOf(maPP);
        if (index == -1) {
            System.out.println("Không tìm thấy phiếu phạt cần xóa.");
        } else {
            // Xóa chi tiết phiếu phạt liên quan
            dsChiTietPP.remove(maPP);
            System.out.println("Đã xóa các chi tiết phiếu phạt liên quan tới mã: " + maPP);

            // Xóa phiếu phạt
            for (int i = index; i < dsPP.length - 1; i++) {
                dsPP[i] = dsPP[i + 1];
            }
            dsPP = Arrays.copyOf(dsPP, dsPP.length - 1);
            System.out.println("Đã xóa phiếu phạt có mã: " + maPP);
        }
    }

    public PhieuPhat[] timKiemMaDocGia(String maDG) {
        PhieuPhat[] result = new PhieuPhat[0];
        for (PhieuPhat pp : dsPP) {
            if (pp.getMaDG().equals(maDG)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = pp;
            }
        }
        return result;
    }

    public PhieuPhat[] timKiemMaNV(String maNV) {
        PhieuPhat[] result = new PhieuPhat[0];
        for (PhieuPhat pp : dsPP) {
            if (pp.getMaNV().equals(maNV)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = pp;
            }
        }
        return result;
    }

    public void tinhTienPhat() {
        if (dsCTPM == null) {
            System.out.println("Chưa có dữ liệu chi tiết phiếu mượn.");
            return;
        }

        ChiTietPhieuMuon[] dsChiTiet = dsCTPM.getList();
        if (dsChiTiet == null || dsChiTiet.length == 0) {
            System.out.println("Không có dữ liệu chi tiết phiếu mượn.");
            return;
        }

        int tienPhatMotNgay = 5000; // Số tiền phạt cho 1 ngày trễ hạn
        boolean coPhat = false;

        // Tiêu đề của bảng
        String[] header = { "Ma Phieu Muon", "Ma Sach", "So Ngay Tre", "Tien Phat" };

        // Tạo mảng tạm để lưu dữ liệu
        String[][] tempData = new String[dsChiTiet.length][];
        int count = 0; // Đếm số lượng phiếu phạt thực tế

        for (ChiTietPhieuMuon ctpm : dsCTPM.getList()) {
            String hanTraStr = ctpm.getHanTra();
            String ngayTraStr = ctpm.getNgayTra();

            if (ngayTraStr != null && hanTraStr != null) {
                Ngay hanTra = new Ngay(hanTraStr);
                Ngay ngayTra = new Ngay(ngayTraStr);

                // So sánh ngày
                if (ngayTra.compare(hanTra) > 0) {
                    // Tính số ngày trễ và tiền phạt
                    java.time.LocalDate hanTraDate = java.time.LocalDate.of(hanTra.getYear(), hanTra.getMonth(),
                            hanTra.getDate());
                    java.time.LocalDate ngayTraDate = java.time.LocalDate.of(ngayTra.getYear(), ngayTra.getMonth(),
                            ngayTra.getDate());
                    int soNgayTre = (int) java.time.temporal.ChronoUnit.DAYS.between(hanTraDate, ngayTraDate);

                    int tienPhat = soNgayTre * tienPhatMotNgay;

                    // Thêm thông tin vào mảng tạm
                    tempData[count] = new String[] { ctpm.getMaPM(), ctpm.getMaSach(), String.valueOf(soNgayTre),
                            String.valueOf(tienPhat) };
                    count++;
                    coPhat = true;
                }
            }
        }

        if (coPhat) {
            // Tạo mảng kết quả với kích thước chính xác
            String[][] data = Arrays.copyOf(tempData, count);
            // In bảng thông tin tiền phạt
            new ANSI(header, data).printTable();
        } else {
            System.out.println("Không có sách nào bị trễ hạn.");
        }
    }

}
