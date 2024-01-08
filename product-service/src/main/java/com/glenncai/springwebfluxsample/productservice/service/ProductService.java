package com.glenncai.springwebfluxsample.productservice.service;

import com.glenncai.springwebfluxsample.common.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product service interface.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
public interface ProductService {

  Flux<ProductDto> getAllProducts();

  Mono<ProductDto> getProductById(String id);

  Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono);

  Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono);

  Mono<Void> deleteProduct(String id);

  Flux<ProductDto> getProductsByPriceRange(int min, int max);
}
