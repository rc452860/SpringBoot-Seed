package com.wind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//特别注意，CustomMapper不能被扫描到，否则会出错
@MapperScan(basePackages = "com.wind.mybatis.mapper")
public class SeedApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}
}
