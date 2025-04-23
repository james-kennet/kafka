package com.demo.kafka.service.impl;

import com.demo.kafka.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl<T> implements ProducerService<T> {

	private final KafkaTemplate<String, T> kafkaTemplate;

	@Override
	public void send(String topic, T message) {
		kafkaTemplate.send(topic, message);
	}

}
