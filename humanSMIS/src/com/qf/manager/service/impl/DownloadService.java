/**
 * 2017年12月31日
 */
package com.qf.manager.service.impl;

import java.sql.SQLException;

import java.util.List;
import com.qf.manager.dao.IDownloadDao;
import com.qf.manager.dao.impl.DownloadDao;
import com.qf.manager.pojo.Download;
import com.qf.manager.service.IDownloadService;
import com.qf.manager.utils.ObjectUtils;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public class DownloadService implements IDownloadService{
	private static IDownloadDao downloadDao=null;
	static{
		try {
			downloadDao=(DownloadDao) ObjectUtils.getObject("downloadDao");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insertDownload(Download Download) throws SQLException {
		 if(!Download.getDoTitle().equals(null)){
			 downloadDao.insertDownload(Download);
		 }else{
			 System.out.println("标题不能为空！");
		 }
		
	}

	@Override
	public void deleteDownload(Download Download) throws SQLException {
		// TODO Auto-generated method stub
		if(Download.getDoId()!=null){
			downloadDao.deleteDownload(Download);
		}else{
			System.out.println("id为空！");
		}
	}

	@Override
	public void updateDownload(Download Download) throws SQLException {
		// TODO Auto-generated method stub
		if(Download.getDoId()!=null){
			downloadDao.updateDownload(Download);
		}else{
			System.out.println("id为空！");
		}
		
	}

	@Override
	public Download selectDownload(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		if(id!=null&&!id.equals("")){
			return downloadDao.selectDownload(id);
		}else{
			System.out.println("输入id非法！");
			return null;
		}
		
		
	}

	@Override
	public List<Download> selectAllDownload() throws SQLException {
		// TODO Auto-generated method stub
		return downloadDao.selectAllDownload();
	}

}
