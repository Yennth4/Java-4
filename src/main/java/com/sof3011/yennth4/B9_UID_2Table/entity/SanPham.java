package com.sof3011.yennth4.B9_UID_2Table.entity;

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

import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID idDongSP;

    private String ten;

    private int soLuongTon;

    private Double giaNhap;

    private Double giaBan;

    private String moTa;
}
