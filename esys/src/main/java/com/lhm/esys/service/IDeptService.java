/**
 * 
 */
package com.qfedu.esys.service;
import java.util.List;


import com.qfedu.esys.entity.Dept;

/**
 * @author cailei
 *
 */
public interface IDeptService {
	void createDept(Dept dept);
	
	void deleteDept(Dept dept);
	
	Dept findDeptById(int id);
	
	List<Dept> findAllDept();
}
