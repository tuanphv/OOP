package PhieuMuon;

import Format.ANSI;
import Sach.DSSach;
import Sach.Sach;
import Validate.Ngay;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/ChiTietPhieuMuon.txt"));
            for (ChiTietPhieuMuon ctpm : dsCTPM) {
                writer.write(ctpm.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        }
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

    public ChiTietPhieuMuon[] getList() {
        return dsCTPM;
    }

    public void xuat() {
        if (isEmpty()) {
            System.out.println("Khong co du lieu");
        } else {
            String[] header = { "Ma phieu muon", "Ma sach", "So luong", "Han phai tra", "Ngay khach tra" };
            String[][] data = new String[dsCTPM.length][5];
            for (int i = 0; i < dsCTPM.length; i++) {
                data[i] = dsCTPM[i].toArray();
            }
            new ANSI("Danh sach chi tiet phieu muon", header, data).printTable();
            ANSI.pause();
        }
    }

    public Sach[] getDSSach(String maPM) {
        Sach[] result = new Sach[0];
        DSSach dsSach = new DSSach();
        for (ChiTietPhieuMuon ctpm : dsCTPM) {
            if (ctpm.getMaPM().equals(maPM)) {
                Sach sach = dsSach.get(ctpm.getMaSach());
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = sach;
            }
        }
        return result;
    }

    public void thongKeSachTheoNgay(String ngayCanXem) {
        try {
            Ngay ngayXem = new Ngay(ngayCanXem);
            if (!ngayXem.isValidDate()) {
                System.out.println("Ngay khong hop le: " + ngayCanXem);
                return;
            }

            DSPhieuMuon dspm = new DSPhieuMuon();
            dspm.docFile();
            
            Map<String, Integer> thongKe = new HashMap<>();
            int tongSach = 0;
            
            for (ChiTietPhieuMuon ctpm : dsCTPM) {
                PhieuMuon pm = dspm.get(ctpm.getMaPM());
                if (pm != null) {
                    try {
                        Ngay ngayMuon = new Ngay(pm.getNgayMuon());
                        if (ngayMuon.compare(ngayXem) == 0) {
                            String maSach = ctpm.getMaSach();
                            thongKe.put(maSach, thongKe.getOrDefault(maSach, 0) + ctpm.getSoLuong());
                            tongSach += ctpm.getSoLuong();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ngay muon khong hop le trong phieu muon: " + pm.getMaPM());
                    }
                }
            }
            
            if (thongKe.isEmpty()) {
                System.out.println("Khong co sach duoc muon trong ngay " + ngayCanXem);
                return;
            }

            System.out.println("Thong ke sach muon trong ngay " + ngayCanXem + ":");
            String[] header = {"Ma sach", "So luong muon"};
            String[][] data = new String[thongKe.size()][2];
            int i = 0;
            for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
                data[i][0] = entry.getKey();
                data[i][1] = String.valueOf(entry.getValue());
                i++;
            }
            new ANSI("Thong ke sach muon theo ngay", header, data).printTable();
            System.out.println("Tong so sach da muon: " + tongSach);
        } catch (Exception e) {
            System.out.println("Loi khi thong ke sach: " + e.getMessage());
        }
    }

    public void thongKeSachTheoThang(int thang, int nam) {
        DSPhieuMuon dspm = new DSPhieuMuon();
        dspm.docFile();
        
        Map<String, Integer> thongKe = new HashMap<>();
        int tongSach = 0;
        
        for (ChiTietPhieuMuon ctpm : dsCTPM) {
            PhieuMuon pm = dspm.get(ctpm.getMaPM());
            if (pm != null) {
                Ngay ngayMuon = new Ngay(pm.getNgayMuon());
                if (ngayMuon.getMonth() == thang && ngayMuon.getYear() == nam) {
                    String maSach = ctpm.getMaSach();
                    thongKe.put(maSach, thongKe.getOrDefault(maSach, 0) + ctpm.getSoLuong());
                    tongSach += ctpm.getSoLuong();
                }
            }
        }
        
        if (thongKe.isEmpty()) {
            System.out.println("Khong co sach duoc muon trong thang " + thang + "/" + nam);
            return;
        }

        System.out.println("Thong ke sach muon trong thang " + thang + "/" + nam + ":");
        String[] header = {"Ma sach", "So luong muon"};
        String[][] data = new String[thongKe.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            data[i][0] = entry.getKey();
            data[i][1] = String.valueOf(entry.getValue());
            i++;
        }
        new ANSI("Thong ke sach muon theo thang", header, data).printTable();
        System.out.println("Tong so sach da muon: " + tongSach);
    }

    public void thongKeSachTheoQuy(int quy, int nam) {
        if (quy < 1 || quy > 4) {
            System.out.println("Quy khong hop le. Vui long nhap tu 1-4");
            return;
        }
        
        DSPhieuMuon dspm = new DSPhieuMuon();
        dspm.docFile();
        
        Map<String, Integer> thongKe = new HashMap<>();
        int tongSach = 0;
        
        for (ChiTietPhieuMuon ctpm : dsCTPM) {
            PhieuMuon pm = dspm.get(ctpm.getMaPM());
            if (pm != null) {
                Ngay ngayMuon = new Ngay(pm.getNgayMuon());
                if (ngayMuon.getQuy() == quy && ngayMuon.getYear() == nam) {
                    String maSach = ctpm.getMaSach();
                    thongKe.put(maSach, thongKe.getOrDefault(maSach, 0) + ctpm.getSoLuong());
                    tongSach += ctpm.getSoLuong();
                }
            }
        }
        
        if (thongKe.isEmpty()) {
            System.out.println("Khong co sach duoc muon trong quy " + quy + "/" + nam);
            return;
        }

        System.out.println("Thong ke sach muon trong quy " + quy + "/" + nam + ":");
        String[] header = {"Ma sach", "So luong muon"};
        String[][] data = new String[thongKe.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            data[i][0] = entry.getKey();
            data[i][1] = String.valueOf(entry.getValue());
            i++;
        }
        new ANSI("Thong ke sach muon theo quy", header, data).printTable();
        System.out.println("Tong so sach da muon: " + tongSach);
    }

    public void thongKeSachTheoNam(int nam) {
        DSPhieuMuon dspm = new DSPhieuMuon();
        dspm.docFile();
        
        Map<String, Integer> thongKe = new HashMap<>();
        int tongSach = 0;
        
        for (ChiTietPhieuMuon ctpm : dsCTPM) {
            PhieuMuon pm = dspm.get(ctpm.getMaPM());
            if (pm != null) {
                Ngay ngayMuon = new Ngay(pm.getNgayMuon());
                if (ngayMuon.getYear() == nam) {
                    String maSach = ctpm.getMaSach();
                    thongKe.put(maSach, thongKe.getOrDefault(maSach, 0) + ctpm.getSoLuong());
                    tongSach += ctpm.getSoLuong();
                }
            }
        }
        
        if (thongKe.isEmpty()) {
            System.out.println("Khong co sach duoc muon trong nam " + nam);
            return;
        }

        System.out.println("Thong ke sach muon trong nam " + nam + ":");
        String[] header = {"Ma sach", "So luong muon"};
        String[][] data = new String[thongKe.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            data[i][0] = entry.getKey();
            data[i][1] = String.valueOf(entry.getValue());
            i++;
        }
        new ANSI("Thong ke sach muon theo nam", header, data).printTable();
        System.out.println("Tong so sach da muon: " + tongSach);
    }
}
