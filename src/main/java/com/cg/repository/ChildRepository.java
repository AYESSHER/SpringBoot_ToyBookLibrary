package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Child;
import com.cg.exception.InvalidUserException;

@SuppressWarnings("unused")
@Repository

public interface ChildRepository extends JpaRepository<Child, Integer> {

	 

	List<Child> findByChildId(@Param("pnm") int child_id); 
	
	@Query("select a from Child a where a.username = :username and a.password = :password")
	Child validatePassword(@Param("username")String username,@Param("password") String password)throws InvalidUserException;
}

