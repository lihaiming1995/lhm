/**
 * 2017年12月31日
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Download;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public interface IDownloadService {
	/**
	 * 添加下载
	 * @throws SQLException 
	 */
	abstract void insertDownload(Download Download) throws SQLException;
	
	/**
	 * 删除下载
	 */
	abstract void deleteDownload(Download Download)throws SQLException;
	
	/**
	 * 修改下载
	 */
	abstract void updateDownload(Download Download)throws SQLException;
	/**
	 * 查询下载
	 */
	abstract Download selectDownload(Integer id)throws SQLException;
	/**
	 * 查询所有下载
	 * @throws SQLException
	 */
	abstract List<Download>selectAllDownload()throws SQLException;
}
