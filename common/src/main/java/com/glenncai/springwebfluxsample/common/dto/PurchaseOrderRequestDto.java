package com.glenncai.springwebfluxsample.common.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * Purchase order request dto.
 *
 * @author Glenn Cai
 * @version 1.0 3/1/2024
 */
@Data
public class PurchaseOrderRequestDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -3333576137717285278L;

  private Integer userId;

  private String productId;
}
