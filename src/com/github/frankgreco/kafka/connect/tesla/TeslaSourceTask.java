package com.github.frankgreco.kafka.connect.tesla;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.util.List;
import java.util.Map;

public class TeslaSourceTask extends SourceTask {
    public static final String TESLA_VEHICLE_NAME_CONF = "tesla.vehicle.name";
    public static final String TESLA_VEHICLE_ID_CONF = "tesla.vehicle.id";

    public void start(Map<String, String> map) {

    }

    public List<SourceRecord> poll() throws InterruptedException {
        return null;
    }

    public void stop() {

    }

    public String version() {
        return null;
    }
}
