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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qf.manager.pojo.Dept;
import com.qf.manager.pojo.Employee;
import com.qf.manager.pojo.Job;
import com.qf.manager.service.IDeptService;
import com.qf.manager.service.IEmployeeService;
import com.qf.manager.service.IJobService;
import com.qf.manager.utils.GetObjectUtils;
import com.qf.manager.utils.ObjectUtils;

/**
 * Servlet implementation class EmployeeControll
 */
@WebServlet("/EmployeeControll")
public class EmployeeControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IEmployeeService employeeService = null;
	private static IJobService jobService = null;
	private static IDeptService deptService = null;
	static {
		try {
			jobService = (IJobService) ObjectUtils.getObject("jobService");
			deptService = (IDeptService) ObjectUtils.getObject("deptService");
			employeeService = (IEmployeeService) ObjectUtils.getObject("employeeService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeControll() {
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
		response.setContentType("text/html;charset=utf8");
		try {
			estimate(methodName, request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
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

	// 判断methodName值
	void estimate(String methodName, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, InstantiationException, IllegalAccessException,
			InvocationTargetException, JSONException {
		// 查询所有员工信息
		if ("select".equals(methodName)) {
			List<Employee> employees = employeeService.selectAllEmployee();
			for(Employee employee:employees ){
				Dept dept=deptService.selectDept(employee.getdId());
				employee.setDept(dept);
				Job job=jobService.selectJob(employee.getjId());
				employee.setJob(job);
			}
			request.setAttribute("employees", employees);
			jumpPage("/jsp/employee/employee.jsp", request, response);
		} else if ("add".equals(methodName)) {// 添加员工信息
			List<Job> jobs=jobService.selectAllJob();
			request.setAttribute("jobs", jobs);
			jumpPage("/jsp/employee/showAddEmployee.jsp", request, response);
		} else if ("added".equals(methodName)) {
			Employee employee = GetObjectUtils.getObject(request, Employee.class);
			System.out.println(employee.toString());
			System.out.println("jId="+employee.getjId()+"dId="+employee.getdId());
			employeeService.insertEmployee(employee);
			jumpPage("/EmployeeControll?method=select", request, response);
		} else if ("update".equals(methodName)) {// 修改员工信息
			System.out.println(request.getParameter("eId"));
			Employee employee = employeeService.selectEmployee(Integer.parseInt(request.getParameter("eId")));

			request.setAttribute("employee", employee);
			jumpPage("jsp/employee/showUpdateEmployee.jsp", request, response);

		} else if ("updated".equals(methodName)) {
			Employee employee = GetObjectUtils.getObject(request, Employee.class);
			System.out.println(employee.toString());
			employeeService.updateEmployee(employee);
			jumpPage("/EmployeeControll?method=select", request, response);
		} else if ("delete".equals(methodName)) {// 删除员工信息
			Employee employee = employeeService.selectEmployee(Integer.parseInt(request.getParameter("eId")));
			employeeService.deleteEmployee(employee);
			jumpPage("/EmployeeControll?method=select", request, response);
		} else if ("getJobs".equals(methodName)) {

			List<Job> jobs = jobService.selectAllJob();
			// 将数据转化为str类型的json格式
			JSONArray jsonArray = new JSONArray();// 1.创建json数组
			for (Job job : jobs) {// for循环将list里面的数组放入json对象中
				JSONObject jObject = new JSONObject();// 创建json对象
				jObject.put("jId", job.getjId());// 放入job中的jid属性，并以jId为键
				jObject.put("jName", job.getjName());// 放入job中的jName属性，并以jName为键
				jsonArray.put(jObject);// 将json对像放入json数组中
			}
			// 向页面写出数据
			response.getWriter().write(jsonArray.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} else if ("getDepts".equals(methodName)) {
			List<Dept> depts = deptService.selectAllDept();
			getJson(response, depts);
		}
	}

	/**
	 * @param response
	 * @param depts
	 * @throws JSONException
	 * @throws IOException
	 */
	private void getJson(HttpServletResponse response, List<Dept> depts) throws JSONException, IOException {
		JSONArray jsonArray = new JSONArray();
		for (Dept dept : depts) {
			JSONObject jobject = new JSONObject();
			jobject.put("dId", dept.getdId());
			jobject.put("dName", dept.getdName());
			jsonArray.put(jobject);
		}
		response.getWriter().write(jsonArray.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	// 跳转页面方法
	void jumpPage(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
}
