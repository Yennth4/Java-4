package com.sof3011.yennth4.B4_ChiaPacket.service;

import com.sof3011.yennth4.B4_ChiaPacket.entity.SinhVien;
import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> listSinhVien;

    public SinhVienService() {
        this.listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("HangNT169" , "Nguyen Thuy Hang" , 10 , "HN" , false));
        listSinhVien.add(new SinhVien("PhongTT35" , "Tran Tuan Phong" , 11 , "HN1" , true));
        listSinhVien.add(new SinhVien("NguyenVV4" , "Vu Van Nguyen" , 12 , "HN2" , false));
        listSinhVien.add(new SinhVien("KhanhPG" , "Pham Gia Khanh" , 13 , "HN3" , true));
        listSinhVien.add(new SinhVien("TienNH21" , "Nguyen Hoang Tien" , 14 , "HN4" , false));
        listSinhVien.add(new SinhVien("DungNA29" , "Nguyen Anh Dung" , 15 , "HN5" , true));
    }

    public List<SinhVien> getAll(){
        return listSinhVien;
    }

    public void fakeData(ArrayList<SinhVien> listSinhVien){
        // Fill du lieu
    }

    // chuyen validate sang service => HashMap

    public void addSinhVien(SinhVien sv){
        listSinhVien.add(sv);
    }
}
