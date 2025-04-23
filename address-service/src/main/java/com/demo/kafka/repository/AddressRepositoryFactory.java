package com.demo.kafka.repository;

import com.demo.kafka.entity.BaseAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryFactory {
  JpaRepository getRepository(Class<? extends BaseAddress> entityType);
}
