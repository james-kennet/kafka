package com.demo.kafka.config;

import com.demo.kafka.dto.TopicDto;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class AddressProducerConfig {

  @Value("${spring.kafka.producer.bootstrap-servers}")
  private String bootstrapAddress;

  @Bean
  public ProducerFactory<String, TopicDto> producerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
        bootstrapAddress);
    props.put(
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        StringSerializer.class.getName());
    props.put(
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        JsonSerializer.class.getName());
    return new DefaultKafkaProducerFactory<String, TopicDto>(props);
  }

  @Bean
  public KafkaTemplate<String, TopicDto>
  kafkaTemplate() {
    return new KafkaTemplate<String, TopicDto>(producerFactory());
  }

}
