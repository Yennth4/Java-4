package com.sof3011.yennth4.Lab.Lab5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NhanVien {

    @Id
    @Column(name = "MaNV")
    private String ma;

    @Column(name = "HoTen")
    private String ten;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "PhongBan")
    private String phongBan;

    @Column(name = "Luong")
    private int luong;

}
