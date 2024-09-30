package model;

/**
 *
 * Họ tên sinh viên: Lê Văn Hoàng Hiếu
 */
public class KhachHang {

    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter
    public String getMaso() {
        return maso;
    }

    public String getHoten() {
        return hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }
    //phương thức tính toán    

    public double getTieuThu() {
        return chisomoi - chisocu;
    }

    public double getDinhMuc() {  
        return sonhankhau*4;
    }

    public double tinhTienTra() {
        double tienTra=0;
        double giaBan=0;
        if(getTieuThu()<=getDinhMuc()){
            giaBan=6700*getTieuThu();
        }
        else {
            if(4<(getTieuThu()/sonhankhau)&&(getTieuThu()/sonhankhau)<=6){
                giaBan=6700*getDinhMuc()+12900*(getTieuThu()-getDinhMuc());
            }
            else{
                giaBan=6700*getDinhMuc()+12900*(getTieuThu()-getDinhMuc()- sonhankhau*2)+ 14400*(getTieuThu()-getDinhMuc()-sonhankhau*2);
            }
        }
        return tienTra=giaBan+giaBan*0.05+giaBan*0.25+(giaBan*0.25)*0.08;
    }
}
