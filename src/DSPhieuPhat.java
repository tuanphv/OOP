import java.io.*;
import java.util.Scanner;

public class DSPhieuPhat implements IList<Phieuphat> {
    private Phieuphat[] list = new Phieuphat[0];  // Mảng ban đầu rỗng

    public DSPhieuPhat() {}

    public DSPhieuPhat(Phieuphat[] l1) {
        this.list = l1;
    }

    // Đọc dữ liệu từ file và lưu vào mảng
    public void docFile() {
        try (Scanner scanner = new Scanner(new File("./lib/PhieuPhat.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(", ");
                String mapp = data[0];
                String madg = data[1];
                String manv = data[2];
                Double tongphat = Double.parseDouble(data[3]);

                Phieuphat phieuphat = new Phieuphat(mapp, madg, manv, tongphat);

                // Mở rộng mảng để thêm đối tượng mới
                Phieuphat[] newList = new Phieuphat[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                newList[list.length] = phieuphat;
                list = newList;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tìm thấy: " + e.getMessage());
        }
    }

    // Ghi dữ liệu vào file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./lib/PhieuPhat.txt"))) {
            for (Phieuphat phieuphat : list) {
                writer.println(phieuphat.getMapp() + ", " + phieuphat.getMadg() + ", " + phieuphat.getManv() + ", " + phieuphat.getTongphat());
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // Thêm phiếu phạt vào mảng
    public void add(Phieuphat phieuphat) {
        // Mở rộng mảng để thêm đối tượng mới
        Phieuphat[] newList = new Phieuphat[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = phieuphat;
        list = newList;
    }

    // Xóa phiếu phạt khỏi mảng
    // Xóa phiếu phạt khỏi mảng
public void remove(Phieuphat phieuphat) {
    int index = indexOf(phieuphat.getMapp());  // Lấy vị trí của phiếu phạt theo mã phiếu
    if (index != -1) {  // Nếu tìm thấy phiếu phạt
        Phieuphat[] newList = new Phieuphat[list.length - 1];  // Tạo mảng mới có kích thước giảm đi 1
        System.arraycopy(list, 0, newList, 0, index);  // Sao chép phần trước phiếu phạt
        System.arraycopy(list, index + 1, newList, index, list.length - index - 1);  // Sao chép phần sau phiếu phạt
        list = newList;  // Gán mảng mới cho danh sách
    }
}




    // Lấy vị trí của phiếu phạt trong mảng
    public int indexOf(String Mapp) {
    for (int i = 0; i < list.length; i++) {
        if (list[i].getMapp().equals(Mapp)) {
            return i;
        }
    }
    return -1; // Không tìm thấy
}


    // Lấy phiếu phạt theo mã phiếu
    public Phieuphat get(String mapp) {
        for (Phieuphat phieuphat : list) {
            if (phieuphat.getMapp().equals(mapp)) {
                return phieuphat;
            }
        }
        return null;  // Trả về null nếu không tìm thấy
    }

    // Kiểm tra mảng có rỗng không
    public boolean isEmpty() {
        return list.length == 0;
    }

    // Lấy độ dài của mảng
    public int size() {
        return list.length;
    }

    // Hiển thị menu và thực hiện các thao tác
    public static void main(String[] args) {
        DSPhieuPhat ds = new DSPhieuPhat();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Đọc dữ liệu từ file");
            System.out.println("2. Ghi dữ liệu vào file");
            System.out.println("3. Thêm phiếu phạt");
            System.out.println("4. Xóa phiếu phạt");
            System.out.println("5. Xem danh sách phiếu phạt");
            System.out.println("6. Thoát");
            System.out.print("Chọn thao tác: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dấu cách hoặc newline dư thừa

            switch (choice) {
                case 1:
                    ds.docFile();
                    System.out.println("Dữ liệu đã được đọc từ file.");
                    break;

                case 2:
                    ds.ghiFile();
                    System.out.println("Dữ liệu đã được ghi vào file.");
                    break;

                case 3:
                    Phieuphat newPhieu = new Phieuphat();
                    newPhieu.nhap();  // Nhập thông tin phiếu phạt mới
                    ds.add(newPhieu);
                    System.out.println("Phiếu phạt đã được thêm.");
                    break;

                case 4:
                    System.out.print("Nhập mã phiếu phạt cần xóa: ");
                    String mappToDelete = scanner.nextLine();
                    Phieuphat phieuphatToRemove = ds.get(mappToDelete);
                    if (phieuphatToRemove != null) {
                        ds.remove(phieuphatToRemove);
                        System.out.println("Phiếu phạt đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy phiếu phạt có mã: " + mappToDelete);
                    }
                    break;

                case 5:
                    if (ds.isEmpty()) {
                        System.out.println("Danh sách phiếu phạt rỗng.");
                    } else {
                        System.out.println("Danh sách phiếu phạt:");
                        for (int i = 0; i < ds.size(); i++) {
                            ds.list[i].xuat();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
