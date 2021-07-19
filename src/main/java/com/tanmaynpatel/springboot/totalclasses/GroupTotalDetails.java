package com.tanmaynpatel.springboot.totalclasses;

import java.util.List;

public class GroupTotalDetails {

	private String groupName;
	List<DirectionTotalDetail> directionTotalDetails;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<DirectionTotalDetail> getDirectionTotalDetails() {
		return directionTotalDetails;
	}

	public void setDirectionTotalDetails(List<DirectionTotalDetail> directionTotalDetails) {
		this.directionTotalDetails = directionTotalDetails;
	}

	@Override
	public String toString() {
		return "GroupTotalDetails [groupName=" + groupName + ", directionTotalDetails=" + directionTotalDetails + "]";
	}
	 

}
