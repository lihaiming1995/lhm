package com.qf.manager.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.manager.dao.INoticeDao;
import com.qf.manager.pojo.Notice;
import com.qf.manager.pojo.User;
import com.qf.manager.utils.DbUtils;

/**
 * @author 李海明
 *	下午8:03:02
 *	NoticeDao.java
 */
/**
 * 
 * @author Administrator
 *2017年12月30日
 *
 */


public class NoticeDao implements INoticeDao{

	@Override
	public void insertNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into t_notice(nTitle,nContent,nCreateTime,uId) values (?,?,?,?)";
		DbUtils.getObject().update(sql,notice.getnTitle(),notice.getnContent(),new Date(System.currentTimeMillis()),notice.getuId());
	}

	

	@Override
	public Notice selectNotice(Integer id) throws SQLException {
		String  sql="select *from t_notice where nId=?";
		return 	DbUtils.getObject().query(sql, new BeanHandler<Notice>(Notice.class),id);
		
		
	}



	@Override
	public void deleteNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from t_notice where nId=?";
		DbUtils.getObject().update(sql, notice.getnId());
	}



	@Override
	public void updateNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update t_notice set nTitle=?,nContent=?,nCreateTime=?,uId=? where nId=?";
		DbUtils.getObject().update(sql,notice.getnTitle(),notice.getnContent(),new Date(System.currentTimeMillis()),notice.getuId(),notice.getnId());;
	}



	@Override
	public List<Notice> selectAllNotice() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_notice";
		return DbUtils.getObject().query(sql, new BeanListHandler<Notice>(Notice.class));
	}



	@Override
	public User selectUserByUid(Integer uid) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select *from t_user where uid=?";
		return DbUtils.getObject().query(sql, new BeanHandler<User>(User.class),uid);
	}





	

}
