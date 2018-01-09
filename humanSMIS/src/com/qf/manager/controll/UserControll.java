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
import com.qf.manager.pojo.User;
import com.qf.manager.service.IUserSevice;
import com.qf.manager.utils.GetObjectUtils;
import com.qf.manager.utils.ObjectUtils;

/**
 * Servlet implementation class UserControll
 */
@WebServlet("/UserControll")
public class UserControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IUserSevice userService = null;
	static {
		try {
			userService = (IUserSevice) ObjectUtils.getObject("userService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserControll() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println("method=" + methodName);
		try {
			// User user=User.class.newInstance();
			// user.setuLoginName(request.getParameter("uLoginName"));
			// user.setuPwd(request.getParameter("uPwd"));
			User user = GetObjectUtils.getObject(request, User.class);
			System.out.println("登陆的用户为："+user.toString());
			jumgement(user, methodName, request, response);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	/**
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * 
	 */
	// 通过页面获取的method值，判断执行什么操作
	void jumgement(User user, String methodName, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, InstantiationException, IllegalAccessException,
			InvocationTargetException {

		if ("login".equals(methodName)) {
			login(user, request, response);
		} else if ("select".equals(methodName)) {
			List<User> users = userService.selectUserALL();
			request.setAttribute("users", users);
			jumpPage("/jsp/user/user.jsp", request, response);
		} else if ("update".equals(methodName)) {
			User user2 = userService.selectUserById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("user", user2);
			jumpPage("/jsp/user/showUpdateUser.jsp", request, response);
		} else if ("updated".equals(methodName)) {
			User user2 = GetObjectUtils.getObject(request, User.class);
			System.out.println(user2.toString());
			;
			userService.updateUser(user2);
			jumpPage("/UserControll?method=select", request, response);
		} else if ("add".equals(methodName)) {
			
			jumpPage("/jsp/user/showAddUser.jsp", request, response);
		} else if ("added".equals(methodName)) {
			request.setCharacterEncoding("UTF-8");
			User user2 = GetObjectUtils.getObject(request, User.class);
			userService.insertUser(user2);
			jumpPage("/UserControll?method=select", request, response);
		} else if ("delete".equals(methodName)) {
			String id = request.getParameter("uId");
			User user2 = userService.selectUserById(Integer.parseInt(id));
			userService.deleteUser(user2);
			jumpPage("/UserControll?method=select", request, response);
		} else if ("exit".equals(methodName)) {
			response.sendRedirect("/jsp/loginForm.jsp");
		} else if ("search".equals(methodName)){
			request.getParameter("username");
		}
	}

	// 跳转页面方法
	void jumpPage(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	// 登陆方法
	void login(User user, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
	
		User user2 =userService.selectUser(user);
	
		if (user2!= null) {
			System.out.println("登陆成功！");
			request.getSession().setAttribute("user", user2);
			jumpPage("/jsp/main.jsp", request, response);
		} else {
			System.out.println("登录失败！");
		}
	}
}
