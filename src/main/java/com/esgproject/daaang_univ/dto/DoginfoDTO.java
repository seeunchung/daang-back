package com.esgproject.daaang_univ.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoginfoDTO {
    private Integer doginfoNo;
    private String userId;
    private String doginfoName;
    private String doginfoType;
    private String doginfoBirth;
    private String doginfoMemo;
    private String dogImg;
}
