package com.sof3011.yennth4.Asm1.entity;

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
public class Movie {

    private String id;

    private String title;

    private String description;

    private Boolean active;

    private String poster;

}
