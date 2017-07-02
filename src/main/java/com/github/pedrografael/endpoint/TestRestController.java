package com.github.pedrografael.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pedrografael.application.service.TestService;

@RestController
@RequestMapping("/test")
public class TestRestController {

  private TestService testService;
  
  @Autowired
  public TestRestController(TestService testService) {
    this.testService = testService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public void test() {

    testService.create();

  }

}
