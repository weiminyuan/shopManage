package com.ywm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ServletComponentScan
public class ShopManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopManageApplication.class, args);
	}
}
