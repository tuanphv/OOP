package PhieuPhat;

import Format.ANSI;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSChiTietPP {
    private static ChiTietPhieuPhat[] dsCTPP = new ChiTietPhieuPhat[0];
    private Scanner input = new Scanner(System.in);

    public DSChiTietPP() {}

    public DSChiTietPP(ChiTietPhieuPhat[] ds) {
        dsCTPP = ds;
    }

    public ChiTietPhieuPhat[] getList() {
        return dsCTPP;
    }

    // Nhập danh sách chi tiết phiếu phạt
    public void nhap(String maPP) {
        System.out.print("Nhập số lượng chi tiết phiếu phạt: ");
        int n = Integer.parseInt(input.nextLine());
        dsCTPP = new ChiTietPhieuPhat[n];
        for (int i = 0; i < n; i++) {
            dsCTPP[i] = new ChiTietPhieuPhat();
            dsCTPP[i].nhap(maPP);
            System.out.println("-------------------------");
        }
    }

    // Xuất danh sách chi tiết phiếu phạt
    public void xuat() {
        String[] header = { "Ma Phieu Phat", "Ma Sach", "Tien Phat" };
        String[][] data = new String[dsCTPP.length][];
        for (int i = 0; i < dsCTPP.length; i++) {
            data[i] = dsCTPP[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    // Ghi file danh sách chi tiết phiếu phạt
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/ChiTietPhieuPhat.txt"))) {
            for (ChiTietPhieuPhat ctp : dsCTPP) {
                bw.write(ctp.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e);
        }
    }

    // Đọc file danh sách chi tiết phiếu phạt
    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./lib/ChiTietPhieuPhat.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                ChiTietPhieuPhat ctp = new ChiTietPhieuPhat(data[0], data[1], Integer.parseInt(data[2]));
                add(ctp);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e);
        }
    }

    // Kiểm tra xem danh sách có rỗng không
    public boolean isEmpty() {
        return dsCTPP.length == 0;
    }

    // Lấy kích thước của danh sách
    public int size() {
        return dsCTPP.length;
    }

    // Lấy chi tiết phiếu phạt theo mã
    public ChiTietPhieuPhat get(String ma) {
        for (ChiTietPhieuPhat ctp : dsCTPP) {
            if (ctp.maPP().equals(ma)) {
                return ctp;
            }
        }
        return null;
    }

    // Thêm chi tiết phiếu phạt vào danh sách
    public boolean add(ChiTietPhieuPhat ctp) {
        int n = dsCTPP.length;
        if (indexOf(ctp.maPP()) == -1) {
            dsCTPP = Arrays.copyOf(dsCTPP, n + 1);
            dsCTPP[n] = ctp;
            return true;
        }
        return false;
    }

    // Tìm kiếm chi tiết phiếu phạt theo mã phiếu phạt
    public int indexOf(String maPP) {
        for (int i = 0; i < dsCTPP.length; i++) {
            if (dsCTPP[i].maPP().equals(maPP)) {
                return i;
            }
        }
        return -1;
    }

    // Xóa chi tiết phiếu phạt theo mã phiếu phạt
    public void remove(String maPP) {
        int index = indexOf(maPP);
        if (index == -1) {
            System.out.println("Không tìm thấy chi tiết phiếu phạt cần xóa");
        } else {
            for (int i = index; i < dsCTPP.length - 1; i++) {
                dsCTPP[i] = dsCTPP[i + 1];
            }
            dsCTPP = Arrays.copyOf(dsCTPP, dsCTPP.length - 1);
        }
    }

    // Tìm kiếm chi tiết phiếu phạt theo mã sách
    public ChiTietPhieuPhat[] timKiemMaSach(String maSach) {
        ChiTietPhieuPhat[] result = new ChiTietPhieuPhat[0];
        for (ChiTietPhieuPhat ctp : dsCTPP) {
            if (ctp.getMaSach().equals(maSach)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = ctp;
            }
        }
        return result;
    }
}
