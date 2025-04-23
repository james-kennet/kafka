package com.demo.kafka.controller;

import com.demo.kafka.constant.Constants;
import com.demo.kafka.dto.TopicDto;
import com.demo.kafka.service.ProducerService;
import com.demo.kafka.util.JsonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AddressProducerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddressProducerController.class);

  @Autowired
  private ProducerService<TopicDto> producerService;

  @PostMapping("/publish")
  public ResponseEntity<String> publishAddress(@Valid @RequestBody TopicDto topicDto)
      throws JsonProcessingException {

    final String requestedTopic = topicDto.getTopicName();
    LOGGER.info("Publishing request for topic {}: {}", requestedTopic,
        JsonUtility.objectToJson(topicDto));

    if (!Constants.ALLOWED_TOPICS.contains(requestedTopic)) {
      LOGGER.warn("Invalid topic attempt: {}", requestedTopic);
      return ResponseEntity.badRequest().body(Constants.ERROR_INVALID_TOPIC);
    }

    try {
      producerService.send(requestedTopic, topicDto);
      return ResponseEntity.accepted().body(Constants.SUCCESS_MESSAGES.get(requestedTopic));

    } catch (Exception e) {
      LOGGER.error("Kafka publish failed for topic {}: {}", requestedTopic, e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(Constants.ERROR_PUBLISHING_MESSAGE);
    }
  }
}
