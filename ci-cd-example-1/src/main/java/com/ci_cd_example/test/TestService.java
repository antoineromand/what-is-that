package com.ci_cd_example.test;

import org.springframework.stereotype.Service;

@Service
public final class TestService {
  public String convertToString(final int number) {
    return number + "";
  }

  public String returnHelloWorld() {
    return "Hello World!";
  }
}
