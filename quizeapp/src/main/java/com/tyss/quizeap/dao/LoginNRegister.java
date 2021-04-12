package com.tyss.quizeap.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.quizapp.dto.Questions;
import com.tyss.quizapp.dto.Register;
import com.tyss.quizapp.dto.Results;

public class LoginNRegister implements Quiz {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public Register login(String username, String Password) {

		try {
			Register login = null;
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			login = entityManager.find(Register.class, username);
			return login;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Register register(Register register) {

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(register);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return register;

	}

	@Override
	public Questions questions(int id) {

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			Questions questions = entityManager.find(Questions.class, id);
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void results(Results results) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(results);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}

	}

	@Override
	public Results getResults(Date date) {
		Results results =null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			results = entityManager.find(Results.class, date);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return results;
	}

	
}
