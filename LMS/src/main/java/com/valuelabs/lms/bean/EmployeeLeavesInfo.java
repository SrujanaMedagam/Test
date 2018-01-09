package com.valuelabs.lms.bean;

public class EmployeeLeavesInfo {
	private String eid;
	private String fromDate;
	private String toDate;
	private float noOfDays;
	private int totalNoOfLeaves;
	private String reportingManager;
	private String reason;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public float getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getTotalNoOfLeaves() {
		return totalNoOfLeaves;
	}
	public void setTotalNoOfLeaves(int totalNoOfLeaves) {
		this.totalNoOfLeaves = totalNoOfLeaves;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

}
