package com.caozhenjieproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.caozhenjieproject.entity.Girl;
import com.caozhenjieproject.entity.GirlStudent;

public interface GirlStudentRepository extends PagingAndSortingRepository<GirlStudent, Integer>{
	
	
	

}
