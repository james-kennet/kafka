package com.demo.kafka.constant;

import java.util.Map;
import java.util.Set;

public class Constants {

	public static final String SALESFORCE_TOPIC = "ADDRESS_CREATE_SALESFORCE";
	public static final String MOBILE_TOPIC = "ADDRESS_CREATE_MOBILE";
	public static final String WEBSITE_TOPIC = "ADDRESS_CREATE_WEBSITE";
	public static final String LIFE400_TOPIC = "ADDRESS_CREATE_LIFE400";
	public static final String ALL_PLATFORM_IN_ONE_TOPIC = "ADDRESS_CREATE_ALL_PLATFORM";

	public static final Set<String> ALLOWED_TOPICS = Set.of(
			SALESFORCE_TOPIC,
			MOBILE_TOPIC,
			WEBSITE_TOPIC,
			LIFE400_TOPIC,
			ALL_PLATFORM_IN_ONE_TOPIC
	);

	public static final Map<String, String> SUCCESS_MESSAGES = Map.of(
			SALESFORCE_TOPIC, "Salesforce message was successfully published.",
			MOBILE_TOPIC, "Mobile app message was successfully published.",
			WEBSITE_TOPIC, "Website message was successfully published.",
			LIFE400_TOPIC, "LIFE400 message was successfully published.",
			ALL_PLATFORM_IN_ONE_TOPIC, "Unified message was successfully published."
	);

	public static final String ERROR_INVALID_TOPIC = "Invalid topic.";
	public static final String ERROR_PUBLISHING_MESSAGE = "An error was encountered when publishing a message";

}
