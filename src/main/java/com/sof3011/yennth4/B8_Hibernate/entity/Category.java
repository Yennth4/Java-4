package com.sof3011.yennth4.B8_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Category {
    /**
     * J3 : truy van sql - JDBC
     * J4 :- Hibernate
     *          : Truy van SQL (nhanh hơn bất cứ loại truy vấn nào)
     *      hoặc => Truy vấn HQL(Hibernate Query Language) : truy vấn trên class (thực thể)
     *
     *  J5 : JPA (đi từ Hibernate đi lên)
     *      => Truy van SQL (native query)
     *      => Truy van JPQL (JPA Query Language) => Truy van tren thuc the (class)
     *
     *  ORM (Object Relationship Mapping) :
     *      - Class : thành 1 bảng - bao nhiêu bảng bấy nhiêu class
     *      - Column :
     *          + Khoa chinh
     *          + Khoa phu
     *          + Column thường
     */

    @Id
    @Column() // trung ten id nen khong can name
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID : tu tang
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;


}
