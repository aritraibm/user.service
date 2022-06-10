package com.pru.test.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pru.test.user.service.VO.ResponseTemplateNamedNativeVO;
import com.pru.test.user.service.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserId(Long userId);
	
	@Query(value = "select * from tbl_user where user_id= :userId", nativeQuery = true)
	public User getUserByNamedNativeSQL(@Param(value = "userId") Long userId);

	User getUserByNamedJPQL(Long userId);
}
