package com.glenncai.springwebfluxsample.userservice.controller;

import com.glenncai.springwebfluxsample.common.dto.UserDto;
import com.glenncai.springwebfluxsample.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User controller.
 *
 * @author Glenn Cai
 * @version 1.0 31/12/2023
 */
@RestController
@RequestMapping("user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * Get all users.
   *
   * @return User dto flux
   */
  @GetMapping("/all")
  public Flux<UserDto> getAllUsers() {
    return this.userService.getAllUsers();
  }

  /**
   * Get user by id.
   *
   * @param userId user id
   * @return User dto mono
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<UserDto>> getUserById(@PathVariable("id") int userId) {
    return this.userService.getUserById(userId)
                           .map(ResponseEntity::ok)
                           .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Create user.
   *
   * @param userDtoMono user dto mono
   * @return User dto mono
   */
  @PostMapping
  public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDtoMono) {
    return this.userService.createUser(userDtoMono);
  }

  /**
   * Update user.
   *
   * @param userId      user id
   * @param userDtoMono user dto mono
   * @return User dto mono
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<UserDto>> updateUser(@PathVariable("id") int userId,
                                                  @RequestBody Mono<UserDto> userDtoMono) {
    return this.userService.updateUser(userId, userDtoMono)
                           .map(ResponseEntity::ok)
                           .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * Delete user.
   *
   * @param userId user id
   * @return Void mono
   */
  @DeleteMapping("/{id}")
  public Mono<Void> deleteUser(@PathVariable("id") int userId) {
    return this.userService.deleteUser(userId);
  }
}
