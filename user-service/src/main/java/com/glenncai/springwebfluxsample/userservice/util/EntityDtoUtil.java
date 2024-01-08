package com.glenncai.springwebfluxsample.userservice.util;

import com.glenncai.springwebfluxsample.common.dto.TransactionRequestDto;
import com.glenncai.springwebfluxsample.common.dto.TransactionResponseDto;
import com.glenncai.springwebfluxsample.common.dto.UserDto;
import com.glenncai.springwebfluxsample.common.enums.TransactionStatus;
import com.glenncai.springwebfluxsample.userservice.entity.User;
import com.glenncai.springwebfluxsample.userservice.entity.UserTransaction;
import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;

/**
 * Entity and Dto convert util.
 *
 * @author Glenn Cai
 * @version 1.0 30/12/2023
 */
public class EntityDtoUtil {

  private EntityDtoUtil() {
    throw new IllegalStateException("Utility class");
  }


  /**
   * Convert User entity to User dto.
   *
   * @param user User entity
   * @return User dto
   */
  public static UserDto convertToDto(User user) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }

  /**
   * Convert TransactionRequestDto and TransactionStatus to TransactionResponseDto.
   *
   * @param transactionRequestDto TransactionRequestDto
   * @param transactionStatus     TransactionStatus
   * @return TransactionResponseDto
   */
  public static TransactionResponseDto convertToDto(TransactionRequestDto transactionRequestDto,
                                                    TransactionStatus transactionStatus) {
    TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
    transactionResponseDto.setUserId(transactionRequestDto.getUserId());
    transactionResponseDto.setAmount(transactionRequestDto.getAmount());
    transactionResponseDto.setStatus(transactionStatus);
    return transactionResponseDto;
  }

  /**
   * Convert User dto to User entity.
   *
   * @param userDto User dto
   * @return User entity
   */
  public static User convertToEntity(UserDto userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  /**
   * Convert TransactionRequestDto to UserTransaction entity.
   *
   * @param transactionRequestDto TransactionRequestDto
   * @return UserTransaction entity
   */
  public static UserTransaction convertToEntity(TransactionRequestDto transactionRequestDto) {
    UserTransaction userTransaction = new UserTransaction();
    userTransaction.setUserId(transactionRequestDto.getUserId());
    userTransaction.setAmount(transactionRequestDto.getAmount());
    userTransaction.setTransactionDate(LocalDateTime.now());
    return userTransaction;
  }
}
