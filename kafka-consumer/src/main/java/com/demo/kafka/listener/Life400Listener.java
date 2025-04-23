package com.demo.kafka.listener;

import com.demo.kafka.dto.TopicDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Life400Listener extends BaseListener {

	@Override
	protected String getListenerName() {
		return "LIFE400";
	}

	@KafkaListener(topics = "${topic.address.create.life400}",
			groupId = "${group-create.life400}",
			containerFactory = "life400CreateAddressListenerContainerFactory")
	public void life400Listener(ConsumerRecord<String, TopicDto> record, Acknowledgment ack) throws JsonProcessingException {
		processMessage(record, ack);
	}

}
