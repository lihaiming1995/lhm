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
@Table(name = "sys_dept")
public class Dept {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(Dept.class);
	@Id
	@Column(length = 50)
	private int id;
	@Column(length = 50)

	private String deptName;
	@Column(length = 50)
	private String leader;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public Dept(int id, String deptName, String leader) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.leader = leader;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Dept() {
		super();
	}

}
