package com.glenncai.springwebfluxsample.userservice.service.impl;

import static com.glenncai.springwebfluxsample.userservice.util.EntityDtoUtil.convertToDto;
import static com.glenncai.springwebfluxsample.userservice.util.EntityDtoUtil.convertToEntity;

import com.glenncai.springwebfluxsample.userservice.dto.TransactionRequestDto;
import com.glenncai.springwebfluxsample.userservice.dto.TransactionResponseDto;
import com.glenncai.springwebfluxsample.userservice.entity.UserTransaction;
import com.glenncai.springwebfluxsample.userservice.enums.TransactionStatus;
import com.glenncai.springwebfluxsample.userservice.repository.UserRepository;
import com.glenncai.springwebfluxsample.userservice.repository.UserTransactionRepository;
import com.glenncai.springwebfluxsample.userservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Transaction service implementation.
 *
 * @author Glenn Cai
 * @version 1.0 1/1/2024
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

  private final UserRepository userRepository;

  private final UserTransactionRepository userTransactionRepository;

  @Autowired
  public TransactionServiceImpl(UserRepository userRepository,
                                UserTransactionRepository userTransactionRepository) {
    this.userRepository = userRepository;
    this.userTransactionRepository = userTransactionRepository;
  }

  @Override
  @Transactional
  public Mono<TransactionResponseDto> createTransaction(
      TransactionRequestDto transactionRequestDto) {
    return this.userRepository.updateUserBalance(transactionRequestDto.getUserId(),
                                                 transactionRequestDto.getAmount())
                              .filter(Boolean::booleanValue)
                              .map(b -> convertToEntity(transactionRequestDto))
                              .flatMap(this.userTransactionRepository::save)
                              .map(ut -> convertToDto(transactionRequestDto,
                                                      TransactionStatus.APPROVED))
                              .defaultIfEmpty(
                                  convertToDto(transactionRequestDto, TransactionStatus.DECLINED));
  }

  @Override
  @Transactional
  public Flux<UserTransaction> getByUserId(int userId) {
    return this.userTransactionRepository.findByUserId(userId);
  }
}
