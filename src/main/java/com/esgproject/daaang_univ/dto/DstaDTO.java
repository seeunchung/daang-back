package com.esgproject.daaang_univ.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class DstaDTO {
    private Integer dstarNo;
    private String userid;
    private String dstarText;
    private String dstarTag;
    private String dstarThumbnail;
    private String dstarImg1;
    private String dstarImg2;
    private String dstarImg3;
    private String dstarImg4;
    private Timestamp dstarDate;
    private Timestamp dstarEditDate;
    private int dstarHit;
    private int dstarLike;
    private int dstarComment;
}
