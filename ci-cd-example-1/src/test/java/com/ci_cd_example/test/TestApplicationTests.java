package com.ci_cd_example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

  @Test
  void contextLoads() {
    assertThat(true).isTrue();
  }

  @Test
  void mainMethodRunsWithoutException() {
    assertDoesNotThrow(() -> TestApplication.main(new String[] {}));
  }
}
