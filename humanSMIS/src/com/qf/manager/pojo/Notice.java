package com.qf.manager.pojo;

import java.sql.SQLException;
import java.util.Date;

public class Notice {
	private Integer nId;
	private String nTitle;
	private User user;	
	public User getUser() throws SQLException {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	private String nContent;
	private Date nCreateTime;
	private Integer uId;
	public Integer getnId() {
		return nId;
	}
	public void setnId(Integer nId) {
		this.nId = nId;
	}
	
	public Date getnCreateTime() {
		return nCreateTime;
	}
	public void setnCreateTime(Date nCreateTime) {
		this.nCreateTime = nCreateTime;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	@Override
	public String toString() {
		return "Notice [nId=" + nId + ", nName=" + nTitle + ", nContent=" + nContent + ", nCreateTime=" + nCreateTime
				+ ", uId=" + uId + "]";
	}
	
}
