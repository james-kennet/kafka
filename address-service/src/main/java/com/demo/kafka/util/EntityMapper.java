package com.demo.kafka.util;

import com.demo.kafka.dto.Address;
import com.demo.kafka.entity.AddressLife400;
import com.demo.kafka.entity.AddressMobile;
import com.demo.kafka.entity.AddressSalesforce;
import com.demo.kafka.entity.AddressTransaction;
import com.demo.kafka.entity.AddressWebsite;
import com.demo.kafka.entity.BaseAddress;
import java.util.function.Supplier;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

  public AddressSalesforce toSalesforce(Address address) {
    return copyToEntity(address, AddressSalesforce::new);
  }

  public AddressMobile toMobile(Address address) {
    return copyToEntity(address, AddressMobile::new);
  }

  public AddressWebsite toWebsite(Address address) {
    return copyToEntity(address, AddressWebsite::new);
  }

  public AddressLife400 toLife400(Address address) {
    return copyToEntity(address, AddressLife400::new);
  }

  private <T extends BaseAddress> T copyToEntity(Address source, Supplier<T> constructor) {
    T entity = constructor.get();
    BeanUtils.copyProperties(source, entity, "status", "clientType");
    return entity;
  }

  public AddressTransaction toTransaction(Address address) {
    AddressTransaction transaction = new AddressTransaction();
    BeanUtils.copyProperties(address, transaction);
    return transaction;
  }
}
