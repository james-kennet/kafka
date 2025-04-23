package com.demo.kafka.listener;

import com.demo.kafka.dto.TopicDto;
import com.demo.kafka.service.ExecuteAddressService;
import com.demo.kafka.util.JsonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.Acknowledgment;

public abstract class BaseListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(BaseListener.class);

  @Autowired
  protected ExecuteAddressService executeAddressService;

  protected abstract String getListenerName();

  protected void processMessage(ConsumerRecord<String, TopicDto> record, Acknowledgment ack) throws JsonProcessingException {
    LOGGER.info("record offset:{} partition:{}", record.offset(), record.partition());
    LOGGER.info("{} ADDRESS topic: {}", getListenerName(), JsonUtility.objectToJson(record.value()));

    try {
      ack.acknowledge();
      LOGGER.info("{} ADDRESS after ack.acknowledge() record.value().getAddress(): {}", getListenerName(), record.value().getAddress());
      executeAddressService.callService(record.value().getAddress());
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }

}
