public class test {
    public static void main(String[] args) {
        ListSach l1 = new ListSach();
        Sach s1 = new Sach("123", "Giai tich 1", "121", "111", 2017, 25000, 2, "Sach giao khoa");
        SachGiaiTri s2 = new SachGiaiTri(s1, 10);
        s2.setMaSach("111");
        l1.themSach(s1);
        l1.themSach(s2);
        ListSach l2 = new ListSach(l1);
        l1.xuat();
        l1.xoaSach(s2);
        l1.xuat();
        l2.xuatTheoLoai();
    }
}
