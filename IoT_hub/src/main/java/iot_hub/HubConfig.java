package iot_hub;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HubConfig {

	private final int httpPort;
	private final String mqttBroker;
	private final String mqttClientId;
	private final String mqttTopicPrefix;
	private final String databaseFileName;

	@JsonCreator
	public HubConfig(
		@JsonProperty(value = "httpPort", required = true) int httpPort,
		@JsonProperty(value = "mqttBroker", required = true) String mqttBroker,
		@JsonProperty(value = "mqttClientId", required = true) String mqttClientId,
		@JsonProperty(value = "mqttTopicPrefix", required = true) String mqttTopicPrefix,
		@JsonProperty(value = "databaseFileName", required = true) String databaseFileName) {
		this.httpPort = httpPort;
		this.mqttBroker = mqttBroker;
		this.mqttClientId = mqttClientId;
		this.mqttTopicPrefix = mqttTopicPrefix;
		this.databaseFileName = databaseFileName;
	}

	public int getHttpPort() {
		return httpPort;
	}

	public String getMqttBroker() {
		return mqttBroker;
	}

	public String getMqttClientId() {
		return mqttClientId;
	}

	public String getMqttTopicPrefix() {
		return mqttTopicPrefix;
	}

	public String getDatabaseFileName() {
		return databaseFileName;
	}
}
