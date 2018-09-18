package com.will.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.crud.bean.Dept;
import com.will.crud.bean.Emp;
import com.will.crud.dao.DeptMapper;
import com.will.crud.dao.EmpMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DeptMapper departmentMapper;
	
	@Autowired
	EmpMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Test
	public void testCRUD(){
	
		departmentMapper.insertSelective(new Dept(null, "开发部"));
		departmentMapper.insertSelective(new Dept(null, "测试部"));

		//employeeMapper.insertSelective(new Emp(null, "Jerry", "M", "Jerry@atguigu.com", 1));
		
	
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		for(int i = 0;i<10;i++){
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Emp(null,uid, "M", uid+"@atwill.com", 1));
			mapper.insertSelective(new Emp(null,uid, "M", uid+"@atwill.com", 2));
		}
		System.out.println("批量成功");
	}
}
