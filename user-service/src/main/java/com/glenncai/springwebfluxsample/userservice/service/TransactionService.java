package com.glenncai.springwebfluxsample.userservice.service;

import com.glenncai.springwebfluxsample.userservice.dto.TransactionRequestDto;
import com.glenncai.springwebfluxsample.userservice.dto.TransactionResponseDto;
import com.glenncai.springwebfluxsample.userservice.entity.UserTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Transaction service interface.
 *
 * @author Glenn Cai
 * @version 1.0 1/1/2024
 */
public interface TransactionService {

  Mono<TransactionResponseDto> createTransaction(TransactionRequestDto transactionRequestDto);

  Flux<UserTransaction> getByUserId(int userId);
}
