package com.demo.kafka.dto;

import com.demo.kafka.constant.ClientType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Address(

		@NotNull(message = "customerId is mandatory")
		Integer customerId,

		@NotEmpty(message = "unitNo is mandatory")
		String unitNo,

		String streetName,

		@NotEmpty(message = "country is mandatory")
		String country,

		@NotEmpty(message = "postalCode is mandatory")
		String postalCode,

		ClientType clientType,
		String status
) {}