package PhieuPhat;

import Interface.IList;
import PhieuMuon.ChiTietPhieuMuon;
import PhieuMuon.DSChiTietPM;
import Validate.Ngay;
import java.util.Arrays;

public class DSPhieuPhat implements IList<PhieuPhat> {
    PhieuPhat[] dsPP = new PhieuPhat[0];

    public DSPhieuPhat() {
    }
    
    public void taoDanhSachPhieuPhat(DSChiTietPM dsCTPM) {
        for (ChiTietPhieuMuon ctpm : dsCTPM.getList()) {
            if (soNgayQuaHan(ctpm.getNgayTra(), ctpm.getHanTra()) > 0) {
                PhieuPhat phieuPhat = new PhieuPhat();
                // Increase the size of dsPP and add the new element
                dsPP = Arrays.copyOf(dsPP, dsPP.length + 1);
                dsPP[dsPP.length - 1] = phieuPhat;
            }
        }
    }

    // Implementing IList methods
    @Override
    public void docFile() {
        // Implementation for reading from a file
    }

    @Override
    public void ghiFile() {
        // Implementation for writing to a file
    }

    @Override
    public boolean add(PhieuPhat obj) {
        dsPP = Arrays.copyOf(dsPP, dsPP.length + 1);
        dsPP[dsPP.length - 1] = obj;
        return true;
    }

    @Override
    public void remove(String ma) {
        // Implementation for removing an object by ID
    }

    @Override
    public int indexOf(String ma) {
        // Implementation for finding the index of an object by ID
        return -1; // Placeholder
    }

    @Override
    public PhieuPhat get(String ma) {
        // Implementation for getting an object by ID
        return null; // Placeholder
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
        dsPhieuPhat.taoDanhSachPhieuPhat(dsCTPM);

        // Hiển thị danh sách phiếu phạt
        System.out.println("Danh sách phiếu phạt:");
        dsPhieuPhat.displayPhieuPhat();

        // Kiểm tra số lượng phiếu phạt
        System.out.println("Số lượng phiếu phạt: " + dsPhieuPhat.size());
    }
}

}

