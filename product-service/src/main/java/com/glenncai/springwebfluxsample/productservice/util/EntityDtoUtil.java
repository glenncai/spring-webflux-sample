package com.glenncai.springwebfluxsample.productservice.util;

import com.glenncai.springwebfluxsample.common.dto.ProductDto;
import com.glenncai.springwebfluxsample.productservice.entity.Product;
import org.springframework.beans.BeanUtils;

/**
 * Entity and Dto convert util.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
public class EntityDtoUtil {

  private EntityDtoUtil() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Convert Product entity to Product dto.
   *
   * @param product Product entity
   * @return Product dto
   */
  public static ProductDto convertToDto(Product product) {
    ProductDto productDto = new ProductDto();
    BeanUtils.copyProperties(product, productDto);
    return productDto;
  }

  /**
   * Convert Product dto to Product entity.
   *
   * @param productDto Product dto
   * @return Product entity
   */
  public static Product convertToEntity(ProductDto productDto) {
    Product product = new Product();
    BeanUtils.copyProperties(productDto, product);
    return product;
  }
}
