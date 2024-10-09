/**
 * Sach
 */
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
}