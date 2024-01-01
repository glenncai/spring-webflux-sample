package com.glenncai.springwebfluxsample.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * User Service Application.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@SpringBootApplication
@ComponentScan("com.glenncai.springwebfluxsample")
public class UserServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
}
