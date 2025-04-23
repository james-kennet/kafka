package com.demo.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_salesforce")
public class AddressSalesforce extends BaseAddress {}