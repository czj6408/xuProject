package com.caozhenjieproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.caozhenjieproject.entity.Girl;

public interface GirlRepository extends PagingAndSortingRepository<Girl, Integer>{
	
	
	Page<Girl> findByName(String Name,Pageable pageable);
	

}
