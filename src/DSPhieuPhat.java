import java.io.*;
import java.util.Scanner;

public class DSPhieuPhat implements IList<Phieuphat>, Serializable {
    private Phieuphat[] dsPhieuPhat; // Mảng lưu danh sách phiếu phạt
    private int soLuong; // Số lượng phiếu phạt hiện tại
    private final int MAX = 100; // Kích thước tối đa của danh sách

    public DSPhieuPhat() {
    }

    public DSPhieuPhat() {
        this.dsPhieuPhat = new Phieuphat[MAX];
        this.soLuong = 0;
    }

    @Override
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./lib/phieuphat.txt"))) {
            for (int i = 0; i < soLuong; i++) {
                Phieuphat phieu = dsPhieuPhat[i];
                if (phieu != null) {
                    bw.write(phieu.getMapp() + ", " +
                            phieu.getMadg() + ", " +
                            phieu.getManv() + ", " +
                            phieu.getTongphat());
                    bw.newLine();
                }
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("./lib/phieuphat.txt"))) {
            String line;
            soLuong = 0; // Đặt lại số lượng phiếu phạt trước khi đọc file
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String maPP = parts[0];
                    String maDG = parts[1];
                    String maNV = parts[2];
                    double tongPhat = Double.parseDouble(parts[3]);

                    // Tạo một đối tượng phiếu phạt từ dữ liệu
                    Phieuphat phieuPhat = new Phieuphat(maPP, maDG, maNV, tongPhat);
                    add(phieuPhat); // Thêm vào danh sách
                } else {
                    System.out.println("Dòng không hợp lệ: " + line);
                }
            }
            System.out.println("Đọc file thành công!");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    @Override
    public void add(Phieuphat obj) {
        if (soLuong >= MAX) {
            System.out.println("Danh sách đã đầy, không thể thêm phiếu phạt mới.");
            return;
        }
        dsPhieuPhat[soLuong++] = obj;
        System.out.println("Thêm phiếu phạt thành công!");
    }

    @Override
    public void remove(Phieuphat obj) {
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsPhieuPhat[i].equals(obj)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsPhieuPhat[j] = dsPhieuPhat[j + 1];
                }
                dsPhieuPhat[--soLuong] = null;
                timThay = true;
                System.out.println("Xóa phiếu phạt thành công!");
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy phiếu phạt để xóa.");
        }
    }

    @Override
    public int indexOf(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPhieuPhat[i].getMapp().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Phieuphat get(String ma) {
        for (Phieuphat phieu : dsPhieuPhat) {
            if (phieu != null && phieu.getMapp().equalsIgnoreCase(ma)) {
                return phieu;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return soLuong == 0;
    }

    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phiếu phạt: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            if (soLuong >= MAX) {
                System.out.println("Danh sách đã đầy, không thể thêm phiếu phạt mới.");
                break;
            }
            System.out.println("Nhập thông tin phiếu phạt thứ " + (i + 1) + ":");
            Phieuphat phieuPhat = new Phieuphat();
            phieuPhat.nhap();
            add(phieuPhat);
        }
    }

    public void xuatDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách phiếu phạt trống.");
            return;
        }
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Mã phiếu phạt", "Mã độc giả", "Mã nhân viên", "Tổng phạt");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < soLuong; i++) {
            Phieuphat phieu = dsPhieuPhat[i];
            System.out.printf("%-15s %-15s %-15s %-15.2f\n", phieu.getMapp(), phieu.getMadg(), phieu.getManv(),
                    phieu.getTongphat());
        }
    }

    public static void main(String[] args) {
        DSPhieuPhat ds = new DSPhieuPhat();
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n--- MENU QUẢN LÝ PHIẾU PHẠT ---");
            System.out.println("1. Nhập danh sách phiếu phạt");
            System.out.println("2. Xuất danh sách phiếu phạt");
            System.out.println("3. Thêm phiếu phạt");
            System.out.println("4. Sửa phiếu phạt");
            System.out.println("5. Xóa phiếu phạt");
            System.out.println("6. Ghi danh sách vào file");
            System.out.println("7. Đọc danh sách từ file");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    ds.nhapDanhSach();
                    break;
                case 2:
                    ds.xuatDanhSach();
                    break;
                case 3:
                    System.out.println("Nhập thông tin phiếu phạt cần thêm:");
                    Phieuphat phieuMoi = new Phieuphat();
                    phieuMoi.nhap();
                    ds.add(phieuMoi);
                    break;
                case 4:
                    System.out.print("Nhập mã phiếu phạt cần sửa: ");
                    String maSua = scanner.nextLine();
                    Phieuphat phieuSua = ds.get(maSua);
                    if (phieuSua != null) {
                        System.out.println("Nhập thông tin mới cho phiếu phạt:");
                        System.out.print("Nhập mã độc giả: ");
                        phieuSua.setMadg(scanner.nextLine());
                        System.out.print("Nhập mã nhân viên: ");
                        phieuSua.setManv(scanner.nextLine());
                        System.out.print("Nhập tổng phạt: ");
                        phieuSua.setTongphat(Double.parseDouble(scanner.nextLine()));
                        System.out.println("Sửa thông tin thành công!");
                    } else {
                        System.out.println("Không tìm thấy mã phiếu phạt cần sửa!");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã phiếu phạt cần xóa: ");
                    String maXoa = scanner.nextLine();
                    Phieuphat phieuXoa = ds.get(maXoa);
                    if (phieuXoa != null) {
                        ds.remove(phieuXoa);
                    } else {
                        System.out.println("Không tìm thấy mã phiếu phạt cần xóa!");
                    }
                    break;
                case 6:
                    ds.ghiFile();
                    break;
                case 7:
                    ds.docFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}
