package com.qf.manager.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.qf.manager.pojo.Download;
import com.qf.manager.pojo.User;
import com.qf.manager.service.IDownloadService;
import com.qf.manager.service.IUserSevice;
import com.qf.manager.utils.LoginUserUtils;
import com.qf.manager.utils.ObjectUtils;

/**
 * Servlet implementation class DownloadControll
 */
@WebServlet("/DownloadControll")
@MultipartConfig
public class DownloadControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IDownloadService downloadService = null;
	private static IUserSevice userService=null;
	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadControll() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		downloadService = (IDownloadService) ObjectUtils.getObject("downloadService");
		userService=(IUserSevice) ObjectUtils.getObject("userService");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			estimate(methodName, request, response);
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

	void estimate(String methodName, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		if ("uploadFileJsp".equals(methodName)) {
			jumpPage("/jsp/document/showAddDocument.jsp", request, response);
		} else if ("upload".equals(methodName)) {
			// 从新对数据进行封装
			Download download = wrapperObject(request);
			// 调用业务逻辑进行插入
			downloadService.insertDownload(download);		
			// 跳转到查询所有的下载地址的页面
			jumpPage("/DownloadControll?method=select", request, response);
		} else if ("select".equals(methodName)) {
			List<Download> downloads = downloadService.selectAllDownload();
			for(Download download:downloads){
				User user=userService.selectUserById(download.getuId()) ;
				download.setUser(user);	
			}
			request.setAttribute("documents", downloads);
			jumpPage("jsp/document/document.jsp", request, response);
		}else if("down".equals(methodName)) {   //这里说民是下载文件
			//把路径取出来
			String filePath="/upload/"+request.getParameter("filePath");
			//接下来构建下载路径
			@SuppressWarnings("deprecation")
			String fileDesPath=request.getRealPath("/")+filePath;
			//通过路径获取这个文件的名字
			String fileName=fileDesPath.substring(fileDesPath.lastIndexOf("\\")+1);
			fileDown(response, fileDesPath, fileName);
		}

	}

	// 跳转页面方法
	void jumpPage(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	// 封装download对象
	private Download wrapperObject(HttpServletRequest request)
			throws IllegalStateException, IOException, ServletException {
		// 解决请求的编码问题
		// System.out.println("这里是上传文件....");
		Part part = request.getPart("file");
		String title = request.getParameter("title");
		String remark = request.getParameter("remark");

		String header = part.getHeader("content-disposition");
		String filenameAll = header.substring(header.indexOf("filename"));
		// 最终获取文件的名字
		String filename = filenameAll.substring(filenameAll.indexOf("\"") + 1, filenameAll.lastIndexOf("\""));
		// 接下来通过流写出去
		// part.write();
		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/upload") + File.separator + filename;
		// 将文件写到目的地
		part.write(path);
		// 这里应该将数据插入到数据库
		return wrapperDownload(request, title, remark, filename);
	}

	/**
	 * @param request
	 * @param title
	 * @param remark
	 * @param filename
	 * @return
	 */
	private Download wrapperDownload(HttpServletRequest request, String title, String remark, String filename) {
		// TODO Auto-generated method stub
		Download download = new Download();
		download.setDoTitle(title);
		download.setDoDes(remark);
		download.setDoCreatetime(new Date());
		download.setFilePath(filename);
		download.setuId(LoginUserUtils.getLoginUserId(request));
		return download;
	}
	 /**
     * 文件的下载
     * @Title: fileDown   
     * @Description: TODO 下载文件   
     * @param: @param response
     * @param: @param fileDesPath
     * @param: @param fileName
     * @param: @throws IOException
     * @param: @throws FileNotFoundException      
     * @return: void      
     * @throws
     */
	private void fileDown(HttpServletResponse response, String fileDesPath, String fileName)
			throws IOException, FileNotFoundException {
		//下面就调用方法进行下载了
		OutputStream out=response.getOutputStream();
		//构建元文件的地址
		File desFile=new File(fileDesPath);
		InputStream in=new FileInputStream(desFile);
		//设置那个请求的头
		response.setHeader("content-disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
		int length;
		byte[] buf=new byte[1024];
		while((length=in.read(buf))!=-1) {
			out.write(buf, 0, length);
		}
		//关闭这个流
		in.close();
		out.close();
	}
}
