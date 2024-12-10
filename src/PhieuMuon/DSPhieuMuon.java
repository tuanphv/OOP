package PhieuMuon;

import Format.ANSI;
import Interface.IList;
import java.io.*;
import java.util.*;

public class DSPhieuMuon implements IList<PhieuMuon> {
    private static PhieuMuon[] dspm = new PhieuMuon[0];
    Scanner input = new Scanner(System.in);

    public DSPhieuMuon() {
    }

    public DSPhieuMuon(PhieuMuon[] ds) {
        dspm = ds;
    }

    public PhieuMuon[] getList() {
        return dspm;
    }

    public void nhap() {
        System.out.print("Nhap so luong phieu muon: ");
        int n = Integer.parseInt(input.nextLine());
        dspm = new PhieuMuon[n];
        for (int i = 0; i < n; i++) {
            dspm[i] = new PhieuMuon();
            dspm[i].nhap();
            System.out.println("-------------------------");
        }
    }

    public void xuat() {
        String[] header = { "Ma Phieu muon", "Ma Nhan vien", "Ma Doc gia", "Ngay muon" };
        String[][] data = new String[dspm.length][];
        for (int i = 0; i < dspm.length; i++) {
            data[i] = dspm[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    public void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/PhieuMuon.txt"));
            for (PhieuMuon pm : dspm) {
                bw.write(pm.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        }

    }

    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/PhieuMuon.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                PhieuMuon pm = new PhieuMuon(data[0], data[1], data[2], data[3]);
                add(pm);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e);
        } finally {
            if (dspm.length == 0) {
                System.out.println("Khong co du lieu");
            } else {
                System.out.println("Doc file PhieuMuon.txt thanh cong");
            }
        }
    }

    public boolean isEmpty() {
        return dspm.length == 0;
    }

    public int size() {
        return dspm.length;
    }

    public PhieuMuon get(String ma) {
        for (PhieuMuon pm : dspm) {
            if (pm.getMaPM().equals(ma)) {
                return pm;
            }
        }
        return null;
    }

    // #region Thêm
    public void them() {
        PhieuMuon pm = new PhieuMuon();
        System.out.println("Nhap thong tin phieu muon muon them");
        pm.nhap();
        boolean result = add(pm);
        while (result == false) {
            System.out.println("Ma phieu muon da ton tai, vui long nhap lai");
            pm.nhap();
            result = add(pm);
        }
        System.out.println("Them phieu muon thanh cong");
    }

    public boolean add(PhieuMuon pm) {
        int n = dspm.length;
        if (indexOf(pm.getMaPM()) == -1) {
            dspm = Arrays.copyOf(dspm, n + 1);
            dspm[n] = pm;
            return true;
        }
        return false;
    }

    // #endregion
    // #region Sửa
    public void edit(String masua) {
        int vitri = indexOf(masua);
        if (vitri == -1) {
            System.out.println("Khong tim thay mon hoc can sua: ");
        } else {
            System.out.print("Nhap ma doc gia: ");
            String madg = input.nextLine();
            dspm[vitri].setMaDG(madg);
            System.out.print("Nhap ngay xuat: ");
            String ngayxuat = input.nextLine();
            dspm[vitri].setNgayMuon(ngayxuat);
            System.out.print("Nhap ma nhan vien: ");
            String manv = input.nextLine();
            dspm[vitri].setMaNV(manv);

        }
    }
    
    

    // #endregion
    // #region Xoá
    public void remove(String maxoa) {
        int vitri = indexOf(maxoa);
        if (vitri == -1) {
            System.out.println("Khong tim thay ma phieu muon can xoa");
        } else {
            for (int i = vitri; i < dspm.length - 1; i++) {
                dspm[i] = dspm[i + 1];
            }
            dspm = Arrays.copyOf(dspm, dspm.length - 1);
        }
    }

    // #endregion
    // #region Tìm kiếm
    public void xuatKQ(PhieuMuon[] result) {
        if (result.length == 0) {
            System.out.println("Khong tim thay ket qua");
        } else {
            String[] header = { "Ma Phieu muon", "Ma Nhan vien", "Ma Doc gia", "Ngay muon" };
            String[][] data = new String[result.length][];
            for (int i = 0; i < result.length; i++) {
                data[i] = result[i].toArray();
            }
            new ANSI(header, data).printTable();
        }
    }

    public int indexOf(String maPhieuMuon) {
        for (int i = 0; i < dspm.length; i++) {
            if (dspm[i].getMaPM().equals(maPhieuMuon)) {
                return i;
            }
        }
        return -1;
    }

    public PhieuMuon timKiemMaPhieuMuon() {
        System.out.print("Nhap ma phieu muon can tim: ");
        String matim = input.nextLine();

        for (PhieuMuon phieu : dspm) {
            if (phieu.getMaPM().equals(matim)) {
                return phieu;
            }
        }

        System.out.println("Khong tim thay ma phieu muon can tim");
        return null;
    }

    public PhieuMuon[] timKiemMaDocGia(String matim) {
        PhieuMuon[] result = new PhieuMuon[0];

        for (PhieuMuon phieu : dspm) {
            if (phieu.getMaDG().equals(matim)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = phieu;
            }
        }
        return result;
    }

    public PhieuMuon[] timKiemMaNV() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String matim = input.nextLine();
        PhieuMuon[] result = new PhieuMuon[0];

        for (PhieuMuon phieu : dspm) {
            if (phieu.getMaNV().equals(matim)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = phieu;
            }
        }
        return result;
    }
   
  
}