package com.caozhenjieproject.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.caozhenjieproject.repository.GirlOrderRepository;
import com.caozhenjieproject.repository.GirlRepository;
import com.caozhenjieproject.repository.GirlStudentRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class GirlTest {	

	@Autowired
    private GirlRepository girlRepository;
	
	
	@Autowired
    private GirlOrderRepository girlOrderRepository;
	
	
	@Autowired
    private GirlStudentRepository girlStudentRepository;
	
	

    @Test
    public void likeName() {
    	int page=0,size=2;
	    Pageable pageable = new PageRequest(page, size);
	    Page<Girl>  p =girlRepository.findAll(pageable);
	    System.out.println("当前页数" +p.getNumber());
	    System.out.println("当前总的记录书" +p.getTotalElements());
	    System.out.println("有多少太偶记" +p.getNumberOfElements());
	    System.out.println("当前页数" +p.getContent());
       
    }
    
    
    
    @Test
    public void test() {
    	GirlOrder girlorder =new GirlOrder();
    	girlorder.setEat("apple");
    	girlorder.setTools("bag");
       	Girl girl =new Girl();
    	girl.setHobby("lanqiu");
    	
    	girl.setName("jey");
    	girl.setGirlOrder(girlorder);
    	girlorder.setGirl(girl);
    	girlRepository.save(girl);      
    }
    
    
    
    @Test
    public void testdelete() {
    	
    	
//    	girlRepository.delete(3);     
    }
    
    
    
    
    @Test
    public void testfindone() {
    	Girl gi=girlRepository.findOne(1);
    	GirlOrder girlorder =new GirlOrder();
    	girlorder.setEat("bananaunitshlsshsdfdsfdsfdsfsdfdsfdsf");
    	girlorder.setTools("clothesdfsfsdfsfdsf");
    	girlorder.setGirl(gi);
    	gi.setGirlOrder(girlorder);
    	girlRepository.save(gi);    
    }
    
    //use girl to save
    @Test
    public void testfindone22() {
    	Girl girl =new Girl();
    	girl.setHobby("lanqiu");
    	girl.setName("jey");
	    List<GirlStudent> list =new ArrayList<GirlStudent>();
	    
	    
		GirlStudent girlstudent =new GirlStudent();
		girlstudent.setAge("12");
		girlstudent.setName("xiaoming");    	
		girlstudent.setGirl(girl);
		GirlStudent girlstudent1 =new GirlStudent();
		girlstudent1.setAge("13");
		girlstudent1.setName("xiaohong");    	
		girlstudent1.setGirl(girl);
		list.add(girlstudent1);
		list.add(girlstudent);
		girl.setGirlStudents(list);
//		girlStudentRepository.save(list);
		
		girlRepository.save(girl);
	}

    
    
    //use girlstude to save
    @Test
    public void girlstude() {
    	Girl girl =new Girl();
    	girl.setHobby("lanqiu");
    	girl.setName("jey");
	    List<GirlStudent> list =new ArrayList<GirlStudent>();
	    
	    
		GirlStudent girlstudent =new GirlStudent();
		girlstudent.setAge("12");
		girlstudent.setName("xiaoming");    	
		girlstudent.setGirl(girl);
		GirlStudent girlstudent1 =new GirlStudent();
		girlstudent1.setAge("13");
		girlstudent1.setName("xiaohong");    	
		girlstudent1.setGirl(girl);
		list.add(girlstudent1);
		list.add(girlstudent);
		girl.setGirlStudents(list);
//		girlStudentRepository.save(list);
		
//		girlRepository.save(girl);
	}

	
	
	
	

}
