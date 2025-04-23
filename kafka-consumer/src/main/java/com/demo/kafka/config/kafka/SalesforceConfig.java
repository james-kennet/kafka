package com.demo.kafka.config.kafka;

import com.demo.kafka.dto.TopicDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class SalesforceConfig extends BaseKafkaConfig<TopicDto> {

	@Value("${group.create.salesforce}")
	private String groupSalesforce;

	@Bean
	public ConsumerFactory<String, TopicDto> salesforceConsumerFactory() {
		return createConsumerFactory(groupSalesforce, TopicDto.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TopicDto>
	salesforceCreateAddressListenerContainerFactory() {
		return createListenerContainerFactory(salesforceConsumerFactory());
	}

}
