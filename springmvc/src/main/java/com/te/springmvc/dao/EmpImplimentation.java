package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmpBean;

@Repository
public class EmpImplimentation implements EmpDao {

	@Override
	public EmpBean authentication(int id, String password) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("spring");
		 EntityManager manager=factory.createEntityManager();
		EmpBean bean= manager.find(EmpBean.class, id);
		 
		 if(bean!=null) {
			 if(bean.getPassword().equals(password)) {
				 System.out.println("login success");
				 return bean;
			 }else
				 System.out.println("invalid inputs");
		 }else {
			 System.out.println("User not found");
		 }
		return null;
	}

	@Override
	public EmpBean getEmployee(int id) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("spring");
		EntityManager manager=factory.createEntityManager();
		EmpBean bean =manager.find(EmpBean.class, id);
		
		return bean ;
	}
    
	@Override
	public boolean deleteEmpData(int id) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("spring");
		EntityManager manager=factory.createEntityManager();
	    EntityTransaction transaction	=manager.getTransaction();
	    transaction.begin();
	    EmpBean bean=manager.find(EmpBean.class, id);
	    manager.remove(bean);
	    transaction.commit();
		return false;
	}

	@Override
	public List<EmpBean> getAllEmp() {
		
			try {
				EntityManagerFactory factory=Persistence.createEntityManagerFactory("spring");
				EntityManager manager=factory.createEntityManager();
				String get = " from EmpBean ";
				Query query = manager.createQuery(get);
				List<EmpBean> data = query.getResultList();
				return data;
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			return null;
			
		}

		
	

}
