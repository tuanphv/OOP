package PhieuPhat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

import Format.ANSI;
import Sach.DSSach;
import Sach.Sach;

public class DSChiTietPP {
    private ChiTietPhieuPhat[] dsCTPP = new ChiTietPhieuPhat[0];

    public DSChiTietPP() {
        docFile();
    }

    public DSChiTietPP(DSChiTietPP dsctpp) {
        this.dsCTPP = dsctpp.dsCTPP;
    }

    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/ChiTietPhieuPhat.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat(data[0], data[1], Integer.parseInt(data[2]));
                dsCTPP = Arrays.copyOf(dsCTPP, dsCTPP.length + 1);
                dsCTPP[dsCTPP.length - 1] = ctpp;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e);
        } finally {
            if (dsCTPP.length == 0) {
                System.out.println("Khong co du lieu");
            } else {
                System.out.println("Doc file ChiTietPhieuPhat.txt thanh cong");
            }
        }
    }

    public void ghiFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/ChiTietPhieuPhat.txt"));
            for (ChiTietPhieuPhat ctpp : dsCTPP) {
                writer.write(ctpp.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        }
    }

    public void them(String maPP) {
        ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
        ctpp.nhap(maPP);
        int index = indexOf(maPP, ctpp.getMaSach());
        if (index == -1) {
            dsCTPP = Arrays.copyOf(dsCTPP, dsCTPP.length + 1);
            dsCTPP[dsCTPP.length - 1] = ctpp;
        } else {
            System.out.println("Sach nay da co trong phieu phat");
        }
    }

    public int indexOf(String maPP, String maSach) {
        for (int i = 0; i < dsCTPP.length; i++) {
            if (dsCTPP[i].maPP().equals(maPP) && dsCTPP[i].getMaSach().equals(maSach)) {
                return i;
            }
        }
        return -1;
    }

    public void xoa(String maPP, String maSach) {
        int index = indexOf(maPP, maSach);
        if (index == -1) {
            System.out.println("Khong tim thay chi tiet phieu phat");
        } else {
            int n = dsCTPP.length;
            System.arraycopy(dsCTPP, index + 1, dsCTPP, index, n - index - 1);
            dsCTPP = Arrays.copyOf(dsCTPP, n - 1);
        }
    }

    public boolean isEmpty() {
        return dsCTPP.length == 0 || dsCTPP == null;
    }

    public ChiTietPhieuPhat[] getList() {
        return dsCTPP;
    }

    public void xuat() {
        if (isEmpty()) {
            System.out.println("Khong co du lieu");
        } else {
            String[] header = { "Ma phieu phat", "Ma sach", "Tien phat" };
            String[][] data = new String[dsCTPP.length][3];
            for (int i = 0; i < dsCTPP.length; i++) {
                data[i] = dsCTPP[i].toArray();
            }
            new ANSI("Danh sach chi tiet phieu phat", header, data).printTable();
            ANSI.pause();
        }
    }

    public Sach[] getDSSach(String maPP) {
        Sach[] result = new Sach[0];
        DSSach dsSach = new DSSach();
        for (ChiTietPhieuPhat ctpp : dsCTPP) {
            if (ctpp.maPP().equals(maPP)) {
                Sach sach = dsSach.get(ctpp.getMaSach());
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = sach;
            }
        }
        return result;
    }
}
