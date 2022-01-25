	
package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Parent;
import com.cg.exception.InvalidUserException;
@SuppressWarnings("unused")
@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
@Query

List<Parent> findByparentId(int parentId);

@Query("select a from Parent a where a.username = :username and a.password = :password")
Parent validatePassword(@Param("username")String username,@Param("password") String password)throws InvalidUserException;	
	}

