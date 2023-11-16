package com.esgproject.daaang_univ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.esgproject.daaang_univ")
public class DAaaNgUnivApplication {

	public static void main(String[] args) {
		SpringApplication.run(DAaaNgUnivApplication.class, args);
	}

}
