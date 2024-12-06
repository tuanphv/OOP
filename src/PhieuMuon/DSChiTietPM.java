package PhieuMuon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import Validate.Ngay;

public class DSChiTietPM {

    private ChiTietPhieuMuon[] dsCTPM = new ChiTietPhieuMuon[0];

    public DSChiTietPM() {
    }

    public DSChiTietPM(DSChiTietPM dsctpm) {
        this.dsCTPM = dsctpm.dsCTPM;
    }
    // không có 2 mã sách giống nhau trong cùng 1 phiếu mượn
    public int indexOf(String maPM, String maSach) {
        for (int i = 0; i < dsCTPM.length; i++) {
            if (dsCTPM[i].getMaPM().equals(maPM)
                    && dsCTPM[i].getMaSach().equals(maSach)) {
                return i;
            }
        }
        return -1;
    }

    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/ChiTietPhieuMuon.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                dsCTPM = Arrays.copyOf(dsCTPM, dsCTPM.length + 1);
                dsCTPM[dsCTPM.length - 1] = ctpm;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e);
        } finally {
            if (dsCTPM.length == 0) {
                System.out.println("Khong co du lieu");
            } else {
                System.out.println("Doc file ChiTietPhieuMuon.txt thanh cong");
            }
        }
    }

    public void ghiFile() {
    }

    public void them(String maPM) {
        ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
        ctpm.nhap(maPM);
        int index = indexOf(maPM, ctpm.getMaSach());
        if (index == -1) {
            dsCTPM = Arrays.copyOf(dsCTPM, dsCTPM.length + 1);
            dsCTPM[dsCTPM.length - 1] = ctpm;
        }
        else {
            System.out.println("Ban da muon sach nay roi");
        }
    }

    public void xoa(String maPM, String maSach) {
        int index = indexOf(maPM, maSach);
        if (index == -1) {
            System.out.println("Khong tim thay sach nay trong phieu muon");
        } else {
            int n = dsCTPM.length;
            System.arraycopy(dsCTPM, index + 1, dsCTPM, index, n - index - 1);
            dsCTPM = Arrays.copyOf(dsCTPM, n - 1);
        }
    }

    public void traSach(String maPM, String maSach) {
        int index = indexOf(maPM, maSach);
        if (index == -1) {
            System.out.println("Khong tim thay sach nay trong phieu muon");
        } else {
            dsCTPM[index].traSach();
        }
    }

    public boolean isEmpty() {
        return dsCTPM.length == 0 || dsCTPM == null;
    }
}