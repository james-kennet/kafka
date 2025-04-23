package com.demo.kafka.service;

public interface ProducerService<T> {

	void send(String topic, T message);
}
