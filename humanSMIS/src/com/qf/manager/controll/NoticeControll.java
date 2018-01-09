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

import com.qf.manager.pojo.Notice;
import com.qf.manager.pojo.User;
import com.qf.manager.service.INoticeService;
import com.qf.manager.utils.GetObjectUtils;
import com.qf.manager.utils.ObjectUtils;

/**
 * Servlet implementation class NoticeControll
 */
@WebServlet("/NoticeControll")
public class NoticeControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static INoticeService noticeServive=null;
    static{
    	try {
			noticeServive=(INoticeService) ObjectUtils.getObject("noticeService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getParameter("method");
		try {
			estimate(methodName,request,response);
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
		}
		
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
	private void estimate(String methodName,HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
		// 查询所有公告
		if ("select".equals(methodName)) {
			List<Notice> notices=noticeServive.selectAllNotice();
			for(Notice notice:notices){
			Integer uid=notice.getuId();
			User user=noticeServive.selectUserByUid(uid);
			notice.setUser(user);
			}		
			request.setAttribute("notices", notices);
			jumpPage("/jsp/notice/notice.jsp", request, response);
		}else if("add".equals(methodName)) {		
			jumpPage("/jsp/notice/showAddNotice.jsp", request, response);
		}else if ("added".equals(methodName)) {
			Notice notice=GetObjectUtils.getObject(request, Notice.class);
			User user=(User) request.getSession().getAttribute("user");
			System.out.println(user.toString());
			notice.setuId(user.getuId());
			noticeServive.insertNotice(notice);
			jumpPage("/NoticeControll?method=select", request, response);
		}else if ("update".equals(methodName)) {
			Notice notice=noticeServive.selectNotice(Integer.parseInt(request.getParameter("nId")));
			System.out.println(request.getParameter("nId"));
			request.setAttribute("notice", notice);
			jumpPage("/jsp/notice/showUpdateNotice.jsp", request, response);
		}else if ("updated".equals(methodName)) {
			Notice notice=GetObjectUtils.getObject(request, Notice.class);	
			noticeServive.updateNotice(notice);
			jumpPage("/NoticeControll?method=select", request, response);
		}else if ("delete".equals(methodName)) {
			Notice notice=noticeServive.selectNotice(Integer.parseInt(request.getParameter("nId")));
			noticeServive.deleteNotice(notice);
			jumpPage("/NoticeControll?method=select", request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 跳转页面方法
	void jumpPage(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
	

}
