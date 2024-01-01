package com.glenncai.springwebfluxsample.userservice.service.impl;

import com.glenncai.springwebfluxsample.userservice.dto.UserDto;
import com.glenncai.springwebfluxsample.userservice.repository.UserRepository;
import com.glenncai.springwebfluxsample.userservice.service.UserService;
import com.glenncai.springwebfluxsample.userservice.util.EntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User service implementation.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public Flux<UserDto> getAllUsers() {
    return this.userRepository.findAll().map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<UserDto> getUserById(int userId) {
    return this.userRepository.findById(userId).map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
    return userDtoMono.map(EntityDtoUtil::convertToEntity)
                      .flatMap(this.userRepository::save)
                      .map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<UserDto> updateUser(int userId, Mono<UserDto> userDtoMono) {
    return this.userRepository.findById(userId)
                              .flatMap(u -> userDtoMono.map(EntityDtoUtil::convertToEntity)
                                                       .doOnNext(e -> e.setId(userId)))
                              .flatMap(this.userRepository::save)
                              .map(EntityDtoUtil::convertToDto);
  }

  @Override
  @Transactional
  public Mono<Void> deleteUser(int userId) {
    return this.userRepository.deleteById(userId);
  }
}
