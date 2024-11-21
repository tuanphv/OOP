public class test {
    public static void main(String[] args) {
        DSSach l1 = new DSSach();
        l1.docFile();
        SachGiaiTri s1 = new SachGiaiTri("123", "Giai tich 1", "121", "111", 2017, 25000, 2,"", 18);
        SachGiaiTri s2 = new SachGiaiTri(s1);
        s2.setDoTuoi(12);
        s2.setMaSach("111");
        l1.add(s1);
        l1.add(s2);
        l1.xuatTheoLoai();
        l1.ghiFile();

        // DSNV dsnv1= new DSNV();
        // dsnv1.menu();
    }
}