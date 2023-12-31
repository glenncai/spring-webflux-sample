package com.glenncai.springwebfluxsample.productservice.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Product Entity.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
@Data
public class Product implements Serializable {

  @Serial
  private static final long serialVersionUID = -3697724367959671957L;

  @Id
  private String id;

  private String description;

  private Integer price;
}
