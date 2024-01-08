package com.glenncai.springwebfluxsample.productservice.service;

import com.glenncai.springwebfluxsample.common.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Mongo DB data setup service.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Slf4j
@Service
public class DataSetupService implements CommandLineRunner {

  private final ProductService productService;

  @Autowired
  public DataSetupService(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public void run(String... args) {
    ProductDto p1 = new ProductDto("4k-tv", 1000);
    ProductDto p2 = new ProductDto("iPhone 15 Pro Max", 2000);
    ProductDto p3 = new ProductDto("MacBook Pro 2023", 3000);
    ProductDto p4 = new ProductDto("Apple Watch 2023", 500);
    ProductDto p5 = new ProductDto("iPad Pro 2023", 800);
    ProductDto p6 = new ProductDto("AirPods Pro 2023", 300);
    ProductDto p7 = new ProductDto("HomePod 2023", 400);

    Flux.just(p1, p2, p3, p4, p5, p6, p7)
        .flatMap(p -> this.productService.insertProduct(Mono.just(p)))
        .subscribe(
            p -> log.info("Product {} is created.", p.getDescription()),
            e -> log.error("Create product failed.", e),
            () -> log.info("Product setup finished."));
  }
}
