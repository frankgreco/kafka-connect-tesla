package com.github.frankgreco.kafka.connect.tesla;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeslaSourceConnector extends SourceConnector {
    private TeslaSourceConnectorConfig config;

    public void start(Map<String, String> map) throws ConfigException {
        try {
            config = new TeslaSourceConnectorConfig(map);
        } catch (ConfigException e) {
            throw new ConfigException("TeslaSourceConnector failed to start due to a configuration error: ", e);
        }
    }

    public void stop() {
        // TODO: Determine if anything needs to be done here.
    }

    public ConfigDef config() {
        return TeslaSourceConnectorConfig.conf();
    }

    public Class<? extends Task> taskClass() {
        return TeslaSourceTask.class;
    }

    public List<Map<String, String>> taskConfigs(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("The cardinality of max tasks must be positive");
        }

        final List<Map<String, String>> taskConfigs = new ArrayList<>();

        List<String> vehicleNames = config.getTeslaVehicleNames();

        if (i < vehicleNames.size()) {
            vehicleNames = vehicleNames.subList(0, i);
        }

        for (String k : vehicleNames) {
            Map<String, String> taskSettings = new HashMap<>();

            if (k != null && !k.isEmpty()) {
                taskSettings.put(TeslaSourceTask.TESLA_VEHICLE_NAME_CONF, k);
                taskConfigs.add(taskSettings);
            }
        }

        return taskConfigs;
    }

    public String version() {
        try {
            return this.getClass().getPackage().getImplementationVersion();
        } catch(Exception ex){
            return "0.0.0.0";
        }
    }
}
