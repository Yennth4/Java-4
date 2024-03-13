package com.sof3011.yennth4.BTVN.Buoi4_GiangVien.service;

import com.sof3011.yennth4.BTVN.Buoi4_GiangVien.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    List<GiangVien> listSinhVien = new ArrayList<>();

    public GiangVienService() {

        // Fill du lieu
        listSinhVien.add(new GiangVien("1","HangNT169","Tao",3,false,"DongBang"));
        listSinhVien.add(new GiangVien("20","NguyenVV4","Cam",5,true,"DongBang1"));
        listSinhVien.add(new GiangVien("12","PhongTT35","Nhan",2,true,"DongBang2"));
        listSinhVien.add(new GiangVien("14","KhanhPG","Vai",7,true,"DongBang3"));
        listSinhVien.add(new GiangVien("15","TienNH21","Xoai",4,true,"DongBang4"));
        listSinhVien.add(new GiangVien("13","NganCT4","Mit",1,false,"DongBang5"));
    }

    public List<GiangVien> getAll(){
        return listSinhVien;
    }

    public void addGV(GiangVien gv) {
        listSinhVien.add(gv);
    }

    public void search(String ten) {
        for (GiangVien gv : listSinhVien) {
            if (ten.equalsIgnoreCase(gv.getTen())){
//                listSinhVien.add
            }
        }
    }
}
