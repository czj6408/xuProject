package com.caozhenjieproject.onetoone;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.fasterxml.classmate.AnnotationConfiguration;


public class OneToOne {	

	 private static SessionFactory sessionFactory;

//     @BeforeClass
//     public static void beforeClass() {
//       sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//     }
     @AfterClass
     public static void afterClass() {
      sessionFactory.close();
     }
	
	
	

}
