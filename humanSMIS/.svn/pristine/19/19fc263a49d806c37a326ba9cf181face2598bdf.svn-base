/**
 * 2017年12月31日
 */
package com.qf.manager.service.impl;

import java.sql.SQLException;

import java.util.List;

import com.qf.manager.dao.INoticeDao;
import com.qf.manager.pojo.Notice;
import com.qf.manager.pojo.User;
import com.qf.manager.service.INoticeService;
import com.qf.manager.utils.ObjectUtils;

/**
 * @author Administrator 2017年12月31日
 * 
 */
public class NoticeService implements INoticeService {
	private static INoticeDao noticeDao = null;
	static {
		try {
			noticeDao = (INoticeDao) ObjectUtils.getObject("noticeDao");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		if (notice.getnTitle() != null) {
			noticeDao.insertNotice(notice);
		}

	}

	@Override
	public void deleteNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		if (notice.getnId() != null) {
			noticeDao.deleteNotice(notice);
		} else {
			System.out.println("id为空！");
		}
	}

	@Override
	public void updateNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		if (notice.getnId() != null) {
			noticeDao.updateNotice(notice);
		} else {
			System.out.println("id为空！");
		}
	}

	@Override
	public Notice selectNotice(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		if (id != null) {
			return noticeDao.selectNotice(id);
		} else {
			System.out.println("id为空！");
			return null;
		}

	}

	@Override
	public List<Notice> selectAllNotice() throws SQLException {
		// TODO Auto-generated method stub
		List<Notice> notices = noticeDao.selectAllNotice();

		return notices;

	}

	@Override
	public User selectUserByUid(Integer uid) throws SQLException {
		// TODO Auto-generated method stub
		return noticeDao.selectUserByUid(uid);
	}

}
