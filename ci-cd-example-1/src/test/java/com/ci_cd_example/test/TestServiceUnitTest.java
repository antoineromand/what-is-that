package com.ci_cd_example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestServiceUnitTest {

  private final TestService testService = new TestService();

  @Test
  public void shouldReturnParameterInString() {
    int parameter = 3;
    String expectedResult = "3";

    String result = this.testService.convertToString(parameter);
    Assertions.assertNotEquals("3   ", result);
    Assertions.assertEquals(expectedResult, result);
  }

  @Test
  public void shouldReturnHelloWorld() {
    String expectedResult = "Hello World!";

    String result = this.testService.returnHelloWorld();

    Assertions.assertEquals(expectedResult, result);
  }
}
