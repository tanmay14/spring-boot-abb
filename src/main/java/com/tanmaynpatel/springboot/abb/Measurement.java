package com.tanmaynpatel.springboot.abb;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;


@JsonRootName("measurement")
public class Measurement {
    @JsonProperty
    private String resourceId;
    @JsonProperty
    private String deviceName;
    @JsonProperty
    private String deviceGroup;
    @SerializedName("direction")
    private Direction direction;
    @JsonProperty
    private List<Power> power = new ArrayList<>();

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(String deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Power> getPower() {
        return power;
    }

    public void setPower(List<Power> power) {
        this.power = power;
    }

    public Key getKey() {
        return new Key(resourceId,deviceName,deviceGroup);
    }

	@Override
	public String toString() {
		return "Measurement [resourceId=" + resourceId + ", deviceName=" + deviceName + ", deviceGroup=" + deviceGroup
				+ ", direction=" + direction + ", power=" + power + "]";
	}
    
    
}
