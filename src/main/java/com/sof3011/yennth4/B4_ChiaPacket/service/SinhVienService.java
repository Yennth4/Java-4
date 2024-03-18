package com.sof3011.yennth4.B4_ChiaPacket.service;

import com.sof3011.yennth4.B4_ChiaPacket.entity.SinhVien;
import org.apache.commons.math3.analysis.function.Sin;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> listSinhVien;

    public SinhVienService() {
        this.listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("HangNT169", "Nguyen Thuy Hang", 10, "HN", false));
        listSinhVien.add(new SinhVien("PhongTT35", "Tran Tuan Phong", 11, "HN1", true));
        listSinhVien.add(new SinhVien("NguyenVV4", "Vu Van Nguyen", 12, "HN2", false));
        listSinhVien.add(new SinhVien("KhanhPG", "Pham Gia Khanh", 13, "HN3", true));
        listSinhVien.add(new SinhVien("TienNH21", "Nguyen Hoang Tien", 14, "HN4", false));
        listSinhVien.add(new SinhVien("DungNA29", "Nguyen Anh Dung", 15, "HN5", true));
    }

    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    public void fakeData(ArrayList<SinhVien> listSinhVien) {
        // Fill du lieu
    }

    // chuyen validate sang service => HashMap

    public void addSinhVien(SinhVien sv) {
        listSinhVien.add(sv);
    }

    public void updateSinhVien(SinhVien sv) {
        for (int i = 0; i < listSinhVien.size(); i++) {
            SinhVien sinhVien = listSinhVien.get(i);
            if (sinhVien.getMssv().equalsIgnoreCase(sv.getMssv())) {
                sinhVien.setTen(sv.getTen());
                sinhVien.setTuoi(sv.getTuoi());
                sinhVien.setDiaChi(sv.getDiaChi());
                sinhVien.setGioiTinh(sv.getGioiTinh());
            }
        }
    }

    /*
    * Mảng tĩnh :
    * a[] = 5 6 1 2
    *i =    0 1 2 3  => lấy gtri cua phan tu i : a[i]
    *
    * Mảng động : lists (kieu Object)
    *   SV1  SV2    SV3   SV4
    * i : 0   1      2     3
    *  => lấy gtri cua phan tu i trong list : list.get(i)
    * */

//     C1 : xoa theo maSV trong list
    public void xoaSinhVien(String mssv) {
        for (int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getMssv().equalsIgnoreCase(mssv)) {
                listSinhVien.remove(i);
            }
        }
    }

/*
      C2: xoa theo vi tri
        public void xoaSinhVien(int index) {
            listSinhVien.remove(index);
        }
*/

    public SinhVien detailSinhVien(String mssv) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(mssv)){
                return sv;
            }
        }
            return null;
    }
}
