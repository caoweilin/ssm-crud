package com.will.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.crud.bean.Dept;
import com.will.crud.dao.DeptMapper;

@Service
public class DepartmentService {
	
	@Autowired
	private DeptMapper departmentMapper;

	public List<Dept> getDepts() {
		// TODO Auto-generated method stub
		List<Dept> list = departmentMapper.selectByExample(null);
		return list;
	}

}
