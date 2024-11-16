public class test {
    public static void main(String[] args) {
        DSSach l1 = new DSSach();
        l1.docFile();
        Sach s1 = new Sach("123", "Giai tich 1", "121", "111", 2017, 25000, 2, "Sach giao khoa");
        SachGiaiTri s2 = new SachGiaiTri(s1, 10);
        s2.setMaSach("111");
        l1.add(s1);
        l1.add(s2);
        l1.xuatTheoLoai();
        l1.ghiFile();
    }
}
