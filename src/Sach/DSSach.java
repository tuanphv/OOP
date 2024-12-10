package Sach;
import Format.ANSI;
import Interface.IList;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DSSach implements IList<Sach> {
    Scanner in = new Scanner(System.in);
    // thuộc tính static để có thể gọi từ bất kỳ đâu
    // do static nên chỉ có 1 bản sao trong bộ nhớ => không làm constructor copy
    private static Sach[] list = new Sach[0];

    public DSSach() {
    }

    public DSSach(Sach[] l1) {
        list = l1;
    }
    public int indexOf(String maSach) {
        int n = list.length;
        for (int i = 0; i < n; i++) {
            if (list[i].getMaSach().toLowerCase().equals(maSach.toLowerCase()))
                return i;
        }
        return -1;
    }

    public Sach[] getList() {
        return list;
    }
    //#region Đọc ghi file
    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/Sach.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // tách dữ liệu từ dạng chuỗi sang mảng
                String[] s = line.split(", ");
                switch (s[0]) {
                    // tạo đối tượng sách theo loại
                    // 0 là sách giải trí, 1 là sách học thuật
                    case "0":
                        SachGiaiTri sgt = new SachGiaiTri(s[1], s[2], s[3], s[4], Integer.parseInt(s[5]),
                                Integer.parseInt(s[6]), Integer.parseInt(s[7]), Integer.parseInt(s[8]));
                        add(sgt);
                        break;
                    case "1":
                        SachHocThuat sht = new SachHocThuat(s[1], s[2], s[3], s[4], Integer.parseInt(s[5]),
                                Integer.parseInt(s[6]), Integer.parseInt(s[7]), s[8], s[9]);
                        add(sht);
                        break;
                    default:
                        System.out.println("Loi doc file");
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Loi doc file " + e.getMessage());
        } finally {
            System.out.println("Doc file Sach.txt thanh cong");
        }
    }

    public void ghiFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/Sach.txt"));
            for (Sach s : list) {
                writer.write(s.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file " + e.getMessage());
        } finally {
            System.out.println("Ghi file thanh cong");
        }
    }
    //#endregion
    //#region Nhập xuất
    public void nhap() {
        System.out.println("Nhap n:");
        int n = Integer.parseInt(in.nextLine());
        list = new Sach[n];
        for (int i = 0; i < n; i++) {
            int chon;
            Sach s = new Sach();
            do {
                System.out.println("Chon loai sach: 1. Sach hoc thuat, 2. Sach giai tri");
                chon = Integer.parseInt(in.nextLine());
                if (chon != 1 && chon != 2)
                    System.out.println("Chon sai! Vui long chon lai");
            } while (chon != 1 && chon != 2);
            switch (chon) {
                case 1:
                    s = new SachHocThuat();
                    break;
                case 2:
                    s = new SachGiaiTri();
                    break;
            }
            s.nhap();
            while (indexOf(s.getMaSach()) != -1) {
                System.out.println("Da co sach. Vui long nhap lai!");
                s.nhap();
            }
            list[i] = s;
        }
    }

    public void xuat() {
        if (isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("Danh sach sach (" + list.length + " sach)");
        String[] head = {"Ma sach", "Ten sach", "Ma NXB", "Ma TG", "Nam XB",
                "Don gia", "So luong", "Trinh do(Do tuoi)", "Linh vuc"};
        String[][] data = new String[list.length][];
        int i = 0;
        for (Sach x : list) {
            data[i] = x.toArray();
            i++;
        }
        new ANSI(head, data).printTable();
        ANSI.pause();
    }
    //#endregion
    //#region Xuất KQ tìm kiếm
    public static void xuatKQTimKiem(Sach[] l1) {
        if (l1.length == 0) {
            System.out.println("Khong tim thay sach");
            return;
        }
        System.out.println("Ket qua tim kiem (" + l1.length + " sach)");
        String[] head = {"Ma sach", "Ten sach", "Ma NXB", "Ma TG", "Nam XB",
                "Don gia", "So luong", "Trinh do(Do tuoi)", "Linh vuc"};
        String[][] data = new String[l1.length][];
        int i = 0;
        for (Sach x : l1) {
            data[i] = x.toArray();
            i++;
        }
        new ANSI(head, data).printTable();
        ANSI.pause();
    }
    //#endregion
    // thêm sách vào danh sách, trước khi thêm hỏi loại cần thêm
    public void them() {
        int chon;
        Sach s = new Sach();
        // while tới khi nào chọn đúng loại sách hoặc thoát
        do {
            System.out.println("Chon loai sach: 1. Sach hoc thuat, 2. Sach giai tri");
            chon = Integer.parseInt(in.nextLine());
            if (chon != 1 && chon != 2)
                System.out.println("Chon sai! Vui long chon lai");
        } while (chon != 1 && chon != 2);
        switch (chon) {
            case 1:
                s = new SachHocThuat();
                break;
            case 2:
                s = new SachGiaiTri();
                break;
        }
        s.nhap();
        boolean check = add(s);
        while (check == false) {
            System.out.println("Ma sach da ton tai, vui long nhap lai");
            s.nhap();
            check = add(s);
        }
        System.out.println("Them sach thanh cong");
    }

    // add sách vào cuối danh sách, kiểm tra trùng mã sách
    public boolean add(Sach s1) {
        int index = indexOf(s1.getMaSach());
        if (index == -1) {
            int n = list.length;
            list = Arrays.copyOf(list, n + 1);
            list[n] = s1;
            return true;
        } 
        return false;
    }

    public void edit(String maSach) {
        int index = indexOf(maSach);
        if (index == -1)
            System.out.println("Khong tim thay sach!");
        else {
            Sach s1 = new Sach();
            if (list[index] instanceof SachHocThuat)
                s1 = new SachHocThuat();
            else
                s1 = new SachGiaiTri();
            s1.nhap();
            list[index] = s1;
        }
    }

    public void remove(String maSach) {
        int index = indexOf(maSach);
        if (index == -1)
            System.out.println("Khong tim thay sach!");
        else {
            int len = list.length;
            System.arraycopy(list, index + 1, list, index, len - index - 1);
            list = Arrays.copyOf(list, len - 1);
            System.out.println("Xoa sach thanh cong");
        }
    }

    // get sách theo mã sách
    public Sach get(String maSach) {
        int index = indexOf(maSach);
        if (index == -1)
            return null;
        return list[index];
    }

    public boolean isEmpty() {
        return list == null || list.length == 0;
    }

    public int size() {
        return list.length;
    }

    public Sach[] timSachHocThuat() {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s instanceof SachHocThuat) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }

    public Sach[] timSachGiaiTri() {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s instanceof SachGiaiTri) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }
    
    public Sach[] timTheoMaTacGia(String maTacGia) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s.getMaTG().equals(maTacGia)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }

    public Sach[] timTheoNamXB(int namXB) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s.getNamXB() == namXB) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }

    public Sach[] timTheoDonGia(int from, int to) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s.getDonGia() <= to && s.getDonGia() >= from) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }

    public Sach[] timTheoTenSach(String tenSach) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s.getTenSach().toLowerCase().contains(tenSach.toLowerCase())) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }
        return result;
    }

    public Sach[] timTheoDoTuoi(int tuoi) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s instanceof SachGiaiTri) {
                SachGiaiTri sgt = (SachGiaiTri) s;
                if (sgt.getDoTuoi() == tuoi) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = s;
                }
            }
        }
        return result;
    }

    public Sach[] timTheoLinhVuc(String linhVuc) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s instanceof SachHocThuat) {
                SachHocThuat sht = (SachHocThuat) s;
                if (sht.getLinhVucNC().contains(linhVuc)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = s;
                }
            }
        }
        return result;
    }

    public Sach[] timTheoTrinhDo(String trinhDo) {
        Sach[] result = new Sach[0];
        for (Sach s : list) {
            if (s instanceof SachHocThuat) {
                SachHocThuat sht = (SachHocThuat) s;
                if (sht.getTrinhDo().contains(trinhDo)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = s;
                }
            }
        }
        return result;
    }

    public Map<String, Integer> thongKeSachGT() {
    Map<String, Integer> thongKe = new HashMap<>();
    
    for (Sach s : list) {
        if (s instanceof SachGiaiTri) {
            String tenSach = s.getTenSach(); 
            int soLuong = s.getSoLuong();  
            
            thongKe.put(tenSach, thongKe.getOrDefault(tenSach, 0) + soLuong);
        }
    }
    return thongKe;
}

}
