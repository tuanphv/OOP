package PhieuPhat;
import java.io.*;

import Interface.IList;

public class DSChiTietPP implements IList<ChiTietPhieuPhat> {
    private ChiTietPhieuPhat[] list = new ChiTietPhieuPhat[0];  // Mảng ban đầu rỗng

    // Phương thức đọc file và khởi tạo danh sách từ file
    @Override
    public void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./lib/ChiTietPhieuPhat.txt"))) {
            String line;
            int count = 0;

            // Đếm số dòng trong file để tạo mảng với kích thước đủ lớn
            while ((line = reader.readLine()) != null) {
                count++;
            }

            // Tạo mảng với kích thước phù hợp
            list = new ChiTietPhieuPhat[count];
            reader.close();

            // Đọc lại file và khởi tạo đối tượng
            BufferedReader reader2 = new BufferedReader(new FileReader("./lib/ChiTietPhieuPhat.txt"));
            int index = 0;
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String mapp = parts[0];
                    String masach = parts[1];
                    String maqd = parts[2];
                    Double tienphat = Double.parseDouble(parts[3]);
                    list[index] = new ChiTietPhieuPhat(mapp, masach, maqd, tienphat);
                    index++;
                }
            }
            reader2.close();
            System.out.println("Đọc file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong file.");
        }
    }

    // Phương thức ghi danh sách vào file
    @Override
    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./lib/ChiTietPhieuPhat.txt"))) {
            for (ChiTietPhieuPhat item : list) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // Thêm một đối tượng vào cuối danh sách
    @Override
    public void add(ChiTietPhieuPhat obj) {
        // Tạo mảng mới với kích thước tăng lên
        ChiTietPhieuPhat[] newList = new ChiTietPhieuPhat[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);  // Sao chép dữ liệu cũ vào mảng mới
        newList[list.length] = obj;  // Thêm đối tượng mới vào cuối mảng
        list = newList;  // Cập nhật mảng mới
    }

    // Xóa đối tượng obj khỏi danh sách
    @Override
    public void remove(ChiTietPhieuPhat obj) {
        // Tìm vị trí của đối tượng trong mảng
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(obj)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Tạo mảng mới với kích thước giảm đi 1
            ChiTietPhieuPhat[] newList = new ChiTietPhieuPhat[list.length - 1];
            // Sao chép các phần tử trước và sau phần tử cần xóa
            System.arraycopy(list, 0, newList, 0, index);
            System.arraycopy(list, index + 1, newList, index, list.length - index - 1);
            list = newList;  // Cập nhật mảng mới
        } else {
            System.out.println("Không tìm thấy đối tượng để xóa.");
        }
    }

    // Lấy vị trí của đối tượng trong danh sách
    @Override
    public int indexOf(String ma) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getMapp().equals(ma)) {
                return i;
            }
        }
        return -1;  // Không tìm thấy
    }

    // Lấy đối tượng theo mã
    @Override
    public ChiTietPhieuPhat get(String ma) {
        for (ChiTietPhieuPhat item : list) {
            if (item.getMapp().equals(ma)) {
                return item;
            }
        }
        return null;  // Không tìm thấy
    }

    // Kiểm tra danh sách có rỗng hay không
    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    // Lấy độ dài của danh sách
    @Override
    public int size() {
        return list.length;
    }
}
