package com.sof3011.yennth4.Lab.Lab6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {

    @Id
    @Column(name = "MaKH")
    private  String maKH;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "DienThoai")
    private String dienThoai;

    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "TrangThai")
    private Boolean trangThai;
}
