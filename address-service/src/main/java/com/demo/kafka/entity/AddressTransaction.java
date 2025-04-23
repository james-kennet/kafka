package com.demo.kafka.entity;

import com.demo.kafka.constant.ClientType;
import com.demo.kafka.constant.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address_transaction")
public class AddressTransaction implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Integer customerId;

  @Enumerated(EnumType.STRING)
  private TransactionStatus status;

  private String unitNo;
  private String streetName;
  private String country;
  private String postalCode;

  @Enumerated(EnumType.STRING)
  private ClientType clientType;
}