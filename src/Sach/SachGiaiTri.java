package Sach;

import Validate.Validate;

public class SachGiaiTri extends Sach {
    private int doTuoi;

    public SachGiaiTri() {
    }

    public SachGiaiTri(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong, int doTuoi) {
        super(maSach, tenSach, maNXB, maTG, namXB, donGia, soLuong);
        this.doTuoi = doTuoi;
    }

    public SachGiaiTri(SachGiaiTri sgt1) {
        super((Sach) sgt1);
        this.doTuoi = sgt1.doTuoi;
    }

    public SachGiaiTri(Sach s1, int doTuoi) {
        super(s1);
        this.doTuoi = doTuoi;
    }

    public int getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(int doTuoi) {
        this.doTuoi = doTuoi;
    }

    @Override
    public void nhap() {
        super.nhap();
        doTuoi = Validate.getNumber(in, "Nhap do tuoi phu hop: ");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-20s%d\n", "Do tuoi phu hop:", doTuoi);
    }

    @Override
    public String toString() {
        return "0, " + super.toString() + ", " + doTuoi;
    }

    @Override
    public String[] toArray() {
        String[] arr = new String[super.toArray().length + 2];
        System.arraycopy(super.toArray(), 0, arr, 0, super.toArray().length);
        arr[arr.length - 2] = String.valueOf(doTuoi);
        arr[arr.length - 1] = "";
        return arr;
    }
}
