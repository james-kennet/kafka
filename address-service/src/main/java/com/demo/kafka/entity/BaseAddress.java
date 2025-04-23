package com.demo.kafka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Getter
@Setter
@MappedSuperclass
@Where(clause = "deleted = false")
public abstract class BaseAddress implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer customerId;

  private String unitNo;
  private String streetName;
  private String country;
  private String postalCode;
  private boolean deleted = false;
}
