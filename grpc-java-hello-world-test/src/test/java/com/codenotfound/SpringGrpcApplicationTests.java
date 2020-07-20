package com.codenotfound;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.codenotfound.grpc.HelloWorldClient;

// try
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(SpringGrpcApplicationTests.class);

  @Autowired
  private HelloWorldClient helloWorldClient;

  @Test
  public void testSayHello() {
    LOGGER.info("TEST Greeting: {}", helloWorldClient.sayHello("John", "Doe"));
    //assertThat(helloWorldClient.sayHello("John", "Doe")).isEqualTo("Hello John Doe!");
    LOGGER.info("TEST: {} is a palindrome of {}", helloWorldClient.palindrome("John"), "John");
    LOGGER.info("TEST: {} is a palindrome of {}", helloWorldClient.palindrome("John Doe"), "John Doe");
    LOGGER.info("TEST: {} is a palindrome of {}", helloWorldClient.palindrome("I am good!"), "I am good!");
    LOGGER.info("TEST: {} is a palindrome of {}", helloWorldClient.palindrome("Bye Bye"), "Bye Bye");
  }
}
