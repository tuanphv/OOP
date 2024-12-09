package PhieuPhat;

import Format.ANSI;
import Interface.IList;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSPhieuPhat implements IList<PhieuPhat> {
    private static PhieuPhat[] dsPP = new PhieuPhat[0];
    private Scanner input = new Scanner(System.in);

    public DSPhieuPhat() {}

    public DSPhieuPhat(PhieuPhat[] ds) {
        dsPP = ds;
    }

    public PhieuPhat[] getList() {
        return dsPP;
    }

    // Nhập danh sách phiếu phạt
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

    // Xuất danh sách phiếu phạt
    public void xuat() {
    String[] header = { "Ma Phieu Muon", "Ma Phieu Phat", "Ma Doc Gia", "Ma Nhan Vien", "Tong Phat" };
    String[][] data = new String[dsPP.length][];  // Tạo mảng 2D để chứa dữ liệu
    for (int i = 0; i < dsPP.length; i++) {
        data[i] = dsPP[i].toArray();  // Lấy mảng chuỗi từ mỗi đối tượng PhieuPhat
    }
    new ANSI(header, data).printTable();  // In bảng với tiêu đề và dữ liệu
}


    // Ghi file danh sách phiếu phạt
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

    // Đọc file danh sách phiếu phạt
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

    // Kiểm tra xem danh sách có rỗng không
    public boolean isEmpty() {
        return dsPP.length == 0;
    }

    // Lấy kích thước của danh sách
    public int size() {
        return dsPP.length;
    }

    // Lấy đối tượng phiếu phạt theo mã
    public PhieuPhat get(String ma) {
        for (PhieuPhat pp : dsPP) {
            if (pp.getMaPP().equals(ma)) {
                return pp;
            }
        }
        return null;
    }

    // Thêm phiếu phạt vào danh sách
    public boolean add(PhieuPhat pp) {
        int n = dsPP.length;
        if (indexOf(pp.getMaPP()) == -1) {
            dsPP = Arrays.copyOf(dsPP, n + 1);
            dsPP[n] = pp;
            return true;
        }
        return false;
    }

    // Tìm kiếm phiếu phạt theo mã
    public int indexOf(String maPP) {
        for (int i = 0; i < dsPP.length; i++) {
            if (dsPP[i].getMaPP().equals(maPP)) {
                return i;
            }
        }
        return -1;
    }

    // Xóa phiếu phạt theo mã
    public void remove(String maPP) {
    int index = indexOf(maPP);
    if (index == -1) {
        System.out.println("Không tìm thấy phiếu phạt cần xóa");
    } else {
        for (int i = index; i < dsPP.length - 1; i++) {
            dsPP[i] = dsPP[i + 1];
        }
        dsPP = Arrays.copyOf(dsPP, dsPP.length - 1);
        System.out.println("Đã xóa phiếu phạt có mã: " + maPP);
    }
    }


    // Tìm kiếm phiếu phạt theo mã độc giả
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

    // Tìm kiếm phiếu phạt theo mã nhân viên
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
}
