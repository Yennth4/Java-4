package com.sof3011.yennth4.DeThiThu.De2_QLBB.entity;

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
@Table(name = "Ban")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ma;

    private String ten;

    private String soThich;

    private int gioiTinh;

    @ManyToOne @JoinColumn(name = "idmqh")
    private MoiQuanHe moiQuanHe;
}
