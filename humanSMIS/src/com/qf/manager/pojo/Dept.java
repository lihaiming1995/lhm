package com.qf.manager.pojo;

public class Dept {
	private Integer dId;
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	private String dName;
	private String dDes;
	
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdDes() {
		return dDes;
	}
	public void setdDes(String dDes) {
		this.dDes = dDes;
	}
	@Override
	public String toString() {
		return "Dept [dId=" + dId + ", dName=" + dName + ", dDes=" + dDes + "]";
	}
	
}
