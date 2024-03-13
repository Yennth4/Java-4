package com.sof3011.yennth4.B5_FormPacket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private String ten;
    private Date tuoi;
    private String gioiTinh;
    private Boolean ketHon;
    private String quocGia;
    private String[] soThich;
    private String moTa;
}
