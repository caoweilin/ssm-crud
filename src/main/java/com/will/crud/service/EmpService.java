package com.will.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.crud.bean.Emp;
import com.will.crud.bean.EmpExample;
import com.will.crud.bean.EmpExample.Criteria;
import com.will.crud.dao.EmpMapper;
@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	public List<Emp> getEmps(){
		List<Emp> emps = empMapper.selectByExampleWithDept(null);
		return emps;
	}
	
	/**
	 * Ա������
	 * @param employee
	 */
	public void saveEmp(Emp employee) {
		// TODO Auto-generated method stub
		empMapper.insertSelective(employee);
	}

	/**
	 * �����û����Ƿ����
	 * 
	 * @param empName
	 * @return  true������ǰ��������   fasle��������
	 */
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = empMapper.countByExample(example);
		return count == 0;
	}
	
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		empMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmpExample example = new EmpExample();
		//��������
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(ids);
		empMapper.deleteByExample(example);
	}
}
