package com.qf.manager.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.manager.dao.IJobDao;
import com.qf.manager.pojo.Job;
import com.qf.manager.utils.DbUtils;

public class JobDao implements IJobDao{

	public JobDao() {
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void insertJob(Job Job) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into t_job(jDes,jName)values(?,?)";
		DbUtils.getObject().update(sql,Job.getjDes(),Job.getjName());
	}

	@Override
	public void deleteJob(Job Job) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from t_job where jId=?";
		DbUtils.getObject().update(sql,Job.getjId());
	}

	@Override
	public void updateJob(Job Job) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update t_job set jDes=?,jName=? where jId=?";
		DbUtils.getObject().update(sql,Job.getjDes(),Job.getjName(),Job.getjId());
	}

	@Override
	public Job selectJob(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_job where jId=?";
		return DbUtils.getObject().query(sql, new BeanHandler<Job>(Job.class),id);
	}

	@Override
	public List<Job> selectAllJob() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_job";
		return DbUtils.getObject().query(sql, new BeanListHandler<Job>(Job.class));
	}

}
