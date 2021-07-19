package com.tanmaynpatel.springboot.abb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Key {
    @JsonProperty
    private String resourceId;
    @JsonProperty
    private String deviceName;
    @JsonProperty
    private String deviceGroup;

    public Key(String resourceId, String deviceName, String deviceGroup) {
        this.resourceId = resourceId;
        this.deviceName = deviceName;
        this.deviceGroup = deviceGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;

        Key key = (Key) o;

        if (resourceId != null ? !resourceId.equals(key.resourceId) : key.resourceId != null) return false;
        if (deviceName != null ? !deviceName.equals(key.deviceName) : key.deviceName != null) return false;
        return deviceGroup != null ? deviceGroup.equals(key.deviceGroup) : key.deviceGroup == null;
    }

    @Override
    public int hashCode() {
        int result = resourceId != null ? resourceId.hashCode() : 0;
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (deviceGroup != null ? deviceGroup.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Key [resourceId=" + resourceId + ", deviceName=" + deviceName + ", deviceGroup=" + deviceGroup + "]";
	}
    
    
}
