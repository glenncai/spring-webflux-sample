package com.glenncai.springwebfluxsample.userservice.service;

import com.glenncai.springwebfluxsample.userservice.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User service interface.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
public interface UserService {

  Flux<UserDto> getAllUsers();

  Mono<UserDto> getUserById(int userId);

  Mono<UserDto> createUser(Mono<UserDto> userDtoMono);

  Mono<UserDto> updateUser(int userId, Mono<UserDto> userDtoMono);

  Mono<Void> deleteUser(int userId);
}
