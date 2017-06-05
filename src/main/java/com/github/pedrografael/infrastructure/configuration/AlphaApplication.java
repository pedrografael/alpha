package com.github.pedrografael.infrastructure.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.github.pedrografael.domain.entity")
@ComponentScan("com.github.pedrografael")
@EnableJpaRepositories("com.github.pedrografael")
public class AlphaApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlphaApplication.class, args);
  }

}
