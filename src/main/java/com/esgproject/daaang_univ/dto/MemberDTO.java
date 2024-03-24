package com.esgproject.daaang_univ.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
 private String userid;
 private String userpwd;
 private String username;
 private String email;
 private String tel;
 private Timestamp joindate;
}
