import java.util.Scanner;

public class MenuQuanLyPhat {
    private DSPhieuPhat dsPhieuPhat;
    private DSQuyDinhPhat dsQuyDinhPhat;

    public MenuQuanLyPhat() {
        dsPhieuPhat = new DSPhieuPhat();
        dsQuyDinhPhat = new DSQuyDinhPhat();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu Quản Lý Phạt ---");
            System.out.println("1. Quản lý phiếu phạt");
            System.out.println("2. Quản lý quy định phạt");
            System.out.println("3. Thoát");
            System.out.print("Chọn thao tác: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    managePhieuPhat(scanner);
                    break;
                case 2:
                    manageQuyDinhPhat(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void managePhieuPhat(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Quản Lý Phiếu Phạt ---");
            System.out.println("1. Đọc dữ liệu từ file");
            System.out.println("2. Ghi dữ liệu vào file");
            System.out.println("3. Thêm phiếu phạt");
            System.out.println("4. Xóa phiếu phạt");
            System.out.println("5. Xem danh sách phiếu phạt");
            System.out.println("6. Quay lại");
            System.out.print("Chọn thao tác: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    dsPhieuPhat.docFile();
                    System.out.println("Dữ liệu đã được đọc từ file.");
                    break;
                case 2:
                    dsPhieuPhat.ghiFile();
                    System.out.println("Dữ liệu đã được ghi vào file.");
                    break;
                case 3:
                    Phieuphat newPhieu = new Phieuphat();
                    newPhieu.nhap();  // Nhập thông tin phiếu phạt mới
                    dsPhieuPhat.add(newPhieu);
                    System.out.println("Phiếu phạt đã được thêm.");
                    break;
                case 4:
                    System.out.print("Nhập mã phiếu phạt cần xóa: ");
                    String mappToDelete = scanner.nextLine();
                    Phieuphat phieuphatToRemove = dsPhieuPhat.get(mappToDelete);
                    if (phieuphatToRemove != null) {
                        dsPhieuPhat.remove(phieuphatToRemove);
                        System.out.println("Phiếu phạt đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy phiếu phạt có mã: " + mappToDelete);
                    }
                    break;
                case 5:
                    if (dsPhieuPhat.isEmpty()) {
                        System.out.println("Danh sách phiếu phạt rỗng.");
                    } else {
                        System.out.println("Danh sách phiếu phạt:");
                        for (int i = 0; i < dsPhieuPhat.size(); i++) {
                            dsPhieuPhat.getList()[i].xuat();
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void manageQuyDinhPhat(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Quản Lý Quy Định Phạt ---");
            System.out.println("1. Đọc dữ liệu từ file");
            System.out.println("2. Ghi dữ liệu vào file");
            System.out.println("3. Thêm quy định phạt");
            System.out.println("4. Xóa quy định phạt");
            System.out.println("5. Xem danh sách quy định phạt");
            System.out.println("6. Quay lại");
            System.out.print("Chọn thao tác: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    dsQuyDinhPhat.docFile();
                    System.out.println("Dữ liệu đã được đọc từ file.");
                    break;
                case 2:
                    dsQuyDinhPhat.ghiFile();
                    System.out.println("Dữ liệu đã được ghi vào file.");
                    break;
                case 3:
                    Quydinhphat newQuyDinh = new Quydinhphat();
                    newQuyDinh.Nhap();  // Nhập thông tin quy định phạt mới
                    dsQuyDinhPhat.add(newQuyDinh);
                    System.out.println("Quy định phạt đã được thêm.");
                    break;
                case 4:
                    System.out.print("Nhập mã quy định phạt cần xóa: ");
                    String maqdToDelete = scanner.nextLine();
                    Quydinhphat quyDinhToRemove = dsQuyDinhPhat.get(maqdToDelete);
                    if (quyDinhToRemove != null) {
                        dsQuyDinhPhat.remove(quyDinhToRemove);
                        System.out.println("Quy định phạt đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy quy định phạt có mã: " + maqdToDelete);
                    }
                    break;
                case 5:
                    if (dsQuyDinhPhat.isEmpty()) {
                        System.out.println("Danh sách quy định phạt rỗng.");
                    } else {
                        System.out.println("Danh sách quy định phạt:");
                        for (int i = 0; i < dsQuyDinhPhat.size(); i++) {
                            dsQuyDinhPhat.getList()[i].Xuat();
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    public static void main(String[] args) {
        MenuQuanLyPhat menu = new MenuQuanLyPhat();
        menu.showMenu();
    }
}
