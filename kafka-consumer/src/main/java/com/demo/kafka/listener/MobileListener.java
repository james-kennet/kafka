package com.demo.kafka.listener;

import com.demo.kafka.dto.TopicDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MobileListener extends BaseListener {

	@Override
	protected String getListenerName() {
		return "Mobile";
	}

	@KafkaListener(topics = "${topic.address.create.mobile}",
			groupId = "${group.create.mobile}",
			containerFactory = "mobileCreateAddressListenerContainerFactory")
	public void mobileListener(ConsumerRecord<String, TopicDto> record, Acknowledgment ack) throws JsonProcessingException {
		processMessage(record, ack);
	}

}
