package com.example.ApiGateWay.Mapper;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateMapper {



    public static LocalDate toLocalDate(Timestamp timestamp) {
        if (timestamp == null) return null;
        return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Timestamp toTimeStamp(LocalDate localDate) {
        if (localDate == null) return null;
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }


}
