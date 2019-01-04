package com.github.frankgreco.kafka.connect.tesla;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;

public class TeslaSchema {

    public final static Schema TELEMETRY_SCHEMA;

    static {
        TELEMETRY_SCHEMA = SchemaBuilder.struct()
                .name("com.github.frankgreco.kafka.connect.tesla.Telemetry")
                .field("ShiftState", SchemaBuilder.string().optional().build())
                .field("Speed", SchemaBuilder.string().optional().build())
                .field("Latitude", SchemaBuilder.string().optional().build())
                .field("Longitude", SchemaBuilder.string().optional().build())
                .field("Heading", SchemaBuilder.string().optional().build())
                .field("GpsAsOf", SchemaBuilder.string().optional().build())
                .field("NativeLocationSupported", SchemaBuilder.string().optional().build())
                .field("NativeLatitude", SchemaBuilder.string().optional().build())
                .field("NativeLongitude", SchemaBuilder.string().optional().build())
                .field("NativeType", SchemaBuilder.string().optional().build())
                .field("Timestamp", SchemaBuilder.string().optional().build())
                .build();
    }

}
