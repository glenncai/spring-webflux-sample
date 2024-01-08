package com.glenncai.springwebfluxsample.common.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Transaction request DTO.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Data
@NoArgsConstructor
public class TransactionRequestDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -7510028621102186210L;

  private Integer userId;

  private Integer amount;
}
