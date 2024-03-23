package com.sof3011.yennth4.B7_De1_SanPham.service;

import com.sof3011.yennth4.B7_De1_SanPham.entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {

    List<SanPham> listSP = new ArrayList<>();

    public SanPhamService() {

        listSP.add(new SanPham(1, "HangNT169", "Tao", "3", 1));
        listSP.add(new SanPham(2, "NguyenVV4", "Cam", "3", 2));
        listSP.add(new SanPham(3, "TienNH21", "Xoai", "3", 3));
        listSP.add(new SanPham(4, "NganCT4", "Mit", "3", 4));
        listSP.add(new SanPham(5, "PhongTT35", "Sau rieng", "3", 5));
    }

    public List<SanPham> getAll() {
        return listSP;
    }

    public void addSP(SanPham sanPham) {
        listSP.add(sanPham);
    }

    public void deleteSP(int id) {
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getId() == id) {
                listSP.remove(i);
            }
        }
    }

    public SanPham detailSP(int id) {
        for (SanPham sanPham : listSP) {
            if (sanPham.getId() == id) {
                return sanPham;
            }
        }
        return null;
    }

    public void editSP (SanPham sanPham) {
        for (SanPham sanPham1 : listSP) {
            if (sanPham.getId() == sanPham1.getId()){
                sanPham1.setMa(sanPham.getMa());
                sanPham1.setTen(sanPham.getTen());
                sanPham1.setLoai(sanPham.getLoai());
                sanPham1.setGia(sanPham.getGia());
            }
        }
    }
}
