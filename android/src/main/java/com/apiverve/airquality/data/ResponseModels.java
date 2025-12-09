// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     AirQualityData data = Converter.fromJsonString(jsonString);

package com.apiverve.airquality.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static AirQualityData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(AirQualityData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(AirQualityData.class);
        writer = mapper.writerFor(AirQualityData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// AirQualityData.java

package com.apiverve.airquality.data;

import com.fasterxml.jackson.annotation.*;

public class AirQualityData {
    private double pm25;
    private double pm10;
    private long usEpaIndex;
    private long gbDefraIndex;
    private double carbonMonoxide;
    private long ozone;
    private double nitrogenDioxide;
    private double sulfurdioxide;
    private String recommendation;
    private String city;

    @JsonProperty("pm2_5")
    public double getPm25() { return pm25; }
    @JsonProperty("pm2_5")
    public void setPm25(double value) { this.pm25 = value; }

    @JsonProperty("pm10")
    public double getPm10() { return pm10; }
    @JsonProperty("pm10")
    public void setPm10(double value) { this.pm10 = value; }

    @JsonProperty("us-epa-index")
    public long getUsEpaIndex() { return usEpaIndex; }
    @JsonProperty("us-epa-index")
    public void setUsEpaIndex(long value) { this.usEpaIndex = value; }

    @JsonProperty("gb-defra-index")
    public long getGBDefraIndex() { return gbDefraIndex; }
    @JsonProperty("gb-defra-index")
    public void setGBDefraIndex(long value) { this.gbDefraIndex = value; }

    @JsonProperty("carbonMonoxide")
    public double getCarbonMonoxide() { return carbonMonoxide; }
    @JsonProperty("carbonMonoxide")
    public void setCarbonMonoxide(double value) { this.carbonMonoxide = value; }

    @JsonProperty("ozone")
    public long getOzone() { return ozone; }
    @JsonProperty("ozone")
    public void setOzone(long value) { this.ozone = value; }

    @JsonProperty("nitrogenDioxide")
    public double getNitrogenDioxide() { return nitrogenDioxide; }
    @JsonProperty("nitrogenDioxide")
    public void setNitrogenDioxide(double value) { this.nitrogenDioxide = value; }

    @JsonProperty("sulfurdioxide")
    public double getSulfurdioxide() { return sulfurdioxide; }
    @JsonProperty("sulfurdioxide")
    public void setSulfurdioxide(double value) { this.sulfurdioxide = value; }

    @JsonProperty("recommendation")
    public String getRecommendation() { return recommendation; }
    @JsonProperty("recommendation")
    public void setRecommendation(String value) { this.recommendation = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }
}