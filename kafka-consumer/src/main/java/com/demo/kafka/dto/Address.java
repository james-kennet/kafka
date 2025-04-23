package com.demo.kafka.dto;

import lombok.Data;

@Data
public class Address {

	private int customerId;
	private String unitNo;
	private String streetName;
	private String country;
	private String postalCode;
	private String clientType;

}
