package com.sof3011.yennth4.B7_De1_SanPham.entity;

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
public class SanPham {

    private int id;

    private String ma;

    private String ten;

    private String loai;

    private int gia;

}
