package com.glenncai.springwebfluxsample.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Product Service Application.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
@SpringBootApplication
@ComponentScan("com.glenncai.springwebfluxsample")
public class ProductServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProductServiceApplication.class, args);
  }
}
