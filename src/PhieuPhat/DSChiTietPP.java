package PhieuPhat;
import java.io.*;
import java.util.Arrays;

import Format.ANSI;
import Interface.IList;

public class DSChiTietPP implements IList<ChiTietPhieuPhat> {
    private static ChiTietPhieuPhat[] list = new ChiTietPhieuPhat[0];

    public DSChiTietPP() {}
    
    // Read data from ChiTietPhieuPhat.txt and store in array
    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/ChiTietPhieuPhat.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                add(new ChiTietPhieuPhat(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Write data to ChiTietPhieuPhat.txt
    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/ChiTietPhieuPhat.txt"))) {
            for (ChiTietPhieuPhat chiTiet : list) {
                if (chiTiet != null) {
                    writer.write(chiTiet.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void them(String maPP) {
        ChiTietPhieuPhat chiTiet = new ChiTietPhieuPhat();
        chiTiet.nhap(maPP);
        add(chiTiet);
    }

    // Add regulation to the array
    public boolean add(ChiTietPhieuPhat chiTiet) {
        int index = indexOf(chiTiet.getMaPP());
        if (index != -1) {
            return false;
        }
        list = Arrays.copyOf(list, list.length + 1);
        list[list.length - 1] = chiTiet;
        return true;
    }

    // Remove regulation from the array
    public void remove(String mapp) {
        int index = indexOf(mapp);
        if (index != -1) {
            System.arraycopy(list, index + 1, list, index, list.length - 1 - index);
            list = Arrays.copyOf(list, list.length - 1);
        }
    }

    // Get regulation by code
    public ChiTietPhieuPhat get(String mapp) {
        for (ChiTietPhieuPhat chiTiet : list) {
            if (chiTiet.getMaPP().equals(mapp)) {
                return chiTiet;
            }
        }
        return null; // Return null if not found
    }

    // Get position of regulation in the array
    public int indexOf(String mapp) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getMaPP().equals(mapp)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Check if array is empty
    public boolean isEmpty() {
        return list.length == 0 || list == null;
    }

    // Get length of array
    public int size() {
        return list.length;
    }

    public ChiTietPhieuPhat[] getChiTietCuaPhieu(String mapp) {
        ChiTietPhieuPhat[] result = new ChiTietPhieuPhat[0];
        for (ChiTietPhieuPhat chiTiet : list) {
            if (chiTiet.getMaPP().equals(mapp)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = chiTiet;
            }
        }
        return result;
    }

    public void xuatKQ(ChiTietPhieuPhat[] result) {
        String[] header = {"Ma phieu phat", "Ma sach", "Ma quy dinh", "Tien phat"};
        String[][] data = new String[result.length][];
        for (int i = 0; i < result.length; i++) {
            data[i] = result[i].toArray();
        }
        new ANSI(header, data).printTable();
    }
}