package com.github.frankgreco.tesla;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class DriveState extends Struct {

    public final static Schema TELEMETRY_SCHEMA;

    private static final String SHIFT_STATE = "ShiftState";
    private static final String SPEED = "Speed";
    private static final String LATITUDE = "Latitude";
    private static final String LONGITUDE = "Longitude";
    private static final String HEADING = "Heading";
    private static final String GPS_AS_OF = "GpsAsOf";
    private static final String NATIVE_LOCATION_SUPPORTED = "NativeLocationSupported";
    private static final String NATIVE_LATITUDE = "NativeLatitude";
    private static final String NATIVE_LONGITUDE = "NativeLongitude";
    private static final String NATIVE_TYPE = "NativeType";
    private static final String TIMESTAMP = "Timestamp";

    static {
        TELEMETRY_SCHEMA = SchemaBuilder.struct()
                .name("com.github.frankgreco.kafka.connect.tesla.Telemetry")
                .field(SHIFT_STATE, SchemaBuilder.string().optional().build())
                .field(SPEED, SchemaBuilder.string().optional().build())
                .field(LATITUDE, SchemaBuilder.string().optional().build())
                .field(LONGITUDE, SchemaBuilder.string().optional().build())
                .field(HEADING, SchemaBuilder.string().optional().build())
                .field(GPS_AS_OF, SchemaBuilder.string().optional().build())
                .field(NATIVE_LOCATION_SUPPORTED, SchemaBuilder.string().optional().build())
                .field(NATIVE_LATITUDE, SchemaBuilder.string().optional().build())
                .field(NATIVE_LONGITUDE, SchemaBuilder.string().optional().build())
                .field(NATIVE_TYPE, SchemaBuilder.string().optional().build())
                .field(TIMESTAMP, SchemaBuilder.string().optional().build())
                .build();
    }

    public DriveState(
        String shiftState,
        String speed,
        String latitude,
        String longitude,
        String heading,
        String gpsAsOf,
        String nativeLocationSupported,
        String nativeLatitude,
        String nativeLongitude,
        String nativeType,
        String timestamp
    ) {
        super(TELEMETRY_SCHEMA);
        this
            .put(SHIFT_STATE, shiftState)
            .put(SPEED, speed)
            .put(LATITUDE, latitude)
            .put(LONGITUDE, longitude)
            .put(HEADING, heading)
            .put(GPS_AS_OF, gpsAsOf)
            .put(NATIVE_LOCATION_SUPPORTED, nativeLocationSupported)
            .put(NATIVE_LATITUDE, nativeLatitude)
            .put(NATIVE_LONGITUDE, nativeLongitude)
            .put(NATIVE_TYPE, nativeType)
            .put(TIMESTAMP, timestamp);
    }

}
