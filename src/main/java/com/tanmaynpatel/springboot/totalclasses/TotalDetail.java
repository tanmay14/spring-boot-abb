package com.tanmaynpatel.springboot.totalclasses;

import java.math.BigDecimal;

public class TotalDetail {


	
	private BigDecimal minTotal;
	private BigDecimal maxTotal;
	private BigDecimal avgTotal;
	
	

	public BigDecimal getMinTotal() {
		return minTotal;
	}

	public void setMinTotal(BigDecimal minTotal) {
		this.minTotal = minTotal;
	}

	public BigDecimal getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(BigDecimal maxTotal) {
		this.maxTotal = maxTotal;
	}

	public BigDecimal getAvgTotal() {
		return avgTotal;
	}

	public void setAvgTotal(BigDecimal avgTotal) {
		this.avgTotal = avgTotal;
	}

	@Override
	public String toString() {
		return "TotalDetail [minTotal=" + minTotal + ", maxTotal=" + maxTotal + ", avgTotal=" + avgTotal + "]";
	}

}