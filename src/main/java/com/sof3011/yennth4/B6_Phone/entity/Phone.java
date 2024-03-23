package com.sof3011.yennth4.B6_Phone.entity;

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
public class Phone {

    private String ten;

    private String gia;

    private String hang;

    private String mauSac;

}