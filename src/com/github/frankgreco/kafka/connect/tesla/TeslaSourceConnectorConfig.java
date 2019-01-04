package com.github.frankgreco.kafka.connect.tesla;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.types.Password;

import java.util.List;
import java.util.Map;

public class TeslaSourceConnectorConfig extends AbstractConfig {

    public static final String KAFKA_TELEMETRY_TOPIC_PREFIX_CONF = "kafka.telemetry.topic_prefix";
    private static final String KAFKA_TELEMETRY_TOPIC_PREFIX_DOC = "Prefix that will be used in Kafka topic names.";

    public static final String TESLA_AUTH_EMAIL_CONF = "tesla.auth.email";
    private static final String TESLA_AUTH_EMAIL_DOC = "Email address associated with your Tesla account.";

    public static final String TESLA_AUTH_PASSWORD_CONF = "tesla.auth.password";
    private static final String TESLA_AUTH_PASSWORD_DOC = "Password associated with your Tesla account.";

    public static final String TESLA_AUTH_CLIENT_ID_CONF = "tesla.auth.client_id";
    private static final String TESLA_AUTH_CLIENT_ID_DOC = "Client id used to authenticated to the Tesla API.";

    public static final String TESLA_AUTH_CLIENT_SECRET_CONF = "tesla.auth.client_secret";
    private static final String TESLA_AUTH_CLIENT_SECRET_DOC = "Client secret used to authenticated to the Tesla API.";

    public static final String TESLA_VEHICLE_NAMES_CONF = "tesla.vehicle.names";
    private static final String TESLA_VEHICLE_NAMES_DOC = "List of vehicle names for which telemetry data will be captured.";

    public TeslaSourceConnectorConfig(Map<String, String> parsedConfig) {
        super(conf(), parsedConfig);
    }

    public static ConfigDef conf() {
        return new ConfigDef()
                .define(KAFKA_TELEMETRY_TOPIC_PREFIX_CONF, Type.STRING, Importance.HIGH, KAFKA_TELEMETRY_TOPIC_PREFIX_DOC)
                .define(TESLA_AUTH_EMAIL_CONF, Type.STRING, Importance.HIGH, TESLA_AUTH_EMAIL_DOC)
                .define(TESLA_AUTH_PASSWORD_CONF, Type.PASSWORD, Importance.HIGH, TESLA_AUTH_PASSWORD_DOC)
                .define(TESLA_AUTH_CLIENT_ID_CONF, Type.PASSWORD, Importance.HIGH, TESLA_AUTH_CLIENT_ID_DOC)
                .define(TESLA_AUTH_CLIENT_SECRET_CONF, Type.PASSWORD, Importance.HIGH, TESLA_AUTH_CLIENT_SECRET_DOC)
                .define(TESLA_VEHICLE_NAMES_CONF, Type.LIST, Importance.HIGH, TESLA_VEHICLE_NAMES_DOC);
    }

    public String getKafkaTelemetryTopicPrefix() { return this.getString(KAFKA_TELEMETRY_TOPIC_PREFIX_CONF); }

    public String getTeslaAuthEmail() { return this.getString(TESLA_AUTH_EMAIL_CONF); }

    public Password getTeslaAuthPassword() { return this.getPassword(TESLA_AUTH_PASSWORD_CONF); }

    public Password getTeslaAuthClientID() { return this.getPassword(TESLA_AUTH_CLIENT_ID_CONF); }

    public Password getTeslaAuthClientSecret() { return this.getPassword(TESLA_AUTH_CLIENT_SECRET_CONF); }

    public List<String> getTeslaVehicleNames() { return this.getList(TESLA_VEHICLE_NAMES_CONF); }

}
