package com.pru.test.user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pru.test.user.service.VO.Department;
import com.pru.test.user.service.VO.ResponseTemplateNamedNativeVO;
import com.pru.test.user.service.VO.ResponseTemplateVO;
import com.pru.test.user.service.entity.User;
import com.pru.test.user.service.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepo userRepo;
	
	@Value("${department.service.url}")
	private String deptServiceUrl;
	
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user= userRepo.findByUserId(userId);
		Department dept= restTemplate.getForObject(deptServiceUrl+"/pru-dept/get-dept/"+user.getDeptId(), Department.class);
		
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDept(dept);
		
		return responseTemplateVO;
	}

	
	public User getUserByNamedNative(Long userId) {
		
		User user= userRepo.getUserByNamedNativeSQL(userId);
		
		return user;
	}
	
	public User getUserByNamed(Long userId) {
		
		User user= userRepo.getUserByNamedJPQL(userId);
		
		return user;
	}
	
}
