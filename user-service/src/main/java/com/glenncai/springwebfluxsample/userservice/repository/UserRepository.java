package com.glenncai.springwebfluxsample.userservice.repository;

import com.glenncai.springwebfluxsample.userservice.entity.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * User repository interface.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

  @Modifying
  @Query("UPDATE users SET balance = balance - :amount WHERE id = :userId AND balance >= :amount")
  Mono<Boolean> updateUserBalance(int userId, int amount);
}
