package com.qf.manager.controll;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.manager.pojo.Job;
import com.qf.manager.service.IJobService;
import com.qf.manager.utils.GetObjectUtils;
import com.qf.manager.utils.ObjectUtils;

/**
 * Servlet implementation class JobControll
 */
@WebServlet("/JobControll")
public class JobControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IJobService jobservice = null;
	static {
		try {
			jobservice = (IJobService) ObjectUtils.getObject("jobService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobControll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("method");
		try {
			estimate(methodName, request, response);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 判断method值得方法
	void estimate(String methodName, HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, SQLException, ServletException, IOException,
			InvocationTargetException {
		if ("select".equals(methodName)) {
			List<Job> jobs = jobservice.selectAllJob();
			request.setAttribute("jobs", jobs);
			jumpPage("/jsp/job/job.jsp", request, response);
		} else if ("add".equals(methodName)) {
			jumpPage("/jsp/job/showAddJob.jsp", request, response);
		} else if ("added".equals(methodName)) {
			Job job = GetObjectUtils.getObject(request, Job.class);
			jobservice.insertJob(job);
			jumpPage("/JobControll?method=select", request, response);
		}else if ("update".equals(methodName)) {
			Job job=jobservice.selectJob(Integer.parseInt(request.getParameter("jId")));
			request.setAttribute("job", job);
			jumpPage("/jsp/job/showUpdateJob.jsp", request, response);
		}else if ("updated".equals(methodName)) {
			Job job=GetObjectUtils.getObject(request,Job.class);
			jobservice.updateJob(job);
			jumpPage("/JobControll?method=select", request, response);
		}else if ("delete".equals(methodName)) {
			System.out.println("执行删除");
			Job job=jobservice.selectJob(Integer.parseInt(request.getParameter("jId")));
			jobservice.deleteJob(job);
			jumpPage("/JobControll?method=select", request, response);
		}
	}

	// 跳转页面方法
	void jumpPage(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
}
