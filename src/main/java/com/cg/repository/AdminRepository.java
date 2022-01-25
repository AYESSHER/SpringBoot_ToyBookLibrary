package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import com.cg.entity.Admin;
import com.cg.exception.InvalidUserException;

@SuppressWarnings("unused")
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	
	List<Admin> findByadminId(int adminId);

	@Query("SELECT a FROM Admin a WHERE a.username=?1")
	List<Admin> validateUsername(String username); 
	
	@Query("SELECT a FROM Admin a WHERE a.password=?1")
	List<Admin> validatePassword(String password); 

	@Query("select a from Admin a where a.username = :username and a.password = :password")
	Admin validatePassword(@Param("username")String username,@Param("password") String password)throws InvalidUserException;

}
