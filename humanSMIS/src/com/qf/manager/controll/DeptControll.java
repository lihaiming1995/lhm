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

import com.qf.manager.pojo.Dept;
import com.qf.manager.service.IDeptService;
import com.qf.manager.utils.GetObjectUtils;
import com.qf.manager.utils.ObjectUtils;

/**
 * Servlet implementation class DeptControll
 */
@WebServlet("/DeptControll")
public class DeptControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static IDeptService deptService=null;
    static{
    	try {
			deptService=(IDeptService) ObjectUtils.getObject("deptService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getParameter("method");
		try {
			estimate( methodName, request, response);
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//判断methed值得方法
	void estimate(String methedName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException{
		if ("select".equals(methedName)) {		
			List<Dept> depts=deptService.selectAllDept();
			request.setAttribute("depts", depts);
			System.out.println("这里是执行跳转页面操作！");
			jumpPage("/jsp/dept/dept.jsp", request, response);
			System.out.println("执行完成！");
		}else if("add".equals(methedName)){		
			jumpPage("/jsp/dept/showAddDept.jsp", request, response);
		}else if("added".equals(methedName)){
			Dept dept=GetObjectUtils.getObject(request, Dept.class);
			deptService.insertDept(dept);
			jumpPage("/DeptControll?method=select", request, response);
		}else if("update".equals(methedName)){			
			Dept dept=deptService.selectDept(Integer.parseInt(request.getParameter("dId")));
			request.setAttribute("dept", dept);
			jumpPage("/jsp/dept/showUpdateDept.jsp", request, response);
		}else if ("updated".equals(methedName)) {
			System.out.println(methedName);
			Dept dept=GetObjectUtils.getObject(request, Dept.class);
			deptService.updateDept(dept);
			System.out.println(dept.toString());
			jumpPage("/DeptControll?method=select", request, response);
		}else if ("delete".equals(methedName)) {
			Dept dept=deptService.selectDept(Integer.parseInt(request.getParameter("dId")));
			System.out.println(dept.toString());
			deptService.deleteDept(dept);
			jumpPage("/DeptControll?method=select", request, response);
		}
	}
	// 跳转页面方法
		void jumpPage(String path, HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.getRequestDispatcher(path).forward(request, response);
		}
}
