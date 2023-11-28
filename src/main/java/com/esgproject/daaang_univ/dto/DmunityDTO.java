package com.esgproject.daaang_univ.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class DmunityDTO {
    private Integer dmunityNo;
    private String userid;
    private int dmunityCategory;
    private String dmunityTitle;
    private String dmunityText;
    private Timestamp dmunityDate;
    private String dmunityFile;
    private int dmunityHit;
    private int dmunityLike;
    private Timestamp dmunityEditDate;
    private int dmunityComments;
}
