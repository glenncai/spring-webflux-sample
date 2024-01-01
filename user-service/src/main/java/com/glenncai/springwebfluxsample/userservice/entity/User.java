package com.glenncai.springwebfluxsample.userservice.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * User entity.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Data
@Table("users")
public class User implements Serializable {

  @Serial
  private static final long serialVersionUID = 8047881568404973482L;

  @Id
  private Integer id;

  private String name;

  private Integer balance;
}
