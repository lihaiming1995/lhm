package com.qf.manager.pojo;

import java.sql.SQLException;

import java.util.Date;

public class Employee {
	
	private Integer eId;
	private String eName;
//	private Gender eGender;
	private String eGender;
	public String geteGender() {
		return eGender;
	}
	public void seteGender(String eGender) {
		this.eGender = eGender;
	}
	private String eTelNum;
	public String geteTelNum() {
		return eTelNum;
	}
	public void seteTelNum(String eTelNum) {
		this.eTelNum = eTelNum;
	}
	private String eEmail;
	private Integer jId;
	private Integer dId;
	private String eStu;
	private String eIdCard;
	private String eQQNum;
	private int ePostCode;
	private String eDes;
	public String geteDes() {
		return eDes;
	}
	public void seteDes(String eDes) {
		this.eDes = eDes;
	}
	public int getePostCode() {
		return ePostCode;
	}
	public void setePostCode(int ePostCode) {
		this.ePostCode = ePostCode;
	}
	public String geteQQNum() {
		return eQQNum;
	}
	public void seteQQNum(String eQQNum) {
		this.eQQNum = eQQNum;
	}
	public String geteIdCard() {
		return eIdCard;
	}
	public void seteIdCard(String eIdCard) {
		this.eIdCard = eIdCard;
	}
	public String geteStu() {
		return eStu;
	}
	public void seteStu(String eStu) {
		this.eStu = eStu;
	}
	private Date eCreateTime;
	private String eAddress;
	private Dept dept;
	private Job job;
	public Dept getDept() throws SQLException {
	/*	this.dept=deptService.selectDept(this.dId);*/
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() throws SQLException {
	/*	this.job=jobService.selectJob(this.jId);*/
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	
	public String geteEmail() {
		return eEmail;
	}
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	public Integer getjId() {
		return jId;
	}
	public void setjId(Integer jId) {
		this.jId = jId;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	
	public Date geteCreateTime() {
		return eCreateTime;
	}
	public void seteCreateTime(Date eCreateTime) {
		this.eCreateTime = eCreateTime;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eGender=" + eGender + ", eTelNum=" + eTelNum
				+ ", eEmail=" + eEmail + ", jId=" + jId + ", dId=" + dId + ", jStu=" + eStu + ", eCreateTime="
				+ eCreateTime + ", eAddress=" + eAddress + "]";
	}
	
}
