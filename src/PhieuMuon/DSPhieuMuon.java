package PhieuMuon;
import java.util.Arrays;
import java.util.Scanner;
public class DSPhieuMuon {
    PhieuMuon[] dspm;
    int n;
    Scanner input = new Scanner(System.in);
    public DSPhieuMuon(){
        this.n = 0;
        this.dspm = new PhieuMuon[0];
    }
    public DSPhieuMuon(int n, PhieuMuon[] dspm){
       this.n = n;
       this.dspm = dspm;
    }
    public void nhap(){
        System.out.print("Nhap so luong phieu muon: ");
        n = Integer.parseInt(input.nextLine());  
        dspm = new PhieuMuon[n];
        for (int i = 0; i < n; i++) {
            dspm[i] = new PhieuMuon();
            dspm[i].nhap();
            System.out.println("-------------------------");
        }
    }
    
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15s \n", "Ma PM", "MaDG", "Ngay Muon","Ma Nhan Vien");
        System.out.println("------------------------------------------------------------------------------");
        for (int i=0;i<n;i++){
            dspm[i].xuat();
        }
    }

    public Boolean kiemTraMaPhieuMuon(String maPhieuMuon) {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (dspm[i].getmaPhieuMuon().equals(maPhieuMuon)) {
                count++;
            }
            
            if (count > 1) {
                return false;  
            }
        }
        return true;
    }
    
    public void them(){
        PhieuMuon pm = new PhieuMuon();
        pm.nhap();
        n=dspm.length;
        if(kiemTraMaPhieuMuon(pm.getmaPhieuMuon())){
            dspm = Arrays.copyOf(dspm, n+1);
            dspm[n]=new PhieuMuon(pm);
            n++;
        }
        else{
            System.out.println("Ma phieu muon da ton  tai ! . Hay nhap lai");
            them();
        }
    }

    public void sua(){
        System.out.print("Nhap ma phieu muon can sua: ");
        String masua =  input.nextLine();
        int vitri=-1;
        for(int i=0;i<n;i++){
            if(dspm[i].getmaPhieuMuon().equals(masua)){
                vitri=i;
                break;
            }
        }
        if(vitri==-1){
            System.out.println("Khong tim thay mon hoc can sua: ");

        }
        else{
            System.out.print("Nhap ma doc gia: ");
            String madg =input.nextLine();
            dspm[vitri].setmaDocGia(madg);
            System.out.print("Nhap ngay xuat: ");
            String ngayxuat = input.nextLine();
            dspm[vitri].setngayMuon(ngayxuat);
            System.out.print("Nhap ma nhan vien: ");
            String manv =input.nextLine();
            dspm[vitri].setmaNhanVien(manv);
            
        }
    }

    public void xoa(){
        System.out.print("Nhap ma phieu muon can xoa: ");
        String maxoa = input.nextLine();
        int vitri=-1;
        for(int i=0;i<n;i++){
            if(dspm[i].getmaPhieuMuon().equals(maxoa)){
                vitri=i;
                break;
            }
        }
        if(vitri==-1){
            System.out.println("Khong tim thay ma phieu muon can xoa");
        }
        else{
            for(int i=vitri;i<n-1;i++){
                dspm[i]=dspm[i+1];
            }
            n--;
            dspm=Arrays.copyOf(dspm, n);
        }
    }
    public PhieuMuon timKiemMaPhieuMuon() {
        System.out.print("Nhap ma phieu muon can tim: ");
        String matim = input.nextLine();
        
        for (PhieuMuon phieu : dspm) {
            if (phieu.getmaPhieuMuon().equals(matim)) {
                return phieu;
            }
        }
        
        System.out.println("Khong tim thay ma phieu muon can tim");
        return null;
    }

    public PhieuMuon timKiemMaDocGia() {
        System.out.print("Nhap ma doc gia can tim: ");
        String matim = input.nextLine();
        
        for (PhieuMuon phieu : dspm) {
            if (phieu.getmaDocGia().equals(matim)) {
                return phieu;
            }
        }
        
        System.out.println("Khong tim thay ma doc gia can tim");
        return null;
    }
    

    public DSPhieuMuon timKiemMaNV() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String matim = input.nextLine();
        PhieuMuon[] dspm1 = new PhieuMuon[n];
        int dem = 0;
        
        for (int i = 0; i < n; i++) {
            if (dspm[i].getmaNhanVien().equals(matim)) {
                dspm1[dem] = dspm[i];
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay ma nhan vien can tim");
            return new DSPhieuMuon(); 
        } 
        PhieuMuon[] ketQua = Arrays.copyOf(dspm1, dem);
        return new DSPhieuMuon(dem, ketQua);
    }
    
    public static void main(String[] args) {
        DSPhieuMuon dspm = new DSPhieuMuon();
        dspm.nhap();
        dspm.xuat();
        System.out.println("THEM ");
        dspm.them();
        System.out.println("SUA ");
        dspm.sua();
        System.out.println("XOA ");
        dspm.xoa();
        PhieuMuon n = dspm.timKiemMaPhieuMuon();
        n.xuat();
        PhieuMuon n1 = dspm.timKiemMaDocGia();
        n1.xuat();
        DSPhieuMuon n2 = dspm.timKiemMaNV();
        n2.xuat();
        
    }
}