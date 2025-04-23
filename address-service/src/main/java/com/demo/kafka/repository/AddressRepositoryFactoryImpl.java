package com.demo.kafka.repository;

import com.demo.kafka.entity.AddressLife400;
import com.demo.kafka.entity.AddressMobile;
import com.demo.kafka.entity.AddressSalesforce;
import com.demo.kafka.entity.AddressWebsite;
import com.demo.kafka.entity.BaseAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryFactoryImpl implements AddressRepositoryFactory {
  private final AddressLife400Repository life400Repo;
  private final AddressMobileRepository mobileRepo;
  private final AddressSalesforceRepository salesforceRepo;
  private final AddressWebsiteRepository websiteRepo;

  public AddressRepositoryFactoryImpl(
      AddressLife400Repository life400Repo,
      AddressMobileRepository mobileRepo,
      AddressSalesforceRepository salesforceRepo,
      AddressWebsiteRepository websiteRepo
  ) {
    this.life400Repo = life400Repo;
    this.mobileRepo = mobileRepo;
    this.salesforceRepo = salesforceRepo;
    this.websiteRepo = websiteRepo;
  }

  @Override
  public JpaRepository getRepository(Class<? extends BaseAddress> entityType) {
    if (entityType == AddressLife400.class) {
      return life400Repo;
    } else if (entityType == AddressMobile.class) {
      return mobileRepo;
    } else if (entityType == AddressSalesforce.class) {
      return salesforceRepo;
    } else if (entityType == AddressWebsite.class) {
      return websiteRepo;
    }
    throw new IllegalArgumentException("No repository found for type: " + entityType);
  }
}
