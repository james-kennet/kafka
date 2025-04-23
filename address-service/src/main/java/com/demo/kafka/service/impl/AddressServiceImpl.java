package com.demo.kafka.service.impl;

import com.demo.kafka.constant.TransactionStatus;
import com.demo.kafka.dao.AddressDao;
import com.demo.kafka.dto.Address;
import com.demo.kafka.entity.AddressTransaction;
import com.demo.kafka.entity.BaseAddress;
import com.demo.kafka.service.AddressService;
import com.demo.kafka.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

  private final AddressDao addressDao;
  private final EntityMapper entityMapper;

  @Override
  public void save(Address address) {
    LOGGER.info("Start of address service layer execution");
    saveClientAddress(address);
    saveTransactionRecord(address);
    LOGGER.info("End of address service layer execution");
  }

  private void saveClientAddress(Address address) {
    BaseAddress entity = switch (address.clientType()) {
      case SALESFORCE -> entityMapper.toSalesforce(address);
      case MOBILE -> entityMapper.toMobile(address);
      case WEBSITE -> entityMapper.toWebsite(address);
      case LIFE400 -> entityMapper.toLife400(address);
    };
    addressDao.saveClientAddress(entity);
  }

  private void saveTransactionRecord(Address address) {
    AddressTransaction transaction = entityMapper.toTransaction(address);
    transaction.setStatus(TransactionStatus.CREATED);
    addressDao.saveTransaction(transaction);
  }
}
