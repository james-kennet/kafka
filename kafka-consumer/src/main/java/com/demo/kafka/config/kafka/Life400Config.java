package com.demo.kafka.config.kafka;

import com.demo.kafka.dto.TopicDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class Life400Config extends BaseKafkaConfig<TopicDto> {

  @Value("${group-create.life400}")
  private String groupILife4000;

  @Bean
  public ConsumerFactory<String, TopicDto> life400ConsumerFactory() {
    return createConsumerFactory(groupILife4000, TopicDto.class);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, TopicDto>
  life400CreateAddressListenerContainerFactory() {
    return createListenerContainerFactory(life400ConsumerFactory());
  }

}
