package com.glenncai.springwebfluxsample.userservice.dto;

import com.glenncai.springwebfluxsample.userservice.enums.TransactionStatus;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Transaction response DTO.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Data
@NoArgsConstructor
public class TransactionResponseDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -8618474313194267368L;

  private Integer userId;

  private Integer amount;

  private TransactionStatus status;
}
