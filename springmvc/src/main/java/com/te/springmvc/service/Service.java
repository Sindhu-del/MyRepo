package com.te.springmvc.service;

import com.te.springmvc.bean.EmpBean;

public interface Service {

	public EmpBean authentication(int id, String password);

	public EmpBean getEmployee(int id);

	public boolean deleteEmpData(int id);

}
