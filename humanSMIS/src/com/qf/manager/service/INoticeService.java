/**
 * 2017年12月31日
 */
package com.qf.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.manager.pojo.Notice;
import com.qf.manager.pojo.User;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public interface INoticeService {
	/**
	 * 添加公告
	 * @throws SQLException 
	 */
	 void insertNotice(Notice notice) throws SQLException;
	
	/**
	 * 删除公告
	 */
	 void deleteNotice(Notice notice) throws SQLException;
	
	/**
	 * 修改公告
	 */
	 void updateNotice(Notice notice) throws SQLException;
	/**
	 * 查询公告
	 */
	 Notice selectNotice(Integer id) throws SQLException;
	/**
	 * 查询所有公告
	 * @return
	 * @throws SQLException
	 */
	 List<Notice> selectAllNotice() throws SQLException;
	 /**
	  * 根据uid查询用户
	  */
	 User selectUserByUid(Integer uid) throws SQLException;

	/**
	 * @return
	 * @throws SQLException
	 */
	
}
