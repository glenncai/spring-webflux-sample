package com.glenncai.springwebfluxsample.userservice.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * User transaction entity.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Data
public class UserTransaction implements Serializable {

  @Serial
  private static final long serialVersionUID = -878116737452070623L;

  @Id
  private Integer id;

  private Integer userId;

  private Integer amount;

  private LocalDateTime transactionDate;
}
