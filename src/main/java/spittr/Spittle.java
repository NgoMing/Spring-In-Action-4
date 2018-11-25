package spittr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

public class Spittle {

    // Id of the spittle
    private final Long id;

    // Message in the spittle
    private final String message;

    // Time when the spittle was posted
    private final Date time;

    // Latitude and Longitude of the position where the spittle was posted
    private Double latitude;
    private Double longitude;

    /**
     * Constructor with message, time, latitude and longitude params
     * @param message message in the spittle
     * @param time time then the spittle was posted
     * @param latitude latitude of the position where the spittle was posted
     * @param longitude longitude of the position where the spittle was posted
     */
    public Spittle(
            Long id, String message, Date time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Constructor with message and time params
     * @param message message in the spittle
     * @param time time then the spittle was posted
     */
    public Spittle(String message, Date time) {
        this(null, message, time, null, null);
    }

    /**
     * Get id
     * @return id of the spittle
     */
    public Long getId() {
        return id;
    }

    /**
     * Get message
     * @return message in the spittle
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get time
     * @return time when the spittle was posted
     */
    public Date getTime() {
        return time;
    }

    /**
     * Get latitude
     * @return latitude of the position where the spittle was posted
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Get longitude
     * @return longitude of the position where the spittle was posted
     */
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
