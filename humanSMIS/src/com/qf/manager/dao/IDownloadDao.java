package com.qf.manager.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Download;

public interface IDownloadDao {
	/**
	 * �������
	 * @throws SQLException 
	 */
	abstract void insertDownload(Download Download) throws SQLException;
	
	/**
	 * ɾ������
	 */
	abstract void deleteDownload(Download Download)throws SQLException;
	
	/**
	 * �޸�����
	 */
	abstract void updateDownload(Download Download)throws SQLException;
	/**
	 * ��ѯ����
	 */
	abstract Download selectDownload(Integer id)throws SQLException;
	/**
	 * ��ѯ��������
	 * @throws SQLException
	 */
	abstract List<Download>selectAllDownload()throws SQLException;
}
