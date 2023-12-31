package com.glenncai.springwebfluxsample.productservice.repository;

import com.glenncai.springwebfluxsample.productservice.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Product repository.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

  Flux<Product> findByPriceBetween(Range<Integer> range);
}
