package com.github.frankgreco.kafka.connect.tesla;

import com.github.frankgreco.tesla.DriveState;
import com.github.frankgreco.tesla.TeslaAPI;
import com.github.frankgreco.tesla.Vehicle;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeslaSourceTask extends SourceTask {

    public static final String TESLA_VEHICLE_NAME_CONF = "tesla.vehicle.name";
    private TeslaSourceConnectorConfig config;
    private TeslaAPI teslaAPI;
    private Vehicle vehicle;
    private String topicName;

    public void start(Map<String, String> map) throws ConfigException {
        try {
            config = new TeslaSourceConnectorConfig(map);
        } catch (ConfigException e) {
            throw new ConfigException("TeslaSourceTask failed to start due to a configuration error: ", e);
        }

        teslaAPI = new TeslaAPI(
            config.getTeslaAuthEmail(),
            config.getTeslaAuthPassword().value(),
            config.getTeslaAuthClientID().value(),
            config.getTeslaAuthClientSecret().value()
        );

        vehicle = teslaAPI.getVehiclesByDisplayName().get(map.get(TESLA_VEHICLE_NAME_CONF));
        topicName = String.format("%s_%s", config.getKafkaTelemetryTopicPrefix(), vehicle.getDisplayName());
    }

    public List<SourceRecord> poll() throws InterruptedException {
        ArrayList<SourceRecord> records = new ArrayList<>();
        DriveState driveState = this.teslaAPI.getDriveState(this.vehicle);
        records.add(new SourceRecord(null, null, this.topicName, null, DriveState.TELEMETRY_SCHEMA, driveState));
        return records;
    }

    public void stop() {
        // TODO: Determine if anything needs to be done here.
    }

    public String version() {
        try {
            return this.getClass().getPackage().getImplementationVersion();
        } catch(Exception ex){
            return "0.0.0.0";
        }
    }

}
