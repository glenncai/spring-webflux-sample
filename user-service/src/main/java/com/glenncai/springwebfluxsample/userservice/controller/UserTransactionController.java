package com.glenncai.springwebfluxsample.userservice.controller;

import com.glenncai.springwebfluxsample.userservice.dto.TransactionRequestDto;
import com.glenncai.springwebfluxsample.userservice.dto.TransactionResponseDto;
import com.glenncai.springwebfluxsample.userservice.entity.UserTransaction;
import com.glenncai.springwebfluxsample.userservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User transaction controller.
 *
 * @author Glenn Cai
 * @version 1.0 1/1/2024
 */
@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {

  private final TransactionService transactionService;

  @Autowired
  public UserTransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping
  public Mono<TransactionResponseDto> createTransaction(
      @RequestBody Mono<TransactionRequestDto> transactionRequestDto) {
    return transactionRequestDto.flatMap(this.transactionService::createTransaction);
  }

  @GetMapping
  public Flux<UserTransaction> getByUserId(@RequestParam("userId") int userId) {
    return this.transactionService.getByUserId(userId);
  }
}
