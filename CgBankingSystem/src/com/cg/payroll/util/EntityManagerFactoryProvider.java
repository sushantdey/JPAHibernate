package com.cg.payroll.util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class EntityManagerFactoryProvider {
	public static EntityManagerFactory factory=null;
	public static EntityManagerFactory getEntityManagerFactory(){
		if(factory==null)
			factory=Persistence.createEntityManagerFactory("JPA-PU");
		return factory;
	}
}
