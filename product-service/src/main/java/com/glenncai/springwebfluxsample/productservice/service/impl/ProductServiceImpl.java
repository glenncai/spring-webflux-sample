package com.glenncai.springwebfluxsample.productservice.service.impl;

import com.glenncai.springwebfluxsample.productservice.dto.ProductDto;
import com.glenncai.springwebfluxsample.productservice.repository.ProductRepository;
import com.glenncai.springwebfluxsample.productservice.service.ProductService;
import com.glenncai.springwebfluxsample.productservice.util.EntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product service implementation.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Transactional
  public Flux<ProductDto> getAllProducts() {
    return this.productRepository.findAll().map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<ProductDto> getProductById(String id) {
    return this.productRepository.findById(id).map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono) {
    return productDtoMono
        .map(EntityDtoUtil::convertToEntity)
        .flatMap(this.productRepository::insert)
        .map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
    return this.productRepository
        .findById(id)
        .flatMap(product -> productDtoMono.map(EntityDtoUtil::convertToEntity)
                                          .doOnNext(e -> e.setId(id)))
        .flatMap(this.productRepository::save)
        .map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<Void> deleteProduct(String id) {
    return this.productRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Flux<ProductDto> getProductsByPriceRange(int min, int max) {
    return this.productRepository.findByPriceBetween(Range.closed(min, max))
                                 .map(EntityDtoUtil::convertToDto);
  }
}
