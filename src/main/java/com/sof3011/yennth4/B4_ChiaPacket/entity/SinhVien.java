package com.sof3011.yennth4.B4_ChiaPacket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // constructor tùy ý

//@Data : ngang với import sao có tất cả getter , setter (cấm dùng)
public class SinhVien {

    private String mssv;

    private String ten;

    private int tuoi;

    private String diaChi;

    private Boolean gioiTinh;

}
