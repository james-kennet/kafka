package com.demo.kafka.controller;

import com.demo.kafka.dto.Address;
import com.demo.kafka.service.AddressService;
import com.demo.kafka.util.JsonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AddressController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	private final AddressService addressService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createAddress(@RequestBody @Valid Address address) throws JsonProcessingException {
		LOGGER.info("Received address creation request: {}", JsonUtility.objectToJson(address));
		addressService.save(address);
		LOGGER.info("Successfully processed address for customer {}", address.customerId());
	}

}
