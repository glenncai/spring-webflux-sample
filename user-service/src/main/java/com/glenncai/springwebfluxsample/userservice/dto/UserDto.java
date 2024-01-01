package com.glenncai.springwebfluxsample.userservice.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User DTO.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Data
@NoArgsConstructor
public class UserDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 6977233816585138735L;

  private Integer id;

  private String name;

  private Integer balance;
}
