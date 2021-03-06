package com.github.pedrografael.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
@Entity
@Table(name = "test")
public class TestEntity {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  private DateTime created;
  private DateTime updated;

}
