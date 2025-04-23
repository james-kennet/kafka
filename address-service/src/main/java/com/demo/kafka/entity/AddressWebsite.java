package com.demo.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_website")
public class AddressWebsite extends BaseAddress {}