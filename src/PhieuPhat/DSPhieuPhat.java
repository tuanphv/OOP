package PhieuPhat;

import Format.ANSI;
import Interface.IList;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DSPhieuPhat implements IList<PhieuPhat> {
    private static PhieuPhat[] dsPP = new PhieuPhat[0];
    private Scanner input = new Scanner(System.in);

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
            dsPP[i].nhap(input);
            System.out.println("-------------------------");
        }
    }

    public void them() {
        PhieuPhat pp = new PhieuPhat();
        System.out.println("Nhap thong tin phieu phat muon them");
        pp.nhap(input);
        boolean result = add(pp);
        while (result == false) {
            System.out.println("Ma phieu phat da ton tai, vui long nhap lai");
            pp.nhap(input);
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
        } finally {
            System.out.println("Ghi file PhieuPhat.txt thanh cong.");
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
        } finally {
            System.out.println("Doc file PhieuPhat.txt thanh cong.");
        }
    }

    public boolean isEmpty() {
        return dsPP == null || dsPP.length == 0;
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
            System.out.println("Khong tim thay phieu phat can xoa");
        } else {
            DSChiTietPP dsChiTietPP = new DSChiTietPP();
            dsChiTietPP.remove(maPP);
            System.out.println("da xoa chi tiet phieu phat lien quan toi ma: " + maPP);

            for (int i = index; i < dsPP.length - 1; i++) {
                dsPP[i] = dsPP[i + 1];
            }
            dsPP = Arrays.copyOf(dsPP, dsPP.length - 1);
            System.out.println("da xoa phieu phat co ma: " + maPP);
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

    public void edit(String masua) {
        int vitri = indexOf(masua);
        if (vitri == -1) {
            System.out.println("Khong tim thay phieu phat can sua.");
        } else {
            System.out.println("Nhap ma phieu muon: ");
            String mapm = input.nextLine();
            dsPP[vitri].setMaPM(mapm);
            System.out.println("Nhap ma phieu phat: ");
            String mapp = input.nextLine();
            dsPP[vitri].setMaPP(mapp);
            System.out.println("Nhap ma doc gia: ");
            String madg = input.nextLine();
            dsPP[vitri].setMaDG(madg);
            System.out.println("Nhap ma nhan vien: ");
            String manv = input.nextLine();
            dsPP[vitri].setMaNV(manv);
            System.out.println("Nhap so tien phat: ");
            int sotienphat = input.nextInt();
            dsPP[vitri].setTongPhat(sotienphat);

        }
    }

    public Map<String, Integer> thongKeDocGiaBiPhat() {
        Map<String, Integer> thongKe = new HashMap<>();
        for (PhieuPhat pp : dsPP) {
            String maDocGia = pp.getMaDG();
            thongKe.put(maDocGia, thongKe.getOrDefault(maDocGia, 0) + 1);
        }
        return thongKe;
    }

    public Map<String, Integer> thongKeNhanVienLapPhieuPhat() {
        Map<String, Integer> thongKe = new HashMap<>();
        for (PhieuPhat pp : dsPP) {
            String maNV = pp.getMaNV();
            thongKe.put(maNV, thongKe.getOrDefault(maNV, 0) + 1);
        }
        return thongKe;
    }

    public double thongKeSoTienPhatTrungBinh() {
        int tienphattrungbinh = 0;
        for (PhieuPhat pp : dsPP) {
            tienphattrungbinh += pp.getTongPhat();
        }
        return (double) tienphattrungbinh / dsPP.length;
    }

    public int thongKeTongTienPhat() {
        int tongTienPhat = 0;
        for (PhieuPhat pp : dsPP) {
            tongTienPhat += pp.getTongPhat();
        }
        return tongTienPhat;
    }

    public void timkiemphieuphat() {
        System.out.println("moi ban nhap ma phieu phat ban can tim: ");
        String mapp = input.nextLine();
        for (PhieuPhat pp : dsPP) {
            if (mapp.equals(pp.getMaPP())) {
                pp.xuat();
            }
        }

    }
}
