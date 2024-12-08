package PhieuPhat;

import Format.ANSI;
import Interface.IList;
import PhieuMuon.ChiTietPhieuMuon;
import PhieuMuon.DSChiTietPM;
import Validate.Ngay;
import java.util.Arrays;
import java.util.Scanner;

public class DSPhieuPhat implements IList<PhieuPhat> {
    private static PhieuPhat[] dsPP = new PhieuPhat[0];
    Scanner input = new Scanner(System.in);

   public DSPhieuPhat() {
   }
    
    public DSPhieuPhat(PhieuPhat[] ds) {
        dsPP = ds;
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
    public void xuat() {
    String[] header = { "Ma Phieu Muon", "Ma Phieu Phat", "Ma Doc Gia", "Ma Nhan Vien", "Tong Phat" };
    String[][] data = new String[dsPP.length][];
    
    for (int i = 0; i < dsPP.length; i++) {
        data[i] = dsPP[i].toArray();
    }
    
    new ANSI(header, data).printTable();
}


    public void tinhTienPhat(DSChiTietPM dsCTPM) {
    int donGiaPhat = 5000; 

    for (ChiTietPhieuMuon ctpm : dsCTPM.getList()) {
        int soNgayTre = soNgayQuaHan(ctpm.getNgayTra(), ctpm.getHanTra());

        if (soNgayTre > 0) {
            int tienPhat = soNgayTre * donGiaPhat;
            
        } else {
            System.out.println("Số ngày quá hạn là 0");
        }
    }
}


    // Implementing IList methods
    @Override
    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./lib/PhieuPhat.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                PhieuPhat phieuPhat = new PhieuPhat(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                add(phieuPhat);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }

    @Override
    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/PhieuPhat.txt"))) {
            for (PhieuPhat phieuPhat : dsPP) {
                writer.write(phieuPhat.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error writing file: " + e);
        }
    }

    @Override
    public void remove(String ma) {
        int index = indexOf(ma);
        if (index != -1) {
            PhieuPhat[] newDsPP = new PhieuPhat[dsPP.length - 1];
            for (int i = 0, j = 0; i < dsPP.length; i++) {
                if (i != index) {
                    newDsPP[j++] = dsPP[i];
                }
            }
            dsPP = newDsPP;
        }
    }

    @Override
    public int indexOf(String ma) {
        for (int i = 0; i < dsPP.length; i++) {
            if (dsPP[i].getMaPP().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public PhieuPhat get(String ma) {
        int index = indexOf(ma);
        return index != -1 ? dsPP[index] : null;
    }

    @Override
    public boolean isEmpty() {
        return dsPP.length == 0;
    }

    @Override
    public int size() {
        return dsPP.length;
    }

    // Method to calculate overdue days
    public int soNgayQuaHan(String ngayTra, String hanTra) {
        Ngay ngayTraObj = new Ngay(ngayTra);
        Ngay hanTraObj = new Ngay(hanTra);
        return ngayTraObj.soNgayTreHan(hanTraObj);
    }

    // New methods added
    public PhieuPhat[] getDanhSachPhieuPhat() {
        return dsPP;
    }

    public void displayPhieuPhat() {
        for (PhieuPhat phieuPhat : dsPP) {
            System.out.println(phieuPhat);
        }
    }
    public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng DSChiTietPM và thêm dữ liệu mẫu (có thể đọc từ file hoặc nhập từ người dùng)
        DSChiTietPM dsCTPM = new DSChiTietPM();
        // Giả sử đã có dữ liệu trong dsCTPM từ file hoặc nhập vào

        // Tạo đối tượng DSPhieuPhat và gọi phương thức tạo danh sách phiếu phạt
        DSPhieuPhat dsPhieuPhat = new DSPhieuPhat();
        //dsPhieuPhat.taoDanhSachPhieuPhat(dsCTPM);

        // Hiển thị danh sách phiếu phạt
        System.out.println("Danh sách phiếu phạt:");
        dsPhieuPhat.displayPhieuPhat();

        // Kiểm tra số lượng phiếu phạt
        System.out.println("Số lượng phiếu phạt: " + dsPhieuPhat.size());
    }
}

}

