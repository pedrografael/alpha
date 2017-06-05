package com.github.pedrografael.application.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pedrografael.domain.entity.TestEntity;
import com.github.pedrografael.infrastructure.repository.TestRepository;

@Service
public class TestService {

  private TestRepository testRepository;

  @Autowired
  public TestService(TestRepository testRepository) {
    super();
    this.testRepository = testRepository;
  }

  public void create() {

    TestEntity entity =
        new TestEntity().name("testName").created(DateTime.now()).updated(DateTime.now());

    testRepository.save(entity);

  }

}
