package com.qf.manager.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.manager.dao.IDownloadDao;
import com.qf.manager.pojo.Download;
import com.qf.manager.utils.DbUtils;

public class DownloadDao implements IDownloadDao{

	@Override
	public void insertDownload(Download download) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into t_download(doDes,doCreateTime,doTitle,filePath,uId)values(?,?,?,?,?)";
		DbUtils.getObject().update(sql,download.getDoDes(),download.getDoCreatetime(),download.getDoTitle(),download.getFilePath(),download.getuId());
	}

	@Override
	public void deleteDownload(Download download) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from t_download where doId=?";
		DbUtils.getObject().update(sql,download.getDoId());
	}

	@Override
	public void updateDownload(Download download) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update t_down set doDes=?,doCreateTime=?,doTitle=?,douId=? where doId=?";
		DbUtils.getObject().update(sql,download.getDoDes(),download.getDoCreatetime(),download.getDoTitle(),download.getuId(),download.getDoId());
	}

	@Override
	public Download selectDownload(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_download where doId=?";
		
		return DbUtils.getObject().query(sql, new BeanHandler<Download>(Download.class),id);
	}

	@Override
	public List<Download> selectAllDownload() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_download";
		return DbUtils.getObject().query(sql, new BeanListHandler<Download>(Download.class));
	}


}
