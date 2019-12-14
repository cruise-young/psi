package com.hy.psicrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author CruiseYoung
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.hy.psicrm.sys.mapper"})
public class PsicrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsicrmApplication.class, args);
	}

}
