package com.github.pedrografael.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pedrografael.domain.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long>{

}
