package com.glenncai.springwebfluxsample.common.dto;

import com.glenncai.springwebfluxsample.common.enums.OrderStatus;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * Purchase order response dto.
 *
 * @author Glenn Cai
 * @version 1.0 3/1/2024
 */
@Data
public class PurchaseOrderResponseDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 5381848523622232899L;

  private Integer orderId;

  private Integer userId;

  private String productId;

  private Integer amount;

  private OrderStatus status;
}
