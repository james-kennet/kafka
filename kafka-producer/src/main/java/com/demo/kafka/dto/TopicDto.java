package com.demo.kafka.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TopicDto {

	@NotEmpty(message = "Topic cannot be empty")
	private String topicName;

	@Valid
	private Address address;
}
