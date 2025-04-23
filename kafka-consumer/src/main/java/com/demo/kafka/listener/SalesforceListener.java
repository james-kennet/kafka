package com.demo.kafka.listener;

import com.demo.kafka.dto.TopicDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class SalesforceListener extends BaseListener {

	@Override
	protected String getListenerName() {
		return "Salesforce";
	}

	@KafkaListener(topics = "${topic.address.create.salesforce}",
			groupId = "${group.create.salesforce}",
			containerFactory = "salesforceCreateAddressListenerContainerFactory")
	public void salesforceListener(ConsumerRecord<String, TopicDto> record, Acknowledgment ack) throws JsonProcessingException {
		processMessage(record, ack);
	}
}
