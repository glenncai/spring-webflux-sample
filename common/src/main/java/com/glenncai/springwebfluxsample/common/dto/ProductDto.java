package com.glenncai.springwebfluxsample.common.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product DTO.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
@Data
@NoArgsConstructor
public class ProductDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 5789024218606338561L;

  private String id;

  private String description;

  private Integer price;

  public ProductDto(String description, Integer price) {
    this.description = description;
    this.price = price;
  }
}
