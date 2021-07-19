package com.tanmaynpatel.springboot.totalclasses;

public class DirectionTotalDetail {

	private String direction;
	private Integer count;
	private TotalDetail totaldetail;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public TotalDetail getTotaldetail() {
		return totaldetail;
	}

	public void setTotaldetail(TotalDetail totaldetail) {
		this.totaldetail = totaldetail;
	}

	@Override
	public String toString() {
		return "DirectionTotalDetail [direction=" + direction + ", count=" + count + ", totaldetail=" + totaldetail
				+ "]";
	}
	
	

}
