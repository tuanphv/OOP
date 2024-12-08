package PhieuPhat;

import Interface.IList;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSPhieuPhat implements IList<PhieuPhat> {
    private PhieuPhat[] list = new PhieuPhat[0];

    public DSPhieuPhat() {
    }

    public DSPhieuPhat(PhieuPhat[] l1) {
        this.list = l1;
    }

    // Read data from file and store in array
    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./lib/PhieuPhat.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 4) {
                    try {
                        int tongPhat = Integer.parseInt(parts[3]);
                        add(new PhieuPhat(parts[0], parts[1], parts[2], parts[3], tongPhat));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format for: " + parts[3] + ". Skipping this entry.");
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Ghi dữ liệu vào file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./lib/PhieuPhat.txt"))) {
            for (PhieuPhat phieuphat : list) {
                if (phieuphat != null) {
                    writer.println(phieuphat.getMaPP() + ", " + phieuphat.getMaDG() + ", " + phieuphat.getMaNV() + ", "
                            + phieuphat.getTongPhat());
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // Thêm phiếu phạt vào mảng
    public boolean add(PhieuPhat phieuphat) {
        int index = indexOf(phieuphat.getMaPP());
        if (index != -1) {
            return false;
        }
        list = Arrays.copyOf(list, list.length + 1);
        list[list.length - 1] = phieuphat;
        return true;
    }

    public void edit(String ma) {
        int index = indexOf(ma);
        if (index != -1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập thông tin mới cho phiếu phạt:");
            System.out.print("Nhập mã độc giả: ");
            list[index].setMaDG(scanner.nextLine());
            System.out.print("Nhập mã nhân viên: ");
            list[index].setMaNV(scanner.nextLine());
            System.out.println("Đã cập nhật thông tin cho phiếu phạt có mã " + ma);
            scanner.close();
            return;
        }
        System.out.println("Không tìm thấy phiếu phạt có mã " + ma);
    }
    // Xóa phiếu phạt khỏi mảng
    public void remove(String ma) {
        int index = indexOf(ma); // Lấy vị trí của phiếu phạt theo mã phiếu
        if (index != -1) { // Nếu tìm thấy phiếu phạt
            int length = list.length;
            System.arraycopy(list, index + 1, list, index, length - index - 1); // Sao chép phần trước phiếu phạt
            list = Arrays.copyOf(list, length - 1);
            System.out.println("Đã xóa phiếu phạt có mã " + ma);
            return;
        }
        System.out.println("Không tìm thấy phiếu phạt có mã " + ma);
    }

    // Lấy vị trí của phiếu phạt trong mảng
    public int indexOf(String Mapp) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getMaPP().equals(Mapp)) {
                return i;
            }
        }
        return -1; // Không tìm thấy
    }

    // Lấy phiếu phạt theo mã phiếu
    public PhieuPhat get(String mapp) {
        for (PhieuPhat phieuphat : list) {
            if (phieuphat != null && phieuphat.getMaPP().equals(mapp)) {
                return phieuphat;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    // Kiểm tra mảng có rỗng không
    public boolean isEmpty() {
        return list.length == 0 || list == null;
    }

    // Lấy độ dài của mảng
    public int size() {
        return list.length;
    }

    // Lấy danh sách phiếu phạt
    public PhieuPhat[] getList() {
        return list;
    }

    public void xuat() {
        if (isEmpty()) {
            System.out.println("Danh sach phieu phat rong.");
        } else {
            System.out.println("Danh sach phieu phat:");
            for (PhieuPhat phieuphat : list)   
                phieuphat.xuat();
        }
    }
}
