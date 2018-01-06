/**
 * 
 */
package com.qfedu.esys.controller;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.esys.entity.Dept;
import com.qfedu.esys.service.IDeptService;
import com.qfedu.esys.vo.GridEuiVo;

/**
 * @author cailei
 *
 */
@Controller
@RequestMapping(value="/sys/dept")
public class DeptController {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(DeptController.class);
	@Resource
	private IDeptService deptService;
	
	@ResponseBody
	@RequestMapping(value="/list",produces="application/json")
	private GridEuiVo<Dept> getList(){
		List<Dept> depts=deptService.findAllDept();
		GridEuiVo<Dept> gridEuiVo=new GridEuiVo<Dept>(Long.valueOf(depts.size()),depts);
		return gridEuiVo;
	}
	@RequestMapping(value="/crud")
	public ModelAndView toMain () {
		ModelAndView m = new ModelAndView();
		m.setViewName("dept");
		return m;
	}
	
	@RequestMapping(value="/delete")
	public void deleteDept(int id){
		System.out.println("选中id为"+id);
		Dept dept=deptService.findDeptById(id);
		deptService.deleteDept(dept);
	}
	



}
