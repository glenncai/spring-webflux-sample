package com.glenncai.springwebfluxsample.productservice.controller;

import com.glenncai.springwebfluxsample.common.dto.ProductDto;
import com.glenncai.springwebfluxsample.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product controller.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Get all products.
   *
   * @return Product dto flux
   */
  @GetMapping("/all")
  public Flux<ProductDto> getAllProducts() {
    return productService.getAllProducts();
  }

  /**
   * Get product by id.
   *
   * @param id product id
   * @return Product dto
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable String id) {
    return productService.getProductById(id)
                         .map(ResponseEntity::ok)
                         .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Insert product.
   *
   * @param productDtoMono product dto mono
   * @return Product dto mono
   */
  @PostMapping
  public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDtoMono) {
    return productService.insertProduct(productDtoMono);
  }

  /**
   * Update product.
   *
   * @param id             product id
   * @param productDtoMono product dto mono
   * @return Product dto mono
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable String id,
                                                        @RequestBody
                                                        Mono<ProductDto> productDtoMono) {
    return productService.updateProduct(id, productDtoMono)
                         .map(ResponseEntity::ok)
                         .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Delete product.
   *
   * @param id product id
   * @return Void mono
   */
  @DeleteMapping("/{id}")
  public Mono<Void> deleteProduct(@PathVariable String id) {
    return productService.deleteProduct(id);
  }

  /**
   * Get products by price range.
   *
   * @param min min price
   * @param max max price
   * @return Product dto flux
   */
  @GetMapping("/price-range")
  public Flux<ProductDto> getProductsByPriceRange(@RequestParam("min") int min,
                                                  @RequestParam("max") int max) {
    return productService.getProductsByPriceRange(min, max);
  }
}
