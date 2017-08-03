package com.caozhenjieproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caozhenjieproject.entity.Girl;
import com.caozhenjieproject.repository.GirlRepository;


@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@GetMapping(value="/girls")
	@ResponseBody 
	public List<Girl> girls(){
		
		return (List<Girl>) girlRepository.findAll();
	}
	
	@GetMapping(value="/welcome")
	public String welcome(){		
		return "welcome to HPE";
	}
	
	
	
	@PostMapping(value = "girls")  //等效于 @RequestMapping(value="girls"  method="RequestMethod.post")
	@ResponseBody
	public Girl postGirls(@RequestBody Girl girl){				
		return girlRepository.save(girl);		
	}
	
	
	
	@GetMapping(value="/page")
	@ResponseBody 
	public void testPageQuery() throws Exception {
		int page=0,size=2;
	    Pageable pageable = new PageRequest(page, size);
	    Page<Girl>  p =girlRepository.findAll(pageable);
	    
	    System.out.println("当前页数" +p.getNumber());
	    
	    System.out.println("当前总的记录书" +p.getTotalElements());
	    
	    
	    System.out.println("有多少太偶记" +p.getNumberOfElements());
	  
	    System.out.println("当前页数" +p.getContent());
	}
	
	
	@GetMapping(value="/sort")
	@ResponseBody 
	public void sort() throws Exception {
		
		Sort sort = new Sort(Direction.DESC, "id");
		int page=2,size=3;
	    Pageable pageable = new PageRequest(page, size,sort);
	    Page<Girl>  p =girlRepository.findAll(pageable);
	    
	    System.out.println("当前页数" +p.getNumber());
	    
	    System.out.println("当前总的记录书" +p.getTotalElements());
	    
	    
	    System.out.println("有多少太偶记" +p.getNumberOfElements());
	  
	    System.out.println("当前页数" +p.getContent());
	}
	
	
	
	
	
	
	
	
	
	

}
