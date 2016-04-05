package com.cui.hebut.jinghedemo.other;

public class Shop {

	private String name;
	private String raminTime;
	private String endTime;
	private String serviceDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaminTime() {
		return raminTime;
	}

	public void setRaminTime(String raminTime) {
		this.raminTime = raminTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", raminTime=" + raminTime + "]";
	}

}
