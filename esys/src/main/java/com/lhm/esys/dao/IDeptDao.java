/**
 * 
 */
package com.qfedu.esys.dao;
import java.util.List;


import com.qfedu.esys.entity.Dept;



public interface IDeptDao {
void createDept(Dept dept);
	
	void deleteDept(Dept dept);
	
	Dept findDeptById(int id);
	
	List<Dept> findAllDept();
}
