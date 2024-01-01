package com.glenncai.springwebfluxsample.userservice.service;

import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

/**
 * Data initialization service.
 *
 * @author Glenn Cai
 * @version 1.0 1/1/2024
 */
@Slf4j
@Service
public class DataSetupService implements CommandLineRunner {

  private final R2dbcEntityTemplate r2dbcEntityTemplate;

  @Value("classpath:h2/init.sql")
  private Resource initSqlScript;

  @Autowired
  public DataSetupService(R2dbcEntityTemplate r2dbcEntityTemplate) {
    this.r2dbcEntityTemplate = r2dbcEntityTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    String query = StreamUtils.copyToString(initSqlScript.getInputStream(), StandardCharsets.UTF_8);
    log.info("Execute init sql script: {}", query);
    this.r2dbcEntityTemplate
        .getDatabaseClient()
        .sql(query)
        .then()
        .thenMany(
            this.r2dbcEntityTemplate.getDatabaseClient().sql("SELECT * FROM users").fetch().all())
        .doOnNext(row -> log.info("Init user: {}", row))
        .subscribe();
  }
}
