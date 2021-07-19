package com.tanmaynpatel.springboot.abb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;
@JsonRootName("direction")
public enum Direction {
   // @JsonProperty("in")
	@SerializedName("in")
    IN,
    //@JsonProperty("out")
    @SerializedName("out")
    OUT
    
    
}
