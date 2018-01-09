package com.qf.manager.pojo;

import java.util.Date;

public class User {
private	Integer uId;
private	String uName;
private	String uPwd;
private Date uCreateTime;
public Date getuCreateTime() {
	return uCreateTime;
}
public void setuCreateTime(Date uCreateTime) {
	this.uCreateTime = uCreateTime;
}
public String getuPwd() {
	return uPwd;
}
public void setuPwd(String uPwd) {
	this.uPwd = uPwd;
}
private	String uLoginName;
private	String uState;


public String getuState() {
	return uState;
}
public void setuState(String uState) {
	this.uState = uState;
}
public Integer getuId() {
	return uId;
}
public void setuId(Integer uId) {
	this.uId = uId;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}

public String getuLoginName() {
	return uLoginName;
}
public void setuLoginName(String uLoginName) {
	this.uLoginName = uLoginName;
}


@Override
public String toString() {
	return "User [uId=" + uId + ", uName=" + uName + ", uPwd=" + uPwd + ", uLoginName=" + uLoginName + ", uState="
			+ uState + "]";
}

	
}
