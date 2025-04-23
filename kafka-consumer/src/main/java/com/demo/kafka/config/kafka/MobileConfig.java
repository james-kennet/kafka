package com.demo.kafka.config.kafka;

import com.demo.kafka.dto.TopicDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class MobileConfig extends BaseKafkaConfig<TopicDto> {

  @Value("${group.create.mobile}")
  private String groupMobile;

  @Bean
  public ConsumerFactory<String, TopicDto> mobileConsumerFactory() {
    return createConsumerFactory(groupMobile, TopicDto.class);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, TopicDto>
  mobileCreateAddressListenerContainerFactory() {
    return createListenerContainerFactory(mobileConsumerFactory());
  }

}
