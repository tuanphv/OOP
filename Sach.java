import java.util.Scanner;
public class Sach {
// các thuộc tính
    private String masach;
    private String tensach;
    private String manxb;
    private String matg;
    private int namxb;
    private int dongia;
    private int soluong;
    private String theloai;
    private String tinhtrang;
// các hàm thiết lập
    public Sach() {}
    public Sach(String masach, String tensach, String manxb, String matg, int namxb, int dongia, int soluong, String theloai, String tinhtrang) 
    {
        this.masach = masach;
        this.tensach = tensach;
        this.manxb = manxb;
        this.matg = matg;
        this.namxb = namxb;
        this.dongia = dongia;
        this.soluong = soluong;
        this.theloai = theloai;
        this.tinhtrang = tinhtrang;
    }   
    public Sach(Sach s1) 
    {
        this.masach = s1.masach;
        this.tensach = s1.tensach;
        this.manxb = s1.manxb;
        this.matg = s1.matg;
        this.namxb = s1.namxb;
        this.dongia = s1.dongia;
        this.soluong = s1.soluong;
        this.theloai = s1.theloai;
        this.tinhtrang = s1.tinhtrang;
    }
// Các hàm get giá trị
    public String getMaSach(){
        return masach;
    }
    public String getTenSach(){
        return tensach;
    }
    public String getMaNXB(){
        return manxb;
    }
    public String getMaTG(){
        return matg;
    }
    public int getNamXB(){
        return namxb;
    }
    public int getDonGia(){
        return dongia;
    }
    public int getSoLuong(){
        return soluong;
    }
    public String getTheLoai(){
        return theloai;
    }
    public String getTinhTrang(){
        return tinhtrang;
    }
// Các hàm set giá trị 
    public void getMaSach(String masach){
        this.masach = masach;
    }
    public void getTenSach(String tensach){
        this.tensach = tensach;
    }
    public void getMaNXB(String manxb){
        this.manxb = manxb;
    }
    public void getMaTG(String matg){
        this.matg = matg;
    }
    public void getNamXB(int namxb){
        this.namxb = namxb;
    }
    public void getDonGia(int dongia){
        this.dongia = dongia;
    }
    public void getSoLuong(int soluong){
        this.soluong = soluong;
    }
    public void getTheLoai(String theloai){
        this.theloai = theloai;
    }
    public void getTinhTrang(String tinhtrang){
        this.tinhtrang = tinhtrang;
    }
    Scanner in = new Scanner(System.in);
    public void nhap() {
        masach = in.nextLine();
        tensach = in.nextLine();
        manxb = in.nextLine();
        matg = in.nextLine();
        namxb = Integer.parseInt(in.nextLine());
        dongia = Integer.parseInt(in.nextLine());
        soluong = Integer.parseInt(in.nextLine());
        theloai = in.nextLine();
        tinhtrang = in.nextLine();
    }
    public void xuat() {
        System.out.println("<===== Thong tin sach =====>");
        System.out.printf("%-25s%s\n","Ma sach:", masach);
        System.out.printf("%-25s%s\n","Ten sach:", tensach);
        System.out.printf("%-25s%s\n","Ma nha xuat ban:", manxb);
        System.out.printf("%-25s%s\n","Ma tac gia:", matg);
        System.out.printf("%-25s%d\n","Nam xuat ban:", namxb);
        System.out.printf("%-25s%d\n","Don gia:", dongia);
        System.out.printf("%-25s%d\n","So luong:", soluong);
        System.out.printf("%-25s%s\n","The loai:", theloai);
        System.out.printf("%-25s%s\n","Tinh trang sach:", tinhtrang);
    }

    public static void main(String[] args) {
        Sach s1 = new SachHocThuat("123", "Giai tich 1", "121", "111", 2017, 25000, 2, "Sach giao khoa", "new", "Toan hoc", "Dai hoc");
        // Sach s2 = new Sach();
        // s2.nhap();
        // s1.xuat();
        s1.xuat();
    }
}