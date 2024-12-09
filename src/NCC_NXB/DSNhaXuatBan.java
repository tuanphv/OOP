package NCC_NXB;

import Interface.IList;
import Validate.Validate;

import java.io.*;
import java.util.Scanner;

import Format.ANSI;

public class DSNhaXuatBan implements IList<NhaXuatBan> {
	private static NhaXuatBan[] dsNXB = new NhaXuatBan[0];
    Scanner sc = new Scanner(System.in);
    public DSNhaXuatBan() {
    }

    public DSNhaXuatBan(NhaXuatBan[] ds) {
        dsNXB = ds;
    }

	@Override
	public void ghiFile() {
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/NXB.txt"));
            for (NhaXuatBan nxb : dsNXB) {
                writer.write(nxb.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        } finally {
            System.out.println("Ghi file thanh cong.");
        }
	}

	@Override
	public int indexOf(String s) {
		for (int i = 0; i < dsNXB.length; i++) {
            if (dsNXB[i].getMaNXB().equals(s)) {
                return i;
            }
        }
        return -1;
	}

	@Override
	public NhaXuatBan get(String s) {
		for (NhaXuatBan nxb : dsNXB) {
            if (nxb.getMaNXB().equals(s)) {
                return nxb;
            }
        }
		return null;
	}

	@Override
	public boolean isEmpty() {
		return dsNXB == null || dsNXB.length == 0;
	}

	@Override
	public void docFile() {
		try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/NXB.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                NhaXuatBan nxb = new NhaXuatBan(data[0], data[1], data[2], data[3], data[4], data[5]);
                add(nxb);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e);
        } finally {
            System.out.println("Doc file thanh cong.");
        }
	}

	@Override
	public void remove(String s) {
		int index = indexOf(s);
        if (index != -1) {
            int len = size();
            System.arraycopy(dsNXB, index + 1, dsNXB, index, len - 1 - index);
            dsNXB = java.util.Arrays.copyOf(dsNXB, len - 1);
            System.out.println("Xoa thanh cong.");
        }
        else 
            System.out.println("Khong tim thay ma nha xuat ban.");
	}

	@Override
	public boolean add(NhaXuatBan o) {
        int index = indexOf(o.getMaNXB());
        if (index == -1) {
            dsNXB = java.util.Arrays.copyOf(dsNXB, dsNXB.length + 1);
            dsNXB[dsNXB.length - 1] = o;
            return true;
        }
        return false;
	}

    public void them() {
        NhaXuatBan nxb = new NhaXuatBan();
        nxb.nhap(sc);
        while (add(nxb) == false) {
            System.out.println("Ma nha xuat ban da ton tai. Nhap lai.");
            nxb.nhap(sc);
        }
    }
    public void edit(String ma) {
        int index = indexOf(ma);
        if (index != -1) {
            dsNXB[index].nhap(sc);
            System.out.println("Sua thanh cong.");
        } else {
            System.out.println("Khong tim thay ma nha xuat ban.");
        }
    }

    public void nhap() {
        System.out.println("Nhap so nha xuat ban: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.nhap(sc);
            add(nxb);
        }
    }

    public void xuat() {
        String[] header = { "Ma NXB", "Ten NXB", "Nam thanh lap", "Quoc gia", "Dia chi", "Email" };
        String[][] data = new String[size()][];
        for (int i = 0; i < size(); i++) {
            data[i] = dsNXB[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

    public void xuatKQ(NhaXuatBan[] ds) {
        if (ds.length == 0) {
            System.out.println("Khong tim thay ket qua.");
            return;
        }
        String[] header = { "Ma NXB", "Ten NXB", "Nam thanh lap", "Quoc gia", "Dia chi", "Email" };
        String[][] data = new String[ds.length][];
        for (int i = 0; i < ds.length; i++) {
            data[i] = ds[i].toArray();
        }
        new ANSI(header, data).printTable();
    }

	@Override
	public int size() {
		return dsNXB.length;
	}

    public NhaXuatBan[] getList() {
        return dsNXB;
    }

    public NhaXuatBan[] timTheoTen(String ten) {
        NhaXuatBan[] result = new NhaXuatBan[0];
        for (NhaXuatBan nxb : dsNXB) {
            if (nxb.getTenNXB().contains(ten)) {
                result = java.util.Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = nxb;
            }
        }
        return result;
    }

    public NhaXuatBan[] timTheoQuocGia(String quocGia) {
        NhaXuatBan[] result = new NhaXuatBan[0];
        for (NhaXuatBan nxb : dsNXB) {
            if (nxb.getQuocGia().contains(quocGia)) {
                result = java.util.Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = nxb;
            }
        }
        return result;
    }

    public void menu(Scanner sc) {
        do {
            new ANSI(new String[] { "Menu nha xuat ban".toUpperCase() },
                    new String[][] {
                            { "1. Them nha xuat ban" },
                            { "2. Sua nha xuat ban" },
                            { "3. Xoa nha xuat ban" },
                            { "4. Hien thi danh sach nha xuat ban" },
                            { "5. Tim kiem theo ten" },
                            { "6. Tim kiem theo quoc gia" },
                            { "7. Thoat" }
                    }).printTable();
            int choice = Validate.getChoice(sc, 1, 7);
            switch (choice) {
                case 1:
                    them();
                    break;
                case 2:
                    System.out.print("Nhap ma nha xuat ban can sua: ");
                    String ma = sc.nextLine();
                    edit(ma);
                    break;
                case 3:
                    System.out.print("Nhap ma nha xuat ban can xoa: ");
                    String maXoa = sc.nextLine();
                    remove(maXoa);
                    break;
                case 4:
                    xuat();
                    break;
                case 5:
                    System.out.print("Nhap ten nha xuat ban can tim: ");
                    String ten = sc.nextLine();
                    xuatKQ(timTheoTen(ten));
                    break;
                case 6:
                    System.out.print("Nhap quoc gia nha xuat ban can tim: ");
                    String quocGia = sc.nextLine();
                    xuatKQ(timTheoQuocGia(quocGia));
                    break;
                default:
                    return;
            }
        } while (true);
    }
}
