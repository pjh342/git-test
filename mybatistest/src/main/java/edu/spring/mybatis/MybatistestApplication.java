package edu.spring.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import product.ProductDAO;
import product.ProductVO;

@SpringBootApplication
@ComponentScan(basePackageClasses = ProductVO.class)
@MapperScan(basePackageClasses = ProductDAO.class)
public class MybatistestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatistestApplication.class, args);
	}

}
