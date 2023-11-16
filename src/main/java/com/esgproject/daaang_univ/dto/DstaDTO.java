package com.esgproject.daaang_univ.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DstaDTO {
    private Integer dstar_no;
    private String userid;
    private String dstar_text;
    private String dstar_thumbnail;
    private String dstar_img1;
    private String dstar_img2;
    private String dstar_img3;
    private String dstar_img4;
    private java.sql.Timestamp dstar_date;
    private int dstar_hit;
    private int dstar_like;
    private java.sql.Timestamp dstar_edit_date;
}