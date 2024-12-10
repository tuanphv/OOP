package PhieuPhat;

import Format.ANSI;
import Interface.IList;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DSChiTietPP implements IList<ChiTietPhieuPhat> {
    private static ChiTietPhieuPhat[] dsCTPP = new ChiTietPhieuPhat[0];
    private Scanner input = new Scanner(System.in);

    public DSChiTietPP() {}

    public DSChiTietPP(ChiTietPhieuPhat[] ds) {
        dsCTPP = ds;
    }

    public ChiTietPhieuPhat[] getList() {
        return dsCTPP;
    }

    public void nhap(String maPP) {
        System.out.print("Nhập số lượng chi tiết phiếu phạt: ");
        int n = Integer.parseInt(input.nextLine());
        dsCTPP = new ChiTietPhieuPhat[n];
        for (int i = 0; i < n; i++) {
            dsCTPP[i] = new ChiTietPhieuPhat();
            dsCTPP[i].nhap(maPP, input);
            System.out.println("-------------------------");
        }
    }

    public void xuat() {
        String[] header = { "Ma Phieu Phat", "Ma Sach", "Tien Phat" };
        String[][] data = new String[dsCTPP.length][];
        for (int i = 0; i < dsCTPP.length; i++) {
            data[i] = dsCTPP[i].toArray();
        }
        new ANSI(header, data).printTable();
        ANSI.pause();
    }

    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/ChiTietPhieuPhat.txt"))) {
            for (ChiTietPhieuPhat ctp : dsCTPP) {
                bw.write(ctp.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e);
        } finally {
            System.out.println("Ghi file ChiTietPhieuPhat.txt thanh cong.");
        }
    }

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
        } finally {
            System.out.println("Doc file ChiTietPhieuPhat.txt thanh cong.");
        }
    }

    public boolean isEmpty() {
        return dsCTPP.length == 0;
    }

    public int size() {
        return dsCTPP.length;
    }

    public ChiTietPhieuPhat get(String ma) {
        for (ChiTietPhieuPhat ctp : dsCTPP) {
            if (ctp.getMaPP().equals(ma)) {
                return ctp;
            }
        }
        return null;
    }

    public boolean add(ChiTietPhieuPhat ctp) {
        int n = dsCTPP.length;
        if (indexOf(ctp.getMaPP(), ctp.getMaSach()) == -1) {
            dsCTPP = Arrays.copyOf(dsCTPP, n + 1);
            dsCTPP[n] = ctp;
            return true;
        }
        return false;
    }

    public int indexOf(String maPP) {
        for (int i = 0; i < dsCTPP.length; i++) {
            if (dsCTPP[i].getMaPP().equals(maPP)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(String maPP, String maSach) {
        for (int i = 0; i < dsCTPP.length; i++) {
            if (dsCTPP[i].getMaPP().equals(maPP) && dsCTPP[i].getMaSach().equals(maSach)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(String maPP, String maSach) {
        int index = indexOf(maPP, maSach);
        if (index == -1) {
            System.out.println("Khong tim thay chi tiet phieu phat can xoa");
        } else {
            for (int i = index; i < dsCTPP.length - 1; i++) {
                dsCTPP[i] = dsCTPP[i + 1];
            }
            dsCTPP = Arrays.copyOf(dsCTPP, dsCTPP.length - 1);
        }
    }

    public void remove(String maPP) {
        do {
            int index = indexOf(maPP);
            if (index == -1) {
                System.out.println("Khong tim thay phieu phat can xoa");
                break;
            }
            for (int i = index; i < dsCTPP.length - 1; i++) {
                dsCTPP[i] = dsCTPP[i + 1];
            }
            dsCTPP = Arrays.copyOf(dsCTPP, dsCTPP.length - 1);
        } while (true);
    }
    
    public Map<String, Integer> thongkesachbiphat() {
        Map<String, Integer> thongke = new HashMap<>();
        for (ChiTietPhieuPhat ctpp : dsCTPP) {
            String maSach = ctpp.getMaSach();
            thongke.put(maSach, thongke.getOrDefault(maSach, 0) + 1);
        }
        return thongke;
    }
    
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

    public ChiTietPhieuPhat[] timKiemMaPP(String maPP) {
        ChiTietPhieuPhat[] result = new ChiTietPhieuPhat[0];
        for (ChiTietPhieuPhat ctp : dsCTPP) {
            if (ctp.getMaPP().equals(maPP)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = ctp;
            }
        }
        return result;
    }

    public void xuatKQ(ChiTietPhieuPhat[] ds) {
        if (ds.length == 0) {
            System.out.println("Khong tim thay ket qua.");
            return;
        }
        String[] header = { "Ma Phieu Phat", "Ma Sach", "Tien Phat" };
        String[][] data = new String[ds.length][];
        for (int i = 0; i < ds.length; i++) {
            data[i] = ds[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    public void them(String maPP) {
        ChiTietPhieuPhat ctp = new ChiTietPhieuPhat();
        ctp.nhap(maPP, input);
        if (add(ctp)) {
            System.out.println("Thêm chi tiết phiếu phạt thành công.");
        } else {
            System.out.println("Chi tiết phiếu phạt đã tồn tại.");
        }
    }

    public void edit(String maPP, String maSach) {
        int index = indexOf(maPP, maSach);
        if (index != -1) {
            dsCTPP[index].nhap(maPP, input);
            System.out.println("Sửa thành công.");
        } else {
            System.out.println("Không tìm thấy mã chi tiết phiếu phạt.");
        }
    }
}
