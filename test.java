public class test {
    public static void main(String[] args) {
        ListSach l1 = new ListSach();
        Sach s1 = new Sach("123", "Giai tich 1", "121", "111", 2017, 25000, 2, "Sach giao khoa", "new");
        Sach s2 = new Sach(s1);
        s2.setMaSach("111");
        l1.addSach(s1);
        l1.addSach(s2);
        l1.xuat();
        l1.deleteSach(s2);
        l1.xuat();
    }
}
