package com.sof3011.yennth4.BTVN.Buoi4_GiangVien.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiangVien {
    private String id;
    private String ma;
    private String ten;
    private int tuoi;
    private Boolean gioiTinh;
    private String diaChi;
}
