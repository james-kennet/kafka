package com.demo.kafka.repository;

import com.demo.kafka.entity.AddressSalesforce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressSalesforceRepository extends JpaRepository<AddressSalesforce, Integer> {}