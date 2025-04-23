package com.demo.kafka.listener;

import com.demo.kafka.dto.TopicDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class WebsiteListener extends BaseListener {

	@Override
	protected String getListenerName() {
		return "Website";
	}

	@KafkaListener(topics = "${topic.address.create.website}",
			groupId = "${group.create.website}",
			containerFactory = "websiteCreateAddressListenerContainerFactory")
	public void websiteListener(ConsumerRecord<String, TopicDto> record, Acknowledgment ack) throws JsonProcessingException {
		processMessage(record, ack);
	}

}
