/**
 * 2017年12月31日
 */
package com.qf.manager.service.impl;
import java.sql.SQLException;
import java.util.List;
import com.qf.manager.dao.IJobDao;
import com.qf.manager.pojo.Job;
import com.qf.manager.service.IJobService;
import com.qf.manager.utils.ObjectUtils;

/**
 * @author Administrator
 *2017年12月31日
 * 
 */
public class JobService implements IJobService{
	private static IJobDao jobDao=null;
	static{
		try {
			jobDao=(IJobDao) ObjectUtils.getObject("jobDao");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void insertJob(Job Job) throws SQLException {
		// TODO Auto-generated method stub
		
			jobDao.insertJob(Job);
		
	}

	@Override
	public void deleteJob(Job Job) throws SQLException {
		// TODO Auto-generated method stub
		if(Job.getjId()!=null){
			jobDao.deleteJob(Job);
		}else{
			System.out.println("id为空！");
		}
	}

	@Override
	public void updateJob(Job Job) throws SQLException {
		// TODO Auto-generated method stub
		if(Job.getjId()!=null){
			jobDao.updateJob(Job);
		}else{
			System.out.println("id为空！");
		}
	}

	@Override
	public Job selectJob(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		if(id!=null){
			return jobDao.selectJob(id);
		}else{
			System.out.println("id为空！");
			return null;
		}
		
		
	}

	@Override
	public List<Job> selectAllJob() throws SQLException {
		// TODO Auto-generated method stub
		return jobDao.selectAllJob();
	}

}
