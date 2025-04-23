package com.demo.kafka.config.kafka;

import com.demo.kafka.dto.TopicDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class WebsiteConfig extends BaseKafkaConfig<TopicDto> {

	@Value("${group.create.website}")
	private String groupWebsite;

	@Bean
	public ConsumerFactory<String, TopicDto> websiteConsumerFactory() {
		return createConsumerFactory(groupWebsite, TopicDto.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TopicDto>
	websiteCreateAddressListenerContainerFactory() {
		return createListenerContainerFactory(websiteConsumerFactory());
	}

}
