package com.sof3011.yennth4.BTVN.BTVN_B12.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sinh_vien")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tuoi")
    private Long tuoi;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "lop_id")
    private int lopID;

}
