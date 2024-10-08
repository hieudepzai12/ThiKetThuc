package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: Lê Văn Hoàng Hiếu
 */
public class QLKhachHang extends KhachHang{

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
       ArrayList<String> data = FileHelper.readFileText(filename); //doc file
        //đổ dữ liệu vào danh sách
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setSonhankhau(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));
            dsKhachHang.add(kh);
    }}

    public boolean GhiHoaDon(String filename) {
         ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getSonhankhau() + ";"
                    + kh.getChisocu() + ";" + kh.getChisomoi() + ";" + kh.getTieuThu();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }

   
    public void sapXepTheoMucTieuThu() {
        //sinh viên viết code 
        Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getTieuThu(), kh2.getTieuThu());
        };
        Collections.sort(dsKhachHang, cmp);
    }
    
    public double getTieuThuCaoNhat()
    {
      double max=0;
      return max;
    }
    
    public double getTieuThuThapNhat()
    {
       double min = 0;  
       sapXepTheoMucTieuThu();
        min = dsKhachHang.get(0).getTieuThu();
        return min;
    }
    
    public double getTieuThuTrungBinh()
    {
        double tb, tongTT = 0;
        for (int i = 0; i < dsKhachHang.size(); i++) {
            tongTT += dsKhachHang.get(i).getTieuThu();
        }
        tb = tongTT / dsKhachHang.size();
        return tb;     
    }
}
