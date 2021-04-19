package com.te.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.bean.EmpBean;
import com.te.springmvc.dao.EmpDao;

@Controller
public class EmployeeController {
	@Autowired
	private EmpDao dao;
	
	@GetMapping("/emp")
	public String getLoginForm() {
		return "login";
	}//end of show login
	
	@PostMapping("/emplogin")
	public String authenticate(int id,String pwd,HttpServletRequest request,ModelMap map) {
		
		EmpBean empbean=dao.authentication(id, pwd);
		
		if(empbean!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("emp",empbean);
			return "homepage";
			
		}else {
			map.addAttribute("errmsg","Invalid credentials");
			return "login";
		}
		
  }//end of athentication
	
	
	@GetMapping("/searchform")
	public String getSearchForm(ModelMap map,HttpSession session) {
		
		if(session.getAttribute("emp")!=null) {
			return "search";
		}else {
			map.addAttribute("errmsg","please login first");
			return "login";
		}
		
		
	}//end of showsearch
	
	@GetMapping("/search")
	public String getEmp(int id,ModelMap map,@SessionAttribute(name="emp",required=false)EmpBean bean) {
		if(bean!=null) {
			EmpBean empBean=dao.getEmployee(id);
			if(empBean!=null) {
				map.addAttribute("data",empBean);
			}else {
				map.addAttribute("msg","data not found for id:"+id);
			}
			return "search";
		}else {
			map.addAttribute("errmsg","please login first");
			return "login";
		}
		
	}//end of search
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap map) {
		session.invalidate();
		map.addAttribute("msg","logout successfull");
		return "login";
		
	}// end of logout
	
	
	@GetMapping("/showdelete")
	public String showdeleteEmp( ModelMap map, @SessionAttribute(name="emp",required=false) EmpBean bean) {
		if(bean!=null) {
			return "delete";
		}else {
			map.addAttribute("errmsg","please login first");
			return "login";
		}	
		
	}//end of show delete
	
	@GetMapping("/delete")
	public String deleteEmp(int id,ModelMap map,@SessionAttribute(name="emp",required=false)EmpBean bean) {
		if(bean!=null) {
			Boolean dataBoolean= dao.deleteEmpData(id);
			if(dataBoolean!=null) {
				map.addAttribute("msg","deleted successfully");
			}else {
				map.addAttribute("msg","data not found");
			}		return "delete";	
		  }else {
			map.addAttribute("errmsg" ,"please login first");
			return "login";
			
		}
		
		
		
	}//end of delete
	
	@GetMapping("/alldata")
	public String getAllEmpData(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmpBean employeeBean) {
		if (employeeBean != null) {
			List<EmpBean>data =dao.getAllEmp();
			if (data != null) {
				map.addAttribute("data", data);
			} else {
				map.addAttribute("errmsg", "Empty Table");
			}
			return "allDetails";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of getAllEmpData Method
	
	
}
