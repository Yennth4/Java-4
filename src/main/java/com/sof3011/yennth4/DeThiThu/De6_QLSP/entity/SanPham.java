package com.sof3011.yennth4.DeThiThu.De6_QLSP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPham {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ma;

    private String ten;

    private Long giaBan;

    private int soLuong;

    @ManyToOne @JoinColumn(name = "IdLoaiSP")
    private LoaiSanPham loaiSanPham;
}
