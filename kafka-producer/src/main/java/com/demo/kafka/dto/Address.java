package com.demo.kafka.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Address {

	@NotNull(message = "customerId is mandatory")
	private Integer customerId;

	@NotEmpty(message = "Address unit number is mandatory")
	private String unitNo;

	@NotEmpty(message = "Address country is mandatory")
	private String country;

	@NotEmpty(message = "Address postal code is mandatory")
	private String postalCode;

	private String streetName;

	@NotEmpty(message = "Client type is mandatory")
	private String clientType;

}
