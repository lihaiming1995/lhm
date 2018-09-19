/**
 * 
 */
package com.qfedu.esys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Entity
@Table(name = "sys_user")
public class User {
	@SuppressWarnings("unused")

	private final static Logger LOG = LogManager.getLogger(User.class);
	@Id
	@Column(length = 50)
	private int id;
	@Column(length = 20)
	private String loginName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(length = 50)
	private int password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + "]";
	}

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
}
