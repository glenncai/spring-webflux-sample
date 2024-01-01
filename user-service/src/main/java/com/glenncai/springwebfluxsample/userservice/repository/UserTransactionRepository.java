package com.glenncai.springwebfluxsample.userservice.repository;

import com.glenncai.springwebfluxsample.userservice.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * User transaction repository interface.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Repository
public interface UserTransactionRepository
    extends ReactiveCrudRepository<UserTransaction, Integer> {
  Flux<UserTransaction> findByUserId(int userId);
}
