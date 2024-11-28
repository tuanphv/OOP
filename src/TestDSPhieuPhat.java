
public class TestDSPhieuPhat {
    public static void main(String[] args) {
        DSPhieuPhat ds = new DSPhieuPhat();
        
        // Test reading from file
        ds.docFile();
        System.out.println("Dữ liệu đã được đọc từ file.");

        // Test adding a new Phieuphat
        Phieuphat newPhieu = new Phieuphat("PP001", "DG001", "NV001", 100.0);
        ds.add(newPhieu);
        System.out.println("Đã thêm phiếu phạt mới.");

        // Test writing to file
        ds.ghiFile();
        System.out.println("Dữ liệu đã được ghi vào file.");

        // Test displaying the list using the getList method
        System.out.println("Danh sách phiếu phạt:");
        for (Phieuphat phieuphat : ds.getList()) {
            if (phieuphat != null) { // Check for null to avoid NullPointerException
                phieuphat.xuat();
            }
        }
    }
}
