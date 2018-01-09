package com.qf.manager.pojo;

import java.util.Date;
/**
 * 
 * @author 李海明
 *	下午5:34:49
 *	
 */
public class Download {
	private Integer doId;
	private String doDes;
	private String doTitle;
	private Date doCreatetime;
	private Integer uId;
	private String filePath;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getDoId() {
		return doId;
	}
	public void setDoId(Integer doId) {
		this.doId = doId;
	}
	public String getDoDes() {
		return doDes;
	}
	public void setDoDes(String doDes) {
		this.doDes = doDes;
	}
	public String getDoTitle() {
		return doTitle;
	}
	public void setDoTitle(String doTitle) {
		this.doTitle = doTitle;
	}
	public Date getDoCreatetime() {
		return doCreatetime;
	}
	public void setDoCreatetime(Date doCreatetime) {
		this.doCreatetime = doCreatetime;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	@Override
	public String toString() {
		return "Download [doId=" + doId + ", doDes=" + doDes + ", doTitle=" + doTitle + ", doCreatetime=" + doCreatetime
				+ ", uId=" + uId + "]";
	}
	
	
}
