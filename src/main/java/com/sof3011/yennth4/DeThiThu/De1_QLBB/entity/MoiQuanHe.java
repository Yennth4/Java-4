package com.sof3011.yennth4.DeThiThu.De1_QLBB.entity;

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
@Table(name = "moiquanhe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoiQuanHe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ma;

    private String ten;
}
