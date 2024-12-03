import java.io.*;
import java.util.Scanner;

public class DSPhieuPhat implements IList<Phieuphat> {
    private Phieuphat[] list = new Phieuphat[100];  // Mảng với kích thước cố định
    
    public DSPhieuPhat() {}

    public DSPhieuPhat(Phieuphat[] l1) {
        this.list = l1;
    }

    // Read data from file and store in array
    public void docFile() {
        try (Scanner scanner = new Scanner(new File("./lib/PhieuPhat.txt"))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(", ");
                String mapp = data[0];
                String madg = data[1];
                String manv = data[2];
                Double tongphat = Double.parseDouble(data[3]);

                Phieuphat phieuphat = new Phieuphat(mapp, madg, manv, tongphat);

                // Expand array to add new object
                Phieuphat[] newList = new Phieuphat[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                newList[list.length] = phieuphat;
                list = newList;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Synchronize with ChiTietPhieuPhat.txt
        synchronizeWithChiTietPhieuPhat();
    }

    // Synchronize data with ChiTietPhieuPhat.txt
    private void synchronizeWithChiTietPhieuPhat() {
        DSChiTietPhieuPhat dsChiTiet = new DSChiTietPhieuPhat();
        dsChiTiet.docFile(); // Read data from ChiTietPhieuPhat.txt

        for (Phieuphat phieuphat : list) {
            // Logic to update PhieuPhat.txt based on ChiTietPhieuPhat.txt
            // This can include checking if the entries in ChiTietPhieuPhat.txt correspond to the entries in PhieuPhat.txt
            // and updating or adding as necessary
        }
    }

    // Ghi dữ liệu vào file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./lib/PhieuPhat.txt"))) {
            for (Phieuphat phieuphat : list) {
                if (phieuphat != null) {
                    writer.println(phieuphat.getMapp() + ", " + phieuphat.getMadg() + ", " + phieuphat.getManv() + ", " + phieuphat.getTongphat());
                }
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
            if (phieuphat != null && phieuphat.getMapp().equals(mapp)) {
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

    // Lấy danh sách phiếu phạt
    public Phieuphat[] getList() {
        return list;
    }
    
    // Removed the main method to prevent Scanner conflicts
}
